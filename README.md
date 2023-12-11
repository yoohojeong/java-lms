# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

</br>

---

## 요구사항

<details>
<summary><b>🚀 1단계 - 레거시 코드 리팩터링</b></summary>

**리팩터링 요구사항**
> - [X] QnaService의 deleteQuestion() 메서드에 단위 테스트 가능한 코드(핵심 비지니스 로직)를 도메인 모델 객체에 구현한다.
> - [X] QnaService의 비지니스 로직을 도메인 모델로 이동하는 리팩터링을 진행할 때 TDD로 구현한다.
>> - [X] 질문(Question)은 Question Domain 에서 삭제 가능 검증 후, 삭제한다.
>> - [X] 질문에 달린 답변들(Answers)는 Answers 일급 컬렉션에서 삭제 가능 검증 후, 삭제한다.
</details>

<details>
<summary><b>🚀 2단계 - 수강신청(도메인 모델)</b></summary>

### 수강 신청 기능 요구사항

**CoverImage**
> - [X] 이미지 크기는 1MB 이하여야 한다.
> - [X] 이미지 타입은 gif, jpg(jpeg 포함),, png, svg만 허용한다.
> - [X] 이미지의 width는 300픽셀, height는 200픽셀 이상이어야 하며, width와 height의 비율은 3:2여야 한다.

**Session**
> - [X] 강의는 강의 커버 이미지 정보를 가진다.
> - [X] 강의 상태는 준비중, 모집중, 종료 3가지 상태를 가진다.
> - Period
>> - [X] 강의는 시작일과 종료일을 가진다.
> - SessionFee
>> - [X] 강의는 무료 강의와 유료 강의로 나뉜다.
>> - [X] 무료 강의는 최대 수강 인원 제한이 없다.


**Enrollment**
> - [X] 유료 강의의 경우 결제는 이미 완료한 것으로 가정하고 이후 과정을 구현한다.
> - [X] 강의 수강신청은 강의 상태가 모집중일 때만 가능하다.
> - [X] 유료 강의는 수강생이 결제한 금액과 수강료가 일치할 때 수강 신청이 가능하다.

**SessionUser**
> - [X] 수강신청 완료 시 Session, NsUser 정보를 등록한다.

**SessionUsers**
> - [X] 유료 강의는 강의 최대 수강 인원을 초과했을 경우 더이상 수강신청 할 수 없다.

**Course**
**Sessions**
> - [X] 과정(Course)은 기수 단위로 운영하며, 여러 개의 강의(Session)를 가질 수 있다.

**Payment**
> - [X] 결제를 완료한 결제 정보는 payments 모듈을 통해 관리되며, 결제 정보는 Payment 객체에 담겨 반한된다.
</details>
