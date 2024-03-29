## Build the app

``` 
mvn clean install
```

## Run the app

``` 
Either
docker run -p 8082:8083 falcon007/spring-mongo-app:1.0.0
Or
docker-compose -f docker-compose-mongo.yml up -d
Or
mvn spring-boot:run

docker-compose -f docker-compose-mongo.yml down

```
## Creating docker image

```
mvn install dockerfile:build

```
## running docker compose

``` 
docker-compose up -d

docker-compose down
```


## Post

``` 
curl --request POST 'http://localhost:8081/hospital/create' --header 'Content-Type: application/json' --data-raw '{"name": "Rama","custId": "1re206","address": "Bangalore"}'
```

## Get 

``` 
curl -X GET http://localhost:8081/hospital/read 
```

## Put

``` 
curl -X PUT 'http://localhost:8081/hospital/update?custId=1re07&name=Rama' 
```

##Delete

```
curl -X DELETE 'http://localhost:8081/hospital/delete?name=Rama' 
```




## Show data

```
docker exec -it spring-mongo-app-mongo-1 bash

mongo

show dbs

show tables

db.customer.find()

```


## Dockerization

### Maven 
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

```

