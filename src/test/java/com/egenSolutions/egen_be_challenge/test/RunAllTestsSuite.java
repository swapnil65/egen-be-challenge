package com.egenSolutions.egen_be_challenge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.egenSolutions.egen_be_challenge.test.resource.TestAlertResource;
import com.egenSolutions.egen_be_challenge.test.resource.TestMetricsResource;
import com.egenSolutions.egen_be_challenge.test.service.TestAlertService;
import com.egenSolutions.egen_be_challenge.test.service.TestMetricsService;

@RunWith(Suite.class)
@SuiteClasses({ TestAlertResource.class, TestMetricsResource.class,
		TestAlertService.class, TestMetricsService.class })
public class RunAllTestsSuite {
}
