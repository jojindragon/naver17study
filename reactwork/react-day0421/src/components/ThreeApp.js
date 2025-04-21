import React, { useState } from 'react';
import "./mystyle.css";

const ThreeApp = () => {
  // 값 변경을 위해서는 useState로 선언
  // [변수, setter 함수]=useState(초기값)
  const [number, setNumber] = useState(0); // 0 - 초기값

  // 통장번호 저장 변수
  const [accountNum, setAccountNum] = useState('111-111-1111');

  // 5씩 증감하는 버튼 이벤트
  const decre5 = () => {
    if(number > 0)
      setNumber(number-5);
  }

  const incre5 = () => {
    if(number < 100)
      setNumber(number+5);
  }

  return (
    <div>
      <h3>ThreeApp 컴포넌트 - 숫자 증감 이벤트</h3>

      <button type='button' className='btnstyle'
        onClick={() => {
          if(number > 0)
            setNumber(number - 1);
        }}>감소</button>
      <button type='button' className='btnstyle'
        onClick={() => {
          if(number < 10)
            setNumber(number + 1);
        }}>증가</button>
      <br /><br />
      <button type='button' className='btnstyle'
       onClick={decre5}>5씩 감소</button>
      <button type='button' className='btnstyle'
       onClick={incre5}>5씩 증가</button>
      <br />
      <b className='numstyle'>{number}</b>
      <hr/>

      {/* 통장번호 입력 시 바로 바뀐 번호로 출력 */}
      <input type='text' className='form-control'
       placeholder='통장번호 입력'
       value={accountNum}
       onChange={(e)=>setAccountNum(e.target.value)} />
      <br />
      <h3 style={{color:'red'}}>{accountNum}</h3>
    </div>
  );
};

export default ThreeApp;