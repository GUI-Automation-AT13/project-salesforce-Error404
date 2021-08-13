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
import salesforce.utils.StringDateConverter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Opportunity {
    @JsonProperty("OpportunityName")
    private String opportunityName;
    @JsonProperty("NextStep")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nextStep;
    @JsonProperty("Amount")
    private double amount;
    @JsonProperty("CloseDate")
    private String closeDate;
    @JsonProperty("Stage")
    private String opportunityStage;
    @JsonProperty("Type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String typeOption;
    @JsonProperty("LeadSource")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String leadSource;
    @JsonProperty("Delivery")
    private String deliveryOption;
    @JsonProperty("Probability")
    private String probability;
    @JsonProperty("OrderNumber")
    private String orderNumber;
    @JsonProperty("CurrentGenerator")
    private String currentGenerator;
    @JsonProperty("TrackingNumber")
    private String trackingNumber;
    @JsonProperty("MainCompetitor")
    private String mainComp;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String searchAccount;
    @JsonProperty("Campaign")
    private String searchCampaign;
    @JsonProperty("Private")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isPrivate;
    private Map<String, String> mapFields;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Opportunity() {
        setCreatedDate("TODAY");
        setUpdatedDate(this.createdDate);
    }

    /**
     * Returns the Opportunity name.
     *
     * @return string of the name.
     */
    public String getOpportunityName() {
        return opportunityName;
    }

    /**
     * Sets the Opportunity Name.
     *
     * @param opportunityNameNew the name to set.
     */
    public void setOpportunityName(final String opportunityNameNew) {

        this.opportunityName = opportunityNameNew.concat(StringDateConverter.convertDate("TODAY").toString());
    }

    /**
     * Returns the Opportunity Next Step.
     *
     * @return string of the next step.
     */
    public String getNextStep() {
        return nextStep;
    }

    /**
     * Sets the Opportunity Next step.
     *
     * @param nextStepNew the text to set.
     */
    public void setNextStep(final String nextStepNew) {
        this.nextStep = nextStepNew;
    }

    /**
     * Returns the Opportunity Amount.
     *
     * @return long of the amount.
     */
    public String getAmount() {
        DecimalFormat decimalFormat = new DecimalFormat("00.00");
        return decimalFormat.format(amount);
    }

    /**
     * Sets the Opportunity Amount.
     *
     * @param amountNew the amount to set.
     */
    public void setAmount(final double amountNew) {
        this.amount = amountNew;
    }

    /**
     * Returns the Opportunity Close date.
     *
     * @return string of the close date.
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * Returns the Opportunity Close date formatted to M/d/YYYY.
     *
     * @return string of the close date.
     */
    public String getFormattedCloseDate() {
        LocalDateTime formatCloseDate = LocalDateTime.parse(closeDate);
        return formatCloseDate.format(DateTimeFormatter.ofPattern("M/d/YYYY"));
    }

    /**
     * Sets the Opportunity Close Date.
     *
     * @param closeDateNew the date to set.
     */
    public void setCloseDate(final String closeDateNew) {
        this.closeDate = StringDateConverter.convertDate(closeDateNew).toString();
    }

    /**
     * Returns the Opportunity Stage.
     *
     * @return string of the stage.
     */
    public String getOpportunityStage() {
        return opportunityStage;
    }

    /**
     * Sets the Opportunity Stage.
     *
     * @param opportunityStageNew the text to set.
     */
    public void setOpportunityStage(final String opportunityStageNew) {
        this.opportunityStage = opportunityStageNew;
    }

    /**
     * Returns the Opportunity type.
     *
     * @return string of the type.
     */
    public String getTypeOption() {
        return typeOption;
    }

    /**
     * Sets the Opportunity Type.
     *
     * @param typeOptionNew the text to set.
     */
    public void setTypeOption(final String typeOptionNew) {
        this.typeOption = typeOptionNew;
    }

    /**
     * Returns the Opportunity Lead source.
     *
     * @return string of the lead source.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Sets the Opportunity Lead Source.
     *
     * @param leadSourceNew the text to set.
     */
    public void setLeadSource(final String leadSourceNew) {
        this.leadSource = leadSourceNew;
    }

    /**
     * Returns the Opportunity Delivery option.
     *
     * @return string of the delivery option.
     */
    public String getDeliveryOption() {
        return deliveryOption;
    }

    /**
     * Sets the Opportunity Delivery Option.
     *
     * @param deliveryOptionNew the text to set.
     */
    public void setDeliveryOption(final String deliveryOptionNew) {
        this.deliveryOption = deliveryOptionNew;
    }

    /**
     * Returns the Opportunity probability.
     *
     * @return string of the probability.
     */
    public String getProbability() {
        return probability;
    }

    /**
     * Sets the Opportunity Probability.
     *
     * @param probabilityNew the text to set.
     */
    public void setProbability(final String probabilityNew) {
        this.probability = probabilityNew;
    }

    /**
     * Returns the Opportunity Order Number.
     *
     * @return string of the order number.
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the Opportunity Order Number.
     *
     * @param orderNumberNew the text to set.
     */
    public void setOrderNumber(final String orderNumberNew) {
        this.orderNumber = orderNumberNew;
    }

    /**
     * Returns the Opportunity Current Generator.
     *
     * @return string of the current generator.
     */
    public String getCurrentGenerator() {
        return currentGenerator;
    }

    /**
     * Sets the Opportunity Current Generator.
     *
     * @param currentGeneratorNew the text to set.
     */
    public void setCurrentGenerator(final String currentGeneratorNew) {
        this.currentGenerator = currentGeneratorNew;
    }

    /**
     * Returns the Opportunity Tracking Number.
     *
     * @return string of the tracking number.
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the Opportunity Tracking Number.
     *
     * @param trackingNumberNew the text to set.
     */
    public void setTrackingNumber(final String trackingNumberNew) {
        this.trackingNumber = trackingNumberNew;
    }

    /**
     * Returns the Opportunity Main competitor.
     *
     * @return string of the main competitor.
     */
    public String getMainComp() {
        return mainComp;
    }

    /**
     * Sets the Opportunity Main Competitor.
     *
     * @param mainCompNew the text to set.
     */
    public void setMainComp(final String mainCompNew) {
        this.mainComp = mainCompNew;
    }

    /**
     * Returns the Opportunity Description.
     *
     * @return string of the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Opportunity Description.
     *
     * @param descriptionNew the text to set.
     */
    public void setDescription(final String descriptionNew) {
        this.description = descriptionNew;
    }

    /**
     * Returns the Opportunity Search Account.
     *
     * @return string of the search account.
     */
    public String getSearchAccount() {
        return searchAccount;
    }

    /**
     * Sets the Opportunity Account.
     *
     * @param searchAccountNew the text to set.
     */
    public void setSearchAccount(final String searchAccountNew) {
        this.searchAccount = searchAccountNew;
    }

    /**
     * Returns the Opportunity Search Campaign.
     *
     * @return string of the search campaign.
     */
    public String getSearchCampaign() {
        return searchCampaign;
    }

    /**
     * Sets the Opportunity Campaign.
     *
     * @param searchCampaignNew the text to set.
     */
    public void setSearchCampaign(final String searchCampaignNew) {
        this.searchCampaign = searchCampaignNew;
    }

    /**
     * Returns the Opportunity Private.
     *
     * @return boolean of private status.
     */
    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Sets the Opportunity Private status.
     *
     * @param isPrivateNew the status to set.
     */
    public void setPrivate(final boolean isPrivateNew) {
        isPrivate = isPrivateNew;
    }

    /**
     * Sets a Map for the detail attribute opportunity.
     */
    public void setOpportunityDetailField() {
        mapFields = new HashMap<>();
        mapFields.put("OpportunityName", getOpportunityName());
        mapFields.put("Type", getTypeOption());
        mapFields.put("LeadSource", getLeadSource());
        mapFields.put("Amount", getAmount());
        mapFields.put("CloseDate", getFormattedCloseDate());
        mapFields.put("NextStep", getNextStep());
        mapFields.put("Stage", getOpportunityStage());
        mapFields.put("Probability", getProbability());
        mapFields.put("Account", getSearchAccount());
        mapFields.put("Created", getCreatedDate());
        mapFields.put("Updated", getUpdatedDateDate());
    }

    /**
     * Gets the Map with the needed fields.
     *
     * @return Map of String text.
     */
    public Map<String, String> getMapFields() {
        return mapFields;
    }

    /**
     * Sets the date of creation.
     *
     * @param newCreatedDate LocalDateTime of creation.
     */
    private void setCreatedDate(final String newCreatedDate) {
        this.createdDate = StringDateConverter.convertDate(newCreatedDate);
    }

    /**
     * Gets the created date.
     *
     * @return LocalDateTime createdDate
     */
    public String getCreatedDate() {
        String formattedDate = createdDate.format(DateTimeFormatter.ofPattern("M/d/YYYY, h:mm a"));
        return formattedDate.toUpperCase().replaceAll("[.] |[.]", "");
    }

    /**
     * Sets the date of update.
     *
     * @param newUpdatedDate LocalDateTime of update.
     */
    private void setUpdatedDate(final LocalDateTime newUpdatedDate) {
        this.updatedDate = newUpdatedDate;
    }

    /**
     * Gets the updated date.
     *
     * @return LocalDateTime updatedDate
     */
    public String getUpdatedDateDate() {
        return this.updatedDate.format(DateTimeFormatter.ofPattern("mm/dd/yy, hh:mm a"));
    }

    /**
     * Sets the values of the opportunity.
     *
     * @param opportunity to be set.
     */
    public void setOpportunityObject(final Opportunity opportunity) {
        this.setOpportunityName(opportunity.getOpportunityName());
        this.setNextStep(opportunity.getNextStep());
        //amount = Double.parseDouble(opportunity.getAmount());
        this.setCloseDate(opportunity.getCloseDate());
        opportunityStage = opportunity.getOpportunityStage();
        typeOption = opportunity.getTypeOption();
        leadSource = opportunity.getLeadSource();
        deliveryOption = opportunity.getDeliveryOption();
        probability = opportunity.getProbability();
        orderNumber = opportunity.getOrderNumber();
        currentGenerator = opportunity.getCurrentGenerator();
        trackingNumber = opportunity.getTrackingNumber();
        mainComp = opportunity.getMainComp();
        description = opportunity.getDescription();
        searchAccount = opportunity.getSearchAccount();
        searchCampaign = opportunity.getSearchCampaign();
        isPrivate = opportunity.isPrivate();
    }
}
