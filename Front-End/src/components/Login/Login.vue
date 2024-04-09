<template>
    <div class="wrapper">
        <div class="login">
            <div class="title">
                <h1>English Study Club</h1>
            </div>
            <div class="idTitle">
                <h2>아이디</h2>
                <input type="text" class="idBox" placeholder="아이디를 입력하세요" v-model.trim="member_id">
            </div>
            <div class="pwdTitle">
                <h2>비밀번호</h2>
                <input type="password" class="pwdBox" placeholder="비밀번호를 입력하세요" v-model.trim="member_pwd">
            </div>
            <div>
                <span class="left">회원가입</span>
                <span class="right">비밀번호 찾기</span>
                <span class="division">|</span>
                <span class="right">아이디 찾기</span>           
            </div>
            <div class="logindiv">
                <button type="button" class="loginBtn" onclick="">로그인</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
const member_id = ref('');
const member_pwd = ref('');

console.log(member_id);
console.log(member_pwd);

const tokenData = async () => {
    await axios.post("http://localhost:5173/api/login",
    {
        memberId: member_id.value,
        memberPwd: member_pwd.value
    }).then ((response) => {    // then: post 요청 성공 시 동작할 콜백 함수 등록
        if(response.status == 200) {
            console.log('response status: ', response.status);
            console.log('response headers: ', response.headers);

            // 토큰 및 아이디 로컬 스토리지에 저장
            localStorage.setItem('token', response.headers.token)
            localStorage.setItem('member_id', member_id.value)

            router.push('/');
        }
    }).catch ((e) => {
        console.log('로그인 실패');
        alert('입력한 정보가 유효하지 않습니다. 아이디와 비밀번호를 확인해주세요.');
    })
};

function inputCheck() {
    if(member_id.value == ''){
        alert('아이디를 입력해주세요.');
        return false;
    } else if (member_pwd.value == ''){
        alert('비밀번호를 입력해주세요.');
        return false;
    } else {
        // 서버 연동하여 토큰값 가져온 후 유효성 검사 코드 추가
        console.log('입력 정보 확인 완료');
        console.log(member_id.value);
        console.log(member_pwd.value);
        return true;
    }
}
</script>

<style scoped>
    .wrapper {
        width:75%;
        margin-left: 12.5%;
        margin-right: 12.5%;
        display: grid;
    }

    .login {
        width:50%;
        margin-left: 25%;
        margin-right: 25%;
        display: grid;
    }

    .title {
        text-align: center;
        margin-top: 5%;
        font-size: 20px;
        
    }

    .idTitle{
        width: 100%;
        margin-top: 10%;
        font-size: 12px;

    }

    .idBox {
        width: 100%;
        height: 50px;
    }

    .pwdTitle {
        width: 100%;
        font-size: 12px;
    }

    .pwdBox {
        width: 100%;
        height: 50px;
    }

    .right {
        float: right;
        margin-left: 2%;
        cursor: pointer;
    }

    .division {
        float: right;
        margin-left: 2%;
    }

    .left {
        cursor: pointer;
    }

    .logindiv {
        width:100%;
        margin-top:20%;
        margin-bottom: 20%;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        justify-items: center;

    }

    .loginBtn {
        background-color: #515050;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 12px;
        font-style: bold;
        justify-content: center;
        display: flex;
        align-items: center;
        width: 100%;
        grid-column-start: 2;
	    grid-column-end: 3;
    }

    
</style>