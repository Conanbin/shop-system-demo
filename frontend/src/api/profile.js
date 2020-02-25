import request from '@/utils/request'

export function getInfo(id) {
  return request({
    url: '/profile/info/id/' + id,
    method: 'get'
  })
}


export function updateInfo(data) {
  return request({
    url: '/profile/info',
    method: 'post',
    data: data
  })
}

export function updatePassword(data) {
  return request({
    url: '/profile/info/passwordd',
    method: 'post',
    data: data
  })
}
export function updateIcon(data) {
  return request({
    url: '/profile/info/icon',
    method: 'post',
    data: data
  })
}
