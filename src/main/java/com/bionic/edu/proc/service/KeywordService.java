package com.bionic.edu.proc.service;

import java.util.List;

import com.bionic.edu.proc.entity.Keyword;

public interface KeywordService {
	public Keyword findById(int id);

	public List<Keyword> findAllKeywords();

	public void save(Keyword keyword);

	public void delete(int id);

}
