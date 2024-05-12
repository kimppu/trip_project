<h1 align="center">5조 프로젝트 👍</h1>

> [플레이 데이터] 데이터 엔지니어링 29 기

프로젝트 주제: 순례 길 안내 및 커뮤니티 플랫폼  

프로젝트 주제 설명:  
- "순례길 관광객들을 위한 순례 루트 계획 및 추천  
- 순례 루트 주변 인프라(상가,숙박 등) 정보 제공  
- 실시간 Talk를 통한 상태 및 감정 공유"

활용 기술 스택: Java, Springboot, Bootstrap

주제 선정 이유: 여행을 다니면서 다양한 어플을 사용해본 결과, 한국인을 위한 어플이 없었고, 여행자들끼리 경로를 공유했으면 좋겠다는 필요성을 느낌

----------

## ✨ 프로젝트 설명


```sh
📦main
 ┣ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┗ 📂travelproject
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthProvider.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthUserService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂constant
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationTypes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommonErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EntityErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂customExceptions
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DuplicateEmailException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DuplicateIdException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExceptionControllerAdvice.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExceptionHandlerAdvice.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RestApiException.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginAuthFailureHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginAuthSuccessHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoutAuthSuccesshandler.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomErrorController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PublicController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┣ 📂base
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DateUtil.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDao.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDto.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEntity.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
 ┃ ┃ ┃ ┃ ┗ 📜TravelprojectApplication.java
 ┗ 📂resources
 ┃ ┣ 📂static
 ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┣ 📂fonts
 ┃ ┃ ┣ 📂img
 ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┣ 📂error
 ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┗ 📂plugins
 ┃ ┣ 📂templates
 ┃ ┃ ┣ 📂admin
 ┃ ┃ ┣ 📂auth
 ┃ ┃ ┣ 📂board
 ┃ ┃ ┣ 📂common
 ┃ ┃ ┣ 📂lodge
 ┃ ┃ ┣ 📂plan
 ┃ ┃ ┣ 📂user
 ┃ ┃ ┣ 📜error.html
 ┃ ┃ ┗ 📜index.html
 ┃ ┣ 📜application.yml
 ┃ ┣ 📜intro_1.jpg
 ┃ ┣ 📜intro_2.jpg
 ┃ ┗ 📜intro_3.jpg
```
📂config : Spring Security, ExceptionHandler 폴더

📂controller  
 📜AdminController.java : 관리자 컨트롤러<br>
 📜AuthController.java : 계정(회원가입, 아이디 찾기 등) 컨트롤러<br>
 📜CustomErrorController.java : ContorllerAdvice 에러 컨트롤러<br>
 📜PublicController.java : 미인증 페이지(홈, 게시판 등) 컨트롤러<br>
 📜UserController.java : 유저 컨트롤러

📂service  
 📜BoardService.java : 게시판 작성/수정/삭제 기능 구현  
 📜CommentService.java : 댓글 작성/수정/삭제 기능 구현  
 📜UserService.java : 회원가입/탈퇴/정보수정 및 ID/PW 찾기 기능 구현  

----------

## 📌 프로젝트 목표

```sh
Spring과 Mustache 템플릿을 활용한 웹 사이트 및 JPA를 통한 MySql 데이터 통신 구현  
```

----------

## 🐧 프로젝트 구현

> ### 🏢 **ERD**

<div align="center">
  <img src="./readme/ERD.png" style="zoom:76%;" align="center"/>
</div>

----------

## 🤼‍♂️팀원

Team Leader : 🐯**강재전**

Member : 🐶 **안현준**

Member : 🐺 **김서윤**

Member : 🐱 **조은별**

Member : 🦁 **유성민**

