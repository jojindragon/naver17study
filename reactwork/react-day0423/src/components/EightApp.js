import React, { useState } from 'react';
import { Alert } from '@mui/material';
import SubEightApp from './SubEightApp';
/*
  ** 부모 자식 간 통신**
  1. 부모 컴포넌트에서 자식 컴포넌트로 props를 통해서 값이나 이벤트 전달 가능
  2. 자식 컴포넌트에서 부모 컴포넌트의 값을 props로 받아서 출력은 가능
      단, 직접적인 변경은 불가능
  3. 만약 변경하려면 부모의 이벤트를 props를 통해서 호출을 해서
      그 이벤트 함수에서 변경을 하면 된다.
 */
const EightApp = () => {
  const [count, setCount] = useState(10);

  const increCountEvent = () => {
    setCount(count+1);
  }

  const decreCountEvent = (num) => {
    setCount(count-num);
  }
  
  return (
    <div>
      <Alert severity='success'>EightApp-부모 자식 컴포넌트 간 통신</Alert>
      <hr />
        <h2>총 방문 횟수: {count}</h2>
      <hr />
      <SubEightApp name={'이영자'} age={21}
       cntHandler={increCountEvent} decHandler={decreCountEvent} />
      <SubEightApp name={'유재석'} age={34}
       cntHandler={increCountEvent} decHandler={decreCountEvent} />
      <SubEightApp name={'강동원'} age={22}
       cntHandler={increCountEvent} decHandler={decreCountEvent} />
    </div>
  );
};

export default EightApp;