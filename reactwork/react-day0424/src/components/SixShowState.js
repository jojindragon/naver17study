import React, { useMemo } from 'react';

const getNumber = (number) => {
  console.log("숫자가 변동되었습니다.");
  return number;
}

const getText = (text) => {
  console.log("글자가 변동되었습니다.");
  return text;
}

const SixShowState = ({number, text}) => {
  /*
   * 숫자나 글자가 바뀌면 모든 함수가 호출된다.
   * 숫자나 글자가 바뀌면 관련 함수만 호출되도록 변경 => 렌더링 최적화
   */
  // const showNumber = getNumber(number);
  // const showText = getText(text);

  const showNumber = useMemo(() => getNumber(number), [number]);
  const showText = useMemo(() => getText(text), [text]);

  return (
    <div style={{fontSize:'2px', margin:'20px'}}>
      {showNumber}
      <br /><br />
      {showText}
    </div>
  );
};

export default SixShowState;