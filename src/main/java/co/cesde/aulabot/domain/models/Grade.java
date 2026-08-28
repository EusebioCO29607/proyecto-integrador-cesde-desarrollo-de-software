package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "grades")

public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long gradeId;
  @Column (
          name = "group_subject_id"
  )
  private Long groupSubjectId;
  @Column (
          name = "student_id"
  )
  private Long studentId;
  @Column (
          name = "final_score"
  )
  private Double finalScore;
  @Column (
          name = "observation"
  )
  private String observation;

  public Grade() {
  }

  public Long getGradeId() {
    return gradeId;
  }

  public void setGradeId(Long gradeId) {
    this.gradeId = gradeId;
  }

  public Long getGroupSubjectId() {
    return groupSubjectId;
  }

  public void setGroupSubjectId(Long groupSubjectId) {
    this.groupSubjectId = groupSubjectId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Double getFinalScore() {
    return finalScore;
  }

  public void setFinalScore(Double finalScore) {
    this.finalScore = finalScore;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Grade(Long gradeId, Long groupSubjectId, Long studentId, Double finalScore, String observation) {
    this.gradeId = gradeId;
    this.groupSubjectId = groupSubjectId;
    this.studentId = studentId;
    this.finalScore = finalScore;
    this.observation = observation;
  }

  @Override
  public String toString() {
    return "Grade{" +
            "gradeId= '" + gradeId + '\'' +
            ", groupSubjectId= " + groupSubjectId +
            ", studentId= " + studentId +
            ", finalScore= " + finalScore +
            ", observation= " + observation +
            '}';
  }

}