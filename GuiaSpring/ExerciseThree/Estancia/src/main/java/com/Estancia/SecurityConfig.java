package com.Estancia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Estancia.Service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UsuarioService usuarioService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/").permitAll()
				.antMatchers("/*").authenticated()
			.and().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/logincheck")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess")
				.permitAll()
			.and().logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll().and().csrf().disable();
	}

}
