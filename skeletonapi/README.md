### skeletonapi
This is a skeleton JSON + HTTP RestFul api service that serves only three endpoints:

1. Retrieve all users

```
GET /users 
```

2. Retrieve a user with a certain ID

```
GET /users/:id 
```

3. Add a user

```
POST /users 
```

Example user:

```
{
    “id”: 1,
    “firstName”: “Mickey”,
    “lastName”: “Mouse”,
    “age”: 83
}
```

Run the following command to start the server

```
./skeletonapi$ sbt run

```

User `curl` to make request to the server for testing:
```
$ curl -XGET http://127.0.0.1:9503/Users
[{"id":1,"firstName":"Mickey","lastName":"Mouse","age":83}]
$ curl -XGET http://127.0.0.1:9503/Users/1
{"id":1,"firstName":"Mickey","lastName":"Mouse","age":83}
$ curl -XGET http://127.0.0.1:9503/Users/2
$ curl -XPOST http://127.0.0.1:9503/Users -d '{"id":2,"firstName":"John","lastName":"Doe","age":25}'
{"response":"Success"}
$ curl -XPOST http://127.0.0.1:9503/Users -d 'wrong format'
$ curl -XGET http://127.0.0.1:9503/Users
[{"id":2,"firstName":"John","lastName":"Doe","age":25},{"id":1,"firstName":"Mickey","lastName":"Mouse","age":83}]
```