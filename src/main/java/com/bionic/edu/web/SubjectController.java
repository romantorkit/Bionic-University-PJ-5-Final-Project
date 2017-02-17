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

import com.bionic.edu.proc.entity.Link;
import com.bionic.edu.proc.entity.Subject;
import com.bionic.edu.proc.service.LinkService;
import com.bionic.edu.proc.service.SubjectService;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	List<Subject> subjectList = null;
	List<Link> linkList = null;

	@Inject
	SubjectService subjectService;

	@Inject
	LinkService linkService;

	@RequestMapping(value = "/newSubject", method = RequestMethod.GET)
	public String newSubject(ModelMap model) {
		model.addAttribute("subject", new Subject());
		return "newSubject";
	}

	@RequestMapping(value = { "/addSubject", "*/addSubject" }, method = RequestMethod.POST)
	public String addSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "newSubject";
		}
		subjectService.save(subject);
		subjectList = subjectService.findAllSubject();

		model.addAttribute("subjectList", subjectList);
		return "redirect:/search/searchData";
	}

	@RequestMapping(value = "/edit/{tempId}", method = RequestMethod.GET)
	public String getEditSubject(@PathVariable String tempId, ModelMap model) {
		int id = Integer.valueOf(tempId);
		Subject subject = subjectService.findById(id);
		model.addAttribute("subject", subject);
		return "newSubject";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSubject(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {

		subjectService.delete(id);
		subjectList = subjectService.findAllSubject();
		model.addAttribute("subjectList", subjectList);
		return "redirect:/search/searchData";
	}

	@RequestMapping(value = "/listOfSubjects", method = RequestMethod.GET)
	public String showSubjectList(ModelMap model) {
		subjectList = subjectService.findAllSubject();
		model.addAttribute("subjectList", subjectList);
		return "redirect:/search/searchData";
	}

}
