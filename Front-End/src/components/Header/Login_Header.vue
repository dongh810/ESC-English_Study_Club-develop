<template>
    <header class="header">
        <div class="logo">
            <img src="../../assets/finalLogo.png" class="logoimage">
        </div>
        <div class="menu">
            <span>소개</span>
            <span>모집</span>
            <span>스터디클럽</span>
            <span>마이페이지</span>
        </div>
        <div class="loginbtndiv">
            <button type="button" class="logoutBtn" onclick="">logout</button>
            <button type="button" class="myPageBtn" onclick="">my page</button>
        </div>
    </header>
</template>

<script setup>
    

</script>

<style scoped>
     * {
		margin: 0;
		padding: 0;
        font-family: 'GmarketSansMedium';
	}

    .header {
        width: 100%;
        height: 100px;
        position: relative;
        top: 0;
        background-color: white;
        display: grid;
        grid-template-columns: 1fr 2fr 1fr;
        justify-items: center;
    }

    .loginbtndiv {
        width:100%;
        text-align: end;
    }

    .logoutBtn {
        background-color: #515050;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 12px;
        font-style: bold;
        margin-top:53px;
        margin-right: 2%;
    }

    .myPageBtn {
        background-color: #515050;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 12px;
        font-style: bold;
        margin-top:53px;    
        margin-right: 2%;
    }

    .logoimage {
        width:100%;
        object-fit: contain;
    }

    .logo {
        width:120px;
        cursor: pointer;
        margin-top: 1%;
        margin-left: 2%;
        justify-self: start;
    }

    .menu {
        text-align: center;
        margin-top:65px;
        font-weight: bold;
        margin-right:2%;
        width: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        justify-items: center;
        
    }
    .menu span{
        margin-left: 3%;
        cursor: pointer;
    }

        
</style>