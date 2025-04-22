import { Switch } from '@mui/material';
import React, { useEffect, useState } from 'react';

const SixApp = () => {
  // style로 이미지 보이기/숨기기
  const [visible, setVisible] = useState('visible');
  // const [visible, setVisible] = useState('hidden');

  const [count, setCount] = useState(1);
  const [number, setNumber] = useState(100);

  // useEffect(() => {
  //   console.log("처음에는 호출되고 state 변수가 변경될 때마다 호출");
  // });

  // useEffect(() => {
  //   // 2번 호출되는 이유: index.js에서 <React.StrictMode></React.StrictMode> 가 있어서..
  //   console.log("처음 로딩 시 딱 1번만 호출된다.");
  // }, []);

  // useEffect(() => {
  //   console.log("count 변경 시 처리할 코드");
  // }, [count]);

  // useEffect(() => {
  //   console.log("number 변경 시 처리할 코드");
  // }, [number]);

  useEffect(() => {
    console.log("count&number 변경 시 처리할 코드");
  }, [count, number]);

  return (
    <div>
      <h3 className='alert alert-success'>SixApp - MUI Switch, require, useEffect</h3>
      <br />
      <Switch defaultChecked color='secondary'
       onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')} />
      <br />
      <img alt='' src={require('../image2/12.jpg')}
       style={{width:'200px', visibility:visible}} />

      <hr />
      <h1>count: {count}</h1>
      <h1>number: {number}</h1>

      <button onClick={()=>setCount(count+1)}>count 1 증가</button><br />
      <button onClick={()=>setNumber(number+10)}>number 10 증가</button><br />
      <button onClick={()=>{
        setCount(count+2);
        setNumber(number+5);
      }}>count & number 모두 증가</button><br />

    </div>
  );
};

export default SixApp;