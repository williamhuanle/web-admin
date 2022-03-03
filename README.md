# web-admin
A web client use spring boot jsp, 

Should install docker before run this application.
## How to run

```
    docker network create backend-network
    
    # run auth service
    docker run --network backend-network --name mysql-container -e MYSQL_ROOT_PASSWORD=mzMysql123 -e MYSQL_DATABASE=mz_db_user --platform linux/x86_64 -d mysql:latest
    docker run --network backend-network --name auth-service-container -p 8080:8080 williamhuanle/auth-service:0.0.1-SNAPSHOT
    
    # run admin service
    docker run --network backend-network --name mongo-container -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=mzMongo123 -e MONGO_INITDB_DATABASE=admin-mongodb -d mongo:latest
    docker run --network backend-network --name admin-service-container -p 8080:8080 williamhuanle/admin-service:0.0.1-SNAPSHOT
    
    # run web-admin
    docker run --network backend-network --name web-admin-container -p 8082:8082 williamhuanle/web-admin:0.0.1-SNAPSHOT
```


## How to build

```
    # build image
    docker build -t web-admin .
    
    # run container
    docker run --network backend-network --name web-admin-container -p 8082:8082 -d web-admin
```