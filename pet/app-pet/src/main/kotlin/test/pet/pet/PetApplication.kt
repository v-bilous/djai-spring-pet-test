package test.pet.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["test.pet.pet", "test.pet.config"])
@EntityScan(value = ["test.pet.pet.domain", "test.pet.domain"])
class PetApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}
