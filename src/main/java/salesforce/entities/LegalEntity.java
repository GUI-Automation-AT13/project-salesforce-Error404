/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    /**
     * Gets the name of the legal entity.
     *
     * @return a string with the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the attributes of the legal entity.
     *
     * @return the attributes.
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the attributes of the legal entity.
     *
     * @param incomingAttributes the attributes to be set.
     */
    public void setAttributes(final Attributes incomingAttributes) {
        this.attributes = incomingAttributes;
    }

    /**
     * Gets the legal entity id.
     *
     * @return a string with the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the legal entity.
     *
     * @param newId the new id to be set.
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets the owner id.
     *
     * @return a string with the owner id.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the owner id.
     *
     * @param newOwnerId the new owner id
     */
    public void setOwnerId(final String newOwnerId) {
        this.ownerId = newOwnerId;
    }

    /**
     * Verify if a legal entity is deleted.
     *
     * @return true if it's deleted, false otherwise.
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Sets the deleted state.
     *
     * @param deleted true or false.
     */
    public void setDeleted(final boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Sets the name.
     *
     * @param newName the new Name
     */
    public void setName(final String newName) {
        this.name = newName.concat(getTodayDate());
    }

    /**
     * Gets the created date.
     *
     * @return a Date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     *
     * @param newCreatedDate the new Date.
     */
    public void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    /**
     * Gets the create by id.
     *
     * @return a string with the created by id.
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Sets the created by id.
     *
     * @param newCreatedById the new created by id.
     */
    public void setCreatedById(final String newCreatedById) {
        this.createdById = newCreatedById;
    }

    /**
     * Gets last modified date.
     *
     * @return a Date.
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the last modified date.
     *
     * @param newLastModifiedDate a date.
     */
    public void setLastModifiedDate(final Date newLastModifiedDate) {
        this.lastModifiedDate = newLastModifiedDate;
    }

    /**
     * Gets the last modified by id.
     *
     * @return a string with the last modified by id.
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    /**
     * Sets the last modified by id.
     *
     * @param newLastModifiedById a string with the last modified id.
     */
    public void setLastModifiedById(final String newLastModifiedById) {
        this.lastModifiedById = newLastModifiedById;
    }

    /**
     * Gets the system modstamp.
     *
     * @return a Date.
     */
    public Date getSystemModstamp() {
        return systemModstamp;
    }

    /**
     * Sets the system modstamp.
     *
     * @param newSystemModstamp a Date.
     */
    public void setSystemModstamp(final Date newSystemModstamp) {
        this.systemModstamp = newSystemModstamp;
    }

    /**
     * Gets the last view date.
     *
     * @return a Date.
     */
    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    /**
     * Sets the last viewed date.
     *
     * @param newLastViewedDate a Date to set.
     */
    public void setLastViewedDate(final Date newLastViewedDate) {
        this.lastViewedDate = newLastViewedDate;
    }

    /**
     * Gets the last referenced date.
     *
     * @return a Date.
     */
    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    /**
     * Sets the last referenced date.
     *
     * @param newLastReferencedDate a Date.
     */
    public void setLastReferencedDate(final Date newLastReferencedDate) {
        this.lastReferencedDate = newLastReferencedDate;
    }

    /**
     * Gets the company name.
     *
     * @return a string with the company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company name.
     *
     * @param newCompanyName the new company name.
     */
    public void setCompanyName(final String newCompanyName) {
        this.companyName = newCompanyName;
    }

    /**
     * Gets the description.
     *
     * @return a string with the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param newDescription the new description.
     */
    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * Gets the status.
     *
     * @return a string with the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param newStatus the new status
     */
    public void setStatus(final String newStatus) {
        this.status = newStatus;
    }

    /**
     * Gets the street.
     *
     * @return a string with the street.
     */
    public String getLegalEntityStreet() {
        return legalEntityStreet;
    }

    /**
     * Sets the street.
     *
     * @param newLegalEntityStreet the new street.
     */
    public void setLegalEntityStreet(final String newLegalEntityStreet) {
        this.legalEntityStreet = newLegalEntityStreet;
    }

    /**
     * Gets the city.
     *
     * @return a string with the city.
     */
    public String getLegalEntityCity() {
        return legalEntityCity;
    }

    /**
     * Sets the city.
     *
     * @param newLegalEntityCity the new city.
     */
    public void setLegalEntityCity(final String newLegalEntityCity) {
        this.legalEntityCity = newLegalEntityCity;
    }

    /**
     * Gets the state.
     *
     * @return a string with the state.
     */
    public String getLegalEntityState() {
        return legalEntityState;
    }

    /**
     * Sets the state.
     *
     * @param newLegalEntityState the new state.
     */
    public void setLegalEntityState(final String newLegalEntityState) {
        this.legalEntityState = newLegalEntityState;
    }

    /**
     * Sets the postal code.
     *
     * @return a string with the postal code.
     */
    public String getLegalEntityPostalCode() {
        return legalEntityPostalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param newLegalEntityPostalCode the new postal code.
     */
    public void setLegalEntityPostalCode(final String newLegalEntityPostalCode) {
        this.legalEntityPostalCode = newLegalEntityPostalCode;
    }

    /**
     * Gets the country.
     *
     * @return a string with the country.
     */
    public String getLegalEntityCountry() {
        return legalEntityCountry;
    }

    /**
     * Sets the country.
     *
     * @param newLegalEntityCountry the new country.
     */
    public void setLegalEntityCountry(final String newLegalEntityCountry) {
        this.legalEntityCountry = newLegalEntityCountry;
    }

    /**
     * Gets the latitude.
     *
     * @return an object with the latitude.
     */
    public Object getLegalEntityLatitude() {
        return legalEntityLatitude;
    }

    /**
     * Sets the latitude.
     *
     * @param newLegalEntityLatitude an object.
     */
    public void setLegalEntityLatitude(final Object newLegalEntityLatitude) {
        this.legalEntityLatitude = newLegalEntityLatitude;
    }

    /**
     * Gets the longitude.
     *
     * @return an object with the longitude.
     */
    public Object getLegalEntityLongitude() {
        return legalEntityLongitude;
    }

    /**
     * Sets the longitude.
     *
     * @param newLegalEntityLongitude an object.
     */
    public void setLegalEntityLongitude(final Object newLegalEntityLongitude) {
        this.legalEntityLongitude = newLegalEntityLongitude;
    }

    /**
     * Gets the geocode accuracy.
     *
     * @return an object.
     */
    public Object getLegalEntityGeocodeAccuracy() {
        return legalEntityGeocodeAccuracy;
    }

    /**
     * Sets the geocode accuracy.
     *
     * @param newLegalEntityGeocodeAccuracy an object.
     */
    public void setLegalEntityGeocodeAccuracy(final Object newLegalEntityGeocodeAccuracy) {
        this.legalEntityGeocodeAccuracy = newLegalEntityGeocodeAccuracy;
    }

    /**
     * Gets the address.
     *
     * @return an object.
     */
    public Object getLegalEntityAddress() {
        return legalEntityAddress;
    }

    /**
     * Sets the address.
     *
     * @param newLegalEntityAddress an object
     */
    public void setLegalEntityAddress(final Object newLegalEntityAddress) {
        this.legalEntityAddress = newLegalEntityAddress;
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

    /**
     * Gets the entity address composed of city, state and postal code.
     *
     * @return a string with the address.
     */
    public String getAddress() {
        if (legalEntityCity == null && legalEntityState == null && legalEntityPostalCode == null) {
            return null;
        }
        return legalEntityCity + ", " + legalEntityState + " " + legalEntityPostalCode;
    }

    /**
     * Builds a summary map, city-state-postalCode as the address.
     *
     * @return HashMap<String, String>.
     */
    public HashMap<String, String> summaryMap() {
        HashMap<String, String> summaryMap = new HashMap<>();
        summaryMap.put("Name", getName());
        summaryMap.put("CompanyName", getCompanyName());
        summaryMap.put("LegalEntityStreet", getLegalEntityStreet());
        summaryMap.put("Address", getAddress());
        summaryMap.put("Country", getLegalEntityCountry());
        summaryMap.put("Description", getDescription());
        summaryMap.put("Status", getStatus());
        return summaryMap;
    }

    /**
     * Gets today date.
     *
     * @return a String with the date.
     */
    public String getTodayDate() {
        Date actualDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy HH:mm");
        return dateFormat.format(actualDate);
    }

    /**
     * Sets the values of the entity.
     *
     * @param legalEntity to be set.
     */
    public void setEntity(final LegalEntity legalEntity) {
        name = legalEntity.getName();
        companyName = legalEntity.getCompanyName();
        description = legalEntity.getDescription();
        status = legalEntity.getStatus();
        legalEntityStreet = legalEntity.getLegalEntityStreet();
        legalEntityCity = legalEntity.getLegalEntityCity();
        legalEntityCountry = legalEntity.getLegalEntityCountry();
        legalEntityState = legalEntity.getLegalEntityState();
        legalEntityPostalCode = legalEntity.getLegalEntityPostalCode();
    }
}
