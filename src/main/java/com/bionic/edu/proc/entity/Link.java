package com.bionic.edu.proc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String linkName;
	private String linkURL;
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "keywordId")
	private Keyword keyword;

	/**
	 * Default constructor
	 */
	public Link() {
		super();
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the keyword
	 */
	public Keyword getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the linkName
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * @param linkName
	 *            the linkName to set
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	/**
	 * @return the linkURL
	 */
	public String getLinkURL() {
		return linkURL;
	}

	/**
	 * @param linkURL
	 *            the linkURL to set
	 */
	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

}
