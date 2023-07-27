package dsk.altlombard.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable {
    private String city;
    private String street;
    private String timeWorking;

    public Address(String city, String street, String timeWorking) {
        this.city = city;
        this.street = street;
        this.timeWorking = timeWorking;
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

    public String getTimeWorking() {
        return timeWorking;
    }

    public void setTimeWorking(String timeWorking) {
        this.timeWorking = timeWorking;
    }
}
