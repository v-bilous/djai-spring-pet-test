package org.test.pet.domain

import org.test.domain.BaseResource
import org.test.domain.History
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* 
* @param name 
* @param tag 
* @param history 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:")

@JsonPropertyOrder("name", "tag", "id", "history")

@Entity
@Table(name = "pet")
data class Pet(

	@Column(name = "name")
	var name: String,

	@Column(name = "tag")
	var tag: String?,

	@AttributeOverrides(
		AttributeOverride(name = "createdBy", column = Column(name = "created_by")),
		AttributeOverride(name = "updatedBy", column = Column(name = "updated_by")),
		AttributeOverride(name = "createdOn", column = Column(name = "created_on")),
		AttributeOverride(name = "updatedOn", column = Column(name = "updated_on")),
	)
	@Embedded
	var history: History?

) : BaseResource()

