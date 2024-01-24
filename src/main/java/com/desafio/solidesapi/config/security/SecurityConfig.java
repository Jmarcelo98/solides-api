package com.desafio.solidesapi.config.security;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

	private final FiltroToken filter;

	private final String[] ACESSO = { "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
			"/configuration/security", "/swagger-ui.html", "/swagger-ui.html**", "/webjars/**", "/h2/**", "/h2-console/**" };

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable()).headers(head -> head.frameOptions().sameOrigin())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize ->authorize
						.antMatchers(HttpMethod.POST, "/post").permitAll()
						.antMatchers(HttpMethod.GET, "/post").permitAll()
						.antMatchers(HttpMethod.POST, "/usuario").permitAll()
//						.antMatchers(HttpMethod.POST, "/cadastrar").permitAll()
						.antMatchers(HttpMethod.GET, "/album/todos").permitAll()
						.antMatchers(ACESSO).permitAll()
						.anyRequest().authenticated())
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).build();

	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		final CorsConfiguration config = new CorsConfiguration();
//		config.addAllowedOrigin(CorsConfiguration.ALL);
//		config.addAllowedHeader("*");
//		config.addAllowedOriginPattern("*");
//		config.setAllowedOrigins(Collections.singletonList("*"));
//		config.addExposedHeader("Authorization");
//		config.addAllowedMethod("OPTIONS");
//		config.addAllowedMethod("HEAD");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("POST");
//		config.addAllowedMethod("DELETE");
//		config.addAllowedMethod("PATCH");
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter();
//	}
}