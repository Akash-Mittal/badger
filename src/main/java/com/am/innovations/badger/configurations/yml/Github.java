package com.am.innovations.badger.configurations.yml;

import java.io.Serializable;

public class Github implements Serializable {

	private String issues;
	private String forks;
	private String stars;
	private String license;
	private String cloneSSH;
	private String cloneHTTP;

	private final static long serialVersionUID = -3610764364456845316L;

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public String getForks() {
		return forks;
	}

	public void setForks(String forks) {
		this.forks = forks;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getCloneSSH() {
		return cloneSSH;
	}

	public void setCloneSSH(String cloneSSH) {
		this.cloneSSH = cloneSSH;
	}

	public String getCloneHTTP() {
		return cloneHTTP;
	}

	public void setCloneHTTP(String cloneHTTP) {
		this.cloneHTTP = cloneHTTP;
	}


}
