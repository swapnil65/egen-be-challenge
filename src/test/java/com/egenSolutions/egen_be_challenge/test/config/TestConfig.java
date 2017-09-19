/**
 * 
 */
package com.egenSolutions.egen_be_challenge.test.config;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.egenSolutions.egen_be_challenge.dao.AlertDao;
import com.egenSolutions.egen_be_challenge.dao.MetricsDao;
import com.egenSolutions.egen_be_challenge.resource.AlertResource;
import com.egenSolutions.egen_be_challenge.resource.MetricsResource;
import com.egenSolutions.egen_be_challenge.service.AlertsService;
import com.egenSolutions.egen_be_challenge.service.MetricsService;
import com.egenSolutions.egen_be_challenge.test.utility.MockAlertsForTest;
import com.egenSolutions.egen_be_challenge.test.utility.MockMetricsForTest;

/**
 * @author swapnilbalakrishna7
 *
 */

@Configuration
public class TestConfig {

	@Bean
	public AlertsService alertsService() {
		return Mockito.mock(AlertsService.class);
	}

	@Bean
	public AlertDao alertDao() {
		return Mockito.mock(AlertDao.class);
	}

	@Bean
	public AlertResource alertResource() {
		return new AlertResource();
	}

	@Bean
	public MockAlertsForTest mockAlertsForTest() {
		return new MockAlertsForTest();
	}

	@Bean("rulesEngine")
	public RulesEngine rulesEngine() {
		return RulesEngineBuilder.aNewRulesEngine().build();
	}

	@Bean
	@DependsOn(value = { "rulesEngine" })
	public MetricsService metricsService() {
		return Mockito.mock(MetricsService.class);
	}

	@Bean
	public MetricsDao metricsDao() {
		return Mockito.mock(MetricsDao.class);
	}

	@Bean
	public MetricsResource metricsResource() {
		return new MetricsResource();
	}

	@Bean
	public MockMetricsForTest mockMetricsForTest() {
		return new MockMetricsForTest();
	}

}
