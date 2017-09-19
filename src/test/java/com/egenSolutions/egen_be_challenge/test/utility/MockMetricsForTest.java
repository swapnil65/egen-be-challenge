/**
 * 
 */
package com.egenSolutions.egen_be_challenge.test.utility;

import java.util.ArrayList;
import java.util.List;

import com.egenSolutions.egen_be_challenge.model.Metrics;

/**
 * @author swapnilbalakrishna7
 *
 */
public class MockMetricsForTest {

	public List<Metrics> getMetrics() {

		List<Metrics> metrics = new ArrayList<Metrics>();
		Metrics metric1 = new Metrics(new Long("1505838914068"), 150);
		Metrics metric2 = new Metrics(new Long("1505838914070"), 160);
		metrics.add(metric1);
		metrics.add(metric2);
		return metrics;
	}

	public List<Metrics> getMetricsByRange() {

		List<Metrics> metrics = new ArrayList<Metrics>();
		Metrics metric1 = new Metrics(new Long("1505838914068"), 150);
		metrics.add(metric1);
		return metrics;
	}

}
