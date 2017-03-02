package io.sagy.springboot.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.sagy.springboot.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String details;
	@ManyToOne
	private Topic topic;

	public Course() {
		super();
	}
	public Course(String id, String name, String details, Topic topic) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.topic = topic;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}

	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "[Course:("+id+" "+name+" "+details+" "+topic+")]";
	}
}
