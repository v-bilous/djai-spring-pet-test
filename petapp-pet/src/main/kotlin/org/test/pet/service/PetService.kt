package org.test.pet.service

import org.test.pet.domain.Pet
import org.test.pet.repository.PetRepository
import org.test.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PetService(
    repository: PetRepository
) : AbstractService<Pet, PetRepository>(repository)
