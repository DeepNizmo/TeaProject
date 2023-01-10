package com.spring.henallux.teaProject.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@SuppressWarnings ( { "deprecation" } )
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_REQUEST = "/login";
    private static final String LOGOUT_REQUEST = "/home";
    private static final String[] AUTHORIZED_REQUESTS_ANYBODY = new String[]{"/cart/**","/about","/home", "/home/**", "/css/**","/images/**", "/tea-category/**", "/tea-product/**", "/cart", "/register", "/register/**"};
    private static final String[] AUTHORIZED_REQUEST_NON_AUTHENTICATED = new String[] { "/login", "/inscription", "/inscription/**"};

    private final UserDetailsService userDetailsServiceImpl;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsServiceImplementation) {
        this.userDetailsServiceImpl = userDetailsServiceImplementation;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Disable because not necessary

        http
                .authorizeRequests() // We define the authorization here
                .antMatchers(AUTHORIZED_REQUEST_NON_AUTHENTICATED).anonymous()
                .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll() // For the request to the index page, any user has access
                .anyRequest().authenticated() // For all the other requests, the user needs to be authenticated

                .and()
                .formLogin() // We define the login part here.
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler()) // provided by spring to redirect to the last request
                .defaultSuccessUrl("/home", true)
                .loginPage(LOGIN_REQUEST) // We specify a login page. Or spring creates one by default
                // To make the login page the available for any user

                .and()
                .logout() // We define the logout part here - By default : URL = "/logout"
                //.logoutUrl("...") // If other link than "/logout" (that is by default)
                .logoutSuccessUrl(LOGOUT_REQUEST)  // URL to return if logout is successfull
                .permitAll(); // To make the logout available for any user
    }




    /**
     * We provide the service which will return the user and the password encoder
     * The service which is created here need to implement an interface provided by spring security.
     * See @UserDetailsServiceImpl
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

}
