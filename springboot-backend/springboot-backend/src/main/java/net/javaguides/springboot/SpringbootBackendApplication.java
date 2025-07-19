package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.StudentRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = Student.builder()
				.fname("John")
				.lname("Doe")
				.address("123 Main St")
				.phone("123-456-7890")
				.city("Springfield")
				.state("IL")
				.zip("62701")
				.date(System.currentTimeMillis())
				.email("email@gmail.com")
				.likedMost("Friends")
				.howInterested("Social Media")
				.howRecommend("Very Likely")
				.build();
		studentRepository.save(student1);

		Student student2 = Student.builder()
				.fname("Jane")
				.lname("Butler")
				.address("456 Elm St")
				.phone("987-654-3210")
				.city("Shelbyville")
				.state("IL")
				.zip("62565")
				.date(System.currentTimeMillis())
				.email("email2@gmail.com")
				.likedMost("Campus")
				.howInterested("Newsletters")
				.howRecommend("Unlikely")
				.build();
		studentRepository.save(student2);

		Student student3 = Student.builder()
				.fname("Alice")
				.lname("Smith")
				.address("789 Oak St")
				.phone("555-123-4567")
				.city("Capital City")
				.state("IL")
				.zip("62702")
				.date(System.currentTimeMillis())
				.email("email3@gmail.com")
				.likedMost("Classes")
				.howInterested("Word of Mouth")
				.howRecommend("Likely")
				.build();
		studentRepository.save(student3);
}
}
