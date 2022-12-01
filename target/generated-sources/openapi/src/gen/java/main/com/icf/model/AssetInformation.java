package com.icf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.icf.model.StringDoubleKeyValuePair;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssetInformation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-01T02:04:54.220330200-05:00[America/New_York]")
public class AssetInformation   {
  @JsonProperty("serialNo")
  private JsonNullable<String> serialNo = JsonNullable.undefined();

  @JsonProperty("dataPoints")
  @Valid
  private JsonNullable<List<StringDoubleKeyValuePair>> dataPoints = JsonNullable.undefined();

  public AssetInformation serialNo(String serialNo) {
    this.serialNo = JsonNullable.of(serialNo);
    return this;
  }

  /**
   * Get serialNo
   * @return serialNo
  */
  @ApiModelProperty(value = "")


  public JsonNullable<String> getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(JsonNullable<String> serialNo) {
    this.serialNo = serialNo;
  }

  public AssetInformation dataPoints(List<StringDoubleKeyValuePair> dataPoints) {
    this.dataPoints = JsonNullable.of(dataPoints);
    return this;
  }

  public AssetInformation addDataPointsItem(StringDoubleKeyValuePair dataPointsItem) {
    if (this.dataPoints == null || !this.dataPoints.isPresent()) {
      this.dataPoints = JsonNullable.of(new ArrayList<>());
    }
    this.dataPoints.get().add(dataPointsItem);
    return this;
  }

  /**
   * Get dataPoints
   * @return dataPoints
  */
  @ApiModelProperty(value = "")

  @Valid

  public JsonNullable<List<StringDoubleKeyValuePair>> getDataPoints() {
    return dataPoints;
  }

  public void setDataPoints(JsonNullable<List<StringDoubleKeyValuePair>> dataPoints) {
    this.dataPoints = dataPoints;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetInformation assetInformation = (AssetInformation) o;
    return Objects.equals(this.serialNo, assetInformation.serialNo) &&
        Objects.equals(this.dataPoints, assetInformation.dataPoints);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNo, dataPoints);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetInformation {\n");
    
    sb.append("    serialNo: ").append(toIndentedString(serialNo)).append("\n");
    sb.append("    dataPoints: ").append(toIndentedString(dataPoints)).append("\n");
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

