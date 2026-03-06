package co.cesde.edu.notapp.ga.models;

public class Students {

    private long studentId;
    private long userId;
    private String code;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String birthDate;
    private boolean status;

    public Students() {

    }

    public Students(long studentId, long userId, String code, String documentNumber, String firstName, String lastName, String birthDate, boolean status) {
        this.studentId = studentId;
        this.userId = userId;
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.status = status;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId='" + studentId + '\'' +
                ", userId=" + userId +
                ", code=" + code +
                ", documentNumber=" + documentNumber +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", birthDate=" + birthDate +
                ", status=" + status +
                '}';
    }

}