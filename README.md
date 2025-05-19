# Spring AI OpenAI 채팅 애플리케이션

Spring AI와 OpenAI API를 활용한 채팅 애플리케이션입니다. 대화 기록을 MySQL 데이터베이스에 저장하고 관리합니다.

## 기술 스택

- Java 17
- Spring Boot 3.2.3
- Spring AI 1.0.0-SNAPSHOT
- Spring AI JDBC ChatMemory
- Spring AI OpenAI Model
- MySQL 8.0
- Gradle

## 주요 기능

- OpenAI GPT 모델을 활용한 채팅
- 대화 기록의 영구 저장 (MySQL)
- 세션 기반 대화 관리
- 글로벌 예외 처리

## 프로젝트 구조

```
src/main/java/com/example/springaiopenai/demo/
├── config/          # 설정 클래스
├── controller/      # REST API 컨트롤러
├── service/         # 비즈니스 로직
├── repository/      # 데이터 접근 계층
├── model/          # 엔티티 클래스
├── exception/      # 예외 처리
└── dto/            # 데이터 전송 객체
```

## 시작하기

### 필수 조건

- Java 17 이상
- MySQL 8.0
- OpenAI API 키

### 환경 설정

1. MySQL 데이터베이스 생성:
```sql
CREATE DATABASE chat_db;
```

2. `application.yml` 설정:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/chat_db
    username: [your-username]
    password: [your-password]
  ai:
    openai:
      api-key: [your-openai-api-key]
```

### 빌드 및 실행

```bash
./gradlew clean build
./gradlew bootRun
```

## API 엔드포인트

### 채팅 세션 생성
```
POST /api/chat/session
```

### 메시지 전송
```
POST /api/chat/{sessionId}/message?content={message}
```

## 데이터베이스 스키마

### SPRING_AI_CHAT_MEMORY
```sql
CREATE TABLE IF NOT EXISTS SPRING_AI_CHAT_MEMORY (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conversation_id VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    type VARCHAR(50) NOT NULL,
    `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_conversation_id (conversation_id)
);
```

## 주의사항

1. OpenAI API 키는 환경 변수로 설정하거나 `application.yml`에 직접 입력할 수 있습니다.
2. MySQL 데이터베이스가 실행 중이어야 합니다.
3. 애플리케이션 시작 시 자동으로 필요한 테이블이 생성됩니다.

## 활용 예시
![image](https://github.com/user-attachments/assets/f5061a9e-fe98-4aeb-9a76-e04a72eb10b2)


## 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 
