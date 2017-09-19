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
import org.easyrules.core.RulesEngineBuilder;
import org.junit.Before;
import org.junit.Test;

import com.egenSolutions.egen_be_challenge.dao.MetricsDao;
import com.egenSolutions.egen_be_challenge.model.Metrics;
import com.egenSolutions.egen_be_challenge.service.MetricsService;

public class TestMetricsService {

	private MetricsService metricsService;
	private MetricsDao metricsDaoMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		metricsService = new MetricsService();
		metricsDaoMock = mock(MetricsDao.class);
		metricsService.setMetricsDao(metricsDaoMock);
		metricsService.setRuleEngine(RulesEngineBuilder.aNewRulesEngine()
				.build());
	}

	@Test
	public void checkCreateMetrics() {
		Metrics metric = new Metrics(new Long("1505838914068"), 150);
		ObjectId expected = new ObjectId();
		when(metricsDaoMock.createMetric(metric)).thenReturn(expected);
		ObjectId actual = metricsService.createMetric(metric);
		verify(metricsDaoMock, times(1)).createMetric(metric);
		verifyNoMoreInteractions(metricsDaoMock);
		assertEquals(expected, actual);
	}

	@Test
	public void checkReadMetrics() {
		List<Metrics> expected = new ArrayList<Metrics>();
		when(metricsService.read()).thenReturn(expected);
		List<Metrics> actual = metricsService.read();
		verify(metricsDaoMock, times(1)).read();
		verifyNoMoreInteractions(metricsDaoMock);
		assertEquals(expected, actual);
	}

	@Test
	public void checkReadMetricsByRange() {
		List<Metrics> expected = new ArrayList<Metrics>();
		Long startTime = new Long("1505838914064");
		Long endTime = new Long("1505838914069");
		when(metricsDaoMock.readByRange(startTime, endTime)).thenReturn(
				expected);
		List<Metrics> actual = metricsService.readByRange(startTime, endTime);
		verify(metricsDaoMock, times(1)).readByRange(startTime, endTime);
		verifyNoMoreInteractions(metricsDaoMock);
		assertEquals(expected, actual);
	}

}
