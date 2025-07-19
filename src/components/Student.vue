<template>
  <div class="container">
    <h1 class="text-center">Student List</h1>
    <!-- Show each student as a button -->

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
        <tr v-for="student in students" :key="student.email">
          <td>{{ student.fname }}</td>
          <td>{{ student.lname }}</td>
          <td>{{ student.address }}</td>
          <td>{{ student.phone }}</td>
          <td>{{ student.city }}</td>
          <td>{{ student.state }}</td>
          <td>{{ student.zip }}</td>
          <td>{{ formatDate(student.date) }}</td>
          <td>{{ student.email }}</td>
          <td>{{ student.likedMost }}</td>
          <td>{{ student.howInterested }}</td>
          <td>{{ student.howRecommend }}</td>
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
import StudentService from '@/services/StudentService';

export default {
  name: "StudentTable",
  data() {
    return {
      students: [],
      selectedStudent: null
    };
  },
  methods: {
    getStudents() {
      StudentService.getStudents()
        .then(response => {
          this.students = response.data;
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
  const newfname = prompt("First name:", student.fname);
  const newlname = prompt("Last name:", student.lname);
  const newEmail = prompt("Email:", student.email);
  const newAddress = prompt("Address:", student.address);
  const newPhone = prompt("Phone:", student.phone);
  const newCity = prompt("City:", student.city);
  const newState = prompt("State:", student.state);
  const newZip = prompt("Zip:", student.zip);
  const newDate = Date.now(); // optional — or prompt for date manually
  const newLikedMost = prompt("What did you like most?", student.likedMost);
  const newHowInterested = prompt("How interested are you?", student.howInterested);
  const newHowRecommend = prompt("Would you recommend?", student.howRecommend);

  const updatedStudent = {
    ...student,
    fname: newfname,
    lname: newlname,
    email: newEmail,
    address: newAddress,
    phone: newPhone,
    city: newCity,
    state: newState,
    zip: newZip,
    date: newDate,
    likedMost: newLikedMost,
    howInterested: newHowInterested,
    howRecommend: newHowRecommend
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