# JPA SHOP
인프런 "실전! 스프링 부트와 JPA 활용 1 - 웹 애플리케이션" 개발 프로젝트

## 프로젝트 세팅
- https://start.spring.io/ 에서 프로젝트 생성
    - Gradle, JAVA 선택
    - Spring Web Starter, Spring Data JPA, H2 Database, Lombok, Thymeleaf dependency 추가
- Lombok 사용 시 Preference > Plugins 에서 Lombok 설치
- 이후 Preference > Compiler > Annotation Processors 에서 Enable annotation processing 체크
- h2 데이터베이스 설치
  - h2 데이터베이스를 다운받아 압축 풀기 (https://www.h2database.com/html/main.html)
  - h2/bin/h2.sh 실행
  - http://localhost:8082/ 접속
  - jdbc:h2:데이터베이스_파일을_생성할_경로 (jdbc:h2:~/jpashop) - 최소 한번 실행
  - jdbc:h2:tcp://localhost/데이터베이스_파일을_생성한_경로 - 이후부터 이렇게 접근
  
