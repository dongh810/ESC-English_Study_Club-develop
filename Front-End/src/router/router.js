import {createRouter, createWebHistory} from 'vue-router';


const router = createRouter({

    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: () => import('../views/MainLogout.vue')
        },
        {
            path: '/login',
            component: () => import('../views/LoginPage.vue')
        },
        {
            path: '/after/login',
            component: () => import('../views/MainLogin.vue')
        },
        {
            path: '/regist',
            component: () => import('../views/Regist.vue')
        }
    ]
})

export default router;