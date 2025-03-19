import http from "../http-common";

class TutorialService {
  // Obtener todos los tutoriales
  getAll() {
    return http.get("/tutorials");
  }

  // Obtener un tutorial por su ID
  get(id) {
    return http.get(`/tutorials/${id}`);
  }

  // Obtener varios tutoriales por sus IDs (útil para contactos con múltiples tutoriales)
  getByIds(ids) {
    return http.get(`/tutorials`, {
      params: { ids: ids.join(",") } // Enviar los IDs como query params
    });
  }

  // Crear un nuevo tutorial
  create(data) {
    return http.post("/tutorials", data);
  }

  // Actualizar un tutorial existente
  update(id, data) {
    return http.put(`/tutorials/${id}`, data);
  }

  // Eliminar un tutorial por su ID
  delete(id) {
    return http.delete(`/tutorials/${id}`);
  }

  // Eliminar todos los tutoriales
  deleteAll() {
    return http.delete(`/tutorials`);
  }

  // Buscar tutoriales por título
  findByTitle(title) {
    return http.get(`/tutorials/title/${title}`);
  }
}

export default new TutorialService();
