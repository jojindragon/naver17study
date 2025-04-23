import React, { useState } from 'react';
import { Alert } from '@mui/material';
import './mystyle.css';
/* 문제
  1. mycarArray를 해당 자동차 이미지가 나오도록 출력(class는 mycar 적용)
  2. input에 숫자 1~15를 입력 후 엔터를 누르면 해당 자동차 번호가 배열에 추가되고
     이미지 형태로 출력이 되도록 한다.
     (단, 1~15가 아닌 경우 '해당 자동차는 존재하지 않아요!' 출력)
  3. 해당 자동차를 더블클릭하면 '해당 자동차를 삭제할까요?'를 물어보고
     확인을 클릭하면 배열에서 삭제하기(filter 이용)
 */

const ThreeApp = () => {
  const [mycarArray, setMycarArray] = useState([1, 5, 10]);
  const [show, setShow] = useState('none');


  const addMycar = (e) => {
    if (e.key === 'Enter') {
      let idx = e.target.value;
      if (idx >= 1 && idx <= 15) {
        setMycarArray(mycarArray.concat(idx));
        setShow('none');
      } else {
        setShow('block');
      }
      e.target.value = ""
    }
  }

  const delMycar = (i) => {
    if(window.confirm("해당 자동차를 삭제할까요?"))
      setMycarArray(mycarArray.filter((c, idx) => idx!==i));
  }

  return (
    <div style={{width:'500px'}}>
      <Alert severity='success'>ThreeApp-배열 문제</Alert>

      <input type='text' className='form-control'
        placeholder='1~15 사이의 자동차 번호 입력' autoFocus
        onKeyUp={addMycar} />
      <div style={{marginTop:'20px'}}>
      <h5 style={{ display: `${show}` }}>해당 자동차는 존재하지 않아요!</h5>
      {
        mycarArray.map((car, i) =>
          <>
            <img alt='' key={i}
              src={require(`../mycar/mycar${car}.png`)}
              className='mycar'
              onDoubleClick={()=>delMycar(i)} />
          </>
        )
      }
      </div>
    </div>
  );
};

export default ThreeApp;