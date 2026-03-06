package co.cesde.edu.notapp.ga.models;

public class Teachers {

  private long teacherId;
  private String firstName;
  private String lastName;
  private String code;
  private long userId;
  private String documentNumber;
  private boolean status;

  public long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(long teacherId) {
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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Teachers(long teacherId, String firstName, String code, String lastName, long userId, String documentNumber, boolean status) {
    this.teacherId = teacherId;
    this.firstName = firstName;
    this.code = code;
    this.lastName = lastName;
    this.userId = userId;
    this.documentNumber = documentNumber;
    this.status = status;
  }

  public Teachers() {
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
