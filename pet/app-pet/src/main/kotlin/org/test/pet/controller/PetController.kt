package org.test.pet.controller

import org.test.pet.domain.Pet
import org.test.pet.service.PetService
import org.test.pet.controller.api.PetApi
import org.test.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PetController(service: PetService)
    : AbstractController<Pet, PetService>(service), PetApi {


    override fun addPet(
			@RequestBody pet: Pet): ResponseEntity<Pet> {
        return super.create(pet)
    }

    override fun deletePet(
			@PathVariable("id") id: String): ResponseEntity<Pet> {
        return super.delete(id)
    }

    override fun findPetById(
			@PathVariable("id") id: String): ResponseEntity<Pet> {
        return super.getById(id)
    }

    override fun findPets(
			@RequestParam(value = "search", required = false) search: String?,
			@RequestParam(value = "limit", required = false) limit: Int?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Pet>> {
        return getAll(search, page)
    }

}
