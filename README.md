# rd01
## 在Docker建立MngoDB

### 下載image同時建立container

```yaml
docker run --name mongoDB -p 27017:27017 -v /Users/chenhaoxian/Documents/mongoDB:/data/db -d -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin1234 mongo
```

- -p mount port 為 docker內的27017至本機的27017
- -v mount volume 為docker內mongo的/data/db至本機的/Users/chenhaoxian/Documents/mongoDB
- -e 
  - 官方環境變數 [MONGO_INITDB_ROOT_USERNAME] 指定ROOT帳號
  - 官方環境變數 [MONGO_INITDB_ROOT_PASSWORD] 指定ROOT密碼


### 開啟不斷更新的 log 
```yaml
docker logs -f mongoDB
```

### 失敗時先關閉container再刪除之
```yaml
docker stop mongoDB
docker container rm mongoDB
```

### 以admin之身份進入image為mongo、container名稱為mongoDB的內部Shell控制台
```yaml
docker exec -it mongoDB mongo admin
```

### 建立User [DB名稱為admin]
```yaml
db.createUser({ user: 'admin', pwd: 'admin1234', roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] } );
```

### 指定使用admin授權
```yaml
db.auth("admin","admin1234");
```
### 切換DB[若不存在則會自動創建]
```yaml
use test
```
### 建立User [DB名稱為test]
```yaml
db.createUser({ user: 'admin', pwd: 'admin1234', roles: [{ role: "readWrite", db: "test"}]});
```





## 至Spring Initializer建立專案
- 主要練習目標
  - MangoDB
  - Reactive Web(Web Flux取代Spring Web MVC)
  - Test







## Reference
  - MongoDB for Docker 安裝
    - [對岸網友](https://www.jianshu.com/p/2181b2e27021)
    - [官方Docker Hub](https://hub.docker.com/_/mongo/)
    - [intellij MongoDB外掛](https://plugins.jetbrains.com/plugin/7141-mongo-plugin)
  - SpringBoot參考資料
    - [對岸網友](https://www.jianshu.com/p/06376b97b11e)
    - [取代Web MVC的Flux?](https://www.ithome.com.tw/voice/122082)
