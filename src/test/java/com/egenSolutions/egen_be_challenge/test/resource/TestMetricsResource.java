/**
 * 
 */
package com.egenSolutions.egen_be_challenge.test.resource;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.egenSolutions.egen_be_challenge.dao.MetricsDao;
import com.egenSolutions.egen_be_challenge.model.Metrics;
import com.egenSolutions.egen_be_challenge.resource.MetricsResource;
import com.egenSolutions.egen_be_challenge.service.MetricsService;
import com.egenSolutions.egen_be_challenge.test.config.MyWebConfig;
import com.egenSolutions.egen_be_challenge.test.config.TestConfig;
import com.egenSolutions.egen_be_challenge.test.utility.MockMetricsForTest;

/**
 * @author swapnilbalakrishna7
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class, MyWebConfig.class })
@WebAppConfiguration
public class TestMetricsResource {

	private MockMvc mockMvc;

	@Autowired
	private MetricsDao metricsDao;

	@MockBean
	private MetricsService metricsServiceMock;

	@InjectMocks
	private MetricsResource metricsResource;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMetricsForTest mockMetrics;

	@Before
	public void setUp() {
		DefaultMockMvcBuilder builder = MockMvcBuilders
				.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testCreateMetrics_ShouldReturnFoundObjectId() throws Exception {

		Metrics metric = new Metrics(new Long("1505838914068"), 200);
		ObjectId id = new ObjectId();

		when(metricsServiceMock.createMetric(metric)).thenReturn(id);
		mockMvc.perform(
				post("/metrics/create")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(
								"{\"timeStamp\": \"1505838914068\", \"value\": \"200\"}"))
				.andExpect(status().isCreated()).andReturn();
	}

	@Test
	public void testGetAlerts_AlertsFound_ShouldReturnFoundAlertsEntries()
			throws Exception {
		when(metricsServiceMock.read()).thenReturn(mockMetrics.getMetrics());
		mockMvc.perform(
				get("/metrics/readAll").contentType(
						MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(
						jsonPath("$[0].timeStamp",
								is(new Long("1505838914068"))))
				.andExpect(jsonPath("$[0].value", is(150)))
				.andExpect(
						jsonPath("$[1].timeStamp",
								is(new Long("1505838914070"))))
				.andExpect(jsonPath("$[1].value", is(160)));
		verify(metricsServiceMock, times(1)).read();
		verifyNoMoreInteractions(metricsServiceMock);
	}

	@Test
	public void testGetAlertsByRange_AlertsFound_ShouldReturnFoundAlertsEntries()
			throws Exception {
		Long startTime = new Long("1505838914064");
		Long endTime = new Long("1505838914069");
		when(metricsServiceMock.readByRange(startTime, endTime)).thenReturn(
				mockMetrics.getMetricsByRange());
		mockMvc.perform(
				get("/metrics/readByRange/{startTime}/{endTime}", startTime,
						endTime).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(
						jsonPath("$[0].timeStamp",
								is(new Long("1505838914068"))))
				.andExpect(jsonPath("$[0].value", is(150)));
		verify(metricsServiceMock, times(1)).readByRange(startTime, endTime);
		verifyNoMoreInteractions(metricsServiceMock);
	}

}
