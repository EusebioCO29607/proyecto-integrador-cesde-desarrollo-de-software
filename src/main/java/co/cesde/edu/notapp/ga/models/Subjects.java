package co.cesde.edu.notapp.ga.models;

public class Subjects {

  private long subjectId;
  private String code;
  private String name;
  private int credits;
  private long programId;

  public Subjects() {

  }

  public long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(long subjectId) {
    this.subjectId = subjectId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public long getProgramId() {
    return programId;
  }

  public void setProgramId(long programId) {
    this.programId = programId;
  }

  public Subjects(long subjectId, String code, int credits, String name, long programId) {
    this.subjectId = subjectId;
    this.code = code;
    this.credits = credits;
    this.name = name;
    this.programId = programId;
  }

  @Override
  public String toString() {
    return "Subjects{" +
        "SubjectId= '" + subjectId + '\'' +
        ", code= " + code +
        ", credits= " + credits +
        ", name= " + name +
        ", programId= " + programId +
        '}';
  }

}
