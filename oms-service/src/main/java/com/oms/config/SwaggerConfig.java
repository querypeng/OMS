package com.oms.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * swagger 配置
 *
 * @author shisen
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final Environment environment;

	@Value("${project.version}")
	private String version;

	public SwaggerConfig(Environment environment) {this.environment = environment;}

	@SuppressWarnings("all")
	@Bean
	public Docket swaggerDocketUser() {
		Predicate<String> userPredicate = PathSelectors.ant("/micro/**");
		return createSwaggerGroup("MicroAppApi", userPredicate);
	}


	@SuppressWarnings("all")
	private Docket createSwaggerGroup(@NotNull String groupName, Predicate... predicates) {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(enableSwagger())
				.apiInfo(apiInfo())
				.groupName(groupName)
				.ignoredParameterTypes(HttpSession.class)
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(Predicates.or(predicates))
				.build();
	}

	private boolean enableSwagger() {
		Profiles profiles = Profiles.of("dev", "test");
		return environment.acceptsProfiles(profiles);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("OMS 服务接口文档")
				.version(version)
				.build();
	}

}
