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
        },
        {
            path: '/findId',
            component: () => import('../views/FindIdPage.vue')
        },
        {
            path: '/findIdResult/:email',
            component: () => import('../views/FindIdResultPage.vue')
        },
        {
            path: '/resetPassword',
            component: () => import('../views/ResetPwdPage.vue')
        },
        {
            path: '/resetPasswordFinal/:email',
            component: () => import('../views/ResetPwdFinalPage.vue')
        }
    ]
})

export default router;