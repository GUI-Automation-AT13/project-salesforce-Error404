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
import salesforce.entities.support.Attribute;
import salesforce.entities.support.BillingAddress;
import salesforce.entities.support.ShippingAddress;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private Attribute attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    private Object masterRecordId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ParentId")
    private Object parentId;
    @JsonProperty("BillingStreet")
    private String billingStreet;
    @JsonProperty("BillingCity")
    private String billingCity;
    @JsonProperty("BillingState")
    private String billingState;
    @JsonProperty("BillingPostalCode")
    private String billingPostalCode;
    @JsonProperty("BillingCountry")
    private String billingCountry;
    @JsonProperty("BillingLatitude")
    private Object billingLatitude;
    @JsonProperty("BillingLongitude")
    private Object billingLongitude;
    @JsonProperty("BillingGeocodeAccuracy")
    private Object billingGeocodeAccuracy;
    @JsonProperty("BillingAddress")
    private BillingAddress billingAddress;
    @JsonProperty("ShippingStreet")
    private String shippingStreet;
    @JsonProperty("ShippingCity")
    private String shippingCity;
    @JsonProperty("ShippingState")
    private String shippingState;
    @JsonProperty("ShippingPostalCode")
    private String shippingPostalCode;
    @JsonProperty("ShippingCountry")
    private String shippingCountry;
    @JsonProperty("ShippingLatitude")
    private Object shippingLatitude;
    @JsonProperty("ShippingLongitude")
    private Object shippingLongitude;
    @JsonProperty("ShippingGeocodeAccuracy")
    private Object shippingGeocodeAccuracy;
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("Website")
    private String website;
    @JsonProperty("PhotoUrl")
    private String photoUrl;
    @JsonProperty("Sic")
    private String sic;
    @JsonProperty("Industry")
    private String industry;
    @JsonProperty("AnnualRevenue")
    private Double annualRevenue;
    @JsonProperty("NumberOfEmployees")
    private Integer numberOfEmployees;
    @JsonProperty("Ownership")
    private String ownership;
    @JsonProperty("TickerSymbol")
    private String tickerSymbol;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Rating")
    private String rating;
    @JsonProperty("Site")
    private String site;
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonProperty("CreatedById")
    private String createdById;
    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;
    @JsonProperty("LastModifiedById")
    private String lastModifiedById;
    @JsonProperty("SystemModstamp")
    private String systemModStamp;
    @JsonProperty("LastActivityDate")
    private Object lastActivityDate;
    @JsonProperty("LastViewedDate")
    private String lastViewedDate;
    @JsonProperty("LastReferencedDate")
    private String lastReferencedDate;
    @JsonProperty("Jigsaw")
    private Object jigsaw;
    @JsonProperty("JigsawCompanyId")
    private Object jigsawCompanyId;
    @JsonProperty("CleanStatus")
    private String cleanStatus;
    @JsonProperty("AccountSource")
    private Object accountSource;
    @JsonProperty("DunsNumber")
    private Object dunsNumber;
    @JsonProperty("Tradestyle")
    private Object tradeStyle;
    @JsonProperty("NaicsCode")
    private Object naiCsCode;
    @JsonProperty("NaicsDesc")
    private Object naiCsDesc;
    @JsonProperty("YearStarted")
    private Object yearStarted;
    @JsonProperty("SicDesc")
    private Object sicDesc;
    @JsonProperty("DandbCompanyId")
    private Object danDbCompanyId;
    @JsonProperty("OperatingHoursId")
    private Object operatingHoursId;
    @JsonProperty("CustomerPriority__c")
    private String customerPriorityC;
    @JsonProperty("SLA__c")
    private String slaC;
    @JsonProperty("Active__c")
    private String activeC;
    @JsonProperty("NumberofLocations__c")
    private Double numberOfLocationsC;
    @JsonProperty("UpsellOpportunity__c")
    private String upsellOpportunityC;
    @JsonProperty("SLASerialNumber__c")
    private String slaSerialNumberC;
    @JsonProperty("SLAExpirationDate__c")
    private String slaExpirationDateC;

    /**
     * Gets attributes of Account.
     *
     * @return attributes of Account.
     */
    public Attribute getAttributes() {
        return attributes;
    }

    /**
     * Sets attributes of Account.
     *
     * @param newAttributes of Account.
     */
    public void setAttributes(final Attribute newAttributes) {
        this.attributes = newAttributes;
    }

    /**
     * Gets id of Account.
     *
     * @return id of Account.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id of Account.
     *
     * @param newId of Account.
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets isDeleted of Account.
     *
     * @return isDeleted of Account.
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets deleted of Account.
     *
     * @param newDeleted of Account.
     */
    public void setIsDeleted(final Boolean newDeleted) {
        isDeleted = newDeleted;
    }

    /**
     * Gets masterRecordId of Account.
     *
     * @return masterRecordId of Account.
     */
    public Object getMasterRecordId() {
        return masterRecordId;
    }

    /**
     * Sets masterRecordId of Account.
     *
     * @param newMasterRecordId of Account.
     */
    public void setMasterRecordId(final Object newMasterRecordId) {
        this.masterRecordId = newMasterRecordId;
    }

    /**
     * Gets name of Account.
     *
     * @return name of Account.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of Account.
     *
     * @param newName of Account.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets type of Account.
     *
     * @return type of Account.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type of Account.
     *
     * @param newType of Account.
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     * Gets parentId of Account.
     *
     * @return parentId of Account.
     */
    public Object getParentId() {
        return parentId;
    }

    /**
     * Sets parentId of Account.
     *
     * @param newParentId of Account.
     */
    public void setParentId(final Object newParentId) {
        this.parentId = newParentId;
    }

    /**
     * Gets billingStreet of Account.
     *
     * @return billingStreet of Account.
     */
    public String getBillingStreet() {
        return billingStreet;
    }

    /**
     * Sets billingStreet of Account.
     *
     * @param newBillingStreet of Account.
     */
    public void setBillingStreet(final String newBillingStreet) {
        this.billingStreet = newBillingStreet;
    }

    /**
     * Gets billingCity of Account.
     *
     * @return billingCity of Account.
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Sets billingCity of Account.
     *
     * @param newBillingCity of Account.
     */
    public void setBillingCity(final String newBillingCity) {
        this.billingCity = newBillingCity;
    }

    /**
     * Gets billingState of Account.
     *
     * @return billingState of Account.
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * Sets billingState of Account.
     *
     * @param newBillingState of Account.
     */
    public void setBillingState(final String newBillingState) {
        this.billingState = newBillingState;
    }

    /**
     * Gets billingPostalCode of Account.
     *
     * @return billingPostalCode of Account.
     */
    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    /**
     * Sets billingPostalCode of Account.
     *
     * @param newBillingPostalCode of Account.
     */
    public void setBillingPostalCode(final String newBillingPostalCode) {
        this.billingPostalCode = newBillingPostalCode;
    }

    /**
     * Gets billingCountry of Account.
     *
     * @return billingCountry of Account.
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * Sets billingCountry of Account.
     *
     * @param newBillingCountry of Account.
     */
    public void setBillingCountry(final String newBillingCountry) {
        this.billingCountry = newBillingCountry;
    }

    /**
     * Gets billingLatitude of Account.
     *
     * @return billingLatitude of Account.
     */
    public Object getBillingLatitude() {
        return billingLatitude;
    }

    /**
     * Sets billingLatitude of Account.
     *
     * @param newBillingLatitude of Account.
     */
    public void setBillingLatitude(final Object newBillingLatitude) {
        this.billingLatitude = newBillingLatitude;
    }

    /**
     * Gets billingLongitude of Account.
     *
     * @return billingLongitude of Account.
     */
    public Object getBillingLongitude() {
        return billingLongitude;
    }

    /**
     * Sets billingLongitude of Account.
     *
     * @param newBillingLongitude of Account.
     */
    public void setBillingLongitude(final Object newBillingLongitude) {
        this.billingLongitude = newBillingLongitude;
    }

    /**
     * Gets billingGeocodeAccuracy of Account.
     *
     * @return billingGeocodeAccuracy of Account.
     */
    public Object getBillingGeocodeAccuracy() {
        return billingGeocodeAccuracy;
    }

    /**
     * Sets billingGeocodeAccuracy of Account.
     *
     * @param newBillingGeocodeAccuracy of Account.
     */
    public void setBillingGeocodeAccuracy(final Object newBillingGeocodeAccuracy) {
        this.billingGeocodeAccuracy = newBillingGeocodeAccuracy;
    }

    /**
     * Gets billingAddress of Account.
     *
     * @return billingAddress of Account.
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets billingAddress of Account.
     *
     * @param newBillingAddress of Account.
     */
    public void setBillingAddress(final BillingAddress newBillingAddress) {
        this.billingAddress = newBillingAddress;
    }

    /**
     * Gets shippingStreet of Account.
     *
     * @return shippingStreet of Account.
     */
    public String getShippingStreet() {
        return shippingStreet;
    }

    /**
     * Sets shippingStreet of Account.
     *
     * @param newShippingStreet of Account.
     */
    public void setShippingStreet(final String newShippingStreet) {
        this.shippingStreet = newShippingStreet;
    }

    /**
     * Gets shippingCity of Account.
     *
     * @return shippingCity of Account.
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * Sets shippingCity of Account.
     *
     * @param newShippingCity of Account.
     */
    public void setShippingCity(final String newShippingCity) {
        this.shippingCity = newShippingCity;
    }

    /**
     * Gets shippingState of Account.
     *
     * @return shippingState of Account.
     */
    public String getShippingState() {
        return shippingState;
    }

    /**
     * Sets shippingState of Account.
     *
     * @param newShippingState of Account.
     */
    public void setShippingState(final String newShippingState) {
        this.shippingState = newShippingState;
    }

    /**
     * Gets shippingPostalCode of Account.
     *
     * @return shippingPostalCode of Account.
     */
    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    /**
     * Sets shippingPostalCode of Account.
     *
     * @param newShippingPostalCode of Account.
     */
    public void setShippingPostalCode(final String newShippingPostalCode) {
        this.shippingPostalCode = newShippingPostalCode;
    }

    /**
     * Gets shippingCountry of Account.
     *
     * @return shippingCountry of Account.
     */
    public String getShippingCountry() {
        return shippingCountry;
    }

    /**
     * Sets shippingCountry of Account.
     *
     * @param newShippingCountry of Account.
     */
    public void setShippingCountry(final String newShippingCountry) {
        this.shippingCountry = newShippingCountry;
    }

    /**
     * Gets shippingLatitude of Account.
     *
     * @return shippingLatitude of Account.
     */
    public Object getShippingLatitude() {
        return shippingLatitude;
    }

    /**
     * Sets shippingLatitude of Account.
     *
     * @param newShippingLatitude of Account.
     */
    public void setShippingLatitude(final Object newShippingLatitude) {
        this.shippingLatitude = newShippingLatitude;
    }

    /**
     * Gets shippingLongitude of Account.
     *
     * @return shippingLongitude of Account.
     */
    public Object getShippingLongitude() {
        return shippingLongitude;
    }

    /**
     * Sets shippingLongitude of Account.
     *
     * @param newShippingLongitude of Account.
     */
    public void setShippingLongitude(final Object newShippingLongitude) {
        this.shippingLongitude = newShippingLongitude;
    }

    /**
     * Gets shippingGeocodeAccuracy of Account.
     *
     * @return shippingGeocodeAccuracy of Account.
     */
    public Object getShippingGeocodeAccuracy() {
        return shippingGeocodeAccuracy;
    }

    /**
     * Sets shippingGeocodeAccuracy of Account.
     *
     * @param newShippingGeocodeAccuracy of Account.
     */
    public void setShippingGeocodeAccuracy(final Object newShippingGeocodeAccuracy) {
        this.shippingGeocodeAccuracy = newShippingGeocodeAccuracy;
    }

    /**
     * Gets shippingAddress of Account.
     *
     * @return shippingAddress of Account.
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets shippingAddress of Account.
     *
     * @param newShippingAddress of Account.
     */
    public void setShippingAddress(final ShippingAddress newShippingAddress) {
        this.shippingAddress = newShippingAddress;
    }

    /**
     * Gets phone of Account.
     *
     * @return phone of Account.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone of Account.
     *
     * @param newPhone of Account.
     */
    public void setPhone(final String newPhone) {
        this.phone = newPhone;
    }

    /**
     * Gets fax of Account.
     *
     * @return fax of Account.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets fax of Account.
     *
     * @param newFax of Account.
     */
    public void setFax(final String newFax) {
        this.fax = newFax;
    }

    /**
     * Gets accountNumber of Account.
     *
     * @return accountNumber of Account.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets accountNumber of Account.
     *
     * @param newAccountNumber of Account.
     */
    public void setAccountNumber(final String newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    /**
     * Gets website of Account.
     *
     * @return website of Account.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website of Account.
     *
     * @param newWebsite of Account.
     */
    public void setWebsite(final String newWebsite) {
        this.website = newWebsite;
    }

    /**
     * Gets photoUrl of Account.
     *
     * @return photoUrl of Account.
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * Sets photoUrl of Account.
     *
     * @param newPhotoUrl of Account.
     */
    public void setPhotoUrl(final String newPhotoUrl) {
        this.photoUrl = newPhotoUrl;
    }

    /**
     * Gets sic of Account.
     *
     * @return sic of Account.
     */
    public String getSic() {
        return sic;
    }

    /**
     * Sets sic of Account.
     *
     * @param newSic of Account.
     */
    public void setSic(final String newSic) {
        this.sic = newSic;
    }

    /**
     * Gets industry of Account.
     *
     * @return industry of Account.
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets industry of Account.
     *
     * @param newIndustry of Account.
     */
    public void setIndustry(final String newIndustry) {
        this.industry = newIndustry;
    }

    /**
     * Gets annualRevenue of Account.
     *
     * @return annualRevenue of Account.
     */
    public Double getAnnualRevenue() {
        return annualRevenue;
    }

    /**
     * Sets annualRevenue of Account.
     *
     * @param newAnnualRevenue of Account.
     */
    public void setAnnualRevenue(final Double newAnnualRevenue) {
        this.annualRevenue = newAnnualRevenue;
    }

    /**
     * Gets numberOfEmployees of Account.
     *
     * @return numberOfEmployees of Account.
     */
    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets numberOfEmployees of Account.
     *
     * @param newNumberOfEmployees of Account.
     */
    public void setNumberOfEmployees(final Integer newNumberOfEmployees) {
        this.numberOfEmployees = newNumberOfEmployees;
    }

    /**
     * Gets ownership of Account.
     *
     * @return ownership of Account.
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * Sets ownership of Account.
     *
     * @param newOwnership of Account.
     */
    public void setOwnership(final String newOwnership) {
        this.ownership = newOwnership;
    }

    /**
     * Gets tickerSymbol of Account.
     *
     * @return tickerSymbol of Account.
     */
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    /**
     * Sets tickerSymbol of Account.
     *
     * @param newTickerSymbol of Account.
     */
    public void setTickerSymbol(final String newTickerSymbol) {
        this.tickerSymbol = newTickerSymbol;
    }

    /**
     * Gets description of Account.
     *
     * @return description of Account.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description of Account.
     *
     * @param newDescription of Account.
     */
    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * Gets rating of Account.
     *
     * @return rating of Account.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets rating of Account.
     *
     * @param newRating of Account.
     */
    public void setRating(final String newRating) {
        this.rating = newRating;
    }

    /**
     * Gets site of Account.
     *
     * @return site of Account.
     */
    public String getSite() {
        return site;
    }

    /**
     * Sets site of Account.
     *
     * @param newSite of Account.
     */
    public void setSite(final String newSite) {
        this.site = newSite;
    }

    /**
     * Gets ownerId of Account.
     *
     * @return ownerId of Account.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets ownerId of Account.
     *
     * @param newOwnerId of Account.
     */
    public void setOwnerId(final String newOwnerId) {
        this.ownerId = newOwnerId;
    }

    /**
     * Gets createdDate of Account.
     *
     * @return createdDate of Account.
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets createdDate of Account.
     *
     * @param newCreatedDate of Account.
     */
    public void setCreatedDate(final String newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    /**
     * Gets createdById of Account.
     *
     * @return createdById of Account.
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Sets createdById of Account.
     *
     * @param newCreatedById of Account.
     */
    public void setCreatedById(final String newCreatedById) {
        this.createdById = newCreatedById;
    }

    /**
     * Gets lastModifiedDate of Account.
     *
     * @return lastModifiedDate of Account.
     */
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets lastModifiedDate of Account.
     *
     * @param newLastModifiedDate of Account.
     */
    public void setLastModifiedDate(final String newLastModifiedDate) {
        this.lastModifiedDate = newLastModifiedDate;
    }

    /**
     * Gets lastModifiedById of Account.
     *
     * @return lastModifiedById of Account.
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    /**
     * Sets lastModifiedById of Account.
     *
     * @param newLastModifiedById of Account.
     */
    public void setLastModifiedById(final String newLastModifiedById) {
        this.lastModifiedById = newLastModifiedById;
    }

    /**
     * Gets systemModStamp of Account.
     *
     * @return systemModStamp of Account.
     */
    public String getSystemModStamp() {
        return systemModStamp;
    }

    /**
     * Sets systemModStamp of Account.
     *
     * @param newSystemModStamp of Account.
     */
    public void setSystemModStamp(final String newSystemModStamp) {
        this.systemModStamp = newSystemModStamp;
    }

    /**
     * Gets lastActivityDate of Account.
     *
     * @return lastActivityDate of Account.
     */
    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * Sets lastActivityDate of Account.
     *
     * @param newLastActivityDate of Account.
     */
    public void setLastActivityDate(final Object newLastActivityDate) {
        this.lastActivityDate = newLastActivityDate;
    }

    /**
     * Gets lastViewedDate of Account.
     *
     * @return lastViewedDate of Account.
     */
    public String getLastViewedDate() {
        return lastViewedDate;
    }

    /**
     * Sets lastViewedDate of Account.
     *
     * @param newLastViewedDate of Account.
     */
    public void setLastViewedDate(final String newLastViewedDate) {
        this.lastViewedDate = newLastViewedDate;
    }

    /**
     * Gets lastReferencedDate of Account.
     *
     * @return lastReferencedDate of Account.
     */
    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    /**
     * Sets lastReferencedDate of Account.
     *
     * @param newLastReferencedDate of Account.
     */
    public void setLastReferencedDate(final String newLastReferencedDate) {
        this.lastReferencedDate = newLastReferencedDate;
    }

    /**
     * Gets jigsaw of Account.
     *
     * @return jigsaw of Account.
     */
    public Object getJigsaw() {
        return jigsaw;
    }

    /**
     * Sets jigsaw of Account.
     *
     * @param newJigsaw of Account.
     */
    public void setJigsaw(final Object newJigsaw) {
        this.jigsaw = newJigsaw;
    }

    /**
     * Gets jigsawCompanyId of Account.
     *
     * @return jigsawCompanyId of Account.
     */
    public Object getJigsawCompanyId() {
        return jigsawCompanyId;
    }

    /**
     * Sets jigsawCompanyId of Account.
     *
     * @param newJigsawCompanyId of Account.
     */
    public void setJigsawCompanyId(final Object newJigsawCompanyId) {
        this.jigsawCompanyId = newJigsawCompanyId;
    }

    /**
     * Gets cleanStatus of Account.
     *
     * @return cleanStatus of Account.
     */
    public String getCleanStatus() {
        return cleanStatus;
    }

    /**
     * Sets cleanStatus of Account.
     *
     * @param newCleanStatus of Account.
     */
    public void setCleanStatus(final String newCleanStatus) {
        this.cleanStatus = newCleanStatus;
    }

    /**
     * Gets accountSource of Account.
     *
     * @return accountSource of Account.
     */
    public Object getAccountSource() {
        return accountSource;
    }

    /**
     * Sets accountSource of Account.
     *
     * @param newAccountSource of Account.
     */
    public void setAccountSource(final Object newAccountSource) {
        this.accountSource = newAccountSource;
    }

    /**
     * Gets dunsNumber of Account.
     *
     * @return dunsNumber of Account.
     */
    public Object getDunsNumber() {
        return dunsNumber;
    }

    /**
     * Sets dunsNumber of Account.
     *
     * @param newDunsNumber of Account.
     */
    public void setDunsNumber(final Object newDunsNumber) {
        this.dunsNumber = newDunsNumber;
    }

    /**
     * Gets tradeStyle of Account.
     *
     * @return tradeStyle of Account.
     */
    public Object getTradeStyle() {
        return tradeStyle;
    }

    /**
     * Sets tradeStyle of Account.
     *
     * @param newTradeStyle of Account.
     */
    public void setTradeStyle(final Object newTradeStyle) {
        this.tradeStyle = newTradeStyle;
    }

    /**
     * Gets naiCsCode of Account.
     *
     * @return naiCsCode of Account.
     */
    public Object getNaiCsCode() {
        return naiCsCode;
    }

    /**
     * Sets naiCsCode of Account.
     *
     * @param newNaiCsCode of Account.
     */
    public void setNaiCsCode(final Object newNaiCsCode) {
        this.naiCsCode = newNaiCsCode;
    }

    /**
     * Gets naiCsDesc of Account.
     *
     * @return naiCsDesc of Account.
     */
    public Object getNaiCsDesc() {
        return naiCsDesc;
    }

    /**
     * Sets naiCsDesc of Account.
     *
     * @param newNaiCsDesc of Account.
     */
    public void setNaiCsDesc(final Object newNaiCsDesc) {
        this.naiCsDesc = newNaiCsDesc;
    }

    /**
     * Gets yearStarted of Account.
     *
     * @return yearStarted of Account.
     */
    public Object getYearStarted() {
        return yearStarted;
    }

    /**
     * Sets yearStarted of Account.
     *
     * @param newYearStarted of Account.
     */
    public void setYearStarted(final Object newYearStarted) {
        this.yearStarted = newYearStarted;
    }

    /**
     * Gets sicDesc of Account.
     *
     * @return sicDesc of Account.
     */
    public Object getSicDesc() {
        return sicDesc;
    }

    /**
     * Sets sicDesc of Account.
     *
     * @param newSicDesc of Account.
     */
    public void setSicDesc(final Object newSicDesc) {
        this.sicDesc = newSicDesc;
    }

    /**
     * Gets danDbCompanyId of Account.
     *
     * @return danDbCompanyId of Account.
     */
    public Object getDanDbCompanyId() {
        return danDbCompanyId;
    }

    /**
     * Sets danDbCompanyId of Account.
     *
     * @param newDanDbCompanyId of Account.
     */
    public void setDanDbCompanyId(final Object newDanDbCompanyId) {
        this.danDbCompanyId = newDanDbCompanyId;
    }

    /**
     * Gets operatingHoursId of Account.
     *
     * @return operatingHoursId of Account.
     */
    public Object getOperatingHoursId() {
        return operatingHoursId;
    }

    /**
     * Sets operatingHoursId of Account.
     *
     * @param newOperatingHoursId of Account.
     */
    public void setOperatingHoursId(final Object newOperatingHoursId) {
        this.operatingHoursId = newOperatingHoursId;
    }

    /**
     * Gets customerPriorityC of Account.
     *
     * @return customerPriorityC of Account.
     */
    public String getCustomerPriorityC() {
        return customerPriorityC;
    }

    /**
     * Sets customerPriorityC of Account.
     *
     * @param newCustomerPriorityC of Account.
     */
    public void setCustomerPriorityC(final String newCustomerPriorityC) {
        this.customerPriorityC = newCustomerPriorityC;
    }

    /**
     * Gets slaC of Account.
     *
     * @return slaC of Account.
     */
    public String getSlaC() {
        return slaC;
    }

    /**
     * Sets slaC of Account.
     *
     * @param newSlaC of Account.
     */
    public void setSlaC(final String newSlaC) {
        this.slaC = newSlaC;
    }

    /**
     * Gets activeC of Account.
     *
     * @return activeC of Account.
     */
    public String getActiveC() {
        return activeC;
    }

    /**
     * Sets activeC of Account.
     *
     * @param newActiveC of Account.
     */
    public void setActiveC(final String newActiveC) {
        this.activeC = newActiveC;
    }

    /**
     * Gets numberOfLocationsC of Account.
     *
     * @return numberOfLocationsC of Account.
     */
    public Double getNumberOfLocationsC() {
        return numberOfLocationsC;
    }

    /**
     * Sets numberOfLocationsC of Account.
     *
     * @param newNumberOfLocationsC of Account.
     */
    public void setNumberOfLocationsC(final Double newNumberOfLocationsC) {
        this.numberOfLocationsC = newNumberOfLocationsC;
    }

    /**
     * Gets upsellOpportunityC of Account.
     *
     * @return upsellOpportunityC of Account.
     */
    public String getUpsellOpportunityC() {
        return upsellOpportunityC;
    }

    /**
     * Sets upsellOpportunityC of Account.
     *
     * @param newUpsellOpportunityC of Account.
     */
    public void setUpsellOpportunityC(final String newUpsellOpportunityC) {
        this.upsellOpportunityC = newUpsellOpportunityC;
    }

    /**
     * Gets slaSerialNumberC of Account.
     *
     * @return slaSerialNumberC of Account.
     */
    public String getSlaSerialNumberC() {
        return slaSerialNumberC;
    }

    /**
     * Sets slaSerialNumberC of Account.
     *
     * @param newSlaSerialNumberC of Account.
     */
    public void setSlaSerialNumberC(final String newSlaSerialNumberC) {
        this.slaSerialNumberC = newSlaSerialNumberC;
    }

    /**
     * Gets slaExpirationDateC of Account.
     *
     * @return slaExpirationDateC of Account.
     */
    public String getSlaExpirationDateC() {
        return slaExpirationDateC;
    }

    /**
     * Sets slaExpirationDateC of Account.
     *
     * @param newSlaExpirationDateC of Account.
     */
    public void setSlaExpirationDateC(final String newSlaExpirationDateC) {
        this.slaExpirationDateC = newSlaExpirationDateC;
    }
}
