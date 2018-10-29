package com.am.innovations.builder.configurations.yml;

import java.io.Serializable;

public class Lgtm implements Serializable {

	private Object alerts;
	private Object grade;
	private final static long serialVersionUID = 8530766049397250557L;

	public Object getAlerts() {
		return alerts;
	}

	public void setAlerts(Object alerts) {
		this.alerts = alerts;
	}

	public Object getGrade() {
		return grade;
	}

	public void setGrade(Object grade) {
		this.grade = grade;
	}

}
