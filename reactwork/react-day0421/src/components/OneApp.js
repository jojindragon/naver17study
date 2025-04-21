/*
    초창기 컴포넌트 - 모두 클래스 형태
    초기 함수형태는 상태 저장을 하는 state 기능이 없었다.

    Hooks 문법이 v16.8부터 새로 도입 => 일반 함수 형태로 변경
    Hooks 문법이 추가되면서 일반 함수에서도 상태유지를 위한 state 기능 추가
    클래스 형태 때는 라이프 사이클이 복잡했었는데 Hooks 문법 이후 라이프 사이클도 엄청 단순해짐
 */
import { Component } from "react";
import car11 from "../mycar11.png";

// 첫 예제: 클래스 형식으로 만들기

class OneApp extends Component {
  // return 내에 있는 구문: html이 아닌 JSX 태그
  /* html & jsx 차이점
      1. 모든 요소는 짝이 맞아야한다 (예: br, img 등등도 짝이 맞아야 함)
      2. 특성 이름이 html 언어 사양이 아닌 dom api에 기반을 둔다.
   */
  // constructor(props) {
  //     // 생성자는 클래스명과 관련없이 무조건 constructor
  //     super(props);
  // }
  render() {
    return (
      // 부모 태그는 무조건 1개만 가능
      // 태그 내의 직접 스타일 추가
      <div style={{backgroundColor: 'orange', width: '300px', height: '200px'}}>
        <h2 style={{color:'blue', backgroundColor: 'yellow'}}>OneApp 컴포넌트</h2>
        {/* <br></br> 같이 보통 단독태그인 경우 />로 닫는다 */}
        <br />
        {/* public 이미지 출력 - 경로로 가능(권장 X)
         -> 나중에 router에서 문제 발생 가능성 */}
        <img alt="" src="./mycar13.png" style={{width:'100px'}}/>

        {/* src 이미지 가져오기
          1. import 후 가져오기
          2. require 명령어 이용
         */}
         <img alt="" src={car11} style={{width:'100px'}} />
      </div>
    )
  }
}

// default 없는 경우
export { OneApp }  // 여러 번 사용 가능, import 할 때 {OneApp}으로만 import 가능

// export default OneApp; // default는 단 1번만 사용 가능, 이 경우는 import 시에 내 마음대로 이름을 정할 수 있다.
