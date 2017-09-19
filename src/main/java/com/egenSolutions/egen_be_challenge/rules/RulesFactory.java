/**
 * 
 */
package com.egenSolutions.egen_be_challenge.rules;

import com.egenSolutions.egen_be_challenge.model.Metrics;
import com.egenSolutions.egen_be_challenge.rules.MetricsRule.RuleType;

/**
 * @author swapnilbalakrishna7
 *
 */
public class RulesFactory {

	public static MetricsRule getRule(RuleType type, Metrics metric) {

		if (type == RuleType.OVER_WEIGHT)
			return new OverweightRule(metric);
		else if (type == RuleType.UNDER_WEIGHT)
			return new UnderweightRule(metric);

		return null;
	}
}
