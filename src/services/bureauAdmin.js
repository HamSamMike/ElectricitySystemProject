import axios from "axios"
export function getmonthlyInfo(data) {
  return axios.post("http://localhost:8080/api/Consumeincome/generate",data)
}
