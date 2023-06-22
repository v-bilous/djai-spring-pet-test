package org.test.pet.domain

import org.test.domain.BaseDomain
import org.test.pet.domain.NewPet
import org.test.pet.domain.PetAllOf
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* 
* @param name 
* @param tag 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:")

@JsonPropertyOrder("name", "tag", "id")

@Entity
@Table(name = "pet")
data class Pet(

	@Column(name = "name")
	var name: String,

	@Column(name = "tag")
	var tag: String?

) : BaseDomain()

