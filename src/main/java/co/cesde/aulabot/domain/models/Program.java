package co.cesde.aulabot.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "program_id")
  private Long programId;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "code", length = 20, nullable = false)
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