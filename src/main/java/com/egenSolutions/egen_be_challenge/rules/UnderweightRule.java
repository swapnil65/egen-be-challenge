package com.egenSolutions.egen_be_challenge.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.egenSolutions.egen_be_challenge.dao.AlertDao;
import com.egenSolutions.egen_be_challenge.model.Alerts;
import com.egenSolutions.egen_be_challenge.model.Metrics;

/**
 * @author swapnilbalakrishna7
 *
 */
@Rule(name = "Under-Weight")
public class UnderweightRule implements MetricsRule {

	private AlertDao alertDao = new AlertDao();

	private Metrics metric;

	public UnderweightRule(Metrics metric) {
		this.metric = metric;
	}

	int baseWeight = OverweightRule.getBaseWeight();

	@Condition
	public boolean when() {

		double percent = ((double) metric.getValue()) / baseWeight;

		return percent < 0.9;

	}

	@Action
	public void then() {
		Alerts alert = new Alerts(MetricsRule.RuleType.UNDER_WEIGHT.toString(),
				metric.getTimeStamp(), metric.getValue());

		alertDao.create(alert);
	}
}
