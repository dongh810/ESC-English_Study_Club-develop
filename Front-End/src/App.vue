<script setup>
    import Header from "@/components/Header/Logout_Header.vue";
    import Footer from "@/components/Footer/Footer.vue";

    import { ref } from 'vue';
    import { RouterLink, RouterView, useRouter } from 'vue-router';

    const router = useRouter();
</script>

<template>
        <Header></Header>

        <main>
            <RouterView />
        </main>

        <Footer></Footer>  
</template>

<style scoped>

</style>