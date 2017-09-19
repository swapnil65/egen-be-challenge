/**
 * 
 */
package com.egenSolutions.egen_be_challenge.rules;

/**
 * @author swapnilbalakrishna7
 *
 */
public interface MetricsRule {

	enum RuleType {
		OVER_WEIGHT, UNDER_WEIGHT
	}

	boolean when();

	void then();
}
