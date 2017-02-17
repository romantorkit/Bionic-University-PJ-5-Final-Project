package com.bionic.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bionic.edu.proc.entity.Keyword;
import com.bionic.edu.proc.entity.Link;
import com.bionic.edu.proc.entity.Subject;
import com.bionic.edu.proc.service.KeywordService;
import com.bionic.edu.proc.service.LinkService;
import com.bionic.edu.proc.service.SubjectService;

@Controller
@RequestMapping("/links")
public class LinkController {
	List<Subject> subjectList = null;
	List<Keyword> keywordList = null;
	List<Link> linkList = null;

	@Inject
	SubjectService subjectService;

	@Inject
	KeywordService keywordService;

	@Inject
	LinkService linkService;

	@RequestMapping(value = "/newLink", method = RequestMethod.GET)
	public String newLink(ModelMap model) {
		model.addAttribute("link", new Link());
		subjectList = subjectService.findAllSubject();
		Map<Integer, String> subjectMap = new HashMap<Integer, String>();
		for (Subject s : subjectList) {
			subjectMap.put(new Integer(s.getId()), s.getSubjectName());
		}
		model.addAttribute("subjectAttribute", subjectMap);
		keywordList = keywordService.findAllKeywords();
		Map<Integer, String> keywordMap = new HashMap<Integer, String>();
		for (Keyword s : keywordList) {
			keywordMap.put(new Integer(s.getId()), s.getKeywordName());
		}
		model.addAttribute("keywordAttribute", keywordMap);
		return "newLink";
	}

	@RequestMapping(value = { "/addLink", "*/addLink" }, method = RequestMethod.POST)
	public String addLink(@ModelAttribute("link") Link link, BindingResult bindingResult,
			@ModelAttribute("subject") Subject subject,
			@RequestParam(value = "subject", required = true) String sTempId,
			@ModelAttribute("keyword") Keyword keyword,
			@RequestParam(value = "keyword", required = true) String kTempId, ModelMap model) {

		int sId = Integer.parseInt(sTempId);
		int kId = Integer.parseInt(kTempId);
		subject = subjectService.findById(sId);
		keyword = keywordService.findById(kId);
		link.setSubject(subject);
		link.setKeyword(keyword);

		linkService.save(link);
		linkList = linkService.findAllLinks();
		model.addAttribute("linkList", linkList);
		return "listOfLinks";
	}

	@RequestMapping(value = "/edit/{tempId}", method = RequestMethod.GET)
	public String getEditLink(@ModelAttribute("link") Link link, @PathVariable String tempId, ModelMap model) {

		subjectList = subjectService.findAllSubject();
		Map<Integer, String> subjectMap = new HashMap<Integer, String>();
		for (Subject s : subjectList) {
			subjectMap.put(new Integer(s.getId()), s.getSubjectName());
		}
		model.addAttribute("subjectAttribute", subjectMap);
		keywordList = keywordService.findAllKeywords();
		Map<Integer, String> keywordMap = new HashMap<Integer, String>();
		for (Keyword s : keywordList) {
			keywordMap.put(new Integer(s.getId()), s.getKeywordName());
		}
		model.addAttribute("keywordAttribute", keywordMap);

		int id = Integer.valueOf(tempId);
		link = linkService.findById(id);
		model.addAttribute("link", link);
		return "newLink";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteKeyword(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {

		linkService.delete(id);
		linkList = linkService.findAllLinks();
		model.addAttribute("linkList", linkList);
		return "listOfLinks";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		linkList = linkService.findAllLinks();
		model.addAttribute("linkList", linkList);
		return "listOfLinks";
	}

}
