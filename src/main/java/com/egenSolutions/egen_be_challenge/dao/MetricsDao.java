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
import com.egenSolutions.egen_be_challenge.model.Metrics;

/**
 * @author swapnilbalakrishna7
 *
 */
@Component
public class MetricsDao {

	Datastore datastore;

	MetricsDao() {
		datastore = MorphiaConfig.getInstance().getDatastore();
	}

	public ObjectId createMetric(Metrics metric) {
		datastore.save(metric);

		return metric.getId();
	}

	public List<Metrics> read() {
		Query<Metrics> query = datastore.createQuery(Metrics.class);

		return query.asList();
	}

	public List<Metrics> readByRange(long startTime, long endTime) {
		Query<Metrics> query = datastore.createQuery(Metrics.class)
				.filter("timeStamp >=", startTime)
				.filter("timeStamp <=", endTime);
		return query.asList();
	}
}
