import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
  const [file, setFile] = useState('');
  const [preview, setPreview] = useState('');
  const [subject, setSubject] = useState('');
  const contentRef = useRef('');
  const [errorMsg, setErrorMsg] = useState(null);

  const {num} = useParams();

  const navi = useNavigate();
  const PHOTO_URL = process.env.REACT_APP_PHOTO_URL;


  // 수정 값을 위한 게시글 얻어오기
  const getUpdateData = () => {
    axios({
      method:'get',
      url:'/auth/board/updateform?num='+num,
      headers: { Authorization: `Bearer ${sessionStorage.token}` }
    }).then(res => {
      // console.log(res.data);
      setPreview(PHOTO_URL+res.data.photo);
      setSubject(res.data.subject);
      contentRef.current.value = res.data.content;
    }).catch(error => setErrorMsg('403'));
  }

  useEffect(() => {
    getUpdateData();
  }, []);

  
  const onUpdateSubmit = (e) => {
    e.preventDefault();

    const uploadData = new FormData();
    uploadData.append("upload", file);
    uploadData.append("num", num);
    uploadData.append("subject", subject);
    uploadData.append("content", contentRef.current.value);

    axios({
      method:'post',
      url:'/auth/board/update',
      data:uploadData,
      headers:{
        'Content-Type':'multipart/form-data',
        Authorization:`Bearer ${sessionStorage.token}`
      }
    }).then(res => {
      alert("게시글 수정!");
      navi(`/board/detail/${num}`);
    })
  }
  
  // 파일 선택 시 미리보기 이미지 나타내기
  const onFileChange = (e) => {
    const file = e.target.files[0];
    const fileReader = new FileReader();
    if(file)
      fileReader.readAsDataURL(file);

    fileReader.onload = () => {
      setPreview(fileReader.result);
    }
  }

  return (
    <div>
      <h3 className='alert alert-info'>게시글 수정</h3>
      {
        sessionStorage.token == null || errorMsg === '403' ?
        <>
          <p>어케 온 건지 모르겠는데 돌아가라</p>
        </>
        :
        <form onSubmit={onUpdateSubmit}>
          <table className='table table-bordered'>
            <tr>
              <th width='100'>사진</th>
              <td width='200'>
                <input type='file' required
                 style={{width:'200px'}}
                 onChange={(e) => {
                  setFile(e.target.files[0]);
                  onFileChange(e);
                 }} />
              </td>
              <td rowSpan={3}>
                <img alt='' src={preview}
                 style={{width:'120px'}} />
              </td>
            </tr>
            <tr>
              <th width='100'>제목</th>
              <td width='200'>
                <input type='text' value={subject}
                 className='form-control' required
                 onChange={(e) => setSubject(e.target.value)} />
              </td>
            </tr>
            <tr style={{height:'120px'}}>
              <td colSpan={2}>
                <textarea style={{width:'100%', height:'120px'}}
                 ref={contentRef}></textarea>
              </td>
            </tr>
            <tr>
              <td colSpan={3} align='center'>
                <button type='submit'
                 className='btn btn-info'>글 수정</button>
              </td>
            </tr>
          </table>
        </form>
      }
    </div>
  );
};

export default UpdateForm;