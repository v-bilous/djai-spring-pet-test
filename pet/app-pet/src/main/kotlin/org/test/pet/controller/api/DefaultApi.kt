package org.test.pet.controller.api

import org.test.pet.domain.NewPet
import org.test.pet.domain.Pet
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "Default", tags = ["Default"], description = "the Default API")
interface DefaultApi {

	@ApiOperation(value = "", nickname = "addPet", notes = "Creates a new pet in the store.  Duplicates are allowed", tags=)
	@ApiResponses(
		ApiResponse(code = 200, message = "pet response"),
		ApiResponse(code = 200, message = "unexpected error")
	)
	@PostMapping("/pets")
	fun addPet(
			@RequestBody newPet: NewPet): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "", nickname = "deletePet", notes = "deletes a single pet based on the ID supplied", tags=)
	@ApiResponses(
		ApiResponse(code = 204, message = "pet deleted"),
		ApiResponse(code = 200, message = "unexpected error")
	)
	@DeleteMapping("/pets/{id}")
	fun deletePet(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "", nickname = "findPetById", notes = "Returns a user based on a single ID, if the user does not have access to the pet", tags=)
	@ApiResponses(
		ApiResponse(code = 200, message = "pet response"),
		ApiResponse(code = 200, message = "unexpected error")
	)
	@GetMapping("/pets/{id}")
	fun findPetById(
			@PathVariable("id") id: Long): ResponseEntity<NewPet> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "", nickname = "findPets", notes = "Returns all pets from the system that the user has access to ", tags=)
	@ApiResponses(
		ApiResponse(code = 200, message = "pet response"),
		ApiResponse(code = 200, message = "unexpected error")
	)
	@GetMapping("/pets")
	fun findPets(
			@RequestParam(value = "tags", required = false) tags: List<String>,
			@RequestParam(value = "limit", required = false) limit: Int?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<NewPet>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
