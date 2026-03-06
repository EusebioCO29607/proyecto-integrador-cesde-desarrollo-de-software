package co.edu.cesde.ga.models;

public class Grades {


    private String gradeId;
    private String groupSubjectId;
    private String studentId;
    private double finalScore;
    private String observation;

    public Grades(String gradeId, String groupSubjectId, String studentId, double finalScore, String observation) {
        this.gradeId = gradeId;
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(String groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }
    @Override
    public String toString() {
        return "Grades{" +
                "gradeId='" + gradeId + '\'' +
                ", groupSubjectId='" + groupSubjectId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", finalScore=" + finalScore +
                ", observation='" + observation + '\'' +
                '}';
    }
}