package com.bionic.edu.proc.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name = "Keyword.getAllKeywords", query = "SELECT k FROM Keyword k")
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Keyword name can not be empty")
	private String keywordName;
	@OneToMany(mappedBy = "keyword")
	private Collection<Link> links;

	/**
	 * Default Constuctor
	 */
	public Keyword() {
		super();
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
	 * @return the keywordName
	 */
	public String getKeywordName() {
		return keywordName;
	}

	/**
	 * @param keywordName
	 *            the keywordName to set
	 */
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	/**
	 * @return the links
	 */
	public Collection<Link> getLinks() {
		return links;
	}

	/**
	 * @param links
	 *            the links to set
	 */
	public void setLinks(Collection<Link> links) {
		this.links = links;
	}

}
