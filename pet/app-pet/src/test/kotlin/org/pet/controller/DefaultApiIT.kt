package org.pet.controller

import org.pet.domain.NewPet
import org.pet.domain.Pet
import org.pet.PetApplication
import org.pet.repository.DefaultRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.util.LinkedMultiValueMap
import java.util.*
import kotlin.test.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [PetApplication::class])
@AutoConfigureMockMvc
class DefaultApiIT : AbstractIntegrationTest<NewPet>() {

	private val url = "/pets"

	@Autowired
	lateinit var repository: DefaultRepository

	@Test
	fun `addPet with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `addPet with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `deletePet api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `findPetById with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `findPetById with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `findPets api`() {
		repository.deleteAll()
		val res1 = createWithRequiredFields()
		val res2 = createWithAllFields()

		val savedRes1 = repository.save(res1)
		val savedRes2 = repository.save(res2)

		val params = LinkedMultiValueMap<String, String>()
		val result = super.findAll(url, params)

		resourceAsserts(savedRes1, result, 0)
		resourceAsserts(savedRes2, result, 1)
	}


	private fun resourceAsserts(savedResource: NewPet, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.id"))
		}
		assertEquals(savedResource.name, getValue(result, "$prefix.name"))
		assertEquals(savedResource.tag, getValue(result, "$prefix.tag"))
	}

	private fun createWithRequiredFields(): NewPet {
	return NewPet(
				name = "test string value",
				tag = null
		)
	}

	private fun createWithAllFields(): NewPet {
		return NewPet(
				name = "test string value",
				tag = "test string value"
		)
	}

}
