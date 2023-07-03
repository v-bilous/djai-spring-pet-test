package org.pet.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["org.pet.pet", "org.pet.config"])
@EntityScan(value = ["org.pet.pet.domain", "org.pet.domain"])
class PetApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}
