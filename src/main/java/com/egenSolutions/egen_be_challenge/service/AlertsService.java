/**
 * 
 */
package com.egenSolutions.egen_be_challenge.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egenSolutions.egen_be_challenge.dao.AlertDao;
import com.egenSolutions.egen_be_challenge.model.Alerts;

/**
 * @author swapnilbalakrishna7
 *
 */

@Component
public class AlertsService {

	@Autowired
	private AlertDao alertDao;

	public AlertsService() {
	}

	public ObjectId create(Alerts alert) {
		return alertDao.create(alert);
	}

	public List<Alerts> read() {
		return alertDao.read();
	}

	public List<Alerts> readByRange(long startTime, long endTime) {
		return alertDao.readByRange(startTime, endTime);
	}

	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}
}
