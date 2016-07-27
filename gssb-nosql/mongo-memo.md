# mongodb getting started - shell
https://docs.mongodb.com/getting-started/shell/

## Introduction to MongoDB
### Documents (are similar to Record, Object and JSON)
- A record in MongoDB is a document.
- MongoDB documents are similar to JSON objects.

### Collections (are similar to Table) 
- MongoDB sotores documents in collections.
- MongoDB has no shcema.
- Collections are stored in a database.

### Image of data structure
```
Database
	- Collection
		- Document
		- Document
		...
	- Collection
		...
```


## Install MongoDB
### Install on windows
- installed and created mongodb service.
- create start and stop bat for administrator.


## Import Example Dataset
- get [import data - restaurants collection](https://raw.githubusercontent.com/mongodb/docs-assets/primer-dataset/primer-dataset.json) and save as 'primer-dataset.json'
- execute import command.

```
mongoimport --db test --collection restaurants --drop --file primer-dataset.json
```

## MongoDB Shell (mongo)
- The mongo shell (mongo.exe) is an interactive JavaScript interface to MongoDB. We can use the mongo to query and update.
- execute `mongo` (`mongo.exe`) to start.
- execute `help` in mongo shell to display help and information.


## Insert Data with the mongo Shell
- execute below in the mongo shell.

```
use test
```

```
db.restaurants.insert(
   {
      "address" : {
         "street" : "2 Avenue",
         "zipcode" : "10075",
         "building" : "1480",
         "coord" : [ -73.9557413, 40.7720266 ]
      },
      "borough" : "Manhattan",
      "cuisine" : "Italian",
      "grades" : [
         {
            "date" : ISODate("2014-10-01T00:00:00Z"),
            "grade" : "A",
            "score" : 11
         },
         {
            "date" : ISODate("2014-01-16T00:00:00Z"),
            "grade" : "B",
            "score" : 17
         }
      ],
      "name" : "Vella",
      "restaurant_id" : "41704620"
   }
)
WriteResult({ "nInserted" : 1 })
```

- WriteResult is a object with the status of the operation.


## Find or Query Data with the mongo Shell
- To return all documents, call the find() method without a criteria like `db.restaurants.find()`.

### Query by a Top Level Field
- `db.restaurants.find( { "borough": "Manhattan" } )` finds documents whose "borough" field equals "Manhattan".

### Query by a Field in an Embedded Document
- use the dot notation like `db.restaurants.find( { "address.zipcode": "10075" } )`. this operation specifies an equality condition on the "zipcode" field in the "address" embedded document.

### Query by a Field in an Array
- `db.restaurants.find( { "grades.grade": "B" } )`

### Specify Conditions with Operators
#### Greater Than Operator ($gt)
- `db.restaurants.find( { "grades.score": { $gt: 30 } } )`

#### Less Than Operator ($lt)
- `db.restaurants.find( { "grades.score": { $lt: 10 } } )`

### Combine Conditions
#### Logical AND
- `db.restaurants.find( { "cuisine": "Italian", "address.zipcode": "10075" } )`

#### Logical OR
```
db.restaurants.find(
   { $or: [ { "cuisine": "Italian" }, { "address.zipcode": "10075" } ] }
)
```

### Sort Query Results
- append the `sort()` method.
- like `db.restaurants.find().sort( { "borough": 1, "address.zipcode": 1 } )` to sort asc.