package co.cesde.aulabot.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enrollments")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "enrollment_id")
  private Long enrollmentId;

  @Column(name = "student_id", nullable = false)
  private Long studentId;

  @Column(name = "group_id", nullable = false)
  private Long groupId;

  @Column(name = "period_id", nullable = false)
  private Long periodId;

  @Column(name = "status", length = 20)
  private String status;

  @Column(name = "enrolled_at")
  private String enrolledAt;

  public Enrollment() {}

  public Long getEnrollmentId() {
    return enrollmentId;
  }

  public void setEnrollmentId(Long enrollmentId) {
    this.enrollmentId = enrollmentId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Long getPeriodId() {
    return periodId;
  }

  public void setPeriodId(Long periodId) {
    this.periodId = periodId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getEnrolledAt() {
    return enrolledAt;
  }

  public void setEnrolledAt(String enrolledAt) {
    this.enrolledAt = enrolledAt;
  }

  public Enrollment(Long enrollmentId, Long studentId, Long groupId, Long periodId, String status, String enrolledAt) {
    this.enrollmentId = enrollmentId;
    this.studentId = studentId;
    this.groupId = groupId;
    this.periodId = periodId;
    this.status = status;
    this.enrolledAt = enrolledAt;
  }

  @Override
  public String toString() {
    return "Enrollment{" +
        "enrollmentId= '" + enrollmentId + '\'' +
        ", studentId= " + studentId +
        ", groupId= " + groupId +
        ", periodId= " + periodId +
        ", status= " + status +
        ", enrolledAt= " + enrolledAt +
        '}';
  }

}