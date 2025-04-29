import axios from 'axios';
import React, { useState } from 'react';
import DaumPostcodeEmbed from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';

const JoinForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [address, setAddress] = useState('');
  const [openPostCode, setOpenPostCode] = useState(false);
  const [role, setRole] = useState('ROLE_MEMBER');
  const [idCheck, setIdCheck] = useState(false); // true - 가입 가능

  const navi = useNavigate();

  // 회원가입 이벤트
  const onSubmit = (e) => {
    e.preventDefault();
    if(!idCheck) {
      alert("아이디 중복체크를 해주세요");
      return;
    }

    // DB 저장 후 로그인 폼 이동
    axios.post("/member/join", {username, password, role, address})
      .then(res => {
        if(res.data === 'success') {
          alert("회원가입 성공!");
          navi("/member/login");
        }
      })
  }

  // 아이디 중복체크 Event
  const btnIdCheck = () => {
    let url = "/member/idcheck?username="+username;
    axios.get(url).then(res => {
      if(res.data === 'fail') {
        setUsername('');
        setIdCheck(false);
        alert("이미 존재하는 아이디");
      } else {
        setIdCheck(true);
        alert("가입 가능한 아이디");
      }
    });
  }

  // KaKao 주소 Events
  const handle = {
    clickButton:() => {
      setOpenPostCode(current=>!current);
    },

    // 주소 선택 시
    selectAddress: (data) => {
      console.log(data);

      setAddress(`(${data.zonecode})${data.address}`);

      setOpenPostCode(false);
    }
  }

  return (
    <div>
      <h3 className='alert alert-danger'>회원 가입</h3>
      <form onSubmit={onSubmit}>
        <table className='table table-bordered'>
          <tbody>
            <tr>
              <th className='table-info'>아이디</th>
              <td className='input-group'>
                <input type='text' value={username}
                 onChange={(e) => {
                  setIdCheck(false);
                  setUsername(e.target.value);
                 }}
                 required className='form-control' />
                &nbsp;
                <button type='button' className='btn btn-sm btn-danger'
                 onClick={btnIdCheck}>중복 체크</button>
              </td>
            </tr>
            <tr>
              <th className='table-info'>비밀번호</th>
              <td>
                <input type='text' value={password}
                 onChange={(e)=>setPassword(e.target.value)}
                 required className='form-control' />
              </td>
            </tr>
            <tr>
              <th className='table-info'>주소</th>
              <td className='input-group'>
                <input type='text' value={address}
                 onChange={(e)=>setAddress(e.target.value)}
                 required className='form-control' />
                &nbsp;
                <button type='button' className='btn btn-sm btn-danger'
                 onClick={handle.clickButton}>주소 검색</button>
                <br />
                {
                  // 보통 dialog 형식으로 꺼낸다.
                  openPostCode &&
                  <DaumPostcodeEmbed
                   onComplete={handle.selectAddress}
                   autoClose={false}
                   defaultQuery='강남대로 94길 20' />
                }
              </td>
            </tr>
            <tr>
              <th className='table-info'>가입권한</th>
              <td>
                <select className='form-select'
                 onChange={(e)=>setRole(e.target.value)}>
                  <option value={'ROLE_MEMBER'}>일반 멤버</option>
                  <option value={'ROLE_ADMIN'}>관리자</option>
                </select>
              </td>
            </tr>
            <tr>
              <td colSpan={2} align='center'>
                <button type='submit' className='btn btn-success'>회원가입</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
};

export default JoinForm;