package org.pet.pet.service

import org.pet.pet.domain.NewPet
import org.pet.pet.domain.Pet
import org.pet.pet.repository.DefaultRepository
import org.pet.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class DefaultService(
    repository: DefaultRepository
) : AbstractService<NewPet, DefaultRepository>(repository)
