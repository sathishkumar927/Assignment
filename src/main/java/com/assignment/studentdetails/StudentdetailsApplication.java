package com.assignment.studentdetails;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.repository.CourseRepository;
import com.assignment.studentdetails.repository.DepartmentRepository;
import com.assignment.studentdetails.repository.InstructorRepository;
import com.assignment.studentdetails.repository.StudentRepository;
import com.assignment.studentdetails.security.JWTAuthorizationFilter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentdetailsApplication.
 */
@SpringBootApplication
@EnableSwagger2
public class StudentdetailsApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudentdetailsApplication.class, args);
	}
	
    /**
     * Product api.
     *
     * @return the docket
     */
    @Bean
    public Docket productApi() {
    	String groupName = "Swagger";
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey())).select()
                .apis(RequestHandlerSelectors.any())
                .build().groupName(groupName);
    }

    /**
     * Api key.
     *
     * @return the api key
     */
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    /**
     * Security context.
     *
     * @return the security context
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

   /**
    * Default auth.
    *
    * @return the list
    */
   private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    /**
     * The Class WebSecurityConfig.
     */
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        /**
         * Configure.
         *
         * @param http the http
         * @throws Exception the exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/v1/user/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/v1/student/**").permitAll()
                    .antMatchers("/h2/**").permitAll()
                    .anyRequest().authenticated();
        }
        
        /**
         * Configure.
         *
         * @param web the web
         * @throws Exception the exception
         */
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/h2/**",
                    "/webjars/**");
        }
    }
	
	
}
