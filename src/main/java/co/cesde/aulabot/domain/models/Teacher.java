package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "teachers")

public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long teacherId;
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

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String  status) {
    this.status = status;
  }

  public Teacher(Long teacherId, String firstName, String code, String lastName, Long userId, String documentNumber, String status) {
    this.teacherId = teacherId;
    this.firstName = firstName;
    this.code = code;
    this.lastName = lastName;
    this.userId = userId;
    this.documentNumber = documentNumber;
    this.status = status;
  }

  public Teacher() {
  }

  @Override
  public String toString() {
    return "Teachers{" +
            "teacherId= '" + teacherId + '\'' +
            ", userId= " + userId +
            ", code= " + code +
            ", documentNumber= " + documentNumber +
            ", firstName= " + firstName +
            ", lastName= " + lastName +
            ", status= " + status +
            '}';
  }

}