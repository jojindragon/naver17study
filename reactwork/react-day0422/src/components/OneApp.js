import React, { useState } from 'react';
import './mystyle.css';
import photo1 from '../image/31.jpg';

const OneApp = () => {
  const [name, setName] = useState('이해성');
  const [age, setAge] = useState(20);

  const style1 = {
    color:'deeppink',
    backgroundColor:'#fcfc00',
    width:'400px',
    border:'5px groove tomato',
    textAlign:'center'
  }

  return (
    <div>
      <h3 className='alert alert-success'>OneApp -복습, 간단한 데이터 입력 이벤트</h3>
      <h5 style={style1}>스타일 적용 방법 #1-변수로 지정</h5>
      <h5 style={{color:'red',fontFamily:'Single Day',
        border:'5px inset gold', width:'400px', textAlign:'center'
      }}>스타일 적용 방법 #2-직접 지정</h5>
      <h5 className='myfont'>스타일 적용 방법 #3-클래스 적용</h5>
      <img alt='' src={photo1} style={{width:'150px'}} />
      <h6>이름&나이 입력</h6>
      <h2 style={{backgroundColor:'orange'}}>
        이름: {name}<br />
        나이: {age}세
      </h2>
      <input type='text' placeholder='이름 입력' value={name}
       onChange={(e)=>setName(e.target.value)} />
      <input type='text' placeholder='나이 입력' value={age}
       onChange={(e)=>setAge(e.target.value)} />
    </div>
  );
};

export default OneApp;