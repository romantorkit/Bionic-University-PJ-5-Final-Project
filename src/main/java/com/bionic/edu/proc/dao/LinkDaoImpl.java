package com.bionic.edu.proc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.proc.entity.Link;

@Repository
public class LinkDaoImpl implements LinkDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Link findById(int id) {
		return em.find(Link.class, id);
	}

	@Override
	public List<Link> findAllLinks() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l", Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getLinksByKeyword(int id) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE l.keyword.id = " + id, Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getLinksBySubject(int id) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE l.subject.id = " + id, Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getLinksBySubjectAndKeyword(int sId, int kId) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE l.subject.id = ?1 AND l.keyword.id = ?2",
				Link.class);
		query.setParameter(1, sId);
		query.setParameter(2, kId);
		return query.getResultList();
	}

	@Override
	public void save(Link link) {
		if (link.getId() == 0)
			em.persist(link);
		else
			em.merge(link);
	}

	@Override
	public void delete(int id) {
		Link link = em.find(Link.class, id);
		if (link != null)
			em.remove(link);
	}

}
