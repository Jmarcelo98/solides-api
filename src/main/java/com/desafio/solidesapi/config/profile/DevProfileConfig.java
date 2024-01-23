package com.desafio.solidesapi.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.solidesapi.services.StartDbServiceDev;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@Profile("dev")
public class DevProfileConfig {

	private StartDbServiceDev dbService;

	@Bean
	public boolean instantiateDatabase() {
		dbService.instanciarDados();
		return true;
	}

}
