package pl.aszul.patronage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import pl.aszul.patronage.domain.enums.Gender;
import pl.aszul.patronage.domain.enums.IDNumberType;

/**
 This is a class for representing a Person
 */
@Entity
@XmlRootElement
public class Person implements ObjectId{

    private static Integer idGenerator = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(notes = "The automatically generated person ID (to be used for all requests)")
    private Integer id;

    @Version
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(notes = "The auto-generated version of the person record (stores number of updates)")
    private Integer version = 1;

    @ApiModelProperty(notes = "Name of person", position = 1)
    private String name;

    @ApiModelProperty(notes = "Surname of person", position = 2)
    private String surname;

    @ApiModelProperty(notes = "Gender identification of person", position = 3)
    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Birth date of person", required = true, position = 1, example = "2000-01-01", dataType = "")
    private LocalDate birthDate;

    @ApiModelProperty(notes = "Personal identification number value (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private String personalIDNumber;

    @ApiModelProperty(notes = "Personal identification number type (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private IDNumberType personalIDNumberType;

    @ApiModelProperty(notes = "Telephone number of person")
    private Long tel;

    @Email
    @ApiModelProperty(notes = "E-mail address of person")
    private String email;

    public Person(){
        this.id = idGenerator++;
    }

    public Person(String surname, String name, Gender gender, LocalDate birthDate, String personalIDNumber, IDNumberType personalIDNumberType, Long tel, String email) {
        this.id = idGenerator++;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.personalIDNumber = personalIDNumber;
        this.personalIDNumberType = personalIDNumberType;
        this.tel = tel;
        this.email = email;
    }

    @Override
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalIDNumber() {
        return personalIDNumber;
    }

    public void setPersonalIDNumber(String personalIDNumber) {
        this.personalIDNumber = personalIDNumber;
    }

    public IDNumberType getPersonalIDNumberType() {
        return personalIDNumberType;
    }

    public void setPersonalIDNumberType(IDNumberType personalIDNumberType) {
        this.personalIDNumberType = personalIDNumberType;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
