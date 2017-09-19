/**
 * 
 */
package com.egenSolutions.egen_be_challenge.test.utility;

import java.util.ArrayList;
import java.util.List;

import com.egenSolutions.egen_be_challenge.model.Alerts;

/**
 * @author swapnilbalakrishna7
 *
 */
public class MockAlertsForTest {

	public List<Alerts> getAlerts() {
		List<Alerts> alerts = new ArrayList<Alerts>();
		Alerts alert1 = new Alerts("OVER_WEIGHT", new Long("1505842554557"),
				171);
		Alerts alert2 = new Alerts("UNDER_WEIGHT", new Long("1505842554560"),
				125);
		alerts.add(alert1);
		alerts.add(alert2);
		return alerts;
	}

	public List<Alerts> getAlertsByRange() {
		List<Alerts> alerts = new ArrayList<Alerts>();
		Alerts alert1 = new Alerts("OVER_WEIGHT", new Long("1505842554557"),
				171);
		alerts.add(alert1);
		return alerts;
	}

}
