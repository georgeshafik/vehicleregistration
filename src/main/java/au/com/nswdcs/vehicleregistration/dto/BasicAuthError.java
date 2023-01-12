package au.com.nswdcs.vehicleregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * BasicAuthError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-18T04:02:16.784Z[GMT]")


public class BasicAuthError {
  @JsonProperty("error")
  private String error = null;

  @JsonProperty("error_description")
  private String errorDescription = null;

  public BasicAuthError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Basic Auth Error message
   * @return error
   **/
  @Schema(required = true, description = "Basic Auth Error message")
      @NotNull

    public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public BasicAuthError errorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
    return this;
  }

  /**
   * Basic Auth Error message
   * @return errorDescription
   **/
  @Schema(description = "Basic Auth Error message")

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
    BasicAuthError basicAuthError = (BasicAuthError) o;
    return Objects.equals(this.error, basicAuthError.error) &&
        Objects.equals(this.errorDescription, basicAuthError.errorDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errorDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicAuthError {\n");

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
