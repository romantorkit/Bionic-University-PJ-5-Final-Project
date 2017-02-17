package com.bionic.edu.proc.entity;

public class Result {
	private int subjectId;
	private int keywordId;

	public Result() {

	}

	public Result(int subjectId, int keywordId) {
		this.subjectId = subjectId;
		this.keywordId = keywordId;
	}

	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId
	 *            the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the keywordId
	 */
	public int getKeywordId() {
		return keywordId;
	}

	/**
	 * @param keywordId
	 *            the keywordId to set
	 */
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}

}
