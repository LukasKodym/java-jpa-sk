package pl.lukas.jpa.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String apartment;
    private String postalCode;
    private String city;

    public Address() {
    }

    public Address(String street, String apartment, String postalCode, String city) {
        this.street = street;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
    }


}
