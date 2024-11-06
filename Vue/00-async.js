// 비동기 작업
setTimeout(function(){
  console.log("2초 후에 실행.")
}, 2000);

console.log("바로 실행")

// 자바스크립트 실행
// 1. 브라우저에서 실행(html 문서)
//    html 파일을 만들고 live-server로 돌린 후
//    브라우저의 콘솔 창으로 확인
// 2. Node.js로 실행.
//    - node.js 설치
//    - node 파일명
//    - Extension: Code Runner