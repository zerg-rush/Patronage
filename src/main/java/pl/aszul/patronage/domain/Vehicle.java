package pl.aszul.patronage.domain;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.*;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import pl.aszul.patronage.domain.enums.FuelType;
import pl.aszul.patronage.domain.validation.ValidFirstRegistrationDate;
import pl.aszul.patronage.domain.validation.ValidPlateNumber;
import pl.aszul.patronage.domain.validation.ValidRegistrationCardIssueDate;

/**
 This is a class for representing a vehicle
 */
@ValidPlateNumber
@ValidFirstRegistrationDate
@ValidRegistrationCardIssueDate
@Entity
public class Vehicle {
    private static Integer idGenerator = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated vehicle ID")
    private Integer id;

    @Version
    @ApiModelProperty(notes = "The auto-generated version of the vehicle")
    private Integer version;

    @ApiModelProperty(notes = "rodzaj pojazdu")
    private String vehicleType;

    @ApiModelProperty(notes = "przeznaczenie pojazdu")
    private String vehiclePurpose;

    @ApiModelProperty(notes = "rok produkcji")
    private Integer manufacturingYear;

    @ApiModelProperty(notes = "dopuszczalna ladowność")
    private String maxLoadCapacity;

    @ApiModelProperty(notes = "największy dopuszczalny nacisk osi [N]")
    private Integer maxAxlePressure;

    @ApiModelProperty(notes = "numer karty pojazdu")
    private String vehicleCardNumber;

    @ApiModelProperty(notes = "seria dowodu rejestracyjnego")
    private String registrationCardSeries;

    @ApiModelProperty(notes = "organ wydający")
    private String registrationCardIssuedBy;

    @NotNull(message = "The plate number can not be null")
    @Size(max = 10, message = "The plate number must be up to the 10 characters!")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{1,8}$", message = "The plate number must start with two letters and have up to eight digits!")
    @ApiModelProperty(notes = "A — numer rejestracyjny pojazdu")
    private String plateNumber;

    @NotNull(message = "The first registration date can not be null!")
    @PastOrPresent(message = "The first registration date can not be from future!")
    @ApiModelProperty(notes = "B — data pierwszej rejestracji pojazdu")
    private LocalDate firstRegistrationDate;

    @ApiModelProperty(notes = "C — dane dotyczące posiadacza dowodu rejestracyjnego i właściciela pojazdu obejmują wydruk następujących kodów i danych:")
    // C.1.1 — nazwisko lub nazwa posiadacza dowodu rejestracyjnego
    private String registrationCardOwnerName;

    @ApiModelProperty(notes = "C.1.2 — numer PESEL lub REGON")
    private String registrationCardOwnerIDNumber;

    @ApiModelProperty(notes = "C.1.3 — adres posiadacza dowodu rejestracyjnego")
    private String registrationCardOwnerAddress;

    @ApiModelProperty(notes = "C.2.1 — nazwisko lub nazwa właściciela pojazdu")
    private String vehicleOwnerName;

    @ApiModelProperty(notes = "C.2.2 — numer PESEL lub REGON")
    private String vehicleOwnerIDNumber;

    @ApiModelProperty(notes = "C.2.3 — adres właściciela pojazdu")
    private String vehicleOwnerAddress;

    @NotNull(message = "The car brand name can not be null")
    @Pattern(regexp="HONDA|FIAT|SKODA", flags = { Pattern.Flag.CASE_INSENSITIVE }, message = "Sorry, we buy and sell only cars manufactured by Honda, Fiat and Skoda")
    @ApiModelProperty(notes = "D — dane dotyczące pojazdu obejmują wydruk następujących kodów i danych: \n D.1 — marka pojazdu")
    private String brandName;

    @ApiModelProperty(notes = "D.2 — typ pojazdu:")
    private String modelName;

    @ApiModelProperty(notes = "D.3 — model pojazdu")
    private String shortModelName;

    @ApiModelProperty(notes = "E — numer identyfikacyjny pojazdu (numer VIN albo numer nadwozia, podwozia lub ramy)")
    private String vINNumber;

    @ApiModelProperty(notes = "F.1 — maksymalna masa całkowita pojazdu[b], wyłączając motocykle i motorowery [kg]")
    private Integer maxWeight;

    @ApiModelProperty(notes = "F.2 — dopuszczalna masa całkowita pojazdu [kg]")
    private Integer acceptableWeight;

    @ApiModelProperty(notes = "F.3 — dopuszczalna masa całkowita zespołu pojazdów [kg]")
    private Integer acceptableGroupWeight;

    @ApiModelProperty(notes = "G — masa własna pojazdu\n w przypadku pojazdu ciągnącego innego niż kategoria M1 masa własna pojazdu obejmuje urządzenie sprzęgające [kg]")
    private Integer weight;

    @ApiModelProperty(notes = "H — okres ważności dowodu, jeżeli występuje takie ograniczenie")
    private LocalDate registrationCardExpiryDate;

    @NotNull(message = "The registration card issue date can not be null")
    @PastOrPresent(message = "The registration card issue date can not be from future")
    @ApiModelProperty(notes = "I — data wydania dowodu rejestracyjnego")
    private LocalDate registrationCardIssueDate;

    @ApiModelProperty(notes = "J — kategoria pojazdu")
    private String vehicleCategory;

    @ApiModelProperty(notes = "K — numer świadectwa homologacji typu pojazdu, jeżeli występuje")
    private String homologationNumber;

    @ApiModelProperty(notes = "L — liczba osi")
    private Integer axleNumber;

    @ApiModelProperty(notes = "O.1 — maksymalna masa całkowita przyczepy z hamulcem [kg]")
    private String maxWeightWTrailerWBreaks;

    @ApiModelProperty(notes = "O.2 — maksymalna masa całkowita przyczepy bez hamulca [kg]")
    private String maxWeightWTrailerWOBreaks;

    @NotNull(message = "The engine capacity can not be null")
    @Range(min = 50, max = 6999, message = "The engine capacity must be bigger than ${min} and less than ${max} [cm3]")
    @ApiModelProperty(notes = "P.1 — pojemność silnika [cm3]")
    private Integer engineCapacity;

    @ApiModelProperty(notes = "P.2 — maksymalna moc netto silnika [W]")
    private Integer enginePower;

    @ApiModelProperty(notes = "P.3 — rodzaj paliwa")
    private FuelType fuelType;

    @ApiModelProperty(notes = "Q — stosunek mocy do masy własnej (dotyczy motocykli i motorowerów) [kW/kg]")
    private String powerToWeightRatio;

    @Range(min = 1, max = 6, message = "Car must have more than ${min} and less than ${max} seats!")
    @ApiModelProperty(notes = "S.1 — liczba miejsc siedzących, włączając siedzenie kierowcy")
    private Integer seats;

    @ApiModelProperty(notes = "S.2 — liczba miejsc stojących, jeżeli występuje")
    private Integer standingPlaces;

    public Vehicle(){
        this.id = idGenerator++;
    }
    
    public Vehicle(String vehicleType, String vehiclePurpose, Integer manufacturingYear, String maxLoadCapacity,
                   int maxAxlePressure, String vehicleCardNumber, String registrationCardSeries,
                   String registrationCardIssuedBy, String plateNumber, LocalDate firstRegistrationDate,
                   String registrationCardOwnerName, String registrationCardOwnerIDNumber,
                   String registrationCardOwnerAddress, String vehicleOwnerName, String vehicleOwnerIDNumber,
                   String vehicleOwnerAddress, String brandName, String modelName, String shortModelName,
                   String vINNumber, Integer maxWeight, Integer acceptableWeight, Integer acceptableGroupWeight, Integer weight,
                   LocalDate registrationCardExpiryDate, LocalDate registrationCardIssueDate, String vehicleCategory,
                   String homologationNumber, Integer axleNumber, String maxWeightWTrailerWBreaks,
                   String maxWeightWTrailerWOBreaks, Integer engineCapacity, Integer enginePower, FuelType fuelType,
                   String powerToWeightRatio, Integer seats, Integer standingPlaces) {
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
    public Vehicle(Integer manufacturingYear,
                   String plateNumber, LocalDate firstRegistrationDate,
                   String brandName, String shortModelName,
                   String vINNumber,
                   LocalDate registrationCardIssueDate, Integer engineCapacity, Integer enginePower, FuelType fuelType) {
        this("passenger car", "---", manufacturingYear, "---",
                10000, "AAA1234567", "DR/AAA 7654321",
                "PREZYDENT", plateNumber, firstRegistrationDate,
                "KOWALSKI JAN", "82091711022",
                "02-517 WARSZAWA, WALBRZYSKA 24/30", "KOWALSKA MARIA", "88030971022",
                "02-517 WARSZAWA, WALBRZYSKA 24/30", brandName, "DUMMY MODEL", shortModelName,
                vINNumber, 1100, 1200, 1300, 1000,
                LocalDate.parse("2019-01-01"), registrationCardIssueDate, "M1",
                "HOM1234567890", 2, "1000",
                "450", engineCapacity, enginePower, FuelType.DIESEL,
                "---", 4, 0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(String maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public Integer getMaxAxlePressure() {
        return maxAxlePressure;
    }

    public void setMaxAxlePressure(Integer maxAxlePressure) {
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

    public LocalDate getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(LocalDate firstRegistrationDate) {
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

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getAcceptableWeight() {
        return acceptableWeight;
    }

    public void setAcceptableWeight(Integer acceptableWeight) {
        this.acceptableWeight = acceptableWeight;
    }

    public Integer getAcceptableGroupWeight() {
        return acceptableGroupWeight;
    }

    public void setAcceptableGroupWeight(Integer acceptableGroupWeight) {
        this.acceptableGroupWeight = acceptableGroupWeight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public LocalDate getRegistrationCardExpiryDate() {
        return registrationCardExpiryDate;
    }

    public void setRegistrationCardExpiryDate(LocalDate registrationCardExpiryDate) {
        this.registrationCardExpiryDate = registrationCardExpiryDate;
    }

    public LocalDate getRegistrationCardIssueDate() {
        return registrationCardIssueDate;
    }

    public void setRegistrationCardIssueDate(LocalDate registrationCardIssueDate) {
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

    public Integer getAxleNumber() {
        return axleNumber;
    }

    public void setAxleNumber(Integer axleNumber) {
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

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getPowerToWeightRatio() {
        return powerToWeightRatio;
    }

    public void setPowerToWeightRatio(String powerToWeightRatio) {
        this.powerToWeightRatio = powerToWeightRatio;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getStandingPlaces() {
        return standingPlaces;
    }

    public void setStandingPlaces(Integer standingPlaces) {
        this.standingPlaces = standingPlaces;
    }
}