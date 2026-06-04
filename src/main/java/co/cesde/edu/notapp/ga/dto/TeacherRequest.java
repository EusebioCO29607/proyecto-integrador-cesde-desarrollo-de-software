package co.cesde.edu.notapp.ga.dto;

public class TeacherRequest {
  private String code;
  private String documentNumber;
  private String firstName;
  private String lastName;
  private String status;

  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }

  public String getDocumentNumber() { return documentNumber; }
  public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
