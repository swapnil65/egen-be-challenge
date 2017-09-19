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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.egenSolutions.egen_be_challenge.dao.AlertDao;
import com.egenSolutions.egen_be_challenge.resource.AlertResource;
import com.egenSolutions.egen_be_challenge.service.AlertsService;
import com.egenSolutions.egen_be_challenge.test.config.MyWebConfig;
import com.egenSolutions.egen_be_challenge.test.config.TestConfig;
import com.egenSolutions.egen_be_challenge.test.utility.MockAlertsForTest;

/**
 * @author swapnilbalakrishna7
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class, MyWebConfig.class })
@WebAppConfiguration
public class TestAlertResource {

	private MockMvc mockMvc;

	@Autowired
	private AlertDao alertDao;

	@MockBean
	private AlertsService alertsServiceMock;

	@InjectMocks
	private AlertResource alertResource;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockAlertsForTest mockAlerts;

	@Before
	public void setUp() {
		DefaultMockMvcBuilder builder = MockMvcBuilders
				.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testGetAlerts_AlertsFound_ShouldReturnFoundAlertsEntries()
			throws Exception {
		when(alertsServiceMock.read()).thenReturn(mockAlerts.getAlerts());
		mockMvc.perform(
				get("/alerts/readAll").contentType(
						MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].type", is("OVER_WEIGHT")))
				.andExpect(
						jsonPath("$[0].timeStamp",
								is(new Long("1505842554557"))))
				.andExpect(jsonPath("$[0].weight", is(171)))
				.andExpect(jsonPath("$[1].type", is("UNDER_WEIGHT")))
				.andExpect(
						jsonPath("$[1].timeStamp",
								is(new Long("1505842554560"))))
				.andExpect(jsonPath("$[1].weight", is(125)));
		verify(alertsServiceMock, times(1)).read();
		verifyNoMoreInteractions(alertsServiceMock);
	}

	@Test
	public void testGetAlertsByRange_AlertsFound_ShouldReturnFoundAlertsEntries()
			throws Exception {
		Long startTime = new Long("1505842554550");
		Long endTime = new Long("1505842554560");
		when(alertsServiceMock.readByRange(startTime, endTime)).thenReturn(
				mockAlerts.getAlertsByRange());
		mockMvc.perform(
				get("/alerts/readByRange/{startTime}/{endTime}", startTime,
						endTime).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].type", is("OVER_WEIGHT")))
				.andExpect(
						jsonPath("$[0].timeStamp",
								is(new Long("1505842554557"))))
				.andExpect(jsonPath("$[0].weight", is(171)));
		verify(alertsServiceMock, times(1)).readByRange(startTime, endTime);
		verifyNoMoreInteractions(alertsServiceMock);
	}

}