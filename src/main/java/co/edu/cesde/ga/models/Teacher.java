package co.edu.cesde.ga.models;

public class Teacher {
    private String teacherId;
    private String userId;
    private String code;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Teacher(String teacherId, String userId, String documentNumber, String code, String firstName, String lastName, String status) {
        this.teacherId = teacherId;
        this.userId = userId;
        this.documentNumber = documentNumber;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }
}
