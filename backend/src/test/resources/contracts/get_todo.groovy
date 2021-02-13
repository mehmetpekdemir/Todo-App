import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "test get todo by id"
    description "test get todo by id"

    request {
        url "/api/v1/todo/1"

        headers {
            header(contentType(), applicationJson())
        }

        method GET()
    }

    response {
        status OK()

        headers {
            header(contentType(), applicationJson())
        }

        body(
                """
                           {
                               "data": {
                                   "id": 1,
                                   "text": "Test",
                                   "status": true
                                },
                                "errors": null,
                           }     
                    """
        )

    }

}