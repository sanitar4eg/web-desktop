package edu.learn.webdesktop.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "journals")
public class Journal {
	protected Journal() {
	}

	public Journal(String inName) {
		setName(name);
		setTasks(new HashMap<String, Task>());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOURNAL_ID", unique = true, nullable = false)
	private Long id;
	@OneToOne()
	@JoinColumn(name = "username")
	private User user;
	private String name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "journal",cascade=CascadeType.ALL)
	@MapKey(name = "name")
	private Map<String, Task> tasks;

	public final String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public final Collection<Task> getTasks() {
		if (tasks == null) {
			return null;
		} else {
			return Collections.unmodifiableCollection(tasks.values());
		}
	}

	private void setTasks(Map<String, Task> inTasks) {
		this.tasks = inTasks;
	}

	public final int getCount() {
		return tasks.size();
	}

	public final boolean isEmpty() {
		return tasks.isEmpty();
	}

	public final Task deleteTask(String name) {
		if (tasks.containsKey(name)) {
			return tasks.remove(name);
		} else {
			return null;
		}
	}

	public void addTask(Task task) {
		tasks.put(task.getName(), task);
	}
}
