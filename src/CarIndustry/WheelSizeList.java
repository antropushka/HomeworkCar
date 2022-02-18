package CarIndustry;

public enum WheelSizeList {

    WHEEL_7_5Jx17ET52("7.5Jx17 ET52"),
    WHEEL_8Jx19ET47("8Jx19 ET47"),
    WHEEL_8_5Jx20ET35("8.5Jx20 ET35"),
    WHEEL_9_5Jx21ET36("8.5Jx20 ET35"),
    WHEEL_10_5Jx22ET43(" 8.5Jx20 ET35"),
    ;
    private String wheelSize;

    WheelSizeList(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getWheelSize() {
        return wheelSize;
    }
}
