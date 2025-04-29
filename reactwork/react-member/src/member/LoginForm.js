import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navi = useNavigate();

  const onLoginSubmit = (e) => {
    e.preventDefault();

    let url = "/login?username="+username+"&password="+password;
    axios.get(url).then(res => {
      if(res.data.token == null) {
        alert("Invalid Data!");
      } else {
        sessionStorage.token = res.data.token;
        navi("/member/list");
      }
    })
  }

  return (
    <div>
      <h3 className='alert alert-danger'>로그인 폼</h3>
      <form onSubmit={onLoginSubmit}>
        <table className='table table-bordered'
         style={{margin:'10px 50px', width:'300px'}}>
          <tbody>
            <tr>
              <th className='table-info'>아이디</th>
              <td className='input-group'>
                <input type='text' value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  required className='form-control' />
              </td>
            </tr>

            <tr>
              <th className='table-info'>비밀번호</th>
              <td className='input-group'>
                <input type='password' value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required className='form-control' />
              </td>
            </tr>
            <tr>
              <td colSpan={2} align='center'>
                <button type='submit' className='btn btn-success'>로그인</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
};

export default LoginForm;