package com.gullyshops.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gullyshops.web.security.UserAuthenticationProvider;
import com.gullyshops.web.security.UserAuthenticationSuccessHandler;

/**
 * 
 * @author Munisekhar
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  auth
      .userDetailsService(userAuthenticationProvider());
      //.passwordEncoder(passwordEncoder());
  }   
  
  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .authorizeRequests()
          .antMatchers("/").permitAll()
          .antMatchers("/error/**").permitAll()
          .antMatchers("/patient").hasAuthority("ROLE_PATIENT")
          .antMatchers("/provider").hasAuthority("ROLE_PROVIDER")
          .antMatchers("/payer").hasAuthority("ROLE_PAYER")
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/login").failureUrl("/login?error")
          .permitAll().successHandler(successHandler()).usernameParameter("username").passwordParameter("password")
          .and()
          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
          .and()
          .exceptionHandling().accessDeniedPage("/ad");
  }
  
  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
         .antMatchers("/assets/**");
  }

  @Bean
  public AuthenticationSuccessHandler successHandler() {
  	return new UserAuthenticationSuccessHandler();
  }
  
  @Bean
  public UserDetailsService userAuthenticationProvider() {
  	return new UserAuthenticationProvider();
  }
  
 /* @Bean
  public AccessDeniedHandler accessDeniedHandler() {
  	return new OmAccessDeniedHandler("403");
  }*/
}