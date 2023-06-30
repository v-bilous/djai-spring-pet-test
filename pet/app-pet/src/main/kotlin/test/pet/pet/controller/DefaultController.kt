package test.pet.pet.controller

import test.pet.pet.domain.NewPet
import test.pet.pet.domain.Pet
import test.pet.pet.service.DefaultService
import test.pet.pet.controller.api.DefaultApi
import test.pet.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class DefaultController(service: DefaultService)
    : AbstractController<NewPet, DefaultService>(service), DefaultApi {


    override fun addPet(
			@RequestBody newPet: NewPet): ResponseEntity<NewPet> {
        return super.create(newPet)
    }

    override fun deletePet(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
        return super.delete(id)
    }

    override fun findPetById(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
        return super.getById(id)
    }

    override fun findPets(
			@RequestParam(value = "tags", required = false) tags: List<String>,
			@RequestParam(value = "limit", required = false) limit: Int?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<NewPet>> {
        return getAll(search, page)
    }

}
