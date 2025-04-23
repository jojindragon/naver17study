import React, { useState } from 'react';
import { Alert, Button } from '@mui/material';
import { DeleteForeverSharp } from '@mui/icons-material';

const SixApp = () => {
  const [inputArray, setInputArray] = useState([]);
  const [inputs, setInputs] = useState({
    name:'',
    nickname:'',
    hp:'',
    addr:''
  });

  // 각 데이터 입력 시 inputs의 각 멤버 값에 넣어주기
  const changeData = (e) => {
    // e.target.name, e.target.value
    let { name, value } = e.target;

    setInputs(
      {
        ...inputs, // 기존 inputs 객체 펼쳐 넣기
        [name]:value // 입력한 태그의 name & value 넣기
      }
    )
  }

  return (
    <div>
      <Alert severity='success'>SixApp - 입력 값들을 하나의 객체에 넣기</Alert>
      <table className='table table-bordered' style={{width:'300px'}}>
        <tbody>
          <tr>
            <th className='table-success' width="100">이름</th>
            <td>
              <input type='text' className='form-control'
               name='name' value={inputs.name}
               onChange={changeData} />
            </td>
          </tr>
          <tr>
            <th className='table-success' width="100">닉네임</th>
            <td>
              <input type='text' className='form-control'
               name='nickname' value={inputs.nickname}
               onChange={changeData} />
            </td>
          </tr>
          <tr>
            <th className='table-success' width="100">핸드폰</th>
            <td>
              <input type='text' className='form-control'
               name='hp' value={inputs.hp}
               onChange={changeData} />
            </td>
          </tr>
          <tr>
            <th className='table-success' width="100">주소</th>
            <td>
              <input type='text' className='form-control'
               name='addr' value={inputs.addr}
               onChange={changeData} />
            </td>
          </tr>
          <tr>
            <td colSpan={2} align='center'>
              <Button variant='outlined' color='warning'
               onClick={()=>setInputArray(inputArray.concat(inputs))}>배열에 추가</Button>
              <Button variant='outlined' color='warning'
               onClick={()=> setInputs({
                name:'',
                nickname:'',
                hp:'',
                addr:''
               })}>입력값 초기화</Button>
            </td>
          </tr>
          <tr style={{height:'100px'}} className='table-info'>
            <td colSpan={2}>
              <h5>이름 : {inputs.name}</h5><br />
              <h5>닉네임 : {inputs.nickname}</h5><br />
              <h5>핸드폰 : {inputs.hp}</h5><br />
              <h5>주소 : {inputs.addr}</h5><br />
            </td>
          </tr>
        </tbody>
      </table>
      <hr />
      <table className='table table-bordered' style={{width:'500px'}}>
        <caption align='top'>총 {inputArray.length} 명</caption>
        <thead>
          <tr className='table-success'>
            <th width='50'>번호</th>
            <th width='80'>이름</th>
            <th width='80'>닉네임</th>
            <th width='100'>핸드폰</th>
            <th width='120'>주소</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {
            inputArray.map((row, idx) =>
              <tr key={idx}>
                <td align='center'>{idx+1}</td>
                <td>{row.name}</td>
                <td>{row.nickname}</td>
                <td>{row.hp}</td>
                <td>{row.addr}</td>
                <td align='center'>
                  <DeleteForeverSharp style={{color:'red', cursor:'pointer'}}
                   onClick={()=> {
                    setInputArray(inputArray.filter((d, i)=> i!==idx));
                   }} />
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </div>
  );
};

export default SixApp;