<template>
    <div class="wrapper">
        <div class="login">
            <div class="title">
                <h1>English Study Club</h1>
            </div>
            <div class="idTitle">
                <h2>아이디</h2>
                <input type="text" class="idBox" placeholder="아이디를 입력하세요" v-model="id">
            </div>
            <div class="pwdTitle">
                <h2>비밀번호</h2>
                <input type="password" class="pwdBox" placeholder="비밀번호를 입력하세요" v-model="pwd">
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