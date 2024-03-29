package com.birdsh.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration  //通过@Configuration注解，表明它是一个配置类
@EnableSwagger2 //@EnableSwagger2开启swagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		/**apiINfo()配置一些基本的信息
		 * apis()指定扫描的包会生成文档
		 */
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.birdsh"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档")
				.description("简单优雅的restfun风格，http://blog.csdn.net/forezp")
				.termsOfServiceUrl("http://blog.csdn.net/forezp")
				.version("1.0")
				.build();
	}
}
