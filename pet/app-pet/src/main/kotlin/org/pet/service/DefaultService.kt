package org.pet.service

import org.pet.domain.NewPet
import org.pet.domain.Pet
import org.pet.repository.DefaultRepository
import org.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class DefaultService(
    repository: DefaultRepository
) : AbstractService<NewPet, DefaultRepository>(repository)
