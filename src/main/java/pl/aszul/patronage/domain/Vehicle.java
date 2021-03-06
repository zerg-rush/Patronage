package pl.aszul.patronage.domain;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PastOrPresent;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import pl.aszul.patronage.domain.enums.FuelType;
import pl.aszul.patronage.domain.validation.ValidFirstRegistrationDate;
import pl.aszul.patronage.domain.validation.ValidRegistrationCardIssueDate;

/**
 This is a class for representing a vehicle
 */
@ValidFirstRegistrationDate
@ValidRegistrationCardIssueDate
@Entity
@XmlRootElement(name = "Vehicle")
public class Vehicle implements ObjectId{

    private static Integer idGenerator = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(notes = "The database generated vehicle ID", position = 1)
    private Integer id;

    @Version
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(notes = "The auto-generated version of the vehicle", position = 2)
    private Integer version = 1;

    @ApiModelProperty(notes = "type of vehicle",
            example = "SAMOCHÓD OSOBOWY",
            position = 3)
    private String vehicleType;

    @ApiModelProperty(notes = "purpose of vehicle",
            example = "---",
            position = 4)
    private String vehiclePurpose;

    @ApiModelProperty(notes = "manufacturing year",
            example = "2018",
            position = 5)
    private Integer manufacturingYear;

    @ApiModelProperty(notes = "maximum load capacity",
            example = "---",
            position = 6)
    private String maxLoadCapacity;

    @ApiModelProperty(notes = "maximum axle pressure [N]",
            example = "8882",
            position = 7)
    private Integer maxAxlePressure;

    @ApiModelProperty(notes = "number of vehicle card",
            example = "AAA0000000",
            position = 8)
    private String vehicleCardNumber;

    @ApiModelProperty(notes = "series of vehicle registration card",
            example = "DR/AAA0007046",
            position = 9)
    private String registrationCardSeries;

    @ApiModelProperty(notes = "authority issuing vehicle registration card",
            example = "PREZYDENT",
            position = 10)
    private String registrationCardIssuedBy;

    @NotNull(message = "The plate number can not be null")
    @Pattern(regexp = "^(?!(.).*\\1)[A-Z]{2}[0-9]{1,8}$",
            message = "The plate number must start with two different big letters and have up to eight digits!")
    @ApiModelProperty(notes = "A — vehicle plate number",
            allowableValues = "must start with two different big letters and have up to eight digits!",
            required = true,
            example = "ZS12345678",
            position = 11)
    private String plateNumber;

    @NotNull(message = "The first registration date can not be null!")
    @PastOrPresent(message = "The first registration date can not be from future!")
    @ApiModelProperty(notes = "B — vehicle first registration date",
            allowableValues = "from past, till today",
            required = true,
            example = "2015-12-31",
            position = 12)
    private LocalDate firstRegistrationDate;

    @ApiModelProperty(notes = "C.1.1 — surname or name of vehicle registration card owner",
            example = "KOWALSKI JAN",
            position = 13)
    private String registrationCardOwnerName;

    @ApiModelProperty(notes = "C.1.2 — personal identification number of vehicle registration card owner (PESEL or REGON)",
            position = 14)
    private String registrationCardOwnerIDNumber;

    @ApiModelProperty(notes = "C.1.3 — address of vehicle registration card owner",
            position = 15)
    private String registrationCardOwnerAddress;

    @ApiModelProperty(notes = "C.2.1 — surname or name of vehicle owner",
            example = "KOWALSKA MARIA",
            position = 16)
    private String vehicleOwnerName;

    @ApiModelProperty(notes = "C.2.2 — personal identification number of vehicle owner (PESEL or REGON)",
            position = 17)
    private String vehicleOwnerIDNumber;

    @ApiModelProperty(notes = "C.2.3 — address of vehicle owner",
            position = 18)
    private String vehicleOwnerAddress;

    @NotNull(message = "The car brand name can not be null")
    @Pattern(regexp="HONDA|FIAT|SKODA", flags = { Pattern.Flag.CASE_INSENSITIVE },
            message = "Sorry, we buy and sell only cars manufactured by Honda, Fiat and Skoda")
    @ApiModelProperty(notes = "D.1 — vehicle brand name",
            allowableValues = "Honda, Fiat, Skoda",
            required = true,
            position = 19)
    private String brandName;

    @ApiModelProperty(notes = "D.2 — full model name of vehicle",
            position = 20)
    private String modelName;

    @ApiModelProperty(notes = "D.3 — short model name of vehicle",
            position = 21)
    private String shortModelName;

    @ApiModelProperty(notes = "E — Vehicle Identification Number",
            example = "1B7HF13YXYJ105403",
            position = 22)
    private String vINNumber;

    @ApiModelProperty(notes = "F.1 — maximum weight of vehicle (excluding motorcycles and motorbikes ) [kg]",
            position = 23)
    private Integer maxWeight;

    @ApiModelProperty(notes = "F.2 — acceptable total weight of vehicle [kg]",
            position = 24)
    private Integer acceptableWeight;

    @ApiModelProperty(notes = "F.3 — acceptable total weight of vehicle group [kg]",
            position = 25)
    private Integer acceptableGroupWeight;

    @ApiModelProperty(notes = "G — vehicle own weight [kg]",
            position = 26)
    private Integer weight;

    @ApiModelProperty(notes = "H — vehicle registration card expiry date (if applicable)",
            example = "2020-12-31",
            position = 27)
    private LocalDate registrationCardExpiryDate;

    @NotNull(message = "The registration card issue date can not be null")
    @PastOrPresent(message = "The registration card issue date can not be from future")
    @ApiModelProperty(notes = "I — vehicle registration card issue date",
            allowableValues = "The registration card issue date must some date from past or at most today!",
            required = true,
            example = "2000-12-31",
            position = 28)
    private LocalDate registrationCardIssueDate;

    @ApiModelProperty(notes = "J — vehicle category",
            position = 29)
    private String vehicleCategory;

    @ApiModelProperty(notes = "K — vehicle homologation number (if applicable)",
            position = 30)
    private String homologationNumber;

    @ApiModelProperty(notes = "L — number of vehicle axles",
            position = 31)
    private Integer axleNumber;

    @ApiModelProperty(notes = "O.1 — maximum total weight with trailer with brakes [kg]",
            position = 32)
    private String maxWeightWTrailerWBreaks;

    @ApiModelProperty(notes = "O.2 — maximum total weight with trailer without brakes [kg]",
            position = 33)
    private String maxWeightWTrailerWOBreaks;

    @NotNull(message = "The engine capacity can not be null")
    @Range(min = 50, max = 6999, message = "The engine capacity must be bigger than {min} and less than {max} [cm3]")
    @ApiModelProperty(notes = "P.1 — vehicle engine capacity [cm3]",
            allowableValues = "range[50, 6999]",
            required = true,
            position = 34)
    private Integer engineCapacity;

    @ApiModelProperty(notes = "P.2 — maximum engine power [W]",
            example = "200000",
            position = 35)
    private Integer enginePower;

    @ApiModelProperty(notes = "P.3 — fuel type",
            example = "DIESEL",
            position = 36)
    private FuelType fuelType;

    @ApiModelProperty(notes = "Q — vehicle power to weight ratio (excluding motorcycles and motorbikes) [kW/kg]",
            position = 37)
    private String powerToWeightRatio;

    @Range(min = 1, max = 6, message = "Vehicle must have at least {min} and at most {max} seats!")
    @ApiModelProperty(notes = "S.1 — vehicle number of seats (including drivers seat )",
            allowableValues = "range[1, 6]",
            position = 38)
    private Integer seats;

    @ApiModelProperty(notes = "S.2 — vehicle number of standing places (if applicable )",
            position = 39)
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
                "450", engineCapacity, enginePower, fuelType,
                "---", 4, 0);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }*/

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

    @XmlElement(name = "plateNumber")
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