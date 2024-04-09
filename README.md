The issue is that jobs are not saved when using Spring without `@Transactional` and with `autoCommit=false`.

To reproduce the bug set the following in `application.properties`

```
spring.datasource.hikari.auto-commit=false
```

Start a MySQL database:

```shell
docker run --name job-not-enqueued-issue-mysql-db -p 3306:3306 \
 -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=test -e MYSQL_PASSWORD=testing -e MYSQL_DATABASE=jobrunr \
 -d mysql:8.0
```

Remove the DB:

```shell
docker rm -f job-not-enqueued-issue-mysql-db
```