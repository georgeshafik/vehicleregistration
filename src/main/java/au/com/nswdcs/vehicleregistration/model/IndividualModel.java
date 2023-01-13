package au.com.nswdcs.vehicleregistration.model;

import au.com.nswdcs.vehicleregistration.dto.Individual;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static au.com.nswdcs.vehicleregistration.utilities.GeneralUtilities.isAnyNullOrEmpty;

/**
 * Created by George Shafik on 12/1/2023
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "individual")
public class IndividualModel {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "middlename")
    private String middlename;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "licenseno")
    private String licenseno;

    @Column(name = "isactive")
    private boolean isactive;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "datecreated")
    private Timestamp datecreated;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "datemodified")
    private Timestamp datemodified;

    @OneToMany(mappedBy = "personid", cascade = CascadeType.ALL)
    private List<VehicleModel> vehicles;

    /**
     *
     * Converts a Individual to IndividualModel
     * Required DTO - Model
     *
     * @param individual
     */
    public void mapIndividualToIndividualModel(Individual individual) {
        if(!isAnyNullOrEmpty(individual.getId())) {
            this.setId(individual.getId());
        }

        this.setFirstname(individual.getFirstname());
        this.setSecondname(individual.getSecondname());
        this.setMiddlename(individual.getMiddlename());
        this.setDob(individual.getDob());
        this.setLicenseno(individual.getLicenseno());
        this.setIsactive(individual.getIsactive());
        this.setDatecreated(individual.getDatecreated());
        this.setDatemodified(individual.getDatemodified());
    }

    /**
     *
     * Converts a Individual to IndividualModel
     * Required DTO - Model
     */
    public Individual mapIndividualToIndividualModel() {
        Individual individual = new Individual();

        individual.setId(this.getId());
        individual.setFirstname(this.getFirstname());
        individual.setSecondname(this.getSecondname());
        individual.setMiddlename(this.getMiddlename());
        individual.setDob(this.getDob());
        individual.setLicenseno(this.getLicenseno());
        individual.setIsactive(this.isIsactive());
        individual.setDatecreated(this.getDatecreated());
        individual.setDatemodified(this.getDatemodified());

        return individual;
    }

}
