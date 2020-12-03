package cloud.jordaan.juan.csg.infrastructure;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.authorizeRequests()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).authenticated()
				.antMatchers("/h2-console/**").permitAll()
			.and()
				.headers().frameOptions().disable()
			.and().httpBasic();
	}
}
