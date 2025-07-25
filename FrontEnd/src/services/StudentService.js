import axios from 'axios';

const BASE_URL = "http://54.208.88.112:30010/surveyapi/";

class StudentService {
  getStudents() {
    return axios.get(`${BASE_URL}/getSurveyRecords`);
  }

  createStudent(student) {
    return axios.post(`${BASE_URL}/submitSurveyRecord`, student);
  }

  updateStudent(id, student) {
    return axios.put(`${BASE_URL}/updateSurveyRecord/${id}`, student);
  }

  deleteStudent(id) {
    return axios.delete(`${BASE_URL}/removeSurveyRecord/${id}`);
  }

  getStudentById(id) {
    return axios.get(`${BASE_URL}/getSurveyRecord/${id}`);
  }
}

export default new StudentService();
