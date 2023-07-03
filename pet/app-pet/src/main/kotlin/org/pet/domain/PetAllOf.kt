package org.pet.domain

import org.domain.BaseDomain
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:")

@JsonPropertyOrder("id")

@Entity
@Table(name = "pet_all_of")
class PetAllOf(

) : BaseDomain()

