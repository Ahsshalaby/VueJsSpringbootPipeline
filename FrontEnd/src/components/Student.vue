


<template>

  <div class="container">
    <StudentForm @survey-submitted="getStudents" />

    <h1 class="text-center">Student List</h1>
 

    <table class="table table-striped">
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Address</th>
          <th>Phone</th>
          <th>City</th>
          <th>State</th>
          <th>Zip</th>
          <th>Date</th>
          <th>Email</th>
          <th>Liked Most</th>
          <th>Interest</th>
          <th>Recommend</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in Surveys" :key="student.email">
          <td>{{ student.firstName }}</td>
          <td>{{ student.lastName }}</td>
          <td>{{ student.streetAddress }}</td>
          <td>{{ student.telephone }}</td>
          <td>{{ student.city }}</td>
          <td>{{ student.state }}</td>
          <td>{{ student.zipcode }}</td>
          <td>{{ student.dateOfSurvey }}</td>
          <td>{{ student.email }}</td>
          <td>{{ student.likes }}</td>
          <td>{{ student.interest }}</td>
          <td>{{ student.recommending }}</td>
          <td>
            <button class="btn btn-warning btn-sm" @click="updateStudent(student)">Update</button>
            <button class="btn btn-danger btn-sm" @click="deleteStudent(student.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
    
  </div>
</template>

<script>
import StudentForm from './StudentForm.vue';
import StudentService from '@/services/StudentService';

export default {
  
  name: "StudentTable",
  components: { StudentForm },
  data() {
    return {
      Surveys: [],
      selectedStudent: null
    };
  },
  methods: {
    getStudents() {
      StudentService.getStudents()
        .then(response => {
          this.Surveys = response.data;
        })
        .catch(error => {
          console.error("There was an error fetching the students!", error);
        });
    },
    formatDate(timestamp) {
      const date = new Date(timestamp);
      return date.toLocaleDateString();
    },
    selectStudent(student) {
      this.selectedStudent = student;
    },
    

    
async updateStudent(student) {
  const newfname = prompt("First name:", student.firstName);
  const newlname = prompt("Last name:", student.lastName);
  const newEmail = prompt("Email:", student.email);
  const newAddress = prompt("Address:", student.streetAddress);
  const newPhone = prompt("Phone:", student.telephone);
  const newCity = prompt("City:", student.city);
  const newState = prompt("State:", student.state);
  const newZip = prompt("Zip:", student.zipcode);
  const newDate = Date.now(); 
  const newLikedMost = prompt("What did you like most?", student.likes);
  const newHowInterested = prompt("How interested are you?", student.interest);
  const newHowRecommend = prompt("Would you recommend?", student.recommending);

  const updatedStudent = {
    ...student,
    firstName: newfname,
    lastName: newlname,
    email: newEmail,
    streetAddress: newAddress,
    telephone: newPhone,
    city: newCity,
    state: newState,
    zipcode: newZip,
    dateOfSurvey: newDate,
    likes: newLikedMost,
    interest: newHowInterested,
    recommending: newHowRecommend
  };

  console.log("Sending this student to backend:", updatedStudent);

  try {
    await StudentService.updateStudent(student.id, updatedStudent);
    this.getStudents(); 
  } catch (err) {
    console.error("Update failed:", err);
  }
},
    async deleteStudent(email) {
    try {
      await StudentService.deleteStudent(email);
      this.students = this.students.filter(student => student.email !== email);
    } catch (error) {
      console.error("Error deleting student:", error);
    }
    this.getStudents();
  }
  },
  created() {
    this.getStudents();
  }
};
</script>