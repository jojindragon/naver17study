import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import noimage from '../image/noimage.png';

const UpdateForm = () => {
  const [shopData, setShopData] = useState('');
  const { num } = useParams();

  //업로드한 사진을 저장하기 위한 변수
  const [photo, setPhoto] = useState(null);

  const navi = useNavigate();

  //사진출력할 url
  const photourl = process.env.REACT_APP_PHOTO_URL;

  //파일 업로드 이벤트
  const photoUploadEvent = (e) => {
    const imageFile = new FormData();
    const uploadFile = e.target.files[0];
    imageFile.append("upload", uploadFile);

    axios({
      method: 'post',
      url: "/react/upload",
      data: imageFile
    }).then(res => setPhoto(res.data));
  }

  // 첫 시작 시 spring에서 data 가져오기
  // const getSelectData = () => {
  //   let url = "/react/detail?num=" + num;
  //   axios.get(url).then(res => {
  //     setShopData(res.data);
  //     setPhoto(res.data.photo);
  //   });
  // }

  // 첫 시작 시 1번만 호출
  useEffect(() => {
    // getSelectData();
    let url = "/react/detail?num=" + num;
    axios.get(url).then(res => {
      setShopData(res.data);
      setPhoto(res.data.photo);
    });
  }, [num]);

  // 입력 시 호출
  const shopDataChange = (e) => {
    const { name, value } = e.target;
    setShopData({
      ...shopData, // 기존 값 유지
      [name]: value // 타겟만 변경
    });
  }

  // submit 발생 시 호출
  const onSubmit = (e) => {
    e.preventDefault(); // 기본 이벤트 무효화(action 호출)

    // 수정
    axios.post("/react/shopupdate", shopData).then(res => {
      // 수정 성공 후 갈 장소 - 상세보기 페이지
      navi(`/five/detail/${num}`);
    });

  }

  return (
    <div>
      <Alert severity='info'>UpdateForm</Alert>
      <form onSubmit={onSubmit}>
        <table className='table table-bordered' style={{ width: '500px' }}>
          <tbody>
            <tr>
              <td rowSpan={5} width={200} align='center'>
                <img alt='' src={photo ? photourl + photo : noimage}
                  style={{ width: '180px' }} />
              </td>
              <td width="100" d>사진</td>
              <td>
                <input type='file' onChange={photoUploadEvent}
                 style={{ width: '200px' }} />
              </td>
            </tr>
            <tr>
              <td>상품명</td>
              <td>
                <input type='text'
                 value={shopData.sangpum} className='form-control'
                 name="sangpum"
                 onChange={shopDataChange} />
              </td>
            </tr>
            <tr>
              <td>가격</td>
              <td>
                <input type='text'
                 value={shopData.price} className='form-control'
                 name="price"
                 onChange={shopDataChange} />
              </td>
            </tr>
            <tr>
              <td>색상</td>
              <td>
                <input type='color'
                 value={shopData.color} className='form-control'
                 name="color"
                 onChange={shopDataChange} />
              </td>
            </tr>
            <tr>
              <td>구입일</td>
              <td>
                <input type='date'
                 value={shopData.sangguip} className='form-control'
                 name='sangguip'
                 onChange={shopDataChange} />
              </td>
            </tr>
            <tr>
              <td colSpan={3} align='center'>
                <Button color='success' variant='contained' type='submit'
                 style={{ margin:'10px 160px', width:'100px' }}>상품 수정</Button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
};

export default UpdateForm;