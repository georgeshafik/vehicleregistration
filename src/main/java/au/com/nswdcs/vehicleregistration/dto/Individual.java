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

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-11T06:02:16.784Z[GMT]")

/**
 * Created by George Shafik on 12/1/2023
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Individual {

    /**
     * Get id
     * @return id
     **/
    @Schema(example = "L22346789", description = "person id")
    @JsonProperty("id")
    private String id = null;

    /**
     * Get firstname
     * @return firstname
     **/
    @Schema(example = "Andy", description = "first name")
    @JsonProperty("firstname")
    private String firstname = null;

    /**
     * Get secondname
     * @return secondname
     **/
    @Schema(example = "Newton", description = "second name")
    @JsonProperty("secondname")
    private String secondname = null;

    /**
     * Get middlename
     * @return middlename
     **/
    @Schema(example = "Geoff", description = "middle name")
    @JsonProperty("middlename")
    private String middlename = null;

    /**
     * Get dob
     * @return dob
     **/
    @Schema(example = "1984-11-22", description = "Date of birth")
    @JsonProperty("dob")
    private Date dob = null;


    /**
     * Get licenseno
     * @return licenseno
     **/
    @Schema(example = "22346789", description = "License number")
    @JsonProperty("licenseno")
    private String licenseno = null;

    /**
     * Get isactive
     * @return isactive
     **/
    @Schema(example = "true", description = "Is person account active")
    @JsonProperty("isactive")
    private Boolean isactive = null;

    /**
     * Get datecreated
     * @return datecreated
     **/
    @Schema(example = "2001-11-12 12:20:00", description = "Date record created")
    @JsonProperty("datecreated")
    private Timestamp datecreated = null;

    /**
     * Get datemodified
     * @return datemodified
     **/
    @Schema(example = "2001-11-12 12:20:00'", description = "Date modified")
    @JsonProperty("datemodified")
    private Timestamp datemodified = null;

}
