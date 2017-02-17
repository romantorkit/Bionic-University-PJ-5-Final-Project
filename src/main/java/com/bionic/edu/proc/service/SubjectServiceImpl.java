package com.bionic.edu.proc.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.proc.dao.SubjectDao;
import com.bionic.edu.proc.entity.Subject;

@Named
public class SubjectServiceImpl implements SubjectService {

	@Inject
	private SubjectDao subjectDao;

	@Override
	public Subject findById(int id) {
		return subjectDao.findById(id);
	}

	@Override
	public List<Subject> findAllSubject() {
		return subjectDao.findAllSubjects();
	}

	@Override
	@Transactional
	public void save(Subject subject) {
		subjectDao.save(subject);
	}

	@Override
	@Transactional
	public void delete(int id) {
		subjectDao.delete(id);
	}

}
