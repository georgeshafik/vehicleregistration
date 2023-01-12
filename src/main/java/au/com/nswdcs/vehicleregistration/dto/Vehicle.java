package au.com.nswdcs.vehicleregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.Valid;
import java.util.Objects;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-11T05:02:16.784Z[GMT]")

/**
 * Created by George Shafik on 11/1/2023
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Vehicle {

    /**
     * Get id
     * @return id
     **/
    @Schema(example = "CG12GH", description = "vehicle id")
    @JsonProperty("id")
    private String id = null;

    /**
     * Get vinno
     * @return vinno
     **/
    @Schema(example = "V12782348-12830912709147", description = "vin number")
    @JsonProperty("vinno")
    private String vinno = null;

    /**
     * Get registrationno
     * @return registrationno
     **/
    @Schema(example = "CG12GH", description = "Registration number")
    @JsonProperty("registrationno")
    private String registrationno = null;

    /**
     * Get personid
     * @return personid
     **/
    @Schema(example = "L22346789", description = "Person id")
    @JsonProperty("personid")
    private String personid = null;

    /**
     * Get vehiclemake
     * @return vehiclemake
     **/
    @Schema(example = "HYUNDAI", description = "Vehicle make")
    @JsonProperty("vehiclemake")
    private String vehiclemake = null;

    /**
     * Get vehiclemodel
     * @return vehiclemodel
     **/
    @Schema(example = "TUCSON", description = "Vehicle model")
    @JsonProperty("vehiclemodel")
    private String vehiclemodel = null;

    /**
     * Get mfgyeardate
     * @return mfgyeardate
     **/
    @Schema(example = "2011-1-1 00:00:00", description = "Manufacturing Year and Date")
    @JsonProperty("mfgyeardate")
    private Date mfgyeardate = null;

    /**
     * Get datecreated
     * @return datecreated
     **/
    @Schema(example = "2011-11-12 12:20:24", description = "Record Creation Date")
    @JsonProperty("datecreated")
    private Timestamp datecreated = null;

    /**
     * Get datemodified
     * @return datemodified
     **/
    @Schema(example = "2011-11-12 12:20:24", description = "Record Modified Date")
    @JsonProperty("datemodified")
    private Timestamp datemodified = null;

}
