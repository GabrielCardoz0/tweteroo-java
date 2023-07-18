package com.tweteroo.api.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {
    @Override
    protected void configuration(HttpSecurity http) {
        http.cors().and().csrf().disable();
    }
}

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig extends WebSecurityConfiguration {

//     @Override
//     protected void Configuration(HttpSecurity http) throws Exception {
//         // Configurações de segurança aqui
//         // Por exemplo, você pode definir regras de autorização, autenticação, etc.
//     }
// }