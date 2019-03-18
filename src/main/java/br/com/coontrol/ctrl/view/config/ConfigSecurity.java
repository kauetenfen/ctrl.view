package br.com.coontrol.ctrl.view.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//    private MyUserDetailsService myUserDetailsService;

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    // require all requests to be authenticated except for the resources
	    http.authorizeRequests().antMatchers("/javax.faces.resource/**", "/images/**")
	        .permitAll().anyRequest().authenticated();
	    // login
	    http.formLogin().loginPage("/login.xhtml").permitAll()
	    	.successForwardUrl("/index.xhtml")
	        .failureUrl("/login.xhtml?error=true")
	        .defaultSuccessUrl("/index.xhtml");
	    // logout
	    http.logout().logoutSuccessUrl("/login.xhtml");
	    // not needed as JSF 2.2 is implicitly protected against CSRF
	    http.csrf().disable();
	  }

	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("coontrol").password("{noop}1234").roles("USER").and()
		  .withUser("kaue").password("{noop}1234").roles("ADMIN");
	  }
	  
//	  @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.authenticationProvider(authenticationProvider());	        
//	    }
	  
//	  @Bean
//	    public DaoAuthenticationProvider authenticationProvider() {
//	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	        authProvider.setUserDetailsService(myUserDetailsService);
//	        authProvider.setPasswordEncoder(passwordEncoder());
//	        return authProvider;
//	    }
	  
//		@Bean
//		public PasswordEncoder passwordEncoder() {
//			return NoOpPasswordEncoder.getInstance();
//		}
	

}
