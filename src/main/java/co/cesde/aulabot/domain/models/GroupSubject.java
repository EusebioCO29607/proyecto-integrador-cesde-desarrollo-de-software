package co.cesde.aulabot.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "group_subjects")
public class GroupSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "group_subject_id")
  private Long groupSubjectId;

  @Column(name = "group_id", nullable = false)
  private Long groupId;

  @Column(name = "subject_id", nullable = false)
  private Long subjectId;

  @Column(name = "teacher_id", nullable = false)
  private Long teacherId;

  public GroupSubject() {

  }

  public Long getGroupSubjectId() {
    return groupSubjectId;
  }

  public void setGroupSubjectId(Long groupSubjectId) {
    this.groupSubjectId = groupSubjectId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Long subjectId) {
    this.subjectId = subjectId;
  }

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
  }

  public GroupSubject(Long groupSubjectId, Long groupId, Long subjectId, Long teacherId) {
    this.groupSubjectId = groupSubjectId;
    this.groupId = groupId;
    this.subjectId = subjectId;
    this.teacherId = teacherId;
  }

  @Override
  public String toString() {
    return "GroupSubject{" +
        "groupSubjectId= '" + groupSubjectId + '\'' +
        ", groupId= " + groupId +
        ", subjectId= " + subjectId +
        ", teacherId= " + teacherId +
        '}';
  }

}