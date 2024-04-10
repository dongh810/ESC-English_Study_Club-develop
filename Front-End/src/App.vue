<script setup>
    import Header from "@/components/Header/Logout_Header.vue";
    import Footer from "@/components/Footer/Footer.vue";

    import { ref } from 'vue';
    import { RouterLink, RouterView, useRouter } from 'vue-router';

    const router = useRouter();
</script>

<template>
        <Header></Header>

        <main class="wrapper">
            <RouterView />
        </main>

        <Footer></Footer>  
</template>

<style scoped>
    .wrapper {
        width:75%;
        margin-left: 12.5%;
        margin-right: 12.5%;
        display: grid;
    }

</style>