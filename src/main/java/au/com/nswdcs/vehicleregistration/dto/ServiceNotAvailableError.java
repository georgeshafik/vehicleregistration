package au.com.nswdcs.vehicleregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ServiceNotAvailableError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen",
        date = "2022-09-18T04:02:16.784Z[GMT]")


public class ServiceNotAvailableError {
    @JsonProperty("error")
    private String error = null;

    @JsonProperty("error_description")
    private String errorDescription = null;

    public ServiceNotAvailableError error(String error) {
        this.error = error;
        return this;
    }

    /**
     * Service Not Available Error message
     *
     * @return error
     **/
    @Schema(required = true, description = "Service Not Available Error message")
    @NotNull

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ServiceNotAvailableError errorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    /**
     * Service Not Available Error message
     *
     * @return errorDescription
     **/
    @Schema(description = "Service Not Available Error message")

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceNotAvailableError serviceNotAvailableError = (ServiceNotAvailableError) o;
        return Objects.equals(this.error, serviceNotAvailableError.error) &&
                Objects.equals(this.errorDescription, serviceNotAvailableError.errorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, errorDescription);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceNotAvailableError {\n");

        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
