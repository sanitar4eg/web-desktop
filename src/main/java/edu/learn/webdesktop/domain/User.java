package edu.learn.webdesktop.domain;
 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username", unique = true, 
		nullable = false, length = 45)
	private String userName;
	
	@Column(name = "password", 
			nullable = false, length = 60)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	private Journal journal;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
	private Set<Widget> widgets = new HashSet<Widget>();
 
	public User() {
	}
 
	public User(String username, String password, boolean enabled) {
		this.userName = username;
		this.password = password;
		this.enabled = enabled;
	}
 
	public User(String username, String password, 
		boolean enabled, Set<UserRole> userRole, Set<Widget> widgets) {
		this.userName = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
		this.widgets = widgets;
	}
 
	public String getUserName() {
		return this.userName;
	}
 
	public void setUserName(String username) {
		this.userName = username;
	}
 
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public boolean isEnabled() {
		return this.enabled;
	}
 
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
 
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}
 
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Set<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(Set<Widget> widgets) {
		this.widgets = widgets;
	} 
}