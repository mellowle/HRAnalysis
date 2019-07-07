package Constants.ExperiencesConstants;

import org.apache.commons.lang3.StringUtils;

public enum RatingEnum {
    EXCEEDS_EXCEEDS("Exceeds / Exceeds", 4),
    EXCEEDS_FULLYMEETS("Exceeds / Fully Meets", 3.5),
    FULLYMEETS_EXCEEDS("Fully Meets / Exceeds", 3.5),
    FULLYMEETS_FULLYMEETS("Fully Meets / Fully Meets", 3),
    EXCEEDS_PARTIALLYMEETS("Exceeds / Partially Meets", 2.5),
    PARTIALLYMEETS_EXCEEDS("Partially Meets / Exceeds", 2.5),
    FULLYMEETS_PARTIALLYMEETS("Fully Meets / Partially Meets", -1),
    PARTIALLYMEETS_FULLYMEETS("Partially Meets / Fully Meets", -1),
    PARTIALLYMEETS_PARTIALLYMEETS("Partially Meets / Partially Meets", -2),
    INSUFFICIENT_DATA("Insufficient Data to Rate / Insufficient Data to Rate", 0);

    private String rating;
    private double score;

    RatingEnum(String rating, double score) {
        this.rating = rating;
        this.score = score;
    }

    public static double getRatingScore(String rating) {
        for (RatingEnum ratingE : RatingEnum.values()) {
            if (ratingE == null || StringUtils.isEmpty(rating)) {
                return 3;
            }
            if (rating.equals(ratingE.getRating())) {
                return ratingE.getScore();
            }
        }

        return 3;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
