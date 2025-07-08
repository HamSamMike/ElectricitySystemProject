import axios from "axios"
export function getAdminCommunityInfo() {
  return axios.get("http://localhost:8080/api/admins/selectPage")
}
export function addAdminInfo(data) {
  return axios.post("http://localhost:8080/api/admins/add", data)
}
export function deleteAdminInfo(data) {
  return axios.delete("http://localhost:8080/api/admins/deleteById", data)
}
export function changeAdminInfo(data) {
  return axios.put("http://localhost:8080/api/admins/update", data)
}
export function getApproveInfo() {
  return axios.get("http://localhost:8080")
}
export function getMonthsInfo(data) {
  return axios.post("http://localhost:8080", data)
}
export function headAdminApproveApplication(data) {
  return axios.post("http://localhost:8080", data)
}
export function headAdminRejectApplication(data) {
  return axios.post("http://localhost:8080", data)
}