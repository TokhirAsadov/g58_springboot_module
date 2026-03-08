package uz.pdp.springboot_module.payload;

public class AddressDTO {
    private String region;
    private String city;
    private String street;

    public AddressDTO() {
    }

    public AddressDTO(String region, String city, String street) {
        this.region = region;
        this.city = city;
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
