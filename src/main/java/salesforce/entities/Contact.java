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
import salesforce.entities.support.MailingAddress;
import salesforce.entities.support.OtherAddress;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    public Object masterRecordId;
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("Salutation")
    public String salutation;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("OtherStreet")
    public String otherStreet;
    @JsonProperty("OtherCity")
    public String otherCity;
    @JsonProperty("OtherState")
    public String otherState;
    @JsonProperty("OtherPostalCode")
    public String otherPostalCode;
    @JsonProperty("OtherCountry")
    public String otherCountry;
    @JsonProperty("OtherLatitude")
    public Object otherLatitude;
    @JsonProperty("OtherLongitude")
    public Object otherLongitude;
    @JsonProperty("OtherGeocodeAccuracy")
    public Object otherGeocodeAccuracy;
    @JsonProperty("OtherAddress")
    public OtherAddress otherAddress;
    @JsonProperty("MailingStreet")
    public String mailingStreet;
    @JsonProperty("MailingCity")
    public String mailingCity;
    @JsonProperty("MailingState")
    public String mailingState;
    @JsonProperty("MailingPostalCode")
    public String mailingPostalCode;
    @JsonProperty("MailingCountry")
    public String mailingCountry;
    @JsonProperty("MailingLatitude")
    public Object mailingLatitude;
    @JsonProperty("MailingLongitude")
    public Object mailingLongitude;
    @JsonProperty("MailingGeocodeAccuracy")
    public Object mailingGeocodeAccuracy;
    @JsonProperty("MailingAddress")
    public MailingAddress mailingAddress;
    @JsonProperty("Phone")
    public String phone;
    @JsonProperty("Fax")
    public String fax;
    @JsonProperty("MobilePhone")
    public String mobilePhone;
    @JsonProperty("HomePhone")
    public String homePhone;
    @JsonProperty("OtherPhone")
    public String otherPhone;
    @JsonProperty("AssistantPhone")
    public String assistantPhone;
    @JsonProperty("ReportsToId")
    public String reportsToId;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Department")
    public String department;
    @JsonProperty("AssistantName")
    public String assistantName;
    @JsonProperty("LeadSource")
    public String leadSource;
    @JsonProperty("Birthdate")
    public String birthdate;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public Date systemModStamp;
    @JsonProperty("LastActivityDate")
    public Object lastActivityDate;
    @JsonProperty("LastCURequestDate")
    public Object lastCuRequestDate;
    @JsonProperty("LastCUUpdateDate")
    public Object lastCuUpdateDate;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("EmailBouncedReason")
    public Object emailBouncedReason;
    @JsonProperty("EmailBouncedDate")
    public Object emailBouncedDate;
    @JsonProperty("IsEmailBounced")
    public Boolean isEmailBounced;
    @JsonProperty("PhotoUrl")
    public String photoUrl;
    @JsonProperty("Jigsaw")
    public Object jigsaw;
    @JsonProperty("JigsawContactId")
    public Object jigsawContactId;
    @JsonProperty("CleanStatus")
    public String cleanStatus;
    @JsonProperty("IndividualId")
    public Object individualId;
    @JsonProperty("Level__c")
    public String levelC;
    @JsonProperty("Languages__c")
    public String languagesC;

    /**
     * Gets attributes of Contact.
     *
     * @return attributes of Contact.
     */
    public Attribute getAttributes() {
        return attributes;
    }

    /**
     * Sets attributes of Contact.
     *
     * @param newAttributes of Contact.
     */
    public void setAttributes(final Attribute newAttributes) {
        this.attributes = newAttributes;
    }

    /**
     * Gets id of Contact.
     *
     * @return id of Contact.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id of Contact.
     *
     * @param newId of Contact.
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets isDeleted of Contact.
     *
     * @return isDeleted of Contact.
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets isDeleted of Contact.
     *
     * @param newIsDeleted of Contact.
     */
    public void setIsDeleted(final Boolean newIsDeleted) {
        this.isDeleted = newIsDeleted;
    }

    /**
     * Gets masterRecordId of Contact.
     *
     * @return masterRecordId of Contact.
     */
    public Object getMasterRecordId() {
        return masterRecordId;
    }

    /**
     * Sets masterRecordId of Contact.
     *
     * @param newMasterRecordId of Contact.
     */
    public void setMasterRecordId(final Object newMasterRecordId) {
        this.masterRecordId = newMasterRecordId;
    }

    /**
     * Gets accountId of Contact.
     *
     * @return accountId of Contact.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets accountId of Contact.
     *
     * @param newAccountId of Contact.
     */
    public void setAccountId(final String newAccountId) {
        this.accountId = newAccountId;
    }

    /**
     * Gets lastName of Contact.
     *
     * @return lastName of Contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets lastName of Contact.
     *
     * @param newLastName of Contact.
     */
    public void setLastName(final String newLastName) {
        this.lastName = newLastName;
    }

    /**
     * Gets firstName of Contact.
     *
     * @return firstName of Contact.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets firstName of Contact.
     *
     * @param newFirstName of Contact.
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * Gets salutation of Contact.
     *
     * @return salutation of Contact.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets salutation of Contact.
     *
     * @param newSalutation of Contact.
     */
    public void setSalutation(final String newSalutation) {
        this.salutation = newSalutation;
    }

    /**
     * Gets name of Contact.
     *
     * @return name of Contact.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of Contact.
     *
     * @param newName of Contact.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets otherStreet of Contact.
     *
     * @return otherStreet of Contact.
     */
    public String getOtherStreet() {
        return otherStreet;
    }

    /**
     * Sets otherStreet of Contact.
     *
     * @param newOtherStreet of Contact.
     */
    public void setOtherStreet(final String newOtherStreet) {
        this.otherStreet = newOtherStreet;
    }

    /**
     * Gets otherCity of Contact.
     *
     * @return otherCity of Contact.
     */
    public String getOtherCity() {
        return otherCity;
    }

    /**
     * Sets otherCity of Contact.
     *
     * @param newOtherCity of Contact.
     */
    public void setOtherCity(final String newOtherCity) {
        this.otherCity = newOtherCity;
    }

    /**
     * Gets otherState of Contact.
     *
     * @return otherState of Contact.
     */
    public String getOtherState() {
        return otherState;
    }

    /**
     * Sets otherState of Contact.
     *
     * @param newOtherState of Contact.
     */
    public void setOtherState(final String newOtherState) {
        this.otherState = newOtherState;
    }

    /**
     * Gets otherPostalCode of Contact.
     *
     * @return otherPostalCode of Contact.
     */
    public String getOtherPostalCode() {
        return otherPostalCode;
    }

    /**
     * Sets otherPostalCode of Contact.
     *
     * @param newOtherPostalCode of Contact.
     */
    public void setOtherPostalCode(final String newOtherPostalCode) {
        this.otherPostalCode = newOtherPostalCode;
    }

    /**
     * Gets otherCountry of Contact.
     *
     * @return otherCountry of Contact.
     */
    public String getOtherCountry() {
        return otherCountry;
    }

    /**
     * Sets otherCountry of Contact.
     *
     * @param newOtherCountry of Contact.
     */
    public void setOtherCountry(final String newOtherCountry) {
        this.otherCountry = newOtherCountry;
    }

    /**
     * Gets otherLatitude of Contact.
     *
     * @return otherLatitude of Contact.
     */
    public Object getOtherLatitude() {
        return otherLatitude;
    }

    /**
     * Sets otherLatitude of Contact.
     *
     * @param newOtherLatitude of Contact.
     */
    public void setOtherLatitude(final Object newOtherLatitude) {
        this.otherLatitude = newOtherLatitude;
    }

    /**
     * Gets otherLongitude of Contact.
     *
     * @return otherLongitude of Contact.
     */
    public Object getOtherLongitude() {
        return otherLongitude;
    }

    /**
     * Sets otherLongitude of Contact.
     *
     * @param newOtherLongitude of Contact.
     */
    public void setOtherLongitude(final Object newOtherLongitude) {
        this.otherLongitude = newOtherLongitude;
    }

    /**
     * Gets otherGeocodeAccuracy of Contact.
     *
     * @return otherGeocodeAccuracy of Contact.
     */
    public Object getOtherGeocodeAccuracy() {
        return otherGeocodeAccuracy;
    }

    /**
     * Sets otherGeocodeAccuracy of Contact.
     *
     * @param newOtherGeocodeAccuracy of Contact.
     */
    public void setOtherGeocodeAccuracy(final Object newOtherGeocodeAccuracy) {
        this.otherGeocodeAccuracy = otherGeocodeAccuracy;
    }

    /**
     * Gets otherAddress of Contact.
     *
     * @return otherAddress of Contact.
     */
    public OtherAddress getOtherAddress() {
        return otherAddress;
    }

    /**
     * Sets otherAddress of Contact.
     *
     * @param newOtherAddress of Contact.
     */
    public void setOtherAddress(final OtherAddress newOtherAddress) {
        this.otherAddress = newOtherAddress;
    }

    /**
     * Gets mailingStreet of Contact.
     *
     * @return mailingStreet of Contact.
     */
    public String getMailingStreet() {
        return mailingStreet;
    }

    /**
     * Sets mailingStreet of Contact.
     *
     * @param newMailingStreet of Contact.
     */
    public void setMailingStreet(final String newMailingStreet) {
        this.mailingStreet = newMailingStreet;
    }

    /**
     * Gets mailingCity of Contact.
     *
     * @return mailingCity of Contact.
     */
    public String getMailingCity() {
        return mailingCity;
    }

    /**
     * Sets mailingCity of Contact.
     *
     * @param newMailingCity of Contact.
     */
    public void setMailingCity(final String newMailingCity) {
        this.mailingCity = newMailingCity;
    }

    /**
     * Gets mailingState of Contact.
     *
     * @return mailingState of Contact.
     */
    public String getMailingState() {
        return mailingState;
    }

    /**
     * Sets mailingState of Contact.
     *
     * @param newMailingState of Contact.
     */
    public void setMailingState(final String newMailingState) {
        this.mailingState = newMailingState;
    }

    /**
     * Gets mailingPostalCode of Contact.
     *
     * @return mailingPostalCode of Contact.
     */
    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    /**
     * Sets mailingPostalCode of Contact.
     *
     * @param newMailingPostalCode of Contact.
     */
    public void setMailingPostalCode(final String newMailingPostalCode) {
        this.mailingPostalCode = newMailingPostalCode;
    }

    /**
     * Gets mailingCountry of Contact.
     *
     * @return mailingCountry of Contact.
     */
    public String getMailingCountry() {
        return mailingCountry;
    }

    /**
     * Sets mailingCountry of Contact.
     *
     * @param newMailingCountry of Contact.
     */
    public void setMailingCountry(final String newMailingCountry) {
        this.mailingCountry = newMailingCountry;
    }

    /**
     * Gets mailingLatitude of Contact.
     *
     * @return mailingLatitude of Contact.
     */
    public Object getMailingLatitude() {
        return mailingLatitude;
    }

    /**
     * Sets mailingLatitude of Contact.
     *
     * @param newMailingLatitude of Contact.
     */
    public void setMailingLatitude(final Object newMailingLatitude) {
        this.mailingLatitude = newMailingLatitude;
    }

    /**
     * Gets mailingLongitude of Contact.
     *
     * @return mailingLongitude of Contact.
     */
    public Object getMailingLongitude() {
        return mailingLongitude;
    }

    /**
     * Sets mailingLongitude of Contact.
     *
     * @param newMailingLongitude of Contact.
     */
    public void setMailingLongitude(final Object newMailingLongitude) {
        this.mailingLongitude = newMailingLongitude;
    }

    /**
     * Gets mailingGeocodeAccuracy of Contact.
     *
     * @return mailingGeocodeAccuracy of Contact.
     */
    public Object getMailingGeocodeAccuracy() {
        return mailingGeocodeAccuracy;
    }

    /**
     * Sets mailingGeocodeAccuracy of Contact.
     *
     * @param newMailingGeocodeAccuracy of Contact.
     */
    public void setMailingGeocodeAccuracy(final Object newMailingGeocodeAccuracy) {
        this.mailingGeocodeAccuracy = newMailingGeocodeAccuracy;
    }

    /**
     * Gets mailingAddress of Contact.
     *
     * @return mailingAddress of Contact.
     */
    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets mailingAddress of Contact.
     *
     * @param newMailingAddress of Contact.
     */
    public void setMailingAddress(final MailingAddress newMailingAddress) {
        this.mailingAddress = newMailingAddress;
    }

    /**
     * Gets phone of Contact.
     *
     * @return phone of Contact.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone of Contact.
     *
     * @param newPhone of Contact.
     */
    public void setPhone(final String newPhone) {
        this.phone = newPhone;
    }

    /**
     * Gets fax of Contact.
     *
     * @return fax of Contact.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets fax of Contact.
     *
     * @param newFax of Contact.
     */
    public void setFax(final String newFax) {
        this.fax = newFax;
    }

    /**
     * Gets mobilePhone of Contact.
     *
     * @return mobilePhone of Contact.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets mobilePhone of Contact.
     *
     * @param newMobilePhone of Contact.
     */
    public void setMobilePhone(final String newMobilePhone) {
        this.mobilePhone = newMobilePhone;
    }

    /**
     * Gets homePhone of Contact.
     *
     * @return homePhone of Contact.
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets homePhone of Contact.
     *
     * @param newHomePhone of Contact.
     */
    public void setHomePhone(final String newHomePhone) {
        this.homePhone = newHomePhone;
    }

    /**
     * Gets otherPhone of Contact.
     *
     * @return otherPhone of Contact.
     */
    public String getOtherPhone() {
        return otherPhone;
    }

    /**
     * Sets otherPhone of Contact.
     *
     * @param newOtherPhone of Contact.
     */
    public void setOtherPhone(final String newOtherPhone) {
        this.otherPhone = newOtherPhone;
    }

    /**
     * Gets assistantPhone of Contact.
     *
     * @return assistantPhone of Contact.
     */
    public String getAssistantPhone() {
        return assistantPhone;
    }

    /**
     * Sets assistantPhone of Contact.
     *
     * @param newAssistantPhone of Contact.
     */
    public void setAssistantPhone(final String newAssistantPhone) {
        this.assistantPhone = newAssistantPhone;
    }

    /**
     * Gets reportsToId of Contact.
     *
     * @return reportsToId of Contact.
     */
    public String getReportsToId() {
        return reportsToId;
    }

    /**
     * Sets reportsToId of Contact.
     *
     * @param newReportsToId of Contact.
     */
    public void setReportsToId(final String newReportsToId) {
        this.reportsToId = newReportsToId;
    }

    /**
     * Gets email of Contact.
     *
     * @return email of Contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email of Contact.
     *
     * @param newEmail of Contact.
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
    }

    /**
     * Gets title of Contact.
     *
     * @return title of Contact.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of Contact.
     *
     * @param newTitle of Contact.
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Gets department of Contact.
     *
     * @return department of Contact.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department of Contact.
     *
     * @param newDepartment of Contact.
     */
    public void setDepartment(final String newDepartment) {
        this.department = newDepartment;
    }

    /**
     * Gets assistantName of Contact.
     *
     * @return assistantName of Contact.
     */
    public String getAssistantName() {
        return assistantName;
    }

    /**
     * Sets assistantName of Contact.
     *
     * @param newAssistantName of Contact.
     */
    public void setAssistantName(final String newAssistantName) {
        this.assistantName = newAssistantName;
    }

    /**
     * Gets leadSource of Contact.
     *
     * @return leadSource of Contact.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Sets leadSource of Contact.
     *
     * @param newLeadSource of Contact.
     */
    public void setLeadSource(final String newLeadSource) {
        this.leadSource = newLeadSource;
    }

    /**
     * Gets birthdate of Contact.
     *
     * @return birthdate of Contact.
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets birthdate of Contact.
     *
     * @param newBirthdate of Contact.
     */
    public void setBirthdate(final String newBirthdate) {
        this.birthdate = newBirthdate;
    }

    /**
     * Gets description of Contact.
     *
     * @return description of Contact.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description of Contact.
     *
     * @param newDescription of Contact.
     */
    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * Gets ownerId of Contact.
     *
     * @return ownerId of Contact.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets ownerId of Contact.
     *
     * @param newOwnerId of Contact.
     */
    public void setOwnerId(final String newOwnerId) {
        this.ownerId = newOwnerId;
    }

    /**
     * Gets createdDate of Contact.
     *
     * @return createdDate of Contact.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets createdDate of Contact.
     *
     * @param newCreatedDate of Contact.
     */
    public void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    /**
     * Gets createdById of Contact.
     *
     * @return createdById of Contact.
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Sets createdById of Contact.
     *
     * @param newCreatedById of Contact.
     */
    public void setCreatedById(final String newCreatedById) {
        this.createdById = newCreatedById;
    }

    /**
     * Gets lastModifiedDate of Contact.
     *
     * @return lastModifiedDate of Contact.
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets lastModifiedDate of Contact.
     *
     * @param newLastModifiedDate of Contact.
     */
    public void setLastModifiedDate(final Date newLastModifiedDate) {
        this.lastModifiedDate = newLastModifiedDate;
    }

    /**
     * Gets lastModifiedById of Contact.
     *
     * @return lastModifiedById of Contact.
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    /**
     * Sets lastModifiedById of Contact.
     *
     * @param newLastModifiedById of Contact.
     */
    public void setLastModifiedById(final String newLastModifiedById) {
        this.lastModifiedById = newLastModifiedById;
    }

    /**
     * Gets systemModStamp of Contact.
     *
     * @return systemModStamp of Contact.
     */
    public Date getSystemModStamp() {
        return systemModStamp;
    }

    /**
     * Sets systemModStamp of Contact.
     *
     * @param newSystemModStamp of Contact.
     */
    public void setSystemModStamp(final Date newSystemModStamp) {
        this.systemModStamp = newSystemModStamp;
    }

    /**
     * Gets lastActivityDate of Contact.
     *
     * @return lastActivityDate of Contact.
     */
    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * Sets lastActivityDate of Contact.
     *
     * @param newLastActivityDate of Contact.
     */
    public void setLastActivityDate(final Object newLastActivityDate) {
        this.lastActivityDate = newLastActivityDate;
    }

    /**
     * Gets lastCuRequestDate of Contact.
     *
     * @return lastCuRequestDate of Contact.
     */
    public Object getLastCuRequestDate() {
        return lastCuRequestDate;
    }

    /**
     * Sets lastCuRequestDate of Contact.
     *
     * @param newLastCuRequestDate of Contact.
     */
    public void setLastCuRequestDate(final Object newLastCuRequestDate) {
        this.lastCuRequestDate = newLastCuRequestDate;
    }

    /**
     * Gets lastCuUpdateDate of Contact.
     *
     * @return lastCuUpdateDate of Contact.
     */
    public Object getLastCuUpdateDate() {
        return lastCuUpdateDate;
    }

    /**
     * Sets lastCuUpdateDate of Contact.
     *
     * @param newLastCuUpdateDate of Contact.
     */
    public void setLastCuUpdateDate(final Object newLastCuUpdateDate) {
        this.lastCuUpdateDate = newLastCuUpdateDate;
    }

    /**
     * Gets lastViewedDate of Contact.
     *
     * @return lastViewedDate of Contact.
     */
    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    /**
     * Sets lastViewedDate of Contact.
     *
     * @param newLastViewedDate of Contact.
     */
    public void setLastViewedDate(final Date newLastViewedDate) {
        this.lastViewedDate = newLastViewedDate;
    }

    /**
     * Gets lastReferencedDate of Contact.
     *
     * @return lastReferencedDate of Contact.
     */
    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    /**
     * Sets lastReferencedDate of Contact.
     *
     * @param newLastReferencedDate of Contact.
     */
    public void setLastReferencedDate(final Date newLastReferencedDate) {
        this.lastReferencedDate = newLastReferencedDate;
    }

    /**
     * Gets emailBouncedReason of Contact.
     *
     * @return emailBouncedReason of Contact.
     */
    public Object getEmailBouncedReason() {
        return emailBouncedReason;
    }

    /**
     * Sets emailBouncedReason of Contact.
     *
     * @param newEmailBouncedReason of Contact.
     */
    public void setEmailBouncedReason(final Object newEmailBouncedReason) {
        this.emailBouncedReason = newEmailBouncedReason;
    }

    /**
     * Gets emailBouncedDate of Contact.
     *
     * @return emailBouncedDate of Contact.
     */
    public Object getEmailBouncedDate() {
        return emailBouncedDate;
    }

    /**
     * Sets emailBouncedDate of Contact.
     *
     * @param newEmailBouncedDate of Contact.
     */
    public void setEmailBouncedDate(final Object newEmailBouncedDate) {
        this.emailBouncedDate = newEmailBouncedDate;
    }

    /**
     * Gets isEmailBounced of Contact.
     *
     * @return isEmailBounced of Contact.
     */
    public Boolean getIsEmailBounced() {
        return isEmailBounced;
    }

    /**
     * Sets isEmailBounced of Contact.
     *
     * @param newIsEmailBounced of Contact.
     */
    public void setIsEmailBounced(final Boolean newIsEmailBounced) {
        this.isEmailBounced = newIsEmailBounced;
    }

    /**
     * Gets photoUrl of Contact.
     *
     * @return photoUrl of Contact.
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * Sets photoUrl of Contact.
     *
     * @param newPhotoUrl of Contact.
     */
    public void setPhotoUrl(final String newPhotoUrl) {
        this.photoUrl = newPhotoUrl;
    }

    /**
     * Gets jigsaw of Contact.
     *
     * @return jigsaw of Contact.
     */
    public Object getJigsaw() {
        return jigsaw;
    }

    /**
     * Sets jigsaw of Contact.
     *
     * @param newJigsaw of Contact.
     */
    public void setJigsaw(final Object newJigsaw) {
        this.jigsaw = newJigsaw;
    }

    /**
     * Gets jigsawContactId of Contact.
     *
     * @return jigsawContactId of Contact.
     */
    public Object getJigsawContactId() {
        return jigsawContactId;
    }

    /**
     * Sets jigsawContactId of Contact.
     *
     * @param newJigsawContactId of Contact.
     */
    public void setJigsawContactId(final Object newJigsawContactId) {
        this.jigsawContactId = newJigsawContactId;
    }

    /**
     * Gets cleanStatus of Contact.
     *
     * @return cleanStatus of Contact.
     */
    public String getCleanStatus() {
        return cleanStatus;
    }

    /**
     * Sets cleanStatus of Contact.
     *
     * @param newCleanStatus of Contact.
     */
    public void setCleanStatus(final String newCleanStatus) {
        this.cleanStatus = newCleanStatus;
    }

    /**
     * Gets individualId of Contact.
     *
     * @return individualId of Contact.
     */
    public Object getIndividualId() {
        return individualId;
    }

    /**
     * Sets individualId of Contact.
     *
     * @param newIndividualId of Contact.
     */
    public void setIndividualId(final Object newIndividualId) {
        this.individualId = newIndividualId;
    }

    /**
     * Gets levelC of Contact.
     *
     * @return levelC of Contact.
     */
    public String getLevelC() {
        return levelC;
    }

    /**
     * Sets levelC of Contact.
     *
     * @param newLevelC of Contact.
     */
    public void setLevelC(final String newLevelC) {
        this.levelC = newLevelC;
    }

    /**
     * Gets languagesC of Contact.
     *
     * @return languagesC of Contact.
     */
    public String getLanguagesC() {
        return languagesC;
    }

    /**
     * Sets languagesC of Contact.
     *
     * @param newLanguagesC of Contact.
     */
    public void setLanguagesC(final String newLanguagesC) {
        this.languagesC = newLanguagesC;
    }
}
