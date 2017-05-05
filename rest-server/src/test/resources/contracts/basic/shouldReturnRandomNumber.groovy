package contracts.basic

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/basic/randomNumber'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
            value: $(consumer('12.2345'), producer(regex('[0-9]+\\.[0-9]+')))
        )
        headers {
            contentType(applicationJson())
        }
    }
}