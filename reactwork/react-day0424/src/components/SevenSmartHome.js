import React, { useCallback, useState } from 'react';
import SevenLight from './SevenLight';

const SevenSmartHome = () => {
  const [masterOn, setMasterOn] = useState(false);
  const [kitchenOn, setKitchenOn] = useState(false);
  const [bathOn, setBathOn] = useState(false);

  // 기존 이 형식 - 버튼 1개만 눌러도 3개의 서브 컴포넌트 모두 호출
  // const toggleMaster = () => setMasterOn(!masterOn);
  // const toggleKitChen = () => setKitchenOn(!kitchenOn);
  // const toggleBath = () => setBathOn(!bathOn);

  // useCallback으로 최적화
  const toggleMaster = useCallback(() => {
    setMasterOn(!masterOn);
  }, [masterOn]);
  
  const toggleKitChen = useCallback(() => {
    setKitchenOn(!kitchenOn);
  }, [kitchenOn]);
  
  const toggleBath = useCallback(() => {
    setBathOn(!bathOn);
  }, [bathOn]);

  return (
    <div>
      <SevenLight room={'침실'} on={masterOn} toggle={toggleMaster} />
      <SevenLight room={'주방'} on={kitchenOn} toggle={toggleKitChen} />
      <SevenLight room={'욕실'} on={bathOn} toggle={toggleBath} />
    </div>
  );
};

export default SevenSmartHome;