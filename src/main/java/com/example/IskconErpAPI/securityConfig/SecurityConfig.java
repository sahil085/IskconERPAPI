package com.example.IskconErpAPI.securityConfig;

import com.example.IskconErpAPI.constants.RoleConstant;
import com.example.IskconErpAPI.domain.Role;
import com.example.IskconErpAPI.domain.User;
import com.example.IskconErpAPI.repository.UserRepository;
import com.example.IskconErpAPI.securityservices.CustomUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService appUserDetailsService;

    @Autowired
    UserRepository userInfoRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");

            }
        };
    }

    @PostConstruct
    public void createAdmin(){
        User userInfo1 = userInfoRepository.findByEmail("sahil.verma@tothenew.com");
        if(userInfo1==null){
            User userInfo = new User();
            userInfo.setEmail("sahil.verma@tothenew.com");
            userInfo.setPassword(new BCryptPasswordEncoder().encode("igdefault"));
            userInfo.setUsername("sahil verma");
            Set<Role> roles = new HashSet<>();
            Role role = new Role();
            role.setRole(RoleConstant.ROLE_ADMIN);
            roles.add(role);
            userInfo.setRoles(roles);
            userInfoRepository.saveAndFlush(userInfo);

            System.out.println(" ****  Admin Created  ****");
        }


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and()
                // starts authorizing configurations
                .authorizeRequests()
                // ignoring the guest's urls "
                .antMatchers("/account/login","/logout").permitAll()
                // authenticate all remaining URLS
                .anyRequest().authenticated().and()
                /* "/logout" will log the user out by invalidating the HTTP Session,
                 * cleaning up any {link rememberMe()} authentication that was configured, */
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .logoutUrl("/account/logout")
                .logoutSuccessUrl("/account/login")
                .and()
                // enabling the basic authentication
                .httpBasic().and()
                // configuring the session on the server
                // disabling the CSRF - Cross Site Request Forgery
                .csrf().disable();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://iskcon-erp.herokuapp.com","http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
