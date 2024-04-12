<template>
    <div>
        <div class="regist">
            <div class="title">
                <h1>English Study Club</h1>
            </div>
            <div class="nameTitle">
                <h2>이름</h2>
                <input type="text" class="nameBox" placeholder="이름을 입력하세요" v-model.trim="memberName">
            </div>
            <div class="emailTitle">
                <h2>이메일</h2>
                <div class="confirmdiv">
                    <input type="text" id = "emailBox" class="emailBox" placeholder="이메일을 입력하세요" v-model.trim="memberEmail">
                    <button class="confirm" @click="emailCheck()">확인</button>
                </div> 
            </div>
            <div class="certificationTitle">
                <h2>인증번호</h2>
                <div class="confirmdiv">
                    <input type="text" id="certificationBox" class="certificationBox" placeholder="인증번호를 입력하세요" v-model.trim="certification">
                    <button class="trans" @click="emailSend()">전송</button>
                    <button class="transconfirm" @click="certificationNumCheck()">확인</button>
                </div>
            </div>
            <div class="pwdTitle">
                <h2>비밀번호</h2>
                <input type="password" class="pwdBox" placeholder="비밀번호를 입력하세요" v-model.trim="memberPassword">
            </div>
            <div class="pwdConfirm">
                <h2>비밀번호 확인</h2>
                <input type="password" class="pwdConfirmBox" placeholder="비밀번호를 확인하세요" v-model.trim="passwordConfirm">
            </div>
            <div class="nicknameTitle">
                <h2>닉네임</h2>
                <input type="text" class="nicknameBox" placeholder="닉네임을 입력하세요" v-model.trim="memberNickname">
            </div>
            <div class="registdiv">
                <button type="button" class="registBtn" @click="inputCheck()">가입하기</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from "axios";
import router from '@/router/router';

const memberEmail = ref('');
const memberName = ref('');
const memberPassword = ref('');
const certification = ref('');
const passwordConfirm = ref('');
const memberNickname = ref('');
let emailcheck = false;
let certificationNum;
let NumCheck = false;
let email;

const regist = async () => {
    await axios.post("/api/user/regist",
    {
        memberEmail: memberEmail.value,
        memberPassword: memberPassword.value,
        memberName: memberName.value,
        memberNickname: memberNickname.value

    }).then ((response) => {    // then: post 요청 성공 시 동작할 콜백 함수 등록
        if(response.status == 201) {
            console.log('response status: ', response.status);
            console.log('response headers: ', response.headers);
            alert('회원가입이 완료되었습니다!');
            router.push('/after/login'); 
        }
    }).catch ((e) => {
        console.log('로그인 실패')
        alert('입력한 정보가 유효하지 않습니다. 아이디와 비밀번호를 확인해주세요.');
    
    })
};

function inputCheck() {
    if(memberName.value == ''){
        alert('이름을 입력해주세요.');
        return false;
    } else if(memberEmail.value == ''){
        alert('이메일을 입력해주세요.');
        return false;
    } else if(emailcheck != true ) {
        alert('이메일 확인버튼을 눌러주세요.');
        return false;
    } else if(NumCheck != true) {
        alert('인증번호 확인버튼을 눌러주세요.');
        return false;
    } else if (memberPassword.value == ''){
        alert('비밀번호를 입력해주세요.');
        return false;
    } else if (memberPassword.value != passwordConfirm.value) {
        alert('비밀번호가 일치하지 않습니다.');
        return false;
    } else if (memberNickname.value == '') {
        alert('닉네임을 입력해주세요.');
        return false;
    } else {
        console.log('입력 정보 확인 완료');
        return regist();
    }
}

const emailCheck = async () => {
    console.log(memberEmail.value);
    await axios.get(`/api/user/emailCheck/${memberEmail.value}`)
    .then(response => {
        if(response.data == true) {
            alert('사용가능한 이메일입니다.')
            emailcheck = true;
            let disable = document.querySelector('#emailBox');
            disable.disabled = true;
        }
        else {
            alert('이미 존재하는 이메일입니다.')
            location.reload();
        }
    })
};

const emailSend = async () => {
    console.log(memberEmail.value);
    await axios.post("/api/mailSend", {email : memberEmail.value})
    .then(response => {
        certificationNum = response.data;
        console.log(certificationNum);
    })
}

function certificationNumCheck() {
    if(certification.value == certificationNum) {
        alert('인증번호가 일치합니다.');
        NumCheck = true;
        let disable = document.querySelector('#certificationBox');
        disable.disabled = true;
    }
    else {
        alert('인증번호가 일치하지 않습니다.');
        return false;
    }
    
}

</script>

<style scoped>
.regist {
    width:40%;
    margin-left: 30%;
    margin-right: 30%;
    display: grid;
}

.title {
    text-align: center;
    margin-top: 5%;
    font-size: 20px;
    
}

.pwdTitle {
    width: 98%;
    font-size: 12px;
}

.pwdBox {
    width: 98%;
    height: 30px;
}

.nameTitle {
    width: 98%;
    font-size: 12px;
}

.nameBox {
    width: 98%;
    height: 30px; 
}

.registdiv {
    width:100%;
    margin-top:20%;
    margin-bottom: 20%;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    justify-items: center;

}

.registBtn {
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

.pwdConfirm {
    width: 98%;
    font-size: 12px;
}

.emailTitle {
    width: 98%;
    font-size: 12px;
}

.certificationTitle {
    width: 98%;
    font-size: 12px;
}

.nicknameTitle {
    width: 98%;
    font-size: 12px;
}

.pwdConfirmBox {
    width: 98%;
    height: 30px;
}

.emailBox {
    width: 98%;
    height: 30px;
}

.certificationBox {
    width: 98%;
    height: 30px;
}

.nicknameBox {
    width: 98%;
    height: 30px;
}

.confirmdiv {
    width: 100%;
    display: grid;
    grid-template-columns: 4.5fr 0.5fr 1fr 0.2fr 1fr;
    justify-items: center;
}

.trans {
    width: 100%;
    grid-column-start: 3;
    grid-column-end: 4;
}

.transconfirm {
    width: 100%;
    grid-column-start: 5;
    grid-column-end: 6;
}


.confirm {
    width: 100%;
    grid-column-start: 3;
    grid-column-end: 6;
}
</style>