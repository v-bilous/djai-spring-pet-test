package org.test.pet.controller

import org.test.domain.BaseResource
import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.MultiValueMap
import org.junit.jupiter.api.Assertions.*
import java.text.SimpleDateFormat
import java.util.*

abstract class AbstractIntegrationTest<E : BaseResource> : CommonIntegrationTest<E> {

	companion object {
		private val expectedDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	}

	@Autowired
	lateinit var mockMvc: MockMvc

	@Autowired
	lateinit var objectMapper: ObjectMapper

	override fun getById(urlTemplate: String, id: String): MvcResult {

		return mockMvc.perform(get("$urlTemplate/{id}", id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun create(urlTemplate: String, entity: E): MvcResult {

		return mockMvc.perform(post("$urlTemplate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(entity)))
				.andExpect(status().isCreated)
				.andReturn()
	}

	override fun update(urlTemplate: String, id: String, entity: E): MvcResult {

		return mockMvc.perform(put("$urlTemplate/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(entity))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun delete(urlTemplate: String, id: String): MvcResult {

		return mockMvc.perform(MockMvcRequestBuilders.delete("$urlTemplate/{id}", id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun deleteAll(urlTemplate: String, ids: List<String?>): MvcResult {
		return mockMvc.perform(delete("$urlTemplate/bulk")
				.param("ids", ids.joinToString(",") { it.toString() })
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun findAll(urlTemplate: String, params: MultiValueMap<String, String>): MvcResult {
		return mockMvc.perform(get("$urlTemplate")
				.params(params)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun createAll(urlTemplate: String, entities: List<E>): MvcResult {
		return mockMvc.perform(post("$urlTemplate/bulk")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(entities)))
				.andExpect(status().isOk)
				.andReturn()
	}

	override fun findById(urlTemplate: String, id: String): MvcResult {
		TODO("Not yet implemented")
	}

	override fun modify(urlTemplate: String, id: String, entity: E): MvcResult {
		TODO("Not yet implemented")
	}

	override fun updateAll(urlTemplate: String, ids: List<String>, entities: List<E>): MvcResult {
		TODO("Not yet implemented")
	}

	fun <T> getValue(mvcResult: MvcResult, jsonPath: String): T =
			JsonPath.read(mvcResult.response.contentAsString, jsonPath)

	fun assertListsEquals(list1: List<Any>?, list2: List<Any>?) {
		if (list1.isNullOrEmpty() && list2.isNullOrEmpty()) {
			return
		}
		list1!!
		list2!!
		assertEquals(list1.size, list2.size, "Lists size should be equal")

		// for now we about to check String lists only, complex object are not supported
		if (!list1.toTypedArray().isArrayOf<String>()) {
			return
		}
		val pairList = list1.zip(list2)
		assertTrue(pairList.all { (elt1, elt2) -> elt1 == elt2 }, "Lists content should be equal")
	}

	fun assertListsEquals(list1: Set<Any>?, list2: Set<Any>?) {
		assertListsEquals(list1?.toList(), list2?.toList())
	}

	fun assertDateEquals(first: Date?, second: String?) {
		if (first == null) {
			return
		}
		assertNotNull(second)
		val secondDate = expectedDateFormat.parse(second)
		assertEquals(first.time, secondDate.time)
	}

	fun assertObjectEquals(first: Any?, second: Any?) {
		if (first == null && second == null) {
			return
		}
		val firstString = objectMapper.writeValueAsString(first)
		val secondString = objectMapper.writeValueAsString(second)
		assertEquals(firstString, secondString, "JSON objects should be equal")
	}

	fun findIdentityId(result: MvcResult): String {
		return getValue(result, "$.id")
	}

	fun String.toUUID(): UUID {
		return UUID.fromString(this)
	}
}
