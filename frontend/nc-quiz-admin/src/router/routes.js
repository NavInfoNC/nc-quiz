
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: 'users/permissions', component: () => import('pages/permissions/UserPermission.vue') },
      { path: 'users/organizations', component: () => import('pages/organizations/UserOrganizations.vue') },
      { path: 'users/groups', component: () => import('pages/groups/UserGroups.vue') },
      { path: 'users/front-users', component: () => import('pages/front-users/FrontUsers.vue') }
    ]
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
