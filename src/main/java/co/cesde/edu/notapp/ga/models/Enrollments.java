package co.cesde.edu.notapp.ga.models;

public class Enrollments {
  private long enrollmentId;
  private long studentId;
  private long groupId;
  private long periodId;
  private boolean status;
  private String enrolledAt;

  public Enrollments() {}

  public long getEnrollmentId() {
    return enrollmentId;
  }

  public void setEnrollmentId(long enrollmentId) {
    this.enrollmentId = enrollmentId;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }

  public long getPeriodId() {
    return periodId;
  }

  public void setPeriodId(long periodId) {
    this.periodId = periodId;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getEnrolledAt() {
    return enrolledAt;
  }

  public void setEnrolledAt(String enrolledAt) {
    this.enrolledAt = enrolledAt;
  }

  public Enrollments(long enrollmentId, long studentId, long groupId, long periodId, boolean status, String enrolledAt) {
    this.enrollmentId = enrollmentId;
    this.studentId = studentId;
    this.groupId = groupId;
    this.periodId = periodId;
    this.status = status;
    this.enrolledAt = enrolledAt;
  }

  @Override
  public String toString() {
    return "Enrollments{" +
        "enrollmentId= '" + enrollmentId + '\'' +
        ", studentId= " + studentId +
        ", groupId= " + groupId +
        ", periodId= " + periodId +
        ", status= " + status +
        ", enrolledAt= " + enrolledAt +
        '}';
  }

}
