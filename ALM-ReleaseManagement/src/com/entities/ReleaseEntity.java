package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="releasetable")

public class ReleaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ReleaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String index;
	@Column
	private String ReleaseTitle,ReleaseDescription,ReleaseStartDate,ReleasePlannedDate,ReleaseReleaseDate,ReleaseType,ReleaseTo,ReleaseItems,ReleaseStatus,ReleaseManager,ReleaseVersion;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getReleaseTitle() {
		return ReleaseTitle;
	}
	public void setReleaseTitle(String releaseTitle) {
		ReleaseTitle = releaseTitle;
	}
	public String getReleaseDescription() {
		return ReleaseDescription;
	}
	public void setReleaseDescription(String releaseDescription) {
		ReleaseDescription = releaseDescription;
	}
	public String getReleaseStartDate() {
		return ReleaseStartDate;
	}
	public void setReleaseStartDate(String releaseStartDate) {
		ReleaseStartDate = releaseStartDate;
	}
	public String getReleasePlannedDate() {
		return ReleasePlannedDate;
	}
	public void setReleasePlannedDate(String releasePlannedDate) {
		ReleasePlannedDate = releasePlannedDate;
	}
	public String getReleaseReleaseDate() {
		return ReleaseReleaseDate;
	}
	public void setReleaseReleaseDate(String releaseReleaseDate) {
		ReleaseReleaseDate = releaseReleaseDate;
	}
	public String getReleaseType() {
		return ReleaseType;
	}
	public void setReleaseType(String releaseType) {
		ReleaseType = releaseType;
	}
	public String getReleaseTo() {
		return ReleaseTo;
	}
	public void setReleaseTo(String releaseTo) {
		ReleaseTo = releaseTo;
	}
	public String getReleaseItems() {
		return ReleaseItems;
	}
	public void setReleaseItems(String releaseItems) {
		ReleaseItems = releaseItems;
	}
	public String getReleaseStatus() {
		return ReleaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		ReleaseStatus = releaseStatus;
	}
	public String getReleaseManager() {
		return ReleaseManager;
	}
	public void setReleaseManager(String releaseManager) {
		ReleaseManager = releaseManager;
	}
	public String getReleaseVersion() {
		return ReleaseVersion;
	}
	public void setReleaseVersion(String releaseVersion) {
		ReleaseVersion = releaseVersion;
	}
	@Override
	public String toString() {
		return "ReleaseEntity [index=" + index + ", ReleaseTitle="
				+ ReleaseTitle + ", ReleaseDescription=" + ReleaseDescription
				+ ", ReleaseStartDate=" + ReleaseStartDate
				+ ", ReleasePlannedDate=" + ReleasePlannedDate
				+ ", ReleaseReleaseDate=" + ReleaseReleaseDate
				+ ", ReleaseType=" + ReleaseType + ", ReleaseTo=" + ReleaseTo
				+ ", ReleaseItems=" + ReleaseItems + ", ReleaseStatus="
				+ ReleaseStatus + ", ReleaseManager=" + ReleaseManager
				+ ", ReleaseVersion=" + ReleaseVersion + "]";
	}

	
}
