package entity.excelEntity.fixed;

public class ExperiencesAverageAttributes {
    private double bonusIncrement20162017;
    private double bonusIncrement20172018;
    private double baseIncrement20172018;
    private double baseIncrement20182019;
    private double externalLengthOfService;

    public double getBonusIncrement20162017() {
        return bonusIncrement20162017;
    }

    public void setBonusIncrement20162017(double bonusIncrement20162017) {
        this.bonusIncrement20162017 = bonusIncrement20162017;
    }

    public double getBonusIncrement20172018() {
        return bonusIncrement20172018;
    }

    public void setBonusIncrement20172018(double bonusIncrement20172018) {
        this.bonusIncrement20172018 = bonusIncrement20172018;
    }

    public double getBaseIncrement20172018() {
        return baseIncrement20172018;
    }

    public void setBaseIncrement20172018(double baseIncrement20172018) {
        this.baseIncrement20172018 = baseIncrement20172018;
    }

    public double getBaseIncrement20182019() {
        return baseIncrement20182019;
    }

    public void setBaseIncrement20182019(double baseIncrement20182019) {
        this.baseIncrement20182019 = baseIncrement20182019;
    }

    public double getExternalLengthOfService() {
        return externalLengthOfService;
    }

    public void setExternalLengthOfService(double externalLengthOfService) {
        this.externalLengthOfService = externalLengthOfService;
    }

    @Override
    public String toString() {
        return "ExperiencesAverageAttributes{" +
                "bonusIncrement20162017=" + bonusIncrement20162017 +
                ", bonusIncrement20172018=" + bonusIncrement20172018 +
                ", baseIncrement20172018=" + baseIncrement20172018 +
                ", baseIncrement20182019=" + baseIncrement20182019 +
                ", externalLengthOfService=" + externalLengthOfService +
                '}';
    }
}
