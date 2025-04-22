import React, { useEffect, useState } from 'react';
import img1 from '../image2/19.jpg';
import { Button } from '@mui/material';

const SevenApp = () => {
  const [count, setCount] = useState(1);
  const [show, setShow] = useState(true);

  // onClick에 다 넣으면 setter 처리 시간으로 인해 한 템포 늦은 실행이 발생
  // 그러므로 userEffect를 사용해서 정확한 순서의 실행
  useEffect(() => {
    count%3===0?setShow(false):setShow(true);
  }, [count]);

  return (
    <div>
      <h3 className='alert alert-success'>SevenApp-useEffect</h3>
      <h5>count가 3의 배수일 때마다 사진 숨기기</h5>

      <Button variant='contained' color='success'
       onClick={()=>{
        setCount(count+1);
        // 비동기 특성 상 순서대로 진행되지 않음
        // count%3===0?setShow(false):setShow(true);
       }}>count 증가</Button>
      <br />
      <b style={{fontSize:'4em', color:'red'}}>{count}</b>
      <br /><br />
      {
        show &&
        <img alt='' src={img1} style={{width:'300px'}} />
      }
    </div>
  );
};

export default SevenApp;