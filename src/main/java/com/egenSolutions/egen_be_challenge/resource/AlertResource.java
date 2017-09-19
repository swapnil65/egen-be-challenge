/**
 * 
 */
package com.egenSolutions.egen_be_challenge.resource;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.badRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egenSolutions.egen_be_challenge.model.Alerts;
import com.egenSolutions.egen_be_challenge.service.AlertsService;

/**
 * @author swapnilbalakrishna7
 *
 */
@RestController
@RequestMapping("/alerts")
public class AlertResource {

	@Autowired
	private AlertsService alertService;

	@GetMapping(value = "/readAll")
	public ResponseEntity<List<Alerts>> read() {

		List<Alerts> alertList = alertService.read();

		if (alertList.size() == 0)
			return notFound().build();

		return ok(alertList);
	}

	@GetMapping(value = "/readByRange/{startTime}/{endTime}")
	public ResponseEntity<List<Alerts>> readByTimeRange(
			@PathVariable Long startTime, @PathVariable Long endTime) {

		if (startTime == null || endTime == null)
			return badRequest().build();

		List<Alerts> alertList = alertService.readByRange(startTime, endTime);

		if (alertList.size() == 0)
			return notFound().build();
		return ok(alertList);
	}
}
