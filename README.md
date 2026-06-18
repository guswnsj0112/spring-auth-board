# AppJam Auth Board

> AppJam 프로젝트를 준비하기 위해 Spring Boot 기반으로 인증/인가, JWT, OAuth2, JPA를 학습하고 구현하는 백엔드 연습 프로젝트입니다.

## 📌 프로젝트 목적

이 프로젝트는 AppJam과 같은 단기 협업 프로젝트에서 자주 사용되는 백엔드 기능을 미리 학습하고 구현하기 위해 시작했습니다.

주요 학습 목표는 다음과 같습니다.

- Spring Data JPA를 활용한 도메인 설계 및 CRUD 구현
- Spring Security 기반 인증/인가 흐름 이해
- JWT Access Token / Refresh Token 발급 및 검증
- 로그인한 사용자 기준의 게시글, 댓글, 좋아요 기능 구현
- OAuth2 소셜 로그인 흐름 학습
- 실전 프로젝트에 가까운 패키지 구조와 API 설계 연습

---

## 🛠 Tech Stack

### Backend

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- JWT
- OAuth2 Client
- MySQL
- H2 Database
- Gradle

### Tool

- IntelliJ IDEA
- Postman
- Git / GitHub
- Swagger

---

## 🧩 주요 기능

### Auth

- 회원가입
- 로그인
- Access Token 발급
- Refresh Token 발급
- 토큰 재발급
- 로그아웃
- OAuth2 소셜 로그인

### User

- 내 정보 조회
- 닉네임 수정

### Post

- 게시글 작성
- 게시글 목록 조회
- 게시글 상세 조회
- 게시글 수정
- 게시글 삭제

### Comment

- 댓글 작성
- 댓글 삭제

### Like

- 게시글 좋아요
- 게시글 좋아요 취소
- 중복 좋아요 방지

---

## 🗂 Package Structure

```text
src/main/java/com/appjam/authboard

global
 ├── config
 │    └── SecurityConfig
 ├── security
 │    ├── JwtAuthenticationFilter
 │    ├── JwtTokenProvider
 │    └── CustomUserDetailsService
 ├── exception
 │    ├── CustomException
 │    ├── ErrorCode
 │    └── GlobalExceptionHandler
 └── response
      └── ApiResponse

domain
 ├── auth
 │    ├── controller
 │    ├── service
 │    ├── dto
 │    └── entity
 ├── user
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── entity
 │    └── dto
 ├── post
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── entity
 │    └── dto
 ├── comment
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── entity
 │    └── dto
 └── like
      ├── controller
      ├── service
      ├── repository
      ├── entity
      └── dto
```

---

## 🧱 ERD

```text
User
- id
- email
- password
- nickname
- role
- provider
- providerId

Post
- id
- title
- content
- writer_id

Comment
- id
- content
- writer_id
- post_id

PostLike
- id
- user_id
- post_id

RefreshToken
- id
- userId
- token
- expiredAt
```

---

## 🔐 인증 흐름

```text
1. 사용자가 로그인 요청을 보냅니다.
2. 서버는 이메일과 비밀번호를 검증합니다.
3. 검증에 성공하면 Access Token과 Refresh Token을 발급합니다.
4. Refresh Token은 DB에 저장합니다.
5. 클라이언트는 Access Token을 Authorization Header에 담아 요청합니다.
6. JwtAuthenticationFilter가 요청을 가로채 토큰을 검증합니다.
7. 토큰이 유효하면 userId를 추출합니다.
8. SecurityContext에 인증 정보를 저장합니다.
9. Controller에서는 로그인한 사용자 정보를 기반으로 API를 처리합니다.
```

---

## 📡 API 명세

### Auth

| Method | URL | Description | Auth |
|---|---|---|---|
| POST | `/api/auth/signup` | 회원가입 | X |
| POST | `/api/auth/login` | 로그인 | X |
| POST | `/api/auth/reissue` | 토큰 재발급 | X |
| POST | `/api/auth/logout` | 로그아웃 | O |

### User

| Method | URL | Description | Auth |
|---|---|---|---|
| GET | `/api/users/me` | 내 정보 조회 | O |
| PATCH | `/api/users/me` | 내 정보 수정 | O |

### Post

| Method | URL | Description | Auth |
|---|---|---|---|
| GET | `/api/posts` | 게시글 목록 조회 | X |
| GET | `/api/posts/{postId}` | 게시글 상세 조회 | X |
| POST | `/api/posts` | 게시글 작성 | O |
| PATCH | `/api/posts/{postId}` | 게시글 수정 | O |
| DELETE | `/api/posts/{postId}` | 게시글 삭제 | O |

### Comment

| Method | URL | Description | Auth |
|---|---|---|---|
| POST | `/api/posts/{postId}/comments` | 댓글 작성 | O |
| DELETE | `/api/comments/{commentId}` | 댓글 삭제 | O |

### Like

| Method | URL | Description | Auth |
|---|---|---|---|
| POST | `/api/posts/{postId}/likes` | 게시글 좋아요 | O |
| DELETE | `/api/posts/{postId}/likes` | 게시글 좋아요 취소 | O |

---

## 🚀 실행 방법

### 1. Repository Clone

```bash
git clone https://github.com/사용자이름/appjam-auth-board.git
cd appjam-auth-board
```

### 2. 환경 변수 설정

`application.yml` 또는 `.env`에 아래 값을 설정합니다.

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/appjam_auth_board
    username: root
    password: password

jwt:
  secret: your-secret-key
  access-token-expiration: 1800000
  refresh-token-expiration: 1209600000
```

### 3. 실행

```bash
./gradlew bootRun
```

---

## ✅ 학습 체크리스트

### JPA

- [x] Entity 설계
- [x] Repository 작성
- [ ] 연관관계 매핑
- [ ] DTO 변환
- [ ] N+1 문제 확인
- [x] `@Transactional` 이해

### Auth

- [ ] 회원가입 구현
- [ ] 비밀번호 암호화
- [ ] 로그인 구현
- [ ] Access Token 발급
- [ ] Refresh Token 발급
- [ ] 토큰 재발급 구현

### Spring Security

- [ ] SecurityConfig 작성
- [ ] JWT Filter 구현
- [ ] 인증이 필요한 API와 필요 없는 API 분리
- [ ] 로그인한 사용자 정보 조회
- [ ] 작성자 권한 검증

### OAuth2

- [ ] Google OAuth2 로그인
- [ ] Kakao OAuth2 로그인
- [ ] 소셜 로그인 성공 후 JWT 발급
- [ ] 신규 사용자 자동 회원가입 처리

---

## 🧠 배운 점 정리

프로젝트를 진행하면서 배운 내용을 아래에 정리합니다.

### JPA

- Entity와 DTO를 분리해야 하는 이유
- `@ManyToOne(fetch = FetchType.LAZY)`를 사용하는 이유
- Repository 메서드 네이밍 규칙

### JWT

- Access Token과 Refresh Token의 차이
- Authorization Header에서 Bearer Token을 추출하는 방법
- 토큰 만료와 재발급 흐름

### Spring Security

- Security Filter Chain의 역할
- JWT 인증 필터가 동작하는 위치
- `SecurityContextHolder`에 인증 정보를 저장하는 이유

### OAuth2

- OAuth2 로그인과 JWT 인증의 차이
- 소셜 로그인 성공 후 우리 서비스의 JWT를 발급해야 하는 이유

---

## 📝 Commit Convention

```text
feat: 새로운 기능 추가
fix: 버그 수정
refactor: 코드 리팩토링
docs: 문서 수정
test: 테스트 코드 추가
chore: 설정 변경
```

예시:

```bash
git commit -m "feat: 회원가입 API 구현"
git commit -m "feat: JWT 토큰 발급 기능 구현"
git commit -m "fix: 게시글 수정 권한 검증 오류 해결"
```

---

## 📍 진행 상황

- [x] 프로젝트 초기 세팅
- [ ] User 도메인 구현
- [x] Post 도메인 구현
- [ ] Comment 도메인 구현
- [ ] Like 도메인 구현
- [ ] 회원가입 구현
- [ ] 로그인 구현
- [ ] JWT 인증 구현
- [ ] Refresh Token 구현
- [ ] Spring Security 적용
- [ ] OAuth2 로그인 구현
- [ ] Swagger API 문서화
- [ ] 배포
