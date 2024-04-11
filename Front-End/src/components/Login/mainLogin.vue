<template>
    <div>
        <p>로그인 성공!</p>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const token = ref(localStorage.getItem('token'));
console.log(token.value);


</script>

<style scoped>

</style>