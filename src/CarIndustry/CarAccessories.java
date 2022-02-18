package CarIndustry;

public enum CarAccessories {

    CLIMATE_CONTROL ("климат контроль"),
    LEATHER_SEATS ("кожаные сиденья"),
    HEATED_SEATS ("подогрев сидений"),
    SUNROOF ("люк"),
    PARK_ASSIST_PACKAGE ("пакет помощи в парковке"),
    NAVIGATION_SYSTEM ("система навигации"),
    BLUETOOTH ("Bluetooth"),
    ACCENT_STRIPES ("акцентные полосы"),
    ROOF_RACK ("багажник на крыше"),
    ;
    private final String additionalAccessories;

    CarAccessories (String additionalAccessories) {
        this.additionalAccessories = additionalAccessories;
    }

    public String getAdditionalAccessories() {
        return additionalAccessories;
    }
}
