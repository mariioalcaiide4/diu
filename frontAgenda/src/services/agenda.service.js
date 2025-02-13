import http from "../http-common";

class AgendaDataService {
  getAll() {
    return http.get("/agenda");
  }

  get(id) {
    return http.get(`/agenda/${dni}`);
  }

  create(data) {
    return http.post("/agenda", data);
  }

  update(dni, data) {
    return http.put(`/agenda/${dni}`, data);
  }

  delete(dni) {
    return http.delete(`/agenda/${dni}`);
  }

  deleteAll() {
    return http.delete(`/agenda`);
  }

 // findByTitle(title) {
 //   return http.get(`/tutorials?title=${title}`);
 // }
 findByNombre(nombre) {
     return http.get(`/agenda/nombre/${nombre}`);
   }
}

export default new AgendaDataService();