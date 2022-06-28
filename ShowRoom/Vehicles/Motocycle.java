package Vehicles;

public class Motocycle extends Vehicle {
    private Boolean isLimitedEdition;
    private Boolean isForRacing;

    public Motocycle(String name, String brand, Double price, Integer year, Boolean isLimitedEdition, Boolean isForRacing) {
        super(name, brand, price, year);
        this.isLimitedEdition = isLimitedEdition;
        this.isForRacing = isForRacing;
    }

    public Boolean getLimitedEdition() {
        return isLimitedEdition;
    }

    public void setLimitedEdition(Boolean limitedEdition) {
        isLimitedEdition = limitedEdition;
    }

    public Boolean getForRacing() {
        return isForRacing;
    }

    public void setForRacing(Boolean forRacing) {
        isForRacing = forRacing;
    }
}
