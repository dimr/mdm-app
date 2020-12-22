## set up database with docker
To initialize the database run the following commands:

```
docker build -t postgres/mdm-postgres:latest .
docker run --name mdm-pg -p 5432:5432  mdm-postgres
```

to install emberjs & dependencies change directory to mdm-from
```
npm install
ember serve
```


Run the application with
```
mvn spring-boot:run
```