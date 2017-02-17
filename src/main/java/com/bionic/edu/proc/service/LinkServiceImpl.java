package com.bionic.edu.proc.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.proc.dao.LinkDao;
import com.bionic.edu.proc.entity.Link;

@Named
public class LinkServiceImpl implements LinkService {

	@Inject
	private LinkDao linkDao;

	@Override
	public Link findById(int id) {
		return linkDao.findById(id);
	}

	@Override
	public List<Link> findAllLinks() {
		return linkDao.findAllLinks();
	}

	@Override
	public List<Link> getLinksBySubjectAndKeyword(int subjectId, int keywordId) {
		return linkDao.getLinksBySubjectAndKeyword(subjectId, keywordId);
	}

	@Override
	public List<Link> getLinksBySubject(int id) {
		return linkDao.getLinksBySubject(id);
	}

	@Override
	public List<Link> getLinksByKeyword(int id) {
		return linkDao.getLinksByKeyword(id);
	}

	@Override
	@Transactional
	public void save(Link link) {
		linkDao.save(link);

	}

	@Override
	@Transactional
	public void delete(int id) {
		linkDao.delete(id);

	}

}
