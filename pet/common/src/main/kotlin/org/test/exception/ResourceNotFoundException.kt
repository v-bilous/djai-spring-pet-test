package org.test.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ResourceNotFoundException : ResponseStatusException {
    constructor(message: String) : super(HttpStatus.NOT_FOUND, message)
    constructor() : this("The requested resource does not exist.")
}
