package com.astroviking.pawpals.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/user/**").authenticated()
        .anyRequest().permitAll();
    http.cors();
    http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    // These two are to enable h2 locally, should remove.
    http.csrf().disable();
    http.headers().frameOptions().sameOrigin();
  }
}
