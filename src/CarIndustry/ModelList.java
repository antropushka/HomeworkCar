package CarIndustry;

public enum ModelList {
    BMWX1("BMWX"),
    BMWXX2("BMWXX2"),
    BMWXX3("BMWXX3"),
    BMWXX4("BMWXX4"),
    BMWXX5("BMWXX5"),
    BMWXX6("BMWXX6"),
    BMWXX7("BMWXX7"),
    BMWXGRANCOPE("BMWX Gran Coupe"),
    ;
    private final String model;

    ModelList(String model) {
        this.model = model;

    }

    public String getModel() {
        return model;
    }
}
