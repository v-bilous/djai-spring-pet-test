package org.test.pet.service

import org.test.pet.domain.NewPet
import org.test.pet.domain.Pet
import org.test.pet.repository.DefaultRepository
import org.test.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class DefaultService(
    repository: DefaultRepository
) : AbstractService<NewPet, DefaultRepository>(repository)
