package pl.aszul.patronage.domain.enums;

public enum FuelType {
    DIESEL ("D"),
    GASOLINE ("G"),
    LPG ("LPG"),
    LNG ("LNG"),
    HYBRID ("HB"),
    ELECTRIC ("E"),
    HYDROGEN ("HG"),
    OTHER ("O");

    final String engineTypeShort;

    FuelType(String engineTypeShort) {
        this.engineTypeShort = engineTypeShort;
    }

    public static FuelType identifyEngineType(String inputString){
        for (FuelType fuelType : FuelType.values()) {
            if (inputString.equals(fuelType.engineTypeShort)) return fuelType;
        }
        return null;
    }

    public static String listTypes() {
        String engineTypes = "";
        for (FuelType fuelType : FuelType.values()) {
            engineTypes += fuelType.engineTypeShort + " -> " + fuelType + ", ";
        }
        return engineTypes.substring(0, engineTypes.length() - 2);
    }
}
