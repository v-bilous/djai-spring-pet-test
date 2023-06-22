package org.test.controller

import org.test.domain.BaseResource
import org.test.exception.InvalidRequestException
import org.test.exception.ResourceNotFoundException
import org.test.service.CommonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*

abstract class AbstractController<E: BaseResource, S: CommonService<E>>(val  service: S):
		CommonController<E>, CommonParameterizedController<E> {

	override fun create(domain: E): ResponseEntity<E> {
		val result = service.save(domain)?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.CREATED)
	}

	override fun delete(id: String): ResponseEntity<E> {
		val entity = service.getById(id)?: throw ResourceNotFoundException()
		service.delete(entity)
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun getById(id: String): ResponseEntity<E> {
		val entity = service.getById(id)?: throw ResourceNotFoundException()
		return ResponseEntity(entity, HttpStatus.OK)
	}

	override fun getAll(search: String?, pageable : Pageable): ResponseEntity<Page<E>> {
		return ResponseEntity(service.getAll(pageable, search), HttpStatus.OK)
	}

	override fun update(id: String, domain: E): ResponseEntity<E> {
		service.getById(id)?: throw ResourceNotFoundException()
		domain.id = id
		val result = service.update(domain)?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.OK)
	}

	override fun modify(id: String, domain: E): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun saveAll(domains: List<E>): List<E> {
		return service.saveAll(domains)
	}

	override fun deleteAll(@RequestParam ids: List<String>): List<E> {
		val domains = service.getByIds(ids)
		service.deleteAll(domains)
		return domains
	}

	override fun create(parentId: String, domain: E): ResponseEntity<E> {
		val result = service.save(domain) ?: throw InvalidRequestException()
		return ResponseEntity(result, HttpStatus.CREATED)
	}

	override fun getById(parentId: String, id: String): ResponseEntity<E> {
		val domain = service.getById(id) ?: throw ResourceNotFoundException()
		//TODO: should assert parent id here
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun delete(parentId: String, id: String): ResponseEntity<E> {
		val domain = service.getById(id) ?: throw ResourceNotFoundException()
		validateParent(domain, parentId)
		service.delete(domain)
		return ResponseEntity(domain, HttpStatus.OK)
	}

	override fun update(parentId: String, id: String, domain: E): ResponseEntity<E> {
		validateParent(domain, parentId)
		domain.id = id
		val updatedEntity = service.update(domain)
		return ResponseEntity(updatedEntity, HttpStatus.OK)
	}

	override fun modify(parentId: String, id: String, domain: E): ResponseEntity<E> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	override fun saveAll(parentId: String, domains: List<E>): List<E> {
		domains.forEach {
			validateParent(it, parentId)
		}
		return service.saveAll(domains)
	}

	override fun deleteAll(parentId: String, ids: List<String>): List<E> {
		val entities = service.getByIds(ids)
		entities.forEach { domain ->
			validateParent(domain, parentId)
		}
		service.deleteAll(entities)
		return entities
	}

	override fun getAll(parentId: String, search: String?, pageable: Pageable): ResponseEntity<Page<E>> {
		val searchCriteria = getSearchCriteria(search, parentId)

		return ResponseEntity(service.getAll(pageable, searchCriteria), HttpStatus.OK)
	}

	private fun validateParent(domain: E, parentId: String) {
		//TODO: should check parent id here
	}

	private fun getSearchCriteria(query: String?, parentId: String): String {
		val underParentSearchCriteria = "entity.parent.id==$parentId"
		return if (query.isNullOrBlank()) {
			underParentSearchCriteria
		} else {
			"$underParentSearchCriteria;$query"
		}
	}
}
