package edu.learn.webdesktop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOURNAL_ID", nullable = false)
	private Journal journal;
	private String name;
	private String description;
	private Date minderTime;
	private String contacts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public final String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public final Date getMinderTime() {
		return minderTime;
	}

	public void setMinderTime(Date minderTime) {
		this.minderTime = minderTime;
	}

	public final String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public boolean isActive() {
		return (minderTime.getTime() > new Date().getTime());
	}
}
