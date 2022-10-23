# Spring Boot Jdbc 설정 자동화


## environment variable설정

```
SPRING_DATASOURCE_URL=SPRING_DATASOURCE_URL=jdbc:mysql://<HOST>:3306/likelion-db
```

## Code

application.yml

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/likelion-db
    username: root
    password: 1234
```

UserDao.java

```java
@Repository
public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = dataSource.getConnection();
            //...
```

User.java

```java
public class User {
    @Id
    private String id;
    private String name;
    private String password;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
```


### Could not autowire. No beans of '~' type found. 에러

이유는 intellij 버전이 낮기 때문입니다. 22.2 이상 버전은 이 버그가 패치 되서 안납니다.

Help에서 Edit Custom Properties 누른 다음 아래 내용을 추가 해줍니다.

```
idea.spring.boot.filter.autoconfig=false
```