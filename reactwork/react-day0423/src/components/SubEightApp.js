import React from 'react';
import './mystyle.css';

// 방법 #1
// const SubEightApp = (props) => {
//   return (
//     <div>
//       <div className='border1'>
//         <h6>이름 : {props.name}</h6>
//         <h6>나이 : {props.age}세</h6>
//         <button type='button'
//          className='btn btn-sm btn-outline-danger'
//          onClick={props.cntHandler}>방문</button>
//         <button type='button'
//          className='btn btn-sm btn-outline-danger'
//          onClick={()=>props.decHandler(3)}>탈퇴</button>
//       </div>
//     </div>
//   );
// };

// 방법 #2
// const SubEightApp = (props) => {
//   const { name, age, cntHandler, decHandler } = props;

//   return (
//     <div>
//       <div className='border1'>
//         <h6>이름 : {name}</h6>
//         <h6>나이 : {age}세</h6>
//         <button type='button'
//          className='btn btn-sm btn-outline-danger'
//          onClick={cntHandler}>방문</button>
//         <button type='button'
//          className='btn btn-sm btn-outline-danger'
//          onClick={()=>decHandler(3)}>탈퇴</button>
//       </div>
//     </div>
//   );
// };

// 방법 #3
const SubEightApp = ({name, age, cntHandler, decHandler}) => {
  return (
    <div>
      <div className='border1'>
        <h6>이름 : {name}</h6>
        <h6>나이 : {age}세</h6>
        <button type='button'
         className='btn btn-sm btn-outline-danger'
         onClick={cntHandler}>방문</button>
        <button type='button'
         className='btn btn-sm btn-outline-danger'
         onClick={()=>decHandler(3)}>탈퇴</button>
      </div>
    </div>
  );
};

export default SubEightApp;