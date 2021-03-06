package com.alkemy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alkemy.service.UsuarioService;

import lombok.AllArgsConstructor;

@Configuration 
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	  	private final UsuarioService usuarioService;
	    private final BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.httpBasic().and()
	                .csrf().disable()
	                .authorizeRequests()  
	                .antMatchers("/auth/register/**").permitAll()
	                .antMatchers("/auth/login").permitAll()	         
	                .anyRequest()
	                .authenticated().and()
	                .formLogin()
	                .loginProcessingUrl("/auth/login");
	    	
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }

	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider =
	                new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(bCryptPasswordEncoder);
	        provider.setUserDetailsService(usuarioService);
	        return provider;
	    }
}
