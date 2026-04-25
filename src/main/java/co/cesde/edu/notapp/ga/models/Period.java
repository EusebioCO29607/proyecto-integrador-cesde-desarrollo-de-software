package co.cesde.edu.notapp.ga.models;

public class Period {
    private Long periodId;
    private String code;
    private String startDate;
    private String endDate;

    public Period() {
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Period(Long periodId, String code, String startDate, String endDate) {
        this.periodId = periodId;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Period{" +
                "periodId= '" + periodId + '\'' +
                ", code= " + code +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                '}';
    }

}