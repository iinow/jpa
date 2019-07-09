# jpa
jpa 

java -jar jpa-0.0.1-SHAPSHOT.jar --server.port=80

인증방식
SAML, JWT, OAuth

스트림
 - SSE(Server-Sent Events)
   MIME TYPE: text/event-stream
     메시지 본문 각 줄 data: 로 시작해서 \n\n 으로 끝난다. 각줄 끝 \n, 마지막 줄 \n\n 
   QOS 지시자가 포함된 줄은 속석명/속성값 사이에 콜론을 넣어 구분
