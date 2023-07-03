package org.test.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

	@Bean
	fun springOpenAPI(): OpenAPI? {
		val openAPI = OpenAPI()
			.info(
				Info().title("Application API")
					.description("Spring Boot application")
					.version("")
			)
		return openAPI
	}
}
