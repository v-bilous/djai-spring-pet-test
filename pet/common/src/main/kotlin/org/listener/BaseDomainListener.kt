package org.listener

import org.domain.BaseDomain
import java.util.*
import javax.persistence.*

class BaseDomainListener {

    @PrePersist
    fun <T : BaseDomain> touchForCreate(domain: T) {
        domain.id = UUID.randomUUID().toString()
    }
}
