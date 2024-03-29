package com.example.gamelistapi.security;

import com.example.gamelistapi.repository.UsuarioRepository;
import com.example.gamelistapi.service.JWTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigs extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthService authService;
    @Autowired
    private JWTokenService jwTokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().authorizeHttpRequests().
                antMatchers(HttpMethod.POST,"/login").permitAll().
                antMatchers(HttpMethod.POST, "/usuario/cadastrar").permitAll().
                antMatchers(HttpMethod.GET,"/usuario/**").permitAll().
                antMatchers(HttpMethod.GET,"/games").permitAll().
                antMatchers(HttpMethod.GET,"/games/*").permitAll().
                antMatchers(HttpMethod.GET,"/games/recuperar-review/").permitAll().
                antMatchers(HttpMethod.GET,"/games/recuperar-review/*").permitAll().
                antMatchers(HttpMethod.POST,"/games/*").permitAll().
                antMatchers(HttpMethod.POST,"/usuario/*").permitAll().
                antMatchers(HttpMethod.DELETE, "/usuario/*").permitAll().
                antMatchers(HttpMethod.GET, "/**").permitAll().
                antMatchers(HttpMethod.POST, "/**").permitAll().
                antMatchers(HttpMethod.DELETE, "/**").permitAll().
                antMatchers(HttpMethod.PUT, "/**").permitAll().
                anyRequest().authenticated().
                and().csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilterBefore(new AuthValidationFilter(jwTokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public CorsFilter corsFilter() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
