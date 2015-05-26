package model;

/*import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

//@Entity

//@Table(name="Iteration")

public class IterationEntity{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//
	
	int index;
	String title,desc,startDate,endDate,items,status,type;
	
	
	public IterationEntity(int index,String title, String desc, String startDate,
		String endDate, String items, String status, String type) 
	{
	super();
	this.index = index;
	this.title = title;
	this.desc = desc;
	this.startDate = startDate;
	this.endDate = endDate;
	this.items = items;
	this.status = status;
	this.type = type;
	}
	public IterationEntity() {
		
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toSilly() {
		
		return "{"+"\"index\":\""+ index+ "\",\"title\":\"" + title + "\",\"desc\":\""
				+ desc + "\",\"startDate\":\"" + startDate + "\",\"endDate\":\""
				+ endDate + "\",\"items\":\"" + items + "\",\"status\":\"" + status
				+ "\",\"type\":\"" + type +"\"}";
	}
	public String toHuz() {	
		return "{"+"\"index\":\""+ index+  "\",\"title\":\""+ title+ "\",\"desc\":\""+ desc 
				+ "\",\"startDate\":\"" + startDate + "\",\"endDate\":\""
				+ endDate + "\",\"items\":\"" + items + "\",\"status\":\"" 
				+ status+ "\",\"type\":\""+type;
		
		//If you add the ending bracket all hell breaks loose
		
	}//{"firstName":"John","lastName":"Doe"}
	
	public String toString() {
		return "IterationEntity [title=" + title + ", description="
				+ desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", items=" + items + ", status=" + status
				+ ", type=" + type + "]";
	}
	
	
}
