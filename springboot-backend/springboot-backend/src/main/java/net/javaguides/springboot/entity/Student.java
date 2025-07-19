package net.javaguides.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String fname;

    @Column(name = "last_name", nullable = false)
    private String lname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip", nullable = false)         
    private String zip;

    @Column(name = "date", nullable = false)
    private long date;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "liked_most", nullable = true)
    private String likedMost;

    @Column(name = "how_interested", nullable = true)
    private String howInterested;

    @Column(name = "how_recommend", nullable = true)
    private String howRecommend;


}
