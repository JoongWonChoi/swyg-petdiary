package com.swyg.petdiary.config;

import com.swyg.petdiary.config.filter.CustomUsernamePasswordAuthenticationFilter;
import com.swyg.petdiary.config.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/join/**").permitAll()
                .and()
                .formLogin().disable();
        http.addFilterAt(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/logoutSuccess")
                .invalidateHttpSession(true);


    }

    protected CustomUsernamePasswordAuthenticationFilter getAuthenticationFilter() {
        CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
        try {
            filter.setFilterProcessesUrl("/login");
            filter.setAuthenticationManager(this.authenticationManagerBean());
            filter.setUsernameParameter("email");
            filter.setPasswordParameter("password");
            filter.setAuthenticationSuccessHandler(new LoginSuccessHandler("/loginSuccess"));
            //filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }
}
