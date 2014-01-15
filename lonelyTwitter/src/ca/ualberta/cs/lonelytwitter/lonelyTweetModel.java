package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
//private    only current class+package
//protected  current class,subclass,package
//public     anywhere in java
public class lonelyTweetModel {
    private String text;
    private Date timestamp;
	// getters and setters
    public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	// constructor
	public lonelyTweetModel(String text, Date timestamp) {
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	// second
	public lonelyTweetModel(String text) {
		super();
		this.text = text;
		this.timestamp = new Date();
	}
    
	
}
