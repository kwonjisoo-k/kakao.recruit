# kakao.recruit

작성자 : 권지수

머니 뿌리기 기능을 수행하는 REST API 구현

* 사용 라이브러리

Spring Boot
MySql
ActiveMQ
--------------------
# 핵심전략

1. 메시지 큐 기능을 활용하여 다중 서버 다중 동작에서도 기능에 문제가 없도록 설계
2. 사용자는 token 값으로 인증하며 token 안에는 X-USER-ID,X-ROOM-ID 정보가 존재 - (암호화 처리적용)
3. http 인터셉터로 모든 http요청에 token을 인증하여 사용자 및 ROOM 정보를 체크
4. 뿌린건 유효기간은 메시지큐의 유효시간 설정으로 대처
5. 조회 API는 Database를 활용하여 쿼리 조건으로 제약조건을 해결



