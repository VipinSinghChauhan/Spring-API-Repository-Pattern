### It is a an API demo for Repository Pattern using SpringBoot.
### I have used h2 database and hibernate for ORM.

## API methods :
* #### GET   : /library => Gives All libraries
* #### POST  : /library => Save a  library
* #### GET   : /library/{libraryId} => Get a library using library Id
* #### PUT   : /library/{libraryId} => Update a given library
* #### DELETE: /library/{libraryId} => Deletes a given library
* #### GET : /library/{libraryId}/books => Return all the books present in a particular library Id
* #### POST : /library/{libraryId}/books => Save a book inside a particular library
* #### DELETE : /library/{libraryId}/{isbn} => Delete a book from a particular library
 #### 
* #### GET : /books => Return all the books
* #### POST : /books => Save a book
* #### GET : /books/{isbn} => get a particular book
* #### PUT : /books/{isbn} => update a particular book
* #### DELETE : /books/{isbn} => deletes a particular book

