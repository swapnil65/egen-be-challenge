/**
 * 
 */
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
@Rule(name = "Over-Weight")
public class OverweightRule implements MetricsRule {

	private AlertDao alertDao = new AlertDao();

	private Metrics metric;

	public OverweightRule(Metrics metric) {
		this.metric = metric;
	}

	public static int getBaseWeight() {

		int baseWeight = 150;
		String baseValue = System.getProperty("base.value");
		if (baseValue == null || baseValue.equals(""))
			System.err.println("Invalid value for VM argument base.value");
		else
			baseWeight = Integer.parseInt(baseValue);
		return baseWeight;
	}

	int baseWeight = 150;

	@Condition
	public boolean when() {

		baseWeight = getBaseWeight();

		double percent = ((double) metric.getValue()) / baseWeight;

		return (percent > 1.1);

	}

	@Action
	public void then() {
		Alerts alert = new Alerts(MetricsRule.RuleType.OVER_WEIGHT.toString(),
				metric.getTimeStamp(), metric.getValue());

		alertDao.create(alert);
	}
}
