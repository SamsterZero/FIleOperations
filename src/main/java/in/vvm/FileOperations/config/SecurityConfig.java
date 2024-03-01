package in.vvm.FileOperations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
				.formLogin(form -> form.defaultSuccessUrl("/Home")).httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder,
			PasswordEncoder passwordEncoder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user")
				.password(passwordEncoder.encode("password")).roles("USER").and().withUser("admin")
				.password(passwordEncoder.encode("admin")).roles("ADMIN");
	}
}