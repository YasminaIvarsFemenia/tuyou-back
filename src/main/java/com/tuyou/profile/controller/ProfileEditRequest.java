package com.tuyou.profile.controller;

public class ProfileEditRequest {

	private String name;
	private String surname;
	private String studies;
	private String birthplace;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the studies
	 */
	public String getStudies() {
		return studies;
	}

	/**
	 * @param studies the studies to set
	 */
	public void setStudies(String studies) {
		this.studies = studies;
	}

	/**
	 * @return the birthplace
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/**
	 * @param birthplace the birthplace to set
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

}
