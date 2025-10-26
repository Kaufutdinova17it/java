public class Name {
    private String surname;
    private String personalName;
    private String patronymic;

    public String getSurname() {
        return surname;
    }

    public String getPersonalName() {
        return personalName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Name(String surname, String personalName, String patronymic) {
        this.surname = surname;
        this.personalName = personalName;
        this.patronymic = patronymic;
    }

    public Name(String surname, String personalName) {
        this(surname, personalName, null);
    }

    public Name(String personalName) {
        this(null, personalName, null);
    }

    @Override
    public String toString() {
        String result = "";
        if (surname != null && !surname.isEmpty()) {
            result += surname;
        }
        if (personalName != null && !personalName.isEmpty()) {
            if (!result.isEmpty()) result += " ";
            result += personalName;
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            if (!result.isEmpty()) result += " ";
            result += patronymic;
        }
        return result;
    }
}