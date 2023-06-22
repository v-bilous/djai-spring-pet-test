package org.test.repository

import org.test.domain.BaseResource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

@NoRepositoryBean
interface CommonRepository<E : BaseResource> :
        PagingAndSortingRepository<E, String>,
        JpaRepository<E, String>,
        JpaSpecificationExecutor<E>
