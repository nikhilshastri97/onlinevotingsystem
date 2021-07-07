package com.cg.ovs;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration

public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("voter-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		// return or(regex("/customers/.*"), regex("/customers/.*"));
		// for lombok below code fr products prog instead of cust
		return or(regex("/VotedList/.*"), regex("/RegisteredSocietyVoter/.*"), regex("/CooperativeSociety/.*"),
				regex("/NominatedCandidate/.*"), regex("/user/.*"), regex("/ElectionResult/.*"),
				regex("/ElectionOfficer/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Voter API").description("Nikhil API voting for developers")
				.termsOfServiceUrl("http://nikhil.com").license("Nikhil License")
				.licenseUrl("nikhilshastri97@gmail.com").version("1.0").build();
	}

}
