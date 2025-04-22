import React, { useState } from 'react';
import photo1 from '../image2/12.jpg';
import photo2 from '../image2/13.jpg';
import photo3 from '../image2/17.jpg';
import photo4 from '../image2/18.jpg';
import photo5 from '../image2/19.jpg';

const ThreeApp = () => {
   const [photo, setPhoto] = useState(photo4);
   const [hide, setHide] = useState(false);
   const [txt, setTxt] = useState('리액트 문제 다 풀면 복습 100% 보장');
   const [border, setBorder] = useState('dashed');
   const [width, setWidth] = useState(200);

   // btn event
   const decreImg = () => {
      setWidth(width-10);
   }
   const increImg = () => {
      setWidth(width+10);
   }

   return (
      <div>
         <h3 className='alert alert-success'>ThreeApp - 이벤트 연습 #2</h3>
         <b style={{fontFamily:'Nanum Pen Script', fontSize:'3em',
            color:'deeppink'
          }}>오늘의 문제</b>
         <hr />
         <div className='input-group'>
            <label>
               <input type='checkbox'onClick={(e)=>setHide(e.target.checked)} />사진 숨김
            </label>

            <button type='button' className='btn btn-outline-danger'
             style={{marginLeft:'60px'}}
             onClick={decreImg}>점점작게</button>
            <button type='button' className='btn btn-outline-danger'
             style={{marginLeft:'10px'}}
             onClick={increImg}>점점크게</button>
         </div>
         <br />
         <input type='text' className='form-control' style={{width:'400px'}}
          placeholder='메시지 입력!'
          value={txt}
          onChange={(e)=>setTxt(e.target.value)} />
         <br /><br />
         <div style={{float:'left'}}>
            <select className='form-select' style={{width:'200px'}}
             onChange={(e)=>setPhoto(e.target.value)}>
               <option value={photo1}>박보영</option>
               <option value={photo2}>사진 박신혜</option>
               <option value={photo3}>신민아</option>
               <option value={photo4} selected>신세경</option>
               <option value={photo5}>수지</option>
            </select>
            <br /><br />
            <select className='form-select' style={{width:'200px'}}
             onChange={(e)=>setBorder(e.target.value)}>
               <option value={'solid'}>solid</option>
               <option value={'inset'}>inset</option>
               <option value={'outset'}>outset</option>
               <option value={'dashed'} selected>dashed</option>
               <option value={'groove'}>groove</option>
            </select>
         </div>
         {
            !hide &&
            <img alt='' src={photo} style={{
               width: `${width}px`,
               border: `10px ${border} pink`,
               marginLeft:'20px'
             }} />
         }

         <h1 style={{clear:'both', width:'500px'}}
          className='alert alert-info'>{txt}</h1>
      </div>
   );
};

export default ThreeApp;