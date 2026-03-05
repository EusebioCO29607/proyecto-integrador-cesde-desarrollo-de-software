package co.cesde.edu.notapp.ga.models;

public class Programs {
  private long programId;
  private String name;
  private String code;

  public Programs() {

  }

  public long getProgramId() {
    return programId;
  }

  public void setProgramId(long programId) {
    this.programId = programId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Programs(long programId, String name, String code) {
    this.programId = programId;
    this.name = name;
    this.code = code;
  }

  @Override
  public String toString() {
    return "Programs{" +
        "programId '" + programId + '\'' +
        ", name= " + name +
        ", code= " + code +
        '}';
  }

}
