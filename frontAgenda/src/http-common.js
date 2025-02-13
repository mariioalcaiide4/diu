import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:8090/api/v1",
  headers: {
    "Content-type": "application/json"
  }
});

export default http;