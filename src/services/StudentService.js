import axios from 'axios'

const STUDENT_API_BASE_URL = "http://localhost:8080/api/students";

class StudentService {
    getStudents() {
        return axios.get(STUDENT_API_BASE_URL);
    }

    createStudent(student) {
        return axios.post(STUDENT_API_BASE_URL, student);
    }


    updateStudent(id, student) {
        return axios.put(STUDENT_API_BASE_URL + '/' + id, student);
    }

    deleteStudent(email) {
        return axios.delete(STUDENT_API_BASE_URL + '/' + email);
    }
}
export default new StudentService();