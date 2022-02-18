package CarIndustry;

public enum ColorList {
    BLUE("синий"),
    RED("красный"),
    GREEN("зеленый"),
    ORANGE("оранжевый"),
    BLACK("черный"),
    PURPLE("фиолетовый"),
    YELLOW("желтый"),
    GREY("серый"),
    WHITE("белый"),
    ;
    private final String color;

    ColorList (String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
