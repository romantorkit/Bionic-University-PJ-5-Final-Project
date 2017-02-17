package com.bionic.edu.proc.dao;

import java.util.List;

import com.bionic.edu.proc.entity.Subject;

public interface SubjectDao {
	public Subject findById(int id);

	public List<Subject> findAllSubjects();

	public void save(Subject subject);

	public void delete(int id);

}
