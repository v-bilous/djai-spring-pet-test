package org.test.service

import org.test.domain.BaseResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface CommonService<E: BaseResource> {
	fun save(domain: E): E?
	fun saveAll(domains: List<E>): List<E>
	fun delete(domain: E)
	fun getById(id: String): E?
	fun update(domain: E): E?
	fun getAll(pageable: Pageable, query: String?): Page<E>
	fun getByIds(ids: List<String>): List<E>
	fun deleteAll(domains: List<E>)
}