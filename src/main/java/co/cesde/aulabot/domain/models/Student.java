package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "students")

public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;
  @Column (
      nullable = false,
      name = "first_name",
      length = 100
  )
  private String firstName;
  @Column (
      nullable = false,
      name = "last_name",
      length = 100
  )
  private String lastName;
  @Column (
      nullable = false,
      length = 20
  )
  private String code;
  @Column (
      name = "user_id"
  )
  private Long userId;
  @Column (
      name = "document_number",
      length = 20
  )
  private String documentNumber;
  @Column (
      name = "status",
      length = 20
  )
  private String status;
  @Column (
      name = "birth_date"
  )
  private String birthDate;
  @Column (
      name = "email",
      length = 50
  )
  private String email;

  public Student() {
  }

  public Student(Long studentId, Long userId, String code, String documentNumber, String firstName, String lastName, String birthDate, String status, String email) {
    this.studentId = studentId;
    this.userId = userId;
    this.code = code;
    this.documentNumber = documentNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.status = status;
    this.email = email;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  @Override
  public String toString() {
    return "Student{" +
        "studentId='" + studentId + '\'' +
        ", userId=" + userId +
        ", code=" + code +
        ", documentNumber=" + documentNumber +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", birthDate=" + birthDate +
        ", status=" + status +
        ", email=" + email +
        '}';
  }

}



