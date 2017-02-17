package com.bionic.edu.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

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
import com.bionic.edu.proc.service.KeywordService;
import com.bionic.edu.proc.service.LinkService;

@Controller
@RequestMapping(value = "/keyword")
public class KeywordController {

	List<Keyword> keywordList = null;
	List<Link> linkList = null;

	@Inject
	KeywordService keywordService;

	@Inject
	LinkService linkService;

	@RequestMapping(value = "/newKeyword", method = RequestMethod.GET)
	public String newKeyword(ModelMap model) {
		model.addAttribute("keyword", new Keyword());
		return "newKeyword";
	}

	@RequestMapping(value = { "/addKeyword", "*/addKeyword" }, method = RequestMethod.POST)
	public String addKeyword(@Valid @ModelAttribute("keyword") Keyword keyword, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "newKeyword";
		}
		keywordService.save(keyword);
		keywordList = keywordService.findAllKeywords();

		model.addAttribute("keywordList", keywordList);
		return "redirect:/search/searchData";
	}

	@RequestMapping(value = "/edit/{tempId}", method = RequestMethod.GET)
	public String getEditKeyword(@PathVariable String tempId, ModelMap model) {
		int id = Integer.valueOf(tempId);
		Keyword keyword = keywordService.findById(id);
		model.addAttribute("keyword", keyword);
		return "newKeyword";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteKeyword(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {

		keywordService.delete(id);
		keywordList = keywordService.findAllKeywords();
		model.addAttribute("keywordList", keywordList);
		return "redirect:/search/searchData";
	}

	@RequestMapping(value = "/listOfKeywords", method = RequestMethod.GET)
	public String showKeywordList(ModelMap model) {
		keywordList = keywordService.findAllKeywords();
		model.addAttribute("keywordList", keywordList);
		return "redirect:/search/searchData";
	}

}
