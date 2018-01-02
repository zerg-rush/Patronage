package pl.aszul.patronage1.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 This is a class for representing a vehicle
 */
public class Vehicle {
    private static Integer idGenerator = 0;

    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;

    @ApiModelProperty(notes = "rodzaj pojazdu")
    public String vehicleType;

    @ApiModelProperty(notes = "przeznaczenie pojazdu")
    public String vehiclePurpose;

    @ApiModelProperty(notes = "rok produkcji")
    public int manufacturingYear;

    @ApiModelProperty(notes = "dopuszczalna ladowność")
    public String maxLoadCapacity;

    @ApiModelProperty(notes = "największy dopuszczalny nacisk osi [N]")
    public int maxAxlePressure;

    @ApiModelProperty(notes = "numer karty pojazdu")
    public String vehicleCardNumber;

    @ApiModelProperty(notes = "seria dowodu rejestracyjnego")
    public String registrationCardSeries;

    @ApiModelProperty(notes = "organ wydający")
    public String registrationCardIssuedBy;

    @ApiModelProperty(notes = "A — numer rejestracyjny pojazdu")
    public String plateNumber;

    @ApiModelProperty(notes = "B — data pierwszej rejestracji pojazdu")
    public String firstRegistrationDate;

    @ApiModelProperty(notes = "C — dane dotyczące posiadacza dowodu rejestracyjnego i właściciela pojazdu obejmują wydruk następujących kodów i danych:")
    // C.1.1 — nazwisko lub nazwa posiadacza dowodu rejestracyjnego
    public String registrationCardOwnerName;

    @ApiModelProperty(notes = "C.1.2 — numer PESEL lub REGON")
    public String registrationCardOwnerIDNumber;

    @ApiModelProperty(notes = "C.1.3 — adres posiadacza dowodu rejestracyjnego")
    public String registrationCardOwnerAddress;

    @ApiModelProperty(notes = "C.2.1 — nazwisko lub nazwa właściciela pojazdu")
    public String vehicleOwnerName;

    @ApiModelProperty(notes = "C.2.2 — numer PESEL lub REGON")
    public String vehicleOwnerIDNumber;

    @ApiModelProperty(notes = "C.2.3 — adres właściciela pojazdu")
    public String vehicleOwnerAddress;

    @ApiModelProperty(notes = "D — dane dotyczące pojazdu obejmują wydruk następujących kodów i danych:")
    // D.1 — marka pojazdu
    public String brandName;

    @ApiModelProperty(notes = "D.2 — typ pojazdu:")
    public String modelName;

    @ApiModelProperty(notes = "D.3 — model pojazdu")
    public String shortModelName;

    @ApiModelProperty(notes = "E — numer identyfikacyjny pojazdu (numer VIN albo numer nadwozia, podwozia lub ramy)")
    public String vINNumber;

    @ApiModelProperty(notes = "F.1 — maksymalna masa całkowita pojazdu[b], wyłączając motocykle i motorowery [kg]")
    public int maxWeight;

    @ApiModelProperty(notes = "F.2 — dopuszczalna masa całkowita pojazdu [kg]")
    public int acceptableWeight;

    @ApiModelProperty(notes = "F.3 — dopuszczalna masa całkowita zespołu pojazdów [kg]")
    public int acceptableGroupWeight;

    @ApiModelProperty(notes = "G — masa własna pojazdu\n w przypadku pojazdu ciągnącego innego niż kategoria M1 masa własna pojazdu obejmuje urządzenie sprzęgające [kg]")
    public int weight;

    @ApiModelProperty(notes = "H — okres ważności dowodu, jeżeli występuje takie ograniczenie")
    public String registrationCardExpiryDate;

    @ApiModelProperty(notes = "I — data wydania dowodu rejestracyjnego")
    public String registrationCardIssueDate;

    @ApiModelProperty(notes = "J — kategoria pojazdu")
    public String vehicleCategory;

    @ApiModelProperty(notes = "K — numer świadectwa homologacji typu pojazdu, jeżeli występuje")
    public String homologationNumber;

    @ApiModelProperty(notes = "L — liczba osi")
    public String axleNumber;

    @ApiModelProperty(notes = "O.1 — maksymalna masa całkowita przyczepy z hamulcem [kg]")
    public String maxWeightWTrailerWBreaks;

    @ApiModelProperty(notes = "O.2 — maksymalna masa całkowita przyczepy bez hamulca [kg]")
    public String maxWeightWTrailerWOBreaks;

    @ApiModelProperty(notes = "P.1 — pojemność silnika [cm3]")
    public int engineCapacity;

    @ApiModelProperty(notes = "P.2 — maksymalna moc netto silnika [W]")
    public int enginePower;

    @ApiModelProperty(notes = "P.3 — rodzaj paliwa")
    public String fuelType;

    @ApiModelProperty(notes = "Q — stosunek mocy do masy własnej (dotyczy motocykli i motorowerów) [kW/kg]")
    public String powerToWeightRatio;

    @ApiModelProperty(notes = "S.1 — liczba miejsc siedzących, włączając siedzenie kierowcy")
    public int seats;

    @ApiModelProperty(notes = "S.2 — liczba miejsc stojących, jeżeli występuje")
    public int standingPlaces;

    public Vehicle(){
        this.id = idGenerator++;
    }
    
    public Vehicle(String vehicleType, String vehiclePurpose, int manufacturingYear, String maxLoadCapacity,
                   int maxAxlePressure, String vehicleCardNumber, String registrationCardSeries,
                   String registrationCardIssuedBy, String plateNumber, String firstRegistrationDate,
                   String registrationCardOwnerName, String registrationCardOwnerIDNumber,
                   String registrationCardOwnerAddress, String vehicleOwnerName, String vehicleOwnerIDNumber,
                   String vehicleOwnerAddress, String brandName, String modelName, String shortModelName,
                   String vINNumber, int maxWeight, int acceptableWeight, int acceptableGroupWeight, int weight,
                   String registrationCardExpiryDate, String registrationCardIssueDate, String vehicleCategory,
                   String homologationNumber, String axleNumber, String maxWeightWTrailerWBreaks,
                   String maxWeightWTrailerWOBreaks, int engineCapacity, int enginePower, String fuelType,
                   String powerToWeightRatio, int seats, int standingPlaces) {
        this.id = idGenerator++;
        this.vehicleType = vehicleType;
        this.vehiclePurpose = vehiclePurpose;
        this.manufacturingYear = manufacturingYear;
        this.maxLoadCapacity = maxLoadCapacity;
        this.maxAxlePressure = maxAxlePressure;
        this.vehicleCardNumber = vehicleCardNumber;
        this.registrationCardSeries = registrationCardSeries;
        this.registrationCardIssuedBy = registrationCardIssuedBy;
        this.plateNumber = plateNumber;
        this.firstRegistrationDate = firstRegistrationDate;
        this.registrationCardOwnerName = registrationCardOwnerName;
        this.registrationCardOwnerIDNumber = registrationCardOwnerIDNumber;
        this.registrationCardOwnerAddress = registrationCardOwnerAddress;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehicleOwnerIDNumber = vehicleOwnerIDNumber;
        this.vehicleOwnerAddress = vehicleOwnerAddress;
        this.brandName = brandName;
        this.modelName = modelName;
        this.shortModelName = shortModelName;
        this.vINNumber = vINNumber;
        this.maxWeight = maxWeight;
        this.acceptableWeight = acceptableWeight;
        this.acceptableGroupWeight = acceptableGroupWeight;
        this.weight = weight;
        this.registrationCardExpiryDate = registrationCardExpiryDate;
        this.registrationCardIssueDate = registrationCardIssueDate;
        this.vehicleCategory = vehicleCategory;
        this.homologationNumber = homologationNumber;
        this.axleNumber = axleNumber;
        this.maxWeightWTrailerWBreaks = maxWeightWTrailerWBreaks;
        this.maxWeightWTrailerWOBreaks = maxWeightWTrailerWOBreaks;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.powerToWeightRatio = powerToWeightRatio;
        this.seats = seats;
        this.standingPlaces = standingPlaces;
    }

    // additional simplified constructor with dummy data
    public Vehicle(int manufacturingYear,
                   String plateNumber, String firstRegistrationDate,
                   String brandName, String shortModelName,
                   String vINNumber,
                   String registrationCardIssueDate, int engineCapacity, int enginePower, String fuelType) {
        this("passenger car", "---", manufacturingYear, "---",
                10000, "AAA1234567", "DR/AAA 7654321",
                "PREZYDENT", plateNumber, firstRegistrationDate,
                "KOWALSKI JAN", "82091711022",
                "02-517 WARSZAWA, WALBRZYSKA 24/30", "KOWALSKA MARIA", "88030971022",
                "02-517 WARSZAWA, WALBRZYSKA 24/30", brandName, "DUMMY MODEL", shortModelName,
                vINNumber, 1100, 1200, 1300, 1000,
                "NO EXPIRE", registrationCardIssueDate, "M1",
                "HOM1234567890", "2", "1000",
                "450", engineCapacity, enginePower, fuelType,
                "---", 4, 0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePurpose() {
        return vehiclePurpose;
    }

    public void setVehiclePurpose(String vehiclePurpose) {
        this.vehiclePurpose = vehiclePurpose;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(String maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public int getMaxAxlePressure() {
        return maxAxlePressure;
    }

    public void setMaxAxlePressure(int maxAxlePressure) {
        this.maxAxlePressure = maxAxlePressure;
    }

    public String getVehicleCardNumber() {
        return vehicleCardNumber;
    }

    public void setVehicleCardNumber(String vehicleCardNumber) {
        this.vehicleCardNumber = vehicleCardNumber;
    }

    public String getRegistrationCardSeries() {
        return registrationCardSeries;
    }

    public void setRegistrationCardSeries(String registrationCardSeries) {
        this.registrationCardSeries = registrationCardSeries;
    }

    public String getRegistrationCardIssuedBy() {
        return registrationCardIssuedBy;
    }

    public void setRegistrationCardIssuedBy(String registrationCardIssuedBy) {
        this.registrationCardIssuedBy = registrationCardIssuedBy;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(String firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getRegistrationCardOwnerName() {
        return registrationCardOwnerName;
    }

    public void setRegistrationCardOwnerName(String registrationCardOwnerName) {
        this.registrationCardOwnerName = registrationCardOwnerName;
    }

    public String getRegistrationCardOwnerIDNumber() {
        return registrationCardOwnerIDNumber;
    }

    public void setRegistrationCardOwnerIDNumber(String registrationCardOwnerIDNumber) {
        this.registrationCardOwnerIDNumber = registrationCardOwnerIDNumber;
    }

    public String getRegistrationCardOwnerAddress() {
        return registrationCardOwnerAddress;
    }

    public void setRegistrationCardOwnerAddress(String registrationCardOwnerAddress) {
        this.registrationCardOwnerAddress = registrationCardOwnerAddress;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public String getVehicleOwnerIDNumber() {
        return vehicleOwnerIDNumber;
    }

    public void setVehicleOwnerIDNumber(String vehicleOwnerIDNumber) {
        this.vehicleOwnerIDNumber = vehicleOwnerIDNumber;
    }

    public String getVehicleOwnerAddress() {
        return vehicleOwnerAddress;
    }

    public void setVehicleOwnerAddress(String vehicleOwnerAddress) {
        this.vehicleOwnerAddress = vehicleOwnerAddress;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getShortModelName() {
        return shortModelName;
    }

    public void setShortModelName(String shortModelName) {
        this.shortModelName = shortModelName;
    }

    public String getVINNumber() {
        return vINNumber;
    }

    public void setVINNumber(String vINNumber) {
        this.vINNumber = vINNumber;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getAcceptableWeight() {
        return acceptableWeight;
    }

    public void setAcceptableWeight(int acceptableWeight) {
        this.acceptableWeight = acceptableWeight;
    }

    public int getAcceptableGroupWeight() {
        return acceptableGroupWeight;
    }

    public void setAcceptableGroupWeight(int acceptableGroupWeight) {
        this.acceptableGroupWeight = acceptableGroupWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRegistrationCardExpiryDate() {
        return registrationCardExpiryDate;
    }

    public void setRegistrationCardExpiryDate(String registrationCardExpiryDate) {
        this.registrationCardExpiryDate = registrationCardExpiryDate;
    }

    public String getRegistrationCardIssueDate() {
        return registrationCardIssueDate;
    }

    public void setRegistrationCardIssueDate(String registrationCardIssueDate) {
        this.registrationCardIssueDate = registrationCardIssueDate;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getHomologationNumber() {
        return homologationNumber;
    }

    public void setHomologationNumber(String homologationNumber) {
        this.homologationNumber = homologationNumber;
    }

    public String getAxleNumber() {
        return axleNumber;
    }

    public void setAxleNumber(String axleNumber) {
        this.axleNumber = axleNumber;
    }

    public String getMaxWeightWTrailerWBreaks() {
        return maxWeightWTrailerWBreaks;
    }

    public void setMaxWeightWTrailerWBreaks(String maxWeightWTrailerWBreaks) {
        this.maxWeightWTrailerWBreaks = maxWeightWTrailerWBreaks;
    }

    public String getMaxWeightWTrailerWOBreaks() {
        return maxWeightWTrailerWOBreaks;
    }

    public void setMaxWeightWTrailerWOBreaks(String maxWeightWTrailerWOBreaks) {
        this.maxWeightWTrailerWOBreaks = maxWeightWTrailerWOBreaks;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getPowerToWeightRatio() {
        return powerToWeightRatio;
    }

    public void setPowerToWeightRatio(String powerToWeightRatio) {
        this.powerToWeightRatio = powerToWeightRatio;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getStandingPlaces() {
        return standingPlaces;
    }

    public void setStandingPlaces(int standingPlaces) {
        this.standingPlaces = standingPlaces;
    }
}
