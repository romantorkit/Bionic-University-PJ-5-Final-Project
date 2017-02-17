package com.bionic.edu.proc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.proc.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Subject findById(int id) {
		return em.find(Subject.class, id);
	}

	@Override
	public List<Subject> findAllSubjects() {
		TypedQuery<Subject> namedQuery = em.createNamedQuery("Subject.getAllSubjects", Subject.class);
		return namedQuery.getResultList();
	}

	@Override
	public void save(Subject subject) {
		if (subject.getId() == 0) {
			em.persist(subject);
		} else {
			em.merge(subject);
		}
	}

	@Override
	public void delete(int id) {
		Subject subject = em.find(Subject.class, id);
		if (subject != null) {
			em.remove(subject);
		}

	}

}
