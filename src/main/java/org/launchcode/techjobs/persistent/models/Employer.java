package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {

    public Employer() {}
    @Size(min=1, max = 150)
    @NotBlank
    @NotNull
    private String location;

    public Employer(String Location) {
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
