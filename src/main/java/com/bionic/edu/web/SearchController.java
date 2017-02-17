package com.bionic.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bionic.edu.proc.entity.Keyword;
import com.bionic.edu.proc.entity.Link;
import com.bionic.edu.proc.entity.Result;
import com.bionic.edu.proc.entity.Subject;
import com.bionic.edu.proc.service.KeywordService;
import com.bionic.edu.proc.service.LinkService;
import com.bionic.edu.proc.service.SubjectService;

@Controller
@RequestMapping("/search")
public class SearchController {
	List<Subject> subjectList = null;
	List<Keyword> keywordList = null;
	List<Link> linkList = null;

	@Inject
	SubjectService subjectService;

	@Inject
	KeywordService keywordService;

	@Inject
	LinkService linkService;

	@RequestMapping(value = "/getSearchData", method = RequestMethod.GET)
	public String getSearchData(Model model, @ModelAttribute("subject") Subject subject,
			@ModelAttribute("keyword") Keyword keyword) {
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
		return "searchPage";
	}

	@RequestMapping(value = "/searchData", method = RequestMethod.GET)
	public String searchData(Model model, @ModelAttribute("subject") Subject subject,
			@ModelAttribute("keyword") Keyword keyword) {
		subjectList = subjectService.findAllSubject();
		model.addAttribute("subjectList", subjectList);

		keywordList = keywordService.findAllKeywords();
		model.addAttribute("keywordList", keywordList);
		return "searchData";
	}

	@ModelAttribute
	public Link addLink() {
		return new Link();
	}

	@ModelAttribute
	public Result addResult() {
		return new Result();
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("result") Result result, Integer subjectId, Integer keywordId,
			ModelMap model) {
		if (subjectId == 0)
			linkList = linkService.getLinksByKeyword(keywordId);
		else if (keywordId == null)
			linkList = linkService.getLinksBySubject(subjectId);
		else
			linkList = linkService.getLinksBySubjectAndKeyword(subjectId, keywordId);
		model.addAttribute("linkList", linkList);
		return "listOfLinks";
	}

}
