package org.test.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["org.test.pet", "org.test.config"])
@EntityScan(value = ["org.test.pet.domain", "org.test.domain"])
class PetApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}
