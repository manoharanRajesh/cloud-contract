package contracts.order

import org.springframework.cloud.contract.spec.Contract

/**
 * Contract definition, written in a Groovy DSL
 */
Contract.make {

    /**
     * Request response for a customercustomer which does not exist, completes HTTP status code 200 with an empty body
     */
    request {
        method 'GET'
        url('/customer/404')
        headers {
            accept("application/json")
        }
    }
    response {
        status 404
    }
}