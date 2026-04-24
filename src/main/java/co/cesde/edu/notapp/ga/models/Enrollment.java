package co.cesde.edu.notapp.ga.models;

public class Enrollment {
  private Long enrollmentId;
  private Long studentId;
  private Long groupId;
  private Long periodId;
  private String status;
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

  public void setStudentId(long studentId) {
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
