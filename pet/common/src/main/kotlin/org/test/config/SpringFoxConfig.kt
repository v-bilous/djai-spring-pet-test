package org.test.config

import org.springframework.beans.factory.annotation.Value
import io.swagger.annotations.ApiModelProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Pageable
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SpringFoxConfig {

	@Bean
	fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build()
			.directModelSubstitute(Pageable::class.java, SwaggerPageable::class.java)

}

data class SwaggerPageable(
		@ApiModelProperty("Number of records per page", example = "20")
		val size: Int?,
		@ApiModelProperty("Results page you want to retrieve (0..N)", example = "0")
		val page: Int?,
		@ApiModelProperty(
				value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending",
				example = "id,asc"
		)
		var sort: String?
)

