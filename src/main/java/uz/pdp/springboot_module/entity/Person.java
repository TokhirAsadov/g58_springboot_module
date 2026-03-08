package uz.pdp.springboot_module.entity;

public class Person {
    private String id;
    private String name;
    private String age;

    private String personAddressRegion;
    private String personAddressCity;
    private String personAddressStreet;

    private String personPassportSeria;
    private String personPassportNumber;

    public Person() {
    }

    public Person(String id, String name, String age, String personAddressRegion, String personAddressCity, String personAddressStreet, String personPassportSeria, String personPassportNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.personAddressRegion = personAddressRegion;
        this.personAddressCity = personAddressCity;
        this.personAddressStreet = personAddressStreet;
        this.personPassportSeria = personPassportSeria;
        this.personPassportNumber = personPassportNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPersonAddressRegion() {
        return personAddressRegion;
    }

    public void setPersonAddressRegion(String personAddressRegion) {
        this.personAddressRegion = personAddressRegion;
    }

    public String getPersonAddressCity() {
        return personAddressCity;
    }

    public void setPersonAddressCity(String personAddressCity) {
        this.personAddressCity = personAddressCity;
    }

    public String getPersonAddressStreet() {
        return personAddressStreet;
    }

    public void setPersonAddressStreet(String personAddressStreet) {
        this.personAddressStreet = personAddressStreet;
    }

    public String getPersonPassportSeria() {
        return personPassportSeria;
    }

    public void setPersonPassportSeria(String personPassportSeria) {
        this.personPassportSeria = personPassportSeria;
    }

    public String getPersonPassportNumber() {
        return personPassportNumber;
    }

    public void setPersonPassportNumber(String personPassportNumber) {
        this.personPassportNumber = personPassportNumber;
    }
}
