import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const ShopDetail = () => {
  const [selectData, setSelectData] = useState('');

  const {num} = useParams();

  // num에 해당하는 데이터 가져오기
  const getSelectData = () => {
    let geturl = "/react/detail?num="+num;
    axios.get(geturl).then(res => setSelectData(res.data));
  }

  // 첫 로딩 시 함수 호출
  useEffect(()=>getSelectData(), []);

  return (
    <div>
      <Alert severity='info'>상품 상세보기</Alert>
      {
        selectData &&
        <h2><b>{selectData.sangpum}</b></h2>
      }
    </div>
  );
};

export default ShopDetail;