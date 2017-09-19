/**
 * 
 */
package com.egenSolutions.egen_be_challenge.config;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

/**
 * @author swapnilbalakrishna7
 *
 */
public class MorphiaConfig {

	private static final String packageName = "com.egenSolutions.egen_be_challenge.model";

	private static MorphiaConfig morphiaConfig = null;

	private Datastore datastore = null;

	private MorphiaConfig() {
		Morphia morphia = new Morphia();
		morphia.mapPackage(packageName);
		datastore = morphia.createDatastore(new MongoClient(), "egenChallenge");
		datastore.ensureIndexes();
	}

	public Datastore getDatastore() {
		return datastore;
	}

	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}

	public static MorphiaConfig getInstance() {
		if (morphiaConfig == null) {
			morphiaConfig = new MorphiaConfig();
		}
		return morphiaConfig;
	}
}
