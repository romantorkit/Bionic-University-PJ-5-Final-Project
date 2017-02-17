package com.bionic.edu.proc.dao;

import java.util.List;

import com.bionic.edu.proc.entity.Keyword;

public interface KeywordDao {
	public Keyword findById(int id);

	public List<Keyword> findAllKeywords();

	public void save(Keyword keyword);

	public void delete(int id);

}
