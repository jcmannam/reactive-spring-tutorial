org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath('/name')
    }
    response {
        status 200
        body("""
        {
            "firstName": "Matt",
            "lastName": "Campbell"
        }
        """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}
