<template>
  <div>
  <img alt="Vue logo" src="./assets/GMUBuilding.jpg">
  <Student />
  </div>
</template>

<script>
import Student from './components/Student.vue';

export default {
  name: 'StudentApp',
  data() {
    return {
      students : []
    };
  },
  components: {
    Student
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
