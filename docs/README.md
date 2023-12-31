# 🎄 크리스마스 프로모션 🎄


### ❗ 2023년 12월에 우테코 식당에서 1년 중 제일 큰 이벤트 ❗

<br/><br/>

## 🖍️ 목표
1) 중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것
2) 올해 12월에 지난 5년 중 최고의 판매 금액을 달성
3) 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참여하는 것 

<br/><br/>

## 📖 프로그램 소개

###  🥇 첫 번째: 할인 
1. 크리스마스 디데이 할인
   - 이벤트 기간: 2023.12.1 ~ 2023.12.25
   - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
   (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)

2. 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
3. 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
4. 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
5. 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정

이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

<br/>

### 🥈 두 번째: 배지 부여
2024 새해 이벤트에서 활용할 예정인 배지 부여
(혜택 금액에 따른다.)

- 5천 원 이상: ⭐(별)
- 1만 원 이상: 🎄(트리)
- 2만 원 이상: 🎅(산타)

<br/><br/>

### 고객에게 안내할 이벤트 주의 사항
- 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 음료만 주문 시, 주문할 수 없습니다.
- 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.

<br/><br/>

## 🖨️ 출력 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

<br/><br/>

## ✒️ 기능 요구 목록

### 크리스 마스 디데이 할인

- [X] 이벤트 기간은 2023.12.1~2023.12.25까지이다.
- [X] 1일에 1000원으로 시작하여, 매일 100원씩 할인 금액이 증가한다.

### 평일 할인

- [X] 이벤트 기간은 2023.12.1~2023.12.31까지이다.
- [X] 일요일부터 목요일까지 진행한다.
- [X] 디저트 메뉴를 1개당 2023원 할인한다

### 주말 할인

- [X] 이벤트 기간은 2023.12.1~2023.12.31까지이다.
- [X] 금요일부터 토요일까지 진행한다.
- [X] 메인 메뉴를 1개당 2023원 할인한다

### 특별 할인

- [X] 이벤트 기간은 2023.12.1~2023.12.31까지이다.
- [X] 이벤트 달력에 별이 있는지 확인한다
- [X] 별이 있다면 총 주문 금액에서 1000원 할인한다

### 증정 이벤트

- [X] 이벤트 기간은 2023.12.1~2023.12.31까지이다.
- [X] 할인 전 총 주문 금액이 12만원 이상인지 확인한다
- [X] 이상이라면 샴페인 1개를 증정한다

### 이벤트 배지

- [X] 총 혜택 금액에 따라 배지를 부여한다.
    - [X] 5천원 이상이면 별을 부여한다
    - [X] 1만원 이상이면 트리를 부여한다
    - [X] 2만원 이상이면 산타를 부여한다

### 총 주문 금액

- [X] 총 금액은 10000원 이상이어야 이벤트가 적용된다.
- [X] 음료만 주문할 수 없다.
- [X] 메뉴의 사이즈가 20개 이하인지 확인한다

### 입력

- [X] 식당 예상 방문 날짜를 입력 받는다.
- [X] 메뉴와 개수를 입력받는다.

### 날짜

- [X] 날짜는 숫자여야 한다
- [X] 1이상 31이하여야 한다
- [X] 위 조건에 맞지 않는다면 예외 메시지를 보낸다

### 주문 메뉴

- [X] 주문 메뉴가 메뉴판에 있는 지 확인한다
- [X] 메뉴 개수가 숫자인지 확인한다
- [X] 메뉴 개수가 1 이상인지 확인한다
- [X] 중복 메뉴가 없게 한다
- [X] 위 조건에 맞지 않는다면 예외 메시지를 보낸다

### 총 혜택 금액

- [X] 할인 금액의 합계와 증정 메뉴 가격을 합산하여 구한다
- [X] 받을 이벤트 배지를 구한다.

### 출력

- [X] 주문한 메뉴를 보여준다
- [X] 할인 전 총 주문 금액을 보여준다
- [X] 증정 메뉴를 보여준다.
    - [X] 없다면 없음 출력
- [X] 혜택 내역을 보여준다
    - [X] 없다면 없음 출력
- [X] 총 혜택 금액을 보여준다
    - [X] 없다면 0원 출력
- [X] 할인 후 예상 결제 금액을 보여준다
- [X] 12월 이벤트 배지를 보여준다
    - [X] 없다면 없음 출력

<br/><br/>

## ✒️ 예외 사항

### 크리스 마스 디데이 할인

- [X] 이벤트 기간에 이벤트가 적용되지 않는다.
- [X] 1일에 1000원으로 시작한다.
- [X] 매일 100원씩 증가한다.
- [X] 총 할인 금액이 정확해야 한다.

### 평일 할인

- [X] 일요일부터 목요일이라면 이벤트가 적용된다.
- [X] 주문에 디저트 메뉴가 없다면 할인 대상이 안된다.
- [X] 할인 금액이 다르다

### 주말 할인

- [X] 금요일부터 토요일이라면 이벤트가 적용된다.
- [X] 주문에 메인 메뉴가 없다면 할인 대상이 안된다.
- [X] 할인 금액이 다르다

### 특별 할인

- [X] 별이 있어도 할인 되지 않는다.
- [X] 할인 금액이 다르다

### 증정 이벤트

- [X] 총 주문 금액이 12만원 이상이면 이벤트가 적용된다.
- [X] 총 주문 금액이 12만원 미만이면 이벤트가 적용되지 않는다.
- [X] 증정 아이템은 샴페인이어야 한다.
- [X] 12월 1일에서 12월 31일이 아니면 이벤트 적용이 되지 않는다.

### 이벤트 배지

- [X] 총 혜택 금액에 따른 배지 부여가 되어야 한다.

### 총 주문 금액

- [X] 총 금액은 10000원 미만이면 이벤트가 적용되지 않는다.

### 예외 메시지

- [X] 예외 메시지가 [ERROR] 로 시작하지 않는다.

### 날짜

- [X] 날짜가 숫자가 아니다.
- [X] 방문 날짜가 1 이상 31 이하의 숫자가 아닌 경우 예외 발생

### 주문 메뉴

- [X] 메뉴판에 없는 메뉴를 주문한다.
- [X] 메뉴 개수가 숫자가 아니다.
- [X] 메뉴 개수가 최소 메뉴 개수보다 낮으면 예외 발생
- [X] 음료만 주문한다.
- [X] 메뉴의 사이즈가 20개 초과다.
- [X] 중복 메뉴를 주문한다.
- [X] 예외 메시지가 잘못 출력된다.

### 총 혜택 금액

- [X] 할인 금액의 합계와 증정 메뉴 가격을 잘못 합산한다.
- [X] 총 혜택 금액에 따른 이벤트 배지를 잘못 구한다.
    - [X] 예시) 5천원 이상이면 트리를 부여한다. 1만원 이상이면 별을 부여한다.

### 출력

- [X] 정상적으로 출력되는 지 확인
    - [X] 주문한 메뉴를 보여준다
    - [X] 할인 전 총 주문 금액을 보여준다
    - [X] 증정 메뉴를 보여준다.
        - [X] 없다면 없음 출력
    - [X] 혜택 내역을 보여준다
        - [X] 없다면 없음 출력
    - [X] 총 혜택 금액을 보여준다
        - [X] 없다면 0원 출력
    - [X] 할인 후 예상 결제 금액을 보여준다
    - [X] 12월 이벤트 배지를 보여준다
        - [X] 없다면 없음 출력