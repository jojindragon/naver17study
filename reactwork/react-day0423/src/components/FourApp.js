import React, { useRef, useState } from 'react';
import { Alert, Button } from '@mui/material';
/*
  React에서 렌더링(Rendering)이란?
  컴포넌트가 화면(UI)에 표시되도록 React가
  컴포넌트 내용을 계산해서 실제 DOM 또는 가상 DOM에 반영하는 과정
 */

const FourApp = () => {
  const [count, setCount] = useState(1); // 변경될 때마다 렌더링
  const numberRef = useRef(1); // 변경되어도 렌더링 발생 X
  /*
    textarea 처럼 헌번에 많은 글자를 입력해야 하는 경우
    한글자 입력 시 마다 렌더링되면 문제 발생 가능성
    그럴 경우 ref 변수에 저장했다가 나중에 한꺼번에 출력
   */

  const countIncreEvent = () => {
    setCount(count+1);
    console.log("count 증가"+count);
  }

  const numberIncreEvent = () => {
    numberRef.current = numberRef.current + 1;
    console.log("numberRef 증가"+numberRef.current);
  }

  return (
    <div>
      <Alert severity='success'>FourApp-state 변수와 ref 변수의 차이점</Alert>

      <Button variant='contained' color='secondary'
       onClick={countIncreEvent}>count 변수 증가</Button>
      <b style={{fontSize:'3em', marginLeft:'20px'}}>{count}</b>
      <br /><br />
      <Button variant='contained' color='info'
       onClick={numberIncreEvent}>numberRef 변수 증가</Button>
      <b style={{fontSize:'3em', marginLeft:'20px'}}>{numberRef.current}</b>
    </div>
  );
};

export default FourApp;