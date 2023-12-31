package org.test.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class InvalidRequestException : ResponseStatusException {
    constructor(message: String) : super(HttpStatus.BAD_REQUEST, message)
    constructor() : this("The request that was sent is not valid.")
}
