package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Iteration")
public class IterationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String index;
	@Column
	String IterationTitle, IterationDescription, IterationStartDate,
			IterationEndDate, IterationItems, IterationStatus, IterationType;

	public IterationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIterationTitle() {
		return IterationTitle;
	}

	public void setIterationTitle(String iterationTitle) {
		IterationTitle = iterationTitle;
	}

	public String getIterationDescription() {
		return IterationDescription;
	}

	public void setIterationDescription(String iterationDescription) {
		IterationDescription = iterationDescription;
	}

	public String getIterationStartDate() {
		return IterationStartDate;
	}

	public void setIterationStartDate(String iterationStartDate) {
		IterationStartDate = iterationStartDate;
	}

	public String getIterationEndDate() {
		return IterationEndDate;
	}

	public void setIterationEndDate(String iterationEndDate) {
		IterationEndDate = iterationEndDate;
	}

	public String getIterationItems() {
		return IterationItems;
	}

	public void setIterationItems(String iterationItems) {
		IterationItems = iterationItems;
	}

	public String getIterationStatus() {
		return IterationStatus;
	}

	public void setIterationStatus(String iterationStatus) {
		IterationStatus = iterationStatus;
	}

	public String getIterationType() {
		return IterationType;
	}

	public void setIterationType(String iterationType) {
		IterationType = iterationType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IterationEntity [index=" + index + ", IterationTitle="
				+ IterationTitle + ", IterationDescription="
				+ IterationDescription + ", IterationStartDate="
				+ IterationStartDate + ", IterationEndDate=" + IterationEndDate
				+ ", IterationItems=" + IterationItems + ", IterationStatus="
				+ IterationStatus + ", IterationType=" + IterationType + "]";
	}

}
