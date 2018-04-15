package contracts.order

import org.springframework.cloud.contract.spec.Contract

/**
 * Contract definition, written in a Groovy DSL
 */
Contract.make {

    /**
     * Request response which succeeds, completes HTTP status code 200
     */
    request {
        method 'GET'
        url('/customer/1')
        headers {
            accept("application/json")
        }
    }
    response {
        status 200
        body(["id" : 1,
                "fullName":"Iron man",
                "balance":"100000"
        ])
        headers {
            contentType(applicationJson())
        }
    }
}