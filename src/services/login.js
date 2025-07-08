import axios from "axios"
export function getAdminsInfo() {
  return axios.post("http://localhost:3000/data")
  
}
