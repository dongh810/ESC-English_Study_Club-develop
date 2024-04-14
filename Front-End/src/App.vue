<script setup>
    import Header from "@/components/Header/Header.vue";
    import Footer from "@/components/Footer/Footer.vue";
    import { RouterLink, RouterView, useRouter } from 'vue-router';

    const router = useRouter();
</script>

<template>
    <div class="all">
        <Header></Header>

        <main class="wrapper">
            <RouterView />
        </main>

        <Footer></Footer>  
    </div>
</template>

<style scoped>
    .wrapper {
        width:75%;
        margin-left: 12.5%;
        margin-right: 12.5%;
        display: grid;
    }

    .all {
        display: grid;
        grid-template-rows: 100px minmax(780px, auto) 200px;
        align-items: center;
    }

</style>