package test.pet.pet.service

import test.pet.pet.domain.NewPet
import test.pet.pet.domain.Pet
import test.pet.pet.repository.DefaultRepository
import test.pet.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class DefaultService(
    repository: DefaultRepository
) : AbstractService<NewPet, DefaultRepository>(repository)
