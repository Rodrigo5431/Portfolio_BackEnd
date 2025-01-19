package com.portfolio.api.dto;

public class ProjectInsertDTO {

	private String title;
	private String description;
	private String technologies;
	private String link;
	private String githubLink;
	private String image;

	public ProjectInsertDTO(String title, String description, String technologies, String link, String githubLink,
			String image) {
		super();
		this.title = title;
		this.description = description;
		this.technologies = technologies;
		this.link = link;
		this.githubLink = githubLink;
		this.image = image;
	}

	public ProjectInsertDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
