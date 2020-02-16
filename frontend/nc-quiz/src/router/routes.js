
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: 'search', component: () => import('pages/search/Search.vue') },
      { path: 'exam', component: () => import('pages/exam/ExamInfo.vue') }
    ]
  }, {
    path: '/question',
    component: () => import('layouts/QuestionLayout.vue'),
    children: [
      { path: '001', component: () => import('pages/question/Question.vue') }
    ]
  }, {
    path: '/login',
    component: () => import('pages/login/Login.vue')
  }
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
