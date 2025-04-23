import React, { useState } from 'react';
import { Alert } from '@mui/material';
import { DeleteForeverOutlined } from '@mui/icons-material';

const TwoApp = () => {
  const [msg, setMsg] = useState(["안녕하세요", "비트캠프", "Happy Day!!"]);

  // 메세지 입력 후 엔터 누르면 배열 추가
  const addMessageEvent = (e) => {
    if(e.key === 'Enter') {
      // alert(e.target.value+","+e.key);

      // react 배열 추가 - push가 아닌 concat으로 추가
      setMsg(msg.concat(e.target.value));
      e.target.value="";
    }
  }

  // 삭제
  const deleteMessage = (i) => {
    // 배열 데이터 삭제
    // 방법 1. slice 이용
    // setMsg(
    //   [
    //     ...msg.slice(0, i),
    //     ...msg.slice(i+1, msg.length)
    //   ]
    // );

    // 방법 2. filter 이용(i번지만 제하고 리턴)
    setMsg(msg.filter((m, idx) => idx!==i));
  }

  return (
    <div style={{width:'400px'}}>
      <Alert severity='success'>TwoApp-배열에 추가&삭제 연습</Alert>
      <h6>추가할 메시지 입력</h6>
      <input type='text' className='form-control'
       placeholder='input message' autoFocus
       onKeyUp={addMessageEvent} />
      <br />
      <h6 style={{backgroundColor:'orange'}}>msg 배열 데이터 (총 {msg.length}개)</h6>
      {
        msg.map((m, i) => 
          <h5 key={i}>
            {i+1} : {m}

            <DeleteForeverOutlined 
             style={{float:'right', cursor:'pointer', color:'red'}}
             onClick={()=>deleteMessage(i)} />
            
          </h5>
        )
      }
    </div>
  );
};

export default TwoApp;