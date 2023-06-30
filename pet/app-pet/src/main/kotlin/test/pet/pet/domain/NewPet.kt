package test.pet.pet.domain

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

@JsonPropertyOrder("name", "tag")

@Embeddable
data class NewPet(

	@Column(name = "name")
	var name: String,

	@Column(name = "tag")
	var tag: String?

) 

