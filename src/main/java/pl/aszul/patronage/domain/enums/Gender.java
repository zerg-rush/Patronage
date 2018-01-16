package pl.aszul.patronage.domain.enums;

public enum Gender {
    MALE ("M"),
    FEMALE ("F"),
    TRANSMALE ("TM"),
    TRANSFEMALE ("TF"),
    ALIEN ("A");
    /* some 'future proof' types ;) */

    final String genderShort;

    Gender(String genderShort) {
        this.genderShort = genderShort;
    }

    public static Gender identifyGender(String inputString){
        for (Gender gender : Gender.values()) {
            if (inputString.equals(gender.genderShort)) return gender;
        }
        return null;
    }

    public static String listGenders() {
        String genders = "";
        for (Gender gender : Gender.values()) {
            genders += gender.genderShort + " -> " + gender + ", ";
        }
        return genders.substring(0, genders.length() - 2);
    }
}