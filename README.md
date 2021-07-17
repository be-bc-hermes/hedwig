# Before running

- Have database running
  - Have docker installed and running 
  - Create postgresql container if not created before
    > docker run --name postgresqldb -e POSTGRES_USER=hermes -e POSTGRES_PASSWORD=hedwig -p 5432:5432 -d postgres
  - Start the container
    > docker start postgresqldb
  - Create a database named `notification` if there is not one