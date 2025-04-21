/* 단축키 - 자동 함수 완성
    rsf: arrow function 형식
import React from 'react';

function TwoApp(props) {
    return (
        <div>
            
        </div>
    );
}

export default TwoApp;
 */

// rsc
import React from 'react';
import "./mystyle.css";
import food1 from "../food/11.jpg";
import food2 from "../food/8.jpg";

const TwoApp = () => {
    let msg = "Have a Good Day!!"; // 출력은 가능, 태그 내에서 수정 불가
    let msg1 = "Have a Nice Day!!";

    return (
        <div>
            <h2>TwoApp</h2>
            <img alt="" src={food1} className='photo1'/>
            <img alt="" src={food2} className='photo2'/>
            
            {/* h5의 배경색, 글자색, 너비, 글꼴 모두 변경(style로) */}
            <h5 style={{backgroundColor:'tomato', color:'gray',
                width:'300px',fontFamily:'Playwrite AU SA'
            }}>{msg}</h5>
            <h5 className='msg1'>{msg1}</h5>
        </div>
    );
};

export default TwoApp;