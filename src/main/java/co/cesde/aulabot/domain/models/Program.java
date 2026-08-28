package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "programs")

public class Program {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long programId;
  @Column (
          nullable = false,
          length = 100
  )
  private String name;
  @Column (
          nullable = false,
          length = 20
  )
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
