package org.test.pet.controller.api

import org.test.pet.domain.NewPet
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

@Tag(name = "Default", description = "the Default API")
interface DefaultApi {

	@Operation(summary = "", description = "Creates a new pet in the store.  Duplicates are allowed", tags=)
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@PostMapping("/pets")
	fun addPet(
			@RequestBody newPet: NewPet): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "deletes a single pet based on the ID supplied", tags=)
	@ApiResponses(
		ApiResponse(responseCode = "204", description = "pet deleted"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@DeleteMapping("/pets/{id}")
	fun deletePet(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "Returns a user based on a single ID, if the user does not have access to the pet", tags=)
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@GetMapping("/pets/{id}")
	fun findPetById(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@Operation(summary = "", description = "Returns all pets from the system that the user has access to ", tags=)
	@ApiResponses(
		ApiResponse(responseCode = "200", description = "pet response"),
		ApiResponse(responseCode = "200", description = "unexpected error")
	)
	@PageableAsQueryParam
	@GetMapping("/pets")
	fun findPets(
			@RequestParam(value = "tags", required = false) tags: List<String>,
			@RequestParam(value = "limit", required = false) limit: Int?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<NewPet>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
