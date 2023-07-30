package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableMethodSecurity
@Configuration
public class MySecurityConfig {

        @Bean
        //Basic Authentication
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authz) -> authz
                            .anyRequest().authenticated()
                    )
                    .httpBasic(withDefaults());
            return http.build();
        }

        @Bean
        public static PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        //in memory --> user haru banaune
        @Bean
        public UserDetailsService userDetailsService(){
            UserDetails santosh = User.builder().username("santosh")
                    .password(passwordEncoder()
                     .encode("santosh"))
                    .roles("USER")
                    .build();

            UserDetails admin = User.builder().username("admin").password(passwordEncoder().
                    encode("admin")).
                    roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(santosh,admin);
        }


    }


