/**
 * 
 */
package com.egenSolutions.egen_be_challenge.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * @author swapnilbalakrishna7
 *
 */
@Entity("metrics")
public class Metrics {

	@Id
	@Property("id")
	private ObjectId id;

	@Property("timeStamp")
	private long timeStamp;

	@Property("value")
	private int value;

	public Metrics() {
	}

	/**
	 * @param timeStamp
	 * @param value
	 */
	public Metrics(long timeStamp, int value) {
		super();
		this.timeStamp = timeStamp;
		this.value = value;
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
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Metric [id=" + id + ", timeStamp=" + timeStamp + ", value="
				+ value + "]";
	}

}
