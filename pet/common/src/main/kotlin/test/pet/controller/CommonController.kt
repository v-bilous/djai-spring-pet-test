package test.pet.controller

import test.pet.domain.BaseResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface CommonController<E : BaseResource> {
    fun create(domain: E): ResponseEntity<E>
    fun delete(id: String): ResponseEntity<E>
    fun getById(id: String): ResponseEntity<E>
    fun getAll(search: String?, pageable: Pageable): ResponseEntity<Page<E>>
    fun update(id: String, domain: E): ResponseEntity<E>
    fun modify(id: String, domain: E): ResponseEntity<E>
    fun saveAll(domains: List<E>): List<E>
    fun deleteAll(ids: List<String>): List<E>
}
