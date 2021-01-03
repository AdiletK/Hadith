package com.tezal.hadith.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(private val jwtTokenProvider: JwtTokenProvider) : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable()
        http.cors()

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        // Entry points
        http.authorizeRequests()
                .antMatchers("/api/auth/signin").permitAll()
                .antMatchers("/api/auth/signup").permitAll()
                .antMatchers("/api/hadith/findAll").permitAll()
                .antMatchers("/api/category/findAll").permitAll()
                .antMatchers("/api/book/findAll").permitAll()
                .antMatchers("/api/status/findAll").permitAll()
                .antMatchers("/api/source/findAll").permitAll()
                .antMatchers("/api/language/findAll").permitAll()
                .antMatchers("/api/hadith/findByCatId/**").permitAll()
                .antMatchers("/api/hadith/findById/**").permitAll()
                .antMatchers("/api/category/findById/**").permitAll()
                .antMatchers("/api/book/findById/**").permitAll()
                .antMatchers("/api/source/findById/**").permitAll()
                .antMatchers("/api/language/findById/**").permitAll()
//                .antMatchers("/api/**").permitAll() // Disallow everything else..
                .anyRequest().authenticated()

        // If a user try to access a resource without having enough permissions
        http.exceptionHandling().accessDeniedPage("/login")

        // Apply JWT
        http.apply(JwtTokenFilterConfigurer(jwtTokenProvider))

        // Optional, if you want to test the API from a browser
        // http.httpBasic();
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        // Allow swagger to be accessed without authentication
        web.ignoring().antMatchers("/v2/api-docs") //
                .antMatchers("/swagger-resources/**") //
                .antMatchers("/swagger-ui/**") //
                .antMatchers("/swagger-ui.html") //
                .antMatchers("/configuration/**") //
                .antMatchers("/webjars/**") //
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(12)
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}