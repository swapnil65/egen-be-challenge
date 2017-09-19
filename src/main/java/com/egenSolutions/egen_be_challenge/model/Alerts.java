package com.egenSolutions.egen_be_challenge.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * @author swapnilbalakrishna7
 *
 */

@Entity("alerts")
public class Alerts {

	@Id
	@Property("id")
	private ObjectId id;

	@Property("type")
	private String type;

	@Property("timeStamp")
	private long timeStamp;

	@Property("weight")
	private int weight;

	public Alerts() {
	}

	/**
	 * @param type
	 * @param timeStamp
	 * @param weight
	 */
	public Alerts(String type, long timeStamp, int weight) {
		super();
		this.type = type;
		this.timeStamp = timeStamp;
		this.weight = weight;
	}

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alert [id=" + id + ", type=" + type + ", timeStamp="
				+ timeStamp + ", weight=" + weight + "]";
	}

}