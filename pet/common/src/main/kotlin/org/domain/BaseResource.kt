package org.domain

import org.listener.BaseResourceListener
import javax.persistence.*

@MappedSuperclass
@EntityListeners(BaseResourceListener::class)
open class BaseResource {

	@Id
	open var id: String? = null
		set(value) {
			field = value
		}
}
