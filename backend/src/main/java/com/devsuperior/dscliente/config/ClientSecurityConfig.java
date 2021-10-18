package com.devsuperior.dscliente.config;

import java.sql.Array;
import java.util.Arrays;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	private static final String[] PUBLIC_MATCHERS = { "/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.autorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll();
		
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.SetAllowedMethods(Array.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
