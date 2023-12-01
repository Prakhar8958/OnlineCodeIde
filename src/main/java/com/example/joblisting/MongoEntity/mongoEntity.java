package com.example.joblisting.MongoEntity;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="demohelper")
public class mongoEntity {

	private int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	private String desc;
	private String profile;
	private int experience;
	private String skills[];
	/**
	 * @return the id
	 */
	

	/**
	 * @return the skills
	 */
	public String[] getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	/**
	 * @param id the id to set
	 */

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	
	

	@Override
	public String toString() {
		return "mongoEntity [id=" + id + ", desc=" + desc + ", profile=" + profile + ", experience=" + experience
				+ ", skills=" + Arrays.toString(skills) + "]";
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the experience
	 */
	
	/**
	 * @param experience the experience to set
	 */
	
	/**
	 * @return the skills
	 */

	/**
	 * @param skills the skills to set
	 */
	
	
	
	
}
