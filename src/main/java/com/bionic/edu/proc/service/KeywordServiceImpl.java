package com.bionic.edu.proc.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.proc.dao.KeywordDao;
import com.bionic.edu.proc.entity.Keyword;

@Named
public class KeywordServiceImpl implements KeywordService {
	@Inject
	private KeywordDao keywordDao;

	@Override
	public Keyword findById(int id) {
		return keywordDao.findById(id);
	}

	@Override
	public List<Keyword> findAllKeywords() {
		return keywordDao.findAllKeywords();
	}

	@Override
	@Transactional
	public void save(Keyword keyword) {
		keywordDao.save(keyword);
	}

	@Override
	@Transactional
	public void delete(int id) {
		keywordDao.delete(id);
	}

}
