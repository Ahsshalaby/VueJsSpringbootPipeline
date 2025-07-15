package summer2025.projects.ualmonte_survey_page.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Surveys")
public class SurveyRecord {
    // Required inputs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public String getLikes() {
	return likes;
    }

    public void setLikes(String likes) {
	this.likes = likes;
    }

    public String getInterest() {
	return interest;
    }

    public void setInterest(String interest) {
	this.interest = interest;
    }

    public String getRecommending() {
	return recommending;
    }

    public void setRecommending(String recommending) {
	this.recommending = recommending;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "street", nullable = false)
    private String streetAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_survey", nullable = false)
    private Date dateOfSurvey;

    @Column(name = "likes")
    private String likes;

    @Column(name = "interest")
    private String interest;

    @Column(name = "recommending")
    private String recommending;

    public SurveyRecord() {
    }

    public SurveyRecord(Long id, String firstName, String lastName, String streetAddress, String city, String state,
	    String zipcode, String telephone, String email, Date dateOfSurvey) {
	Id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.streetAddress = streetAddress;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
	this.telephone = telephone;
	this.email = email;
	this.dateOfSurvey = dateOfSurvey;
    }

    public Long getId() {
	return Id;
    }

    public void setId(Long id) {
	Id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getStreetAddress() {
	return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZipcode() {
	return zipcode;
    }

    public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
    }

    public String getTelephone() {
	return telephone;
    }

    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Date getDateOfSurvey() {
	return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
	this.dateOfSurvey = dateOfSurvey;
    }
}
