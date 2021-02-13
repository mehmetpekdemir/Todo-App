import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "test get todos by username"
    description "test get todos by username"

    request {
        url "/api/v1/todo/username/Mehmet1"

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
                                "items": [
                                     {
                                        "id": 1,
                                        "text": "Test",
                                        "status": true
                                    },
                                    {
                                        "id": 2,
                                        "text": "Test2",
                                        "status": false
                                    }
                                ]
                            },
                                "errors": null,
                            }    
                    """
        )

    }

}
