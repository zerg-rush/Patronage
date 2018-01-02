package pl.aszul.patronage1.domain;

import io.swagger.annotations.ApiModelProperty;

public class Person {
    private static Integer idGenerator = 0;

    private Integer id;

    @ApiModelProperty(notes = "surename of person")
    private String surname;

    @ApiModelProperty(notes = "name of person")
    private String name;

    @ApiModelProperty(notes = "gender identification")
    private String sex;

    @ApiModelProperty(notes = "birth date")
    private String birthDate;

    @ApiModelProperty(notes = "personal identification number value (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private String personalIDNumber;

    @ApiModelProperty(notes = "personal identification number type (PESEL, NIP, REGON, ID card number, passport number etc.)")
    private String personalIDNumberType;

    @ApiModelProperty(notes = "telephone number")
    private String tel;

    @ApiModelProperty(notes = "e-mail address")
    private String email;

    public Person(){
        this.id = idGenerator++;
    }

    public Person(String surname, String name, String sex, String birthDate, String personalIDNumber, String personalIDNumberType, String tel, String email) {
        this.id = idGenerator++;
        this.surname = surname;
        this.name = name;
        this.sex = sex;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalIDNumber() {
        return personalIDNumber;
    }

    public void setPersonalIDNumber(String personalIDNumber) {
        this.personalIDNumber = personalIDNumber;
    }

    public String getPersonalIDNumberType() {
        return personalIDNumberType;
    }

    public void setPersonalIDNumberType(String personalIDNumberType) {
        this.personalIDNumberType = personalIDNumberType;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
