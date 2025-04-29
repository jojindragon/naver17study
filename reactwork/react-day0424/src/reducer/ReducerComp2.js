import React, { useReducer, useState } from 'react';
import Student from './Student';

const initialState = {
  count:1,
  students: [
    {
      id:new Date(),
      name:'이영자',
      isHere:false
    }
  ]
}

const reducer = (state, action) => {
  console.log(state, action);

  switch(action.type) {
    case 'add-student':
      const name = action.payload.name;
      // 추가할 학생 정보
      const addStudent = {
        id:new Date(),
        // name:name //같을 경우 1번만 써도 됨
        name,
        isHere:false
      }

      const data = {
        count:state.count+1,
        students:[
          ...state.students,
          addStudent
        ]
      }
      return data;
    case 'delete-student':
      return {
        count:state.count-1, // 인원 수 1 줄이기
        // payload로 전달된 id를 찾아 filter로 제거
        students:state.students.filter(s=>s.id!==action.payload.id)
      };
    case 'mark-student':
      // mark-student action 발생 시 해당 id와 같은 학생을 찾아서
      // isHere만 반대로 값을 수정
      return {
        count:state.count,
        students:state.students.map(s=>{
          if(s.id===action.payload.id) {
            return {...s, isHere:!s.isHere}
          }
          return s;
        })
      };
    default:
      return state;
  }

}

const ReducerComp2 = () => {
  const [name, setName] = useState('');
  const [studentInfo, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <h5>useReducer 예제 #2</h5>
      <h2 className='alert alert-success'>학생관리 Reducer</h2>
      <div className='input-group' style={{width:'200px'}}>
        <input type='text' className='form-control'
         value={name} onChange={(e)=>setName(e.target.value)} />
        
        &nbsp;&nbsp;
        <button type='button' className='btn btn-sm btn-info'
         onClick={()=>{
          dispatch({'type':'add-student',payload:{name}});
          setName('');
         }}>추가</button>
         <br /><br />
         {
          studentInfo.students.map((stu, idx)=>
            <Student key={idx} stu={stu} dispatch={dispatch} />
          )
         }
      </div>
    </div>
  );
};

export default ReducerComp2;