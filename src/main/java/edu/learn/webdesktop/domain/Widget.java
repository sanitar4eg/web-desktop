package edu.learn.webdesktop.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "widgets", uniqueConstraints = @UniqueConstraint(columnNames = {
		"widget", "username" }))
public class Widget {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "widget_id")
	private Integer userWidgetId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	@Column(name = "widget", nullable = false, length = 45)
	private String widgetName;

	public Widget() {
	}

	public Widget(User user, String widget) {
		this.user = user;
		this.widgetName = widget;
	}

	public Integer getUserWidgetId() {
		return userWidgetId;
	}

	public void setUserWidgetId(Integer userWidgetId) {
		this.userWidgetId = userWidgetId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widget) {
		this.widgetName = widget;
	}
	
	@Override
	public int hashCode() {
		return new String(widgetName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Widget)) {
            return false;
        }
        Widget objCast = (Widget) obj;
        return this.widgetName.equalsIgnoreCase(objCast.widgetName);
	}
}
