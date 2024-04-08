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
        }
    ]
})

export default router;