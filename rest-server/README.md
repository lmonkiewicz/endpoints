##Simple Rest server offering few endpoints for testing:

I've made this server for testing purpouses of different clients.
Each endpoint can generate custom errors with varying propabilty of occurance. It can be controlled with following query parameters:
* t - time dalay for response in miliseconds (long)
* r - propability of an error, a double value in range of 0.0-1.0
* c - error code to produce, defaults to 500

For example:

`curl -i -X GET -G "http://localhost:8080/basic/randomNumber?t=5000&r=0.5&c=404"`

###Running

`mvnw install spring-boot:run`

It will start on port 8080, you can invoke it with:

`curl -i -X GET http://localhost:8080/basic/randomNumber`


###Basic endpoints

Generate random double:

`GET /basic/randomNumber`


Return current timestamp as long:

`GET /basic/timestamp`


Generate UUID as string:

`GET /basic/uuid`

Return "Hello 'name'!" text, with name taken from header value named 'Name':

`GET /basic/hello`

Return desired error code:

`GET /basic/error/403`

###CRUD endpoints

There are few endpoints for general CRUD operation on Task object:
```
{
    "title": "Title of a task",
    "done": false
}
```

`GET /crud/tasks` - lists tasks

`GET /crud/tasks/1` - returns a task with id 1

`PUT /crud/tasks` - creates a task

`POST /crud/tasks/1` - updates a task


`DELETE /crud/tasks/1` - deletes a task

###Mirror endpoints

This endpoints responds with the same JSON as in the request body:

`POST /mirror/json`