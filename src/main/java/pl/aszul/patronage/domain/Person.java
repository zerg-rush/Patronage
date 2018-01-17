package pl.aszul.patronage.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import pl.aszul.patronage.domain.enums.Gender;
import pl.aszul.patronage.domain.enums.IDNumberType;

import java.time.LocalDate;

/**
 This is a class for representing a person
 */
@Entity
public class Person {
    private static Integer idGenerator = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;

    @Version
    @ApiModelProperty(notes = "The auto-generated version of the person")
    private Integer version;

    @ApiModelProperty(notes = "surename of person")
    private String surname;

    @ApiModelProperty(notes = "name of person")
    private String name;

    @ApiModelProperty(notes = "gender identification")
    private Gender gender;

    @ApiModelProperty(notes = "birth date")
    private LocalDate birthDate;

    @ApiModelProperty(notes = "personal identification number value (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private String personalIDNumber;

    @ApiModelProperty(notes = "personal identification number type (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private IDNumberType personalIDNumberType;

    @ApiModelProperty(notes = "telephone number")
    private Long tel;

    @Email
    @ApiModelProperty(notes = "e-mail address")
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
