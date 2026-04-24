package co.cesde.edu.notapp.ga.models;

public class Program {
  private Long programId;
  private String name;
  private String code;

  public Program() {

  }

  public Long getProgramId() {
    return programId;
  }

  public void setProgramId(Long programId) {
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

  public Program(Long programId, String name, String code) {
    this.programId = programId;
    this.name = name;
    this.code = code;
  }

  @Override
  public String toString() {
    return "Program{" +
        "programId '" + programId + '\'' +
        ", name= " + name +
        ", code= " + code +
        '}';
  }

}
