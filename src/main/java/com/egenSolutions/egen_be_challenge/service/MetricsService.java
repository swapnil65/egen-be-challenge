/**
 * 
 */
package com.egenSolutions.egen_be_challenge.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egenSolutions.egen_be_challenge.dao.MetricsDao;
import com.egenSolutions.egen_be_challenge.model.Metrics;
import com.egenSolutions.egen_be_challenge.rules.MetricsRule;
import com.egenSolutions.egen_be_challenge.rules.RulesFactory;

/**
 * @author swapnilbalakrishna7
 *
 */
@Component
public class MetricsService {

	@Autowired
	RulesEngine rulesEngine;

	MetricsRule rule;

	@Autowired
	private MetricsDao metricsDao;

	public ObjectId createMetric(Metrics metric) {
		rule = RulesFactory.getRule(MetricsRule.RuleType.UNDER_WEIGHT, metric);
		rulesEngine.registerRule(rule);
		rule = RulesFactory.getRule(MetricsRule.RuleType.OVER_WEIGHT, metric);
		rulesEngine.registerRule(rule);

		rulesEngine.fireRules();
		rulesEngine.clearRules();

		return metricsDao.createMetric(metric);
	}

	public List<Metrics> read() {
		return metricsDao.read();
	}

	public List<Metrics> readByRange(long startTime, long endTime) {
		return metricsDao.readByRange(startTime, endTime);
	}

	public void setMetricsDao(MetricsDao metricsDao) {
		this.metricsDao = metricsDao;
	}

	public void setRuleEngine(RulesEngine rulesEngine) {
		this.rulesEngine = rulesEngine;
	}
}
