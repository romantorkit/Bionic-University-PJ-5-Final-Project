package com.bionic.edu.proc.dao;

import java.util.List;

import com.bionic.edu.proc.entity.Link;

public interface LinkDao {

	public Link findById(int id);

	public List<Link> getLinksByKeyword(int id);

	public List<Link> getLinksBySubject(int id);

	public List<Link> findAllLinks();

	public List<Link> getLinksBySubjectAndKeyword(int subjectId, int keywordId);

	public void save(Link link);

	public void delete(int id);

}
