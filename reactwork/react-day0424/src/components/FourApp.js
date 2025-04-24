import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import FourWriteShop from './FourWriteShop';
import axios from 'axios';
import FourRowItem from './FourRowItem';
/*
  axios - 현재 커뮤니티에서 가장 많이 사용하는 http 통신 라이브러리
  **형식**
  axios.get('url').then().catch();
  axios.post('url).then().catch();
  또는
  axios({
    method:'get',
    url:'url',
    ......
  })
 */
const FourApp = () => {
  const [shoplist, setShoplist] = useState([]);

  // 추가하는 함수
  // const addurl = "http://localhost:8090/react/addshop";
  const addurl = "/react/addshop"; // package.json에서 proxy 설정한 경우

  const addShopEvent = (shopdata) => {
    // console.log(shopdata);
    axios.post(addurl, shopdata)
      .then(res=>{
        // alert(res.data);
        list();
      }).catch(error=>console.log("insert 오류: "+error));
  }

  // db에서 데이터를 가져오는 함수
  const list = () => {
    axios.get("/react/shoplist")
      .then(res=>setShoplist(res.data));
  }
  // 처음 시작 시 딱 1번만 list 호출
  useEffect(() => {
    list();
  }, []);

  return (
    <div>
      <Alert severity='success'
       style={{fontSize:'25px'}}>FourApp - axios 통신</Alert>
      <FourWriteShop onSave={addShopEvent} />
      <hr />
      <h5>총 {shoplist.length} 개의 상품</h5>
      <table className='table table-bordered' style={{width:'500px'}}>
        <tbody>
          {
            // 비동기 통신 특성 상 약간의 시간을 두고 불러와지는 경우
            // 가끔 오류가 발생하는 현상
            shoplist &&
            shoplist.map((row, idx) =>
              <FourRowItem key={idx} row={row} />)
          }
        </tbody>
      </table>
    </div>
  );
};

export default FourApp;