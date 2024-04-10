<template>
    <div>
        <div class="regist">
            <div class="title">
                <h1>English Study Club</h1>
            </div>
            <div class="idTitle">
                <h2>아이디</h2>
                <div class="confirmdiv">
                    <input type="text" class="idBox" placeholder="아이디를 입력하세요" v-model.trim="email">
                    <button class="confirm" @click="">확인</button>
                </div>
                
            </div>
            <div class="pwdTitle">
                <h2>비밀번호</h2>
                <input type="password" class="pwdBox" placeholder="비밀번호를 입력하세요" v-model.trim="password">
            </div>
            <div class="pwdConfirm">
                <h2>비밀번호 확인</h2>
                <input type="password" class="pwdConfirmBox" placeholder="비밀번호를 확인하세요" v-model.trim="passwordConfirm">
            </div>
            <div class="emailTitle">
                <h2>이메일</h2>
                <div class="confirmdiv">
                    <input type="text" class="emailBox" placeholder="이메일을 입력하세요" v-model.trim="email">
                    <button class="confirm" @click="">확인</button>
                </div> 
            </div>
            <div class="certificationTitle">
                <h2>인증번호</h2>
                <div class="confirmdiv">
                    <input type="text" class="certificationBox" placeholder="인증번호를 입력하세요" v-model.trim="certification">
                    <button class="confirm" @click="">확인</button>
                </div>
            </div>
            <div class="nicknameTitle">
                <h2>닉네임</h2>
                <input type="text" class="nicknameBox" placeholder="닉네임을 입력하세요" v-model.trim="nickname">
            </div>
            <div class="registdiv">
                <button type="button" class="registBtn" @click.prevent="[inputCheck(), tokenData()]">가입하기</button>
            </div>
        </div>
    </div>
</template>

<script setup>

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

.idTitle{
    width: 98%;
    margin-top: 10%;
    font-size: 12px;
}

.idBox {
    width: 98%;
    height: 30px;
}

.pwdTitle {
    width: 98%;
    font-size: 12px;
}

.pwdBox {
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
    grid-template-columns: 4.5fr 0.5fr 1fr;
    justify-items: center;
}

.confirm {
    width: 100%;
    grid-column-start: 3;
    grid-column-end: 4;
}
</style>