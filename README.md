# snippet-rest-api

## Getting started

Run postgres locally

`docker run --name snippet-postgres -it -d -p 5432:5432 -e POSTGRES_PASSWORD="password" postgres`

Start server

`lein ring server`