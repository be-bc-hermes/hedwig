# Before running

- Have docker installed and running
  
- Have database running
  - Create postgresql container if not created before
    > docker run --name postgresqldb -e POSTGRES_USER=hermes -e POSTGRES_PASSWORD=hedwig -p 5432:5432 -d postgres
  - Start the container
    > docker start postgresqldb
  - Create a database named `notification` if there is not one
  
- Have rabbit-mq server running
  - Create rabbit-mq container if not created before
    > docker run -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
  - Start the container
    > docker start rabbitmq