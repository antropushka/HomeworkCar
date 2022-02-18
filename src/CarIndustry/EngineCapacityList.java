package CarIndustry;

public enum EngineCapacityList {
    V1_6 (1.6),
    V1_8 (1.8),
    V2_0 (2.0),
    V2_4 (2.4),
    V3_0 (3.0),
    V4_0 (4.0),
    V4_6 (4.6),
    V5_0 (5.0),
    ;
    private final double engineCapacity;

    EngineCapacityList(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
}
