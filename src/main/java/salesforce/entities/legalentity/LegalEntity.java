package salesforce.entities.legalentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.jar.Attributes;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegalEntity {

    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public Date systemModstamp;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("CompanyName")
    public String companyName;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("LegalEntityStreet")
    public String legalEntityStreet;
    @JsonProperty("LegalEntityCity")
    public String legalEntityCity;
    @JsonProperty("LegalEntityState")
    public String legalEntityState;
    @JsonProperty("LegalEntityPostalCode")
    public String legalEntityPostalCode;
    @JsonProperty("LegalEntityCountry")
    public String legalEntityCountry;
    @JsonProperty("LegalEntityLatitude")
    public Object legalEntityLatitude;
    @JsonProperty("LegalEntityLongitude")
    public Object legalEntityLongitude;
    @JsonProperty("LegalEntityGeocodeAccuracy")
    public Object legalEntityGeocodeAccuracy;
    @JsonProperty("LegalEntityAddress")
    public Object legalEntityAddress;

    public String getName() {
        return name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(Date systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLegalEntityStreet() {
        return legalEntityStreet;
    }

    public void setLegalEntityStreet(String legalEntityStreet) {
        this.legalEntityStreet = legalEntityStreet;
    }

    public String getLegalEntityCity() {
        return legalEntityCity;
    }

    public void setLegalEntityCity(String legalEntityCity) {
        this.legalEntityCity = legalEntityCity;
    }

    public String getLegalEntityState() {
        return legalEntityState;
    }

    public void setLegalEntityState(String legalEntityState) {
        this.legalEntityState = legalEntityState;
    }

    public String getLegalEntityPostalCode() {
        return legalEntityPostalCode;
    }

    public void setLegalEntityPostalCode(String legalEntityPostalCode) {
        this.legalEntityPostalCode = legalEntityPostalCode;
    }

    public String getLegalEntityCountry() {
        return legalEntityCountry;
    }

    public void setLegalEntityCountry(String legalEntityCountry) {
        this.legalEntityCountry = legalEntityCountry;
    }

    public Object getLegalEntityLatitude() {
        return legalEntityLatitude;
    }

    public void setLegalEntityLatitude(Object legalEntityLatitude) {
        this.legalEntityLatitude = legalEntityLatitude;
    }

    public Object getLegalEntityLongitude() {
        return legalEntityLongitude;
    }

    public void setLegalEntityLongitude(Object legalEntityLongitude) {
        this.legalEntityLongitude = legalEntityLongitude;
    }

    public Object getLegalEntityGeocodeAccuracy() {
        return legalEntityGeocodeAccuracy;
    }

    public void setLegalEntityGeocodeAccuracy(Object legalEntityGeocodeAccuracy) {
        this.legalEntityGeocodeAccuracy = legalEntityGeocodeAccuracy;
    }

    public Object getLegalEntityAddress() {
        return legalEntityAddress;
    }

    public void setLegalEntityAddress(Object legalEntityAddress) {
        this.legalEntityAddress = legalEntityAddress;
    }

    /**
     * Sets the attributes with null values to empty.
     *
     * @throws IllegalAccessException when access to class not provided
     */
    public void setNullValuesToEmpty() throws IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.get(this) == null) {
                field.set(this, "");
            }
        }
    }

    public String getAddress() {
        if (legalEntityCity == null && legalEntityState == null && legalEntityPostalCode == null) {
            return null;
        }
        return legalEntityCity+ ", " + legalEntityState + " " + legalEntityPostalCode;
    }
}


