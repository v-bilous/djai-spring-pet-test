package org.test.pet.controller.api

import org.test.pet.domain.Pet
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.converters.models.PageableAsQueryParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Tag(name = "Pet", description = "the Pet API")
interface PetApi {

	@Operation(summary = "", description = "Creates a new pet in the store.  Duplicates are allowed", tags=["Pet"])
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@PostMapping("/pets")
	fun addPet(
			@RequestBody pet: Pet): ResponseEntity<Pet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "deletes a single pet based on the ID supplied", tags=["Pet"])
	@ApiResponses(
		ApiResponse(responseCode = "204", description = "pet deleted"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@DeleteMapping("/pets/{id}")
	fun deletePet(
			@PathVariable("id") id: String): ResponseEntity<Pet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "Returns a user based on a single ID, if the user does not have access to the pet", tags=["Pet"])
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@GetMapping("/pets/{id}")
	fun findPetById(
			@PathVariable("id") id: String): ResponseEntity<Pet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "Returns all pets from the system that the user has access to ", tags=["Pet"])
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@PageableAsQueryParam
	@GetMapping("/pets")
	fun findPets(
			@RequestParam(value = "search", required = false) search: String?,
			@RequestParam(value = "limit", required = false) limit: Int?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Pet>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
