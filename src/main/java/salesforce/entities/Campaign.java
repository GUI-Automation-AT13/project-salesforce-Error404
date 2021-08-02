/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Campaign {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String isDeleted;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String startDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String expectedRevenue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String budgetedCost;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String actualCost;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String expectedResponse;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberSent;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String isActive;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfLeads;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfConvertedLeads;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfContacts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfResponses;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfWonOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String amountAllOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String amountWonOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ownerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastActivityDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String campaignMemberRecordTypeId;

    /**
     * Gets the Id.
     *
     * @return the Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param idNew to be set.
     */
    public void setId(final String idNew) {
        this.id = idNew;
    }

    /**
     * Gets the IsDeleted.
     *
     * @return the IsDeleted.
     */
    public String isDeleted() {
        return isDeleted;
    }

    /**
     * Sets the deleted.
     *
     * @param deletedNew to be set.
     */
    public void setDeleted(final String deletedNew) {
        this.isDeleted = deletedNew;
    }

    /**
     * Gets the Name.
     *
     * @return the Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param nameNew to be set.
     */
    public void setName(final String nameNew) {
        this.name = nameNew;
    }

    /**
     * Gets the ParentId.
     *
     * @return the ParentId.
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the parentId.
     *
     * @param parentIdNew to be set.
     */
    public void setParentId(final String parentIdNew) {
        this.parentId = parentIdNew;
    }

    /**
     * Gets the Type.
     *
     * @return the Type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param typeNew to be set.
     */
    public void setType(final String typeNew) {
        this.type = typeNew;
    }

    /**
     * Gets the Status.
     *
     * @return the Status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param statusNew to be set.
     */
    public void setStatus(final String statusNew) {
        this.status = statusNew;
    }

    /**
     * Gets the StartDate.
     *
     * @return the StartDate.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the startDate.
     *
     * @param startDateNew to be set.
     */
    public void setStartDate(final String startDateNew) {
        this.startDate = startDateNew;
    }

    /**
     * Gets the EndDate.
     *
     * @return the EndDate.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the endDate.
     *
     * @param endDateNew to be set.
     */
    public void setEndDate(final String endDateNew) {
        this.endDate = endDateNew;
    }

    /**
     * Gets the ExpectedRevenue.
     *
     * @return the ExpectedRevenue.
     */
    public String getExpectedRevenue() {
        return expectedRevenue;
    }

    /**
     * Sets the expectedRevenue.
     *
     * @param expectedRevenueNew to be set.
     */
    public void setExpectedRevenue(final String expectedRevenueNew) {
        this.expectedRevenue = expectedRevenueNew;
    }

    /**
     * Gets the BudgetedCost.
     *
     * @return the BudgetedCost.
     */
    public String getBudgetedCost() {
        return budgetedCost;
    }

    /**
     * Sets the budgetedCost.
     *
     * @param budgetedCostNew to be set.
     */
    public void setBudgetedCost(final String budgetedCostNew) {
        this.budgetedCost = budgetedCostNew;
    }

    /**
     * Gets the ActualCost.
     *
     * @return the ActualCost.
     */
    public String getActualCost() {
        return actualCost;
    }

    /**
     * Sets the actualCost.
     *
     * @param actualCostNew to be set.
     */
    public void setActualCost(final String actualCostNew) {
        this.actualCost = actualCostNew;
    }

    /**
     * Gets the ExpectedResponse.
     *
     * @return the ExpectedResponse.
     */
    public String getExpectedResponse() {
        return expectedResponse;
    }

    /**
     * Sets the expectedResponse.
     *
     * @param expectedResponseNew to be set.
     */
    public void setExpectedResponse(final String expectedResponseNew) {
        this.expectedResponse = expectedResponseNew;
    }

    /**
     * Gets the NumberSent.
     *
     * @return the NumberSent.
     */
    public String getNumberSent() {
        return numberSent;
    }

    /**
     * Sets the numberSent.
     *
     * @param numberSentNew to be set.
     */
    public void setNumberSent(final String numberSentNew) {
        this.numberSent = numberSentNew;
    }

    /**
     * Gets the IsActive.
     *
     * @return the IsActive.
     */
    public String isActive() {
        return isActive;
    }

    /**
     * Sets the active.
     *
     * @param activeNew to be set.
     */
    public void setActive(final String activeNew) {
        isActive = activeNew;
    }

    /**
     * Gets the Description.
     *
     * @return the Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param descriptionNew to be set.
     */
    public void setDescription(final String descriptionNew) {
        this.description = descriptionNew;
    }

    /**
     * Gets the NumberOfLeads.
     *
     * @return the NumberOfLeads.
     */
    public String getNumberOfLeads() {
        return numberOfLeads;
    }

    /**
     * Sets the numberOfLeads.
     *
     * @param numberOfLeadsNew to be set.
     */
    public void setNumberOfLeads(final String numberOfLeadsNew) {
        this.numberOfLeads = numberOfLeadsNew;
    }

    /**
     * Gets the NumberOfConvertedLeads.
     *
     * @return the NumberOfConvertedLeads.
     */
    public String getNumberOfConvertedLeads() {
        return numberOfConvertedLeads;
    }

    /**
     * Sets the numberOfConvertedLeads.
     *
     * @param numberOfConvertedLeadsNew to be set.
     */
    public void setNumberOfConvertedLeads(final String numberOfConvertedLeadsNew) {
        this.numberOfConvertedLeads = numberOfConvertedLeadsNew;
    }

    /**
     * Gets the NumberOfContacts.
     *
     * @return the NumberOfContacts.
     */
    public String getNumberOfContacts() {
        return numberOfContacts;
    }

    /**
     * Sets the numberOfContacts.
     *
     * @param numberOfContactsNew to be set.
     */
    public void setNumberOfContacts(final String numberOfContactsNew) {
        this.numberOfContacts = numberOfContactsNew;
    }

    /**
     * Gets the NumberOfResponses.
     *
     * @return the NumberOfResponses.
     */
    public String getNumberOfResponses() {
        return numberOfResponses;
    }

    /**
     * Sets the numberOfResponses.
     *
     * @param numberOfResponsesNew to be set.
     */
    public void setNumberOfResponses(final String numberOfResponsesNew) {
        this.numberOfResponses = numberOfResponsesNew;
    }

    /**
     * Gets the NumberOfOpportunities.
     *
     * @return the NumberOfOpportunities.
     */
    public String getNumberOfOpportunities() {
        return numberOfOpportunities;
    }

    /**
     * Sets the numberOfOpportunities.
     *
     * @param numberOfOpportunitiesNew to be set.
     */
    public void setNumberOfOpportunities(final String numberOfOpportunitiesNew) {
        this.numberOfOpportunities = numberOfOpportunitiesNew;
    }

    /**
     * Gets the NumberOfWonOpportunities.
     *
     * @return the NumberOfWonOpportunities.
     */
    public String getNumberOfWonOpportunities() {
        return numberOfWonOpportunities;
    }

    /**
     * Sets the numberOfWonOpportunities.
     *
     * @param numberOfWonOpportunitiesNew to be set.
     */
    public void setNumberOfWonOpportunities(final String numberOfWonOpportunitiesNew) {
        this.numberOfWonOpportunities = numberOfWonOpportunitiesNew;
    }

    /**
     * Gets the AmountAllOpportunities.
     *
     * @return the AmountAllOpportunities.
     */
    public String getAmountAllOpportunities() {
        return amountAllOpportunities;
    }

    /**
     * Sets the amountAllOpportunities.
     *
     * @param amountAllOpportunitiesNew to be set.
     */
    public void setAmountAllOpportunities(final String amountAllOpportunitiesNew) {
        this.amountAllOpportunities = amountAllOpportunitiesNew;
    }

    /**
     * Gets the AmountWonOpportunities.
     *
     * @return the AmountWonOpportunities.
     */
    public String getAmountWonOpportunities() {
        return amountWonOpportunities;
    }

    /**
     * Sets the amountWonOpportunities.
     *
     * @param amountWonOpportunitiesNew to be set.
     */
    public void setAmountWonOpportunities(final String amountWonOpportunitiesNew) {
        this.amountWonOpportunities = amountWonOpportunitiesNew;
    }

    /**
     * Gets the OwnerId.
     *
     * @return the OwnerId.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the ownerId.
     *
     * @param ownerIdNew to be set.
     */
    public void setOwnerId(final String ownerIdNew) {
        this.ownerId = ownerIdNew;
    }

    /**
     * Gets the CreatedDate.
     *
     * @return the CreatedDate.
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the createdDate.
     *
     * @param createdDateNew to be set.
     */
    public void setCreatedDate(final String createdDateNew) {
        this.createdDate = createdDateNew;
    }

    /**
     * Gets the CreatedById.
     *
     * @return the CreatedById.
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Sets the createdById.
     *
     * @param createdByIdNew to be set.
     */
    public void setCreatedById(final String createdByIdNew) {
        this.createdById = createdByIdNew;
    }

    /**
     * Gets the LastModifiedDate.
     *
     * @return the LastModifiedDate.
     */
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate.
     *
     * @param lastModifiedDateNew to be set.
     */
    public void setLastModifiedDate(final String lastModifiedDateNew) {
        this.lastModifiedDate = lastModifiedDateNew;
    }

    /**
     * Gets the LastModifiedById.
     *
     * @return the LastModifiedById.
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    /**
     * Sets the lastModifiedById.
     *
     * @param lastModifiedByIdNew to be set.
     */
    public void setLastModifiedById(final String lastModifiedByIdNew) {
        this.lastModifiedById = lastModifiedByIdNew;
    }

    /**
     * Gets the SystemModstamp.
     *
     * @return the SystemModstamp.
     */
    public String getSystemModstamp() {
        return systemModstamp;
    }

    /**
     * Sets the systemModstamp.
     *
     * @param systemModstampNew to be set.
     */
    public void setSystemModstamp(final String systemModstampNew) {
        this.systemModstamp = systemModstampNew;
    }

    /**
     * Gets the LastActivityDate.
     *
     * @return the LastActivityDate.
     */
    public String getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * Sets the lastActivityDate.
     *
     * @param lastActivityDateNew to be set.
     */
    public void setLastActivityDate(final String lastActivityDateNew) {
        this.lastActivityDate = lastActivityDateNew;
    }

    /**
     * Gets the LastViewedDate.
     *
     * @return the LastViewedDate.
     */
    public String getLastViewedDate() {
        return lastViewedDate;
    }

    /**
     * Sets the lastViewedDate.
     *
     * @param lastViewedDateNew to be set.
     */
    public void setLastViewedDate(final String lastViewedDateNew) {
        this.lastViewedDate = lastViewedDateNew;
    }

    /**
     * Gets the LastReferencedDate.
     *
     * @return the LastReferencedDate.
     */
    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    /**
     * Sets the lastReferencedDate.
     *
     * @param lastReferencedDateNew to be set.
     */
    public void setLastReferencedDate(final String lastReferencedDateNew) {
        this.lastReferencedDate = lastReferencedDateNew;
    }

    /**
     * Gets the CampaignMemberRecordTypeId.
     *
     * @return the CampaignMemberRecordTypeId.
     */
    public String getCampaignMemberRecordTypeId() {
        return campaignMemberRecordTypeId;
    }

    /**
     * Sets the campaignMemberRecordTypeId.
     *
     * @param campaignMemberRecordTypeIdNew to be set.
     */
    public void setCampaignMemberRecordTypeId(final String campaignMemberRecordTypeIdNew) {
        this.campaignMemberRecordTypeId = campaignMemberRecordTypeIdNew;
    }
}
