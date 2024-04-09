```shell
docker run --name job-not-enqueued-issue-mysql-db -p 3306:3306 \
 -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=test -e MYSQL_PASSWORD=testing -e MYSQL_DATABASE=jobrunr \
 -d mysql:8.0
```

```shell
docker rm -f job-not-enqueued-issue-mysql-db
```