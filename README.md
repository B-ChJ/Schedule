# Schedule - 일정 관리 앱 Project
Schedule 관리 API

## 🛠️ 개발 환경
- Spring-Boot
- JDK 17
- JPA
- MySQL9

## ➡️ ERD
<img width="320" height="187" alt="image" src="https://github.com/user-attachments/assets/e4fcb94e-e8e6-4efc-be0f-ffa32c099e4b" />

⟪ERD ver1.0⟫

## 📄 API 명세서
[Postman 명세서 이동](https://documenter.getpostman.com/view/48172004/2sB3QQHSq3)

## 🆗 주요 기능
### - 일정 등록
새로운 일정을 등록하는 기능
`Input` 일정 제목, 내용, 작성자명, 비밀번호 ⇒ `Create` 일정 고유ID, 제목, 내용, 작성자명, 비밀번호, 작성일, 수정일
- 최초 등록 시점에서 작성일과 수정일은 동일
- 고유 ID는 등록 순서대로 자동 생성됩니다.
  
### - 일정 조회
등록된 일정 전체, 작성자별 등록된 일정 전체, 1건의 일정을 조회하는 기능
- 비밀번호는 조회할 수 없습니다.

### - 일정 수정
등록된 1건의 일정에 관한 제목, 작성자명을 수정하는 기능
- 입력된 비밀번호와 일정을 등록했을 때 설정한 비밀번호가 일치해야 수정할 수 있습니다. 

### - 일정 삭제
등록된 1건의 일정을 삭제하는 기능
- 입력된 비밀번호와 일정을 등록했을 때 설정한 비밀번호가 일치해야 삭제할 수 있습니다. 
