package entity;

import java.sql.Date;

public class PerformanceRating {
    private String wwid;
    private String review_period_start_date;
    private String review_period_end_date;
    private String results_rating;
    private String leadership_rating;
    private String overall_rating;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getReview_period_start_date() {
        return review_period_start_date;
    }

    public void setReview_period_start_date(String review_period_start_date) {
        this.review_period_start_date = review_period_start_date;
    }

    public String getReview_period_end_date() {
        return review_period_end_date;
    }

    public void setReview_period_end_date(String review_period_end_date) {
        this.review_period_end_date = review_period_end_date;
    }

    public String getResults_rating() {
        return results_rating;
    }

    public void setResults_rating(String results_rating) {
        this.results_rating = results_rating;
    }

    public String getLeadership_rating() {
        return leadership_rating;
    }

    public void setLeadership_rating(String leadership_rating) {
        this.leadership_rating = leadership_rating;
    }

    public String getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(String overall_rating) {
        this.overall_rating = overall_rating;
    }
}
