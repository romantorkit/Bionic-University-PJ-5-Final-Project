package com.bionic.edu.proc.service;

import java.util.List;

import com.bionic.edu.proc.entity.Subject;

public interface SubjectService {
	public Subject findById(int id);

	public List<Subject> findAllSubject();

	public void save(Subject subject);

	public void delete(int id);
}
