<template>
  <div class="container mt-4">
    <h2>Submit a New Survey(THIS IS AN EDIT TO TEST THE PIPELINE)</h2>
    <form @submit.prevent="submitSurvey">
      <div class="form-group">
        <label>First Name</label>
        <input v-model="survey.firstName" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Last Name</label>
        <input v-model="survey.lastName" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Street Address</label>
        <input v-model="survey.streetAddress" class="form-control" required />
      </div>
      <div class="form-group">
        <label>City</label>
        <input v-model="survey.city" class="form-control" required />
      </div>
      <div class="form-group">
        <label>State</label>
        <input v-model="survey.state" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Zipcode</label>
        <input v-model="survey.zipcode" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Phone</label>
        <input v-model="survey.telephone" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Email</label>
        <input v-model="survey.email" class="form-control" required />
      </div>
      <div class="form-group">
        <label>Likes</label>
        <input v-model="survey.likes" class="form-control" />
      </div>
      <div class="form-group">
        <label>Interest</label>
        <input v-model="survey.interest" class="form-control" />
      </div>
      <div class="form-group">
        <label>Would You Recommend?</label>
        <input v-model="survey.recommending" class="form-control" />
      </div>
      <button type="submit" class="btn btn-success mt-2">Submit Survey</button>
    </form>
  </div>
</template>

<script>
import StudentService from '@/services/StudentService';

export default {
  name: "StudentForm",
  data() {
    return {
      survey: {
        firstName: '',
        lastName: '',
        streetAddress: '',
        city: '',
        state: '',
        zipcode: '',
        telephone: '',
        email: '',
        likes: '',
        interest: '',
        recommending: '',
        dateOfSurvey: Date.now()
      }
    };
  },
  methods: {
    async submitSurvey() {
      try {
        console.log("Submitting survey:", this.survey);
        await StudentService.createStudent(this.survey);
        alert("Survey submitted successfully!");
        this.$emit("survey-submitted"); // Optional: to notify parent to refresh table
        this.resetForm();
      } catch (error) {
        console.error("Error submitting survey:", error);
        alert("There was an error submitting the survey.");
      }
    },
    resetForm() {
      this.survey = {
        firstName: '',
        lastName: '',
        streetAddress: '',
        city: '',
        state: '',
        zipcode: '',
        telephone: '',
        email: '',
        likes: '',
        interest: '',
        recommending: '',
        dateOfSurvey: Date.now()
      };
    }
    
  }

};

</script>
