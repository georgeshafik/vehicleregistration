package au.com.nswdcs.vehicleregistration.model;

import au.com.nswdcs.vehicleregistration.dto.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static au.com.nswdcs.vehicleregistration.utilities.GeneralUtilities.isAnyNullOrEmpty;

/**
 * Created by George Shafik on 12/1/2023
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleModel {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "vinno")
    private String vinno;

    @Column(name = "registrationno")
    private String registrationno;

    @Column(name = "personid")
    private String personid;

    @Column(name = "vehiclemake")
    private String vehiclemake;

    @Column(name = "vehiclemodel")
    private String vehiclemodel;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "mfgyeardate")
    private Date mfgyeardate;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "datecreated")
    private Timestamp datecreated;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "datemodified")
    private Timestamp datemodified;


    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private IndividualModel person;

    /**
     *
     * Converts a Vehicle to VehicleModel
     * Required DTO - Model
     *
     * @param vehicle
     */
    public void mapVehicleToVehicleModel(Vehicle vehicle) {
        if(!isAnyNullOrEmpty(vehicle.getId())) {
            this.setId(vehicle.getId());
        }

        this.setVinno(vehicle.getVinno());
        this.setRegistrationno(vehicle.getRegistrationno());
        this.setPersonid(vehicle.getPersonid());
        this.setVehiclemake(vehicle.getVehiclemake());
        this.setVehiclemodel(vehicle.getVehiclemodel());
        this.setMfgyeardate(vehicle.getMfgyeardate());
        this.setDatecreated(vehicle.getDatecreated());
        this.setDatemodified(vehicle.getDatemodified());
    }

    /**
     *
     * Converts a Vehicle to VehicleModel
     * Required DTO - Model
     *
     */
    public Vehicle mapVehicleToVehicleModel() {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(this.getId());
        vehicle.setVinno(this.getVinno());
        vehicle.setRegistrationno(this.getRegistrationno());
        vehicle.setPersonid(this.getPersonid());
        vehicle.setVehiclemake(this.getVehiclemake());
        vehicle.setVehiclemodel(this.getVehiclemodel());
        vehicle.setMfgyeardate(this.getMfgyeardate());
        vehicle.setDatecreated(this.getDatecreated());
        vehicle.setDatemodified(this.getDatemodified());

        return vehicle;
    }
}
