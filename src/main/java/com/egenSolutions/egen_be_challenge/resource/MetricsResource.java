/**
 * 
 */
package com.egenSolutions.egen_be_challenge.resource;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.created;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.egenSolutions.egen_be_challenge.model.Metrics;
import com.egenSolutions.egen_be_challenge.service.MetricsService;

/**
 * @author swapnilbalakrishna7
 *
 */
@RestController
@RequestMapping("/metrics")
public class MetricsResource {

	@Autowired
	private MetricsService metricService;

	@PostMapping(value = "/create")
	public ResponseEntity<Metrics> create(@RequestBody Metrics metric) {

		if (metric == null)
			return badRequest().build();

		metricService.createMetric(metric);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/create").buildAndExpand(metric).toUri();

		return created(location).build();
	}

	@GetMapping(value = "/readAll")
	public ResponseEntity<List<Metrics>> read() {

		List<Metrics> metricList = metricService.read();

		if (metricList.size() == 0)
			return notFound().build();

		return ok(metricList);
	}

	@GetMapping(value = "/readByRange/{startTime}/{endTime}")
	public ResponseEntity<List<Metrics>> readByTimeRange(
			@PathVariable Long startTime, @PathVariable Long endTime) {

		if (startTime == null || endTime == null)
			return ResponseEntity.badRequest().build();

		List<Metrics> metricList = metricService
				.readByRange(startTime, endTime);

		if (metricList.size() == 0)
			return notFound().build();

		return ok(metricList);
	}
}
