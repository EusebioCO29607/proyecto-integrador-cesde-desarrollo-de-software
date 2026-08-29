package co.cesde.aulabot.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subject_id")
  private Long subjectId;

  @Column(name = "code", length = 20, nullable = false)
  private String code;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "credits")
  private Integer credits;

  @Column(name = "program_id")
  private Long programId;

  public Subject() {

  }

  public Long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Long subjectId) {
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

  public Integer getCredits() {
    return credits;
  }

  public void setCredits(Integer credits) {
    this.credits = credits;
  }

  public Long getProgramId() {
    return programId;
  }

  public void setProgramId(Long programId) {
    this.programId = programId;
  }

  public Subject(Long subjectId, String code, Integer credits, String name, Long programId) {
    this.subjectId = subjectId;
    this.code = code;
    this.credits = credits;
    this.name = name;
    this.programId = programId;
  }

  @Override
  public String toString() {
    return "Subject{" +
        "SubjectId= '" + subjectId + '\'' +
        ", code= " + code +
        ", credits= " + credits +
        ", name= " + name +
        ", programId= " + programId +
        '}';
  }

}