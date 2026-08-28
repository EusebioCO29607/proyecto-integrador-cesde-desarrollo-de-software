package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "periods")

public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long periodId;
    @Column (
            nullable = false,
            length = 20
    )
    private String code;
    @Column (
            name = "start_date"
    )
    private String startDate;
    @Column (
            name = "end_date"
    )
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