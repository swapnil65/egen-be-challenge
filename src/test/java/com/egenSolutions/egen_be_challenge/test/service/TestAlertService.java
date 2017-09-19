/**
 * 
 */
package com.egenSolutions.egen_be_challenge.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.egenSolutions.egen_be_challenge.dao.AlertDao;
import com.egenSolutions.egen_be_challenge.model.Alerts;
import com.egenSolutions.egen_be_challenge.service.AlertsService;

/**
 * @author swapnilbalakrishna7
 *
 */
public class TestAlertService {

	private AlertsService alertService;
	private AlertDao alertDaoMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		alertService = new AlertsService();
		alertDaoMock = mock(AlertDao.class);
		alertService.setAlertDao(alertDaoMock);
		;
	}

	@Test
	public void checkCreateAlert() {
		Alerts alert = new Alerts("OVER_WEIGHT", new Long("1505842554557"), 171);
		ObjectId expected = new ObjectId();
		when(alertDaoMock.create(alert)).thenReturn(expected);
		ObjectId actual = alertService.create(alert);
		verify(alertDaoMock, times(1)).create(alert);
		verifyNoMoreInteractions(alertDaoMock);
		assertEquals(expected, actual);
	}

	@Test
	public void checkReadAlerts() {
		List<Alerts> expected = new ArrayList<Alerts>();
		when(alertDaoMock.read()).thenReturn(expected);
		List<Alerts> actual = alertService.read();
		verify(alertDaoMock, times(1)).read();
		verifyNoMoreInteractions(alertDaoMock);
		assertEquals(expected, actual);
	}

	@Test
	public void checkReadAlertsByRange() {
		List<Alerts> expected = new ArrayList<Alerts>();
		Long startTime = new Long("1505842554550");
		Long endTime = new Long("1505842554560");
		when(alertDaoMock.readByRange(startTime, endTime)).thenReturn(expected);
		List<Alerts> actual = alertService.readByRange(startTime, endTime);
		verify(alertDaoMock, times(1)).readByRange(startTime, endTime);
		verifyNoMoreInteractions(alertDaoMock);
		assertEquals(expected, actual);
	}

}
