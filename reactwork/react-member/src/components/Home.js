import React from 'react';
import mainImg from '../image/mainImg.jpg';

const Home = () => {
  return (
    <div>
      <h3 className='alert alert-danger'>홈페이지 방문을 환영합니다</h3>
      <img alt='' src={mainImg}
       style={{width:'100%', border:'10px solid gold'}} />
    </div>
  );
};

export default Home;