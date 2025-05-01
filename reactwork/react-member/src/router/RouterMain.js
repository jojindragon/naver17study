import React from 'react';
import { Home, Menu } from '../components';
import { Route, Routes } from 'react-router-dom';
import { JoinForm, LoginForm, MemberList } from '../member';
import { BoardDetail, BoardForm, BoardList, UpdateForm } from '../board';
import errorimg from '../image/errorImg.jpg';

const RouterMain = () => {
  return (
    <div>
      <Menu />
      <br style={{ clear: 'both' }} />
      <div style={{ margin:'10px 30px', width:'500px' }}>
        <Routes>
          <Route path='/' element={<Home />} />

          <Route path='/member'>
            <Route path='join' element={<JoinForm />} />
            <Route path='list' element={<MemberList />} />
            <Route path='login' element={<LoginForm />} />
          </Route>

          <Route path='/board'>
            <Route path='list' element={<BoardList />} />
            <Route path='form' element={<BoardForm />} />
            <Route path='detail/:num' element={<BoardDetail />} />
            <Route path='updateform/:num' element={<UpdateForm />} />
          </Route>

          {/* 이외의 매핑주소 */}
          <Route path='*' element={
            <div>
              <h1>잘못된 URL 입니다</h1>
              <img alt='' src={errorimg} />
            </div>
          } />

        </Routes>
      </div>
    </div>
  );
};

export default RouterMain;