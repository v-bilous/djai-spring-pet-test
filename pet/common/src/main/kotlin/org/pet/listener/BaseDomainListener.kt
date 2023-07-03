package org.pet.listener

import org.pet.domain.BaseDomain
import java.util.*
import javax.persistence.*

class BaseDomainListener {

    @PrePersist
    fun <T : BaseDomain> touchForCreate(domain: T) {
        domain.id = UUID.randomUUID().toString()
    }
}
