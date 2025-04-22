import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

const MainApp = () => {
  const [idx, setIdx] = useState(8);

  // radio Event
  const selectapp = (e) => {
    setIdx(Number(e.target.value));
    // alert(typeof(e.target.value)); // default 값으로는 string이 넘어옴

  }

  return (
    <div>
      <h3 className='alert alert-danger'>react 수업 2025/04/22</h3>
      <label>
        <input type='radio' name='selectapp' defaultValue={1}
         onClick={selectapp} />OneApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp' defaultValue={2}
         onClick={selectapp} />TwoApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={3} />ThreeApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={4} />FourApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={5} />FiveApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={6} />SixApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={7} />SevenApp
      </label>&nbsp;
      <label>
        <input type='radio' name='selectapp'
         onClick={selectapp} defaultValue={8} defaultChecked />EightApp
      </label>&nbsp;
      <div style={{marginTop:'20px'}}>
        {idx===1?<OneApp />:idx===2?<TwoApp />:idx===3?<ThreeApp />:
         idx===4?<FourApp />:idx===5?<FiveApp />:
         idx===6?<SixApp />:idx===7?<SevenApp />:<EightApp />}
      </div>
    </div>
  );
};

export default MainApp;