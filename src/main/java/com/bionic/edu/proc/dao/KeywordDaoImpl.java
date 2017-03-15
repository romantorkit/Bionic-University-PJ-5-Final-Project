package com.bionic.edu.proc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.proc.entity.Keyword;

@Repository
public class KeywordDaoImpl implements KeywordDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Keyword findById(int id) {
		return em.find(Keyword.class, id);
	}

	@Override
	public List<Keyword> findAllKeywords() {
		TypedQuery<Keyword> namedQuery = em.createNamedQuery("Keyword.getAllKeywords", Keyword.class);
		return namedQuery.getResultList();
	}

	@Override
	public void save(Keyword keyword) {
		if (keyword.getId() == 0)
			em.persist(keyword);
		else
			em.merge(keyword);
	}

	@Override
	public void delete(int id) {
		TypedQuery<Link> query = em
				.createQuery("SELECT l FROM Link l WHERE l.keyword.id = " + id + " ORDER BY l.subject", Link.class);
		List<Link> linkList = query.getResultList();
		for (Link link : linkList) {
			if (link != null) {
				link.setKeyword(null);
				em.merge(link);
			}
		}
		Keyword keyword = em.find(Keyword.class, id);
		if (keyword != null)
			em.remove(keyword);
	}

}
