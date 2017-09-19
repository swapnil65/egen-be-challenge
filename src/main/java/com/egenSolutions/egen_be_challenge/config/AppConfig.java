/**
 * 
 */
package com.egenSolutions.egen_be_challenge.config;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author swapnilbalakrishna7
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public RulesEngine rulesEngine() {
		return RulesEngineBuilder.aNewRulesEngine().build();
	}

}
