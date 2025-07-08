import axios from "axios"
export function getAreaList() {
  return axios.get("http://localhost:8080/api/areas/selectPage")
}

export function getCommunityList() {
  return axios.get("http://localhost:8080/api/communities/selectPage")
}