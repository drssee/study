async function uploadToServer(formObj) {
    //자바스크립트 formData()로 'file', input[name=files].files[0]을 전송
    //서버에서 전송받아 uuid로 이미지이름 중복없이 지정된 path에 저장
    console.log('upload to server....');
    console.log(formObj);

    const response = await axios({
        method: 'post',
        url: '/upload',
        data: formObj,
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });

    return response.data;
}

async function removeFileToServer(uuid, fileName) {
    const response = await axios.delete(`/remove/${uuid}_${fileName}`);
    return response.data;
}

