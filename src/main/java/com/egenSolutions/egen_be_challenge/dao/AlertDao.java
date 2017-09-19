/**
 * 
 */
package com.egenSolutions.egen_be_challenge.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import com.egenSolutions.egen_be_challenge.config.MorphiaConfig;
import com.egenSolutions.egen_be_challenge.model.Alerts;

/**
 * @author swapnilbalakrishna7
 *
 */
@Component
public class AlertDao {

	Datastore datastore;

	public AlertDao() {
		datastore = MorphiaConfig.getInstance().getDatastore();
	}

	public ObjectId create(Alerts alert) {
		Datastore datastore = MorphiaConfig.getInstance().getDatastore();

		datastore.save(alert);

		return alert.getId();
	}

	public List<Alerts> read() {
		Query<Alerts> query = datastore.createQuery(Alerts.class);

		return query.asList();
	}

	public List<Alerts> readByRange(long startTime, long endTime) {
		Query<Alerts> query = datastore.createQuery(Alerts.class)
				.filter("timeStamp >=", startTime)
				.filter("timeStamp <=", endTime);

		return query.asList();
	}

}
