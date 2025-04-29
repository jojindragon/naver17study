import { DeleteForeverOutlined } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';

const MemberList = () => {
  const [members, setMembers] = useState([]);
  // 관리자 외를 위한 에러메시지
  const [errorMsg, setErrorMsg] = useState(null);

  // 기존 받는 형식 - 얘는 admin을 알 수 없기에 header를 보내야함
  // const list = () => {
  //   axios.get("/auth/member/list")
  //     .then(res => setMembers(res.data));
  // }

  const list = () => {
    axios({
      method: 'get',
      url: '/auth/member/list',
      headers: { Authorization: `Bearer ${sessionStorage.token}` }
    }).then(res => setMembers(res.data))
      .catch(error => {
        // alert(error);
        setErrorMsg("403");
      });
  }

  // 삭제 이벤트
  const delMember = (id) => {
    // alert(id);
    if (!window.confirm("해당 멤버를 삭제?"))
      return;

    axios.delete("/member/delete?id=" + id)
      .then(res => list());
  }


  useEffect(() => {
    list();
  }, []);


  return (
    <div>
    {
      sessionStorage.token == null ?
        <div>
          <h1>먼저 로그인을 해라.</h1>
        </div>
      :errorMsg === '403' ?
        <div>
          <h1>관리자만 볼 수 있는 페이지입니다</h1>
        </div>
      :
        <div>
          <h3 className='alert alert-danger'>회원 리스트</h3>
          <table className='table table-bordered'>
            <thead>
              <tr className='table-warning'>
                <td>번호</td>
                <td>아이디</td>
                <td>권한</td>
                <td>가입일</td>
                <td>삭제</td>
              </tr>
            </thead>
            <tbody>
              {
                members &&
                members.map((row, idx) =>
                  <>
                    <tr key={idx}>
                      <td rowSpan={2} align='center'>{idx + 1}</td>
                      <td>{row.username}</td>
                      <td align='center'>
                        {row.role === 'ROLE_ADMIN' ? "관리자" : "회원"}
                      </td>
                      <td align='center'>{row.gaipday}</td>
                      <td align='center'>
                        <DeleteForeverOutlined
                          style={{ cursor: 'pointer', color: 'red' }}
                          onClick={() => delMember(row.id)} />
                      </td>
                    </tr>
                    <tr>
                      <td colSpan={4}
                        style={{ backgroundColor: '#ffc' }}>[주소]{row.address}</td>
                    </tr>
                  </>
                )
              }
            </tbody>
          </table>
        </div>}
    </div>
  );
};

export default MemberList;