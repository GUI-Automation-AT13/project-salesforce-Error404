package salesforce.entities;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Case {
    private String id;
    private String sLAViolation;
    private String internalComments;
    private String caseOwner;
    private String accountName;
    private String subject;
    private String description;
    private String type;
    private String webEmail;
    private String caseNumber;
    private String webName;
    private String caseOrigin;
    private String product;
    private String potentialLiability;
    private String contactEmail;
    private String contactName;
    private String engineeringReqNumber;
    private String lastModifiedBy;
    private String priority;
    private String webPhone;
    private String dateTimeOpened;
    private String caseReason;
    private String createdBy;
    private String dateTimeClosed;
    private String contactPhone;
    private String status;
    private String webCompany;
    private Map<String, String> commentsList = new HashMap<>();

    /**
     * Gets the case id.
     *
     * @return a String with the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param inputId the value to set
     */
    public void setId(final String inputId) {
        this.id = inputId;
    }

    /**
     * Gets the SLA violation field.
     *
     * @return a String with Yes|No|--None--
     */
    public String getsLAViolation() {
        return sLAViolation;
    }

    /**
     * Sets the SLA violation field.
     *
     * @param inputSLAViolation a String with Yes|No|--None--
     */
    public void setsLAViolation(final String inputSLAViolation) {
        this.sLAViolation = inputSLAViolation;
    }

    /**
     * Gets the internal comments.
     *
     * @return a String with the comments
     */
    public String getInternalComments() {
        return internalComments;
    }

    /**
     * Sets the internal comments.
     *
     * @param inputInternalComments the value to set
     */
    public void setInternalComments(final String inputInternalComments) {
        this.internalComments = inputInternalComments;
    }

    /**
     * Gets the case's owner.
     *
     * @return a String with the owner
     */
    public String getCaseOwner() {
        return caseOwner;
    }

    /**
     * Sets the case's owner.
     *
     * @param inputCaseOwner the value to set
     */
    public void setCaseOwner(final String inputCaseOwner) {
        this.caseOwner = inputCaseOwner;
    }

    /**
     * Gets the account name.
     *
     * @return a String with the account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account name.
     *
     * @param inputAccountName the value to set
     */
    public void setAccountName(final String inputAccountName) {
        this.accountName = inputAccountName;
    }

    /**
     * Gets the subject.
     *
     * @return a String with the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param inputSubject te value to set
     */
    public void setSubject(final String inputSubject) {
        this.subject = inputSubject;
    }

    /**
     * Gets the description.
     *
     * @return a String with the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param inputDescription the value to set
     */
    public void setDescription(final String inputDescription) {
        this.description = inputDescription;
    }

    /**
     * Gets the type.
     *
     * @return a String with the value
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param inputType the values Mechanical|Electrical|Electronic|Structural|Other|--None--
     */
    public void setType(final String inputType) {
        this.type = inputType;
    }

    /**
     * Gets the web email.
     *
     * @return a String with the email
     */
    public String getWebEmail() {
        return webEmail;
    }

    /**
     * Sets the web email.
     *
     * @param inputWebEmail the value to set
     */
    public void setWebEmail(final String inputWebEmail) {
        this.webEmail = inputWebEmail;
    }

    /**
     * Gets the case number.
     *
     * @return the case number
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * Sets the case number.
     *
     * @param inputCaseNumber the value to set
     */
    public void setCaseNumber(final String inputCaseNumber) {
        this.caseNumber = inputCaseNumber;
    }

    /**
     * Gets the web name.
     *
     * @return a String with the web name
     */
    public String getWebName() {
        return webName;
    }

    /**
     * Sets the web name.
     *
     * @param inputWebName the value to set
     */
    public void setWebName(final String inputWebName) {
        this.webName = inputWebName;
    }

    /**
     * Gets the case origin.
     *
     * @return a String with the case origin
     */
    public String getCaseOrigin() {
        return caseOrigin;
    }

    /**
     * Sets the case origin.
     *
     * @param inputCaseOrigin values Phone|Email|Web|--None--
     */
    public void setCaseOrigin(final String inputCaseOrigin) {
        this.caseOrigin = inputCaseOrigin;
    }

    /**
     * Gets the product.
     *
     * @return a String with the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param inputProduct the value to set
     */
    public void setProduct(final String inputProduct) {
        this.product = inputProduct;
    }

    /**
     * Gets the potential liability.
     *
     * @return a String with the potential liabiliy
     */
    public String getPotentialLiability() {
        return potentialLiability;
    }

    /**
     * Sets the potential liability.
     *
     * @param inputPotentialLiability the values Yes|No|--None--
     */
    public void setPotentialLiability(final String inputPotentialLiability) {
        this.potentialLiability = inputPotentialLiability;
    }

    /**
     * Gets the contact email.
     *
     * @return a String with the email
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the contact email.
     *
     * @param inputContactEmail the value to set
     */
    public void setContactEmail(final String inputContactEmail) {
        this.contactEmail = inputContactEmail;
    }

    /**
     * Gets the contact name.
     *
     * @return a String with the name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the contact's name.
     *
     * @param inputContactName the value to set
     */
    public void setContactName(final String inputContactName) {
        this.contactName = inputContactName;
    }

    /**
     * Gets the required engineering number.
     *
     * @return a String with the number
     */
    public String getEngineeringReqNumber() {
        return engineeringReqNumber;
    }

    /**
     * Sets the required engineering number.
     *
     * @param inputEngineeringReqNumber the value to set
     */
    public void setEngineeringReqNumber(final String inputEngineeringReqNumber) {
        this.engineeringReqNumber = inputEngineeringReqNumber;
    }

    /**
     * Gets the las date the case was updated.
     *
     * @return the date
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the last date the case was modified.
     *
     * @param inputLastModifiedBy the value to set
     */
    public void setLastModifiedBy(final String inputLastModifiedBy) {
        this.lastModifiedBy = inputLastModifiedBy;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param inputPriority values High|Medium|Low|--None--
     */
    public void setPriority(final String inputPriority) {
        this.priority = inputPriority;
    }

    /**
     * Gets the web phone.
     *
     * @return the web phone
     */
    public String getWebPhone() {
        return webPhone;
    }

    /**
     * Sets the web phone.
     *
     * @param inputWebPhone the value to set
     */
    public void setWebPhone(final String inputWebPhone) {
        this.webPhone = inputWebPhone;
    }

    /**
     * Gets the date the case was created.
     *
     * @return the created date
     */
    public String getDateTimeOpened() {
        return dateTimeOpened;
    }

    /**
     * Sets the date the case was created.
     *
     * @param inputDateTimeOpened the date to set
     */
    public void setDateTimeOpened(final String inputDateTimeOpened) {
        this.dateTimeOpened = inputDateTimeOpened;
    }

    /**
     * Gets the case reason.
     *
     * @return the case reason
     */
    public String getCaseReason() {
        return caseReason;
    }

    /**
     * Sets the case reason.
     *
     * @param inputCaseReason values Installation|Equipment Complexity|Performance|
     *                        Breakdown|Equipment Design|Feedback|Other|--None--
     */
    public void setCaseReason(final String inputCaseReason) {
        this.caseReason = inputCaseReason;
    }

    /**
     * Gets the date the case was created and the owner.
     *
     * @return the date and owner
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the date and owner of created case.
     *
     * @param inputCreatedBy the value to set
     */
    public void setCreatedBy(final String inputCreatedBy) {
        this.createdBy = inputCreatedBy;
    }

    /**
     * Gets the date the case is closed.
     *
     * @return the date
     */
    public String getDateTimeClosed() {
        return dateTimeClosed;
    }

    /**
     * Sets the date the case is closed.
     *
     * @param inputDateTimeClosed the value to set
     */
    public void setDateTimeClosed(final String inputDateTimeClosed) {
        this.dateTimeClosed = inputDateTimeClosed;
    }

    /**
     * Gets the contact's phone.
     *
     * @return the phone number
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the contact's phone number.
     *
     * @param inputContactPhone the value to set
     */
    public void setContactPhone(final String inputContactPhone) {
        this.contactPhone = inputContactPhone;
    }

    /**
     * Gets the case status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the case status.
     *
     * @param inputStatus values New|Working|Escalated|--None--
     */
    public void setStatus(final String inputStatus) {
        this.status = inputStatus;
    }

    /**
     * Gets the company's web.
     *
     * @return the web site
     */
    public String getWebCompany() {
        return webCompany;
    }

    /**
     * Sets the company's web site.
     *
     * @param inputWebCompany the value to set
     */
    public void setWebCompany(final String inputWebCompany) {
        this.webCompany = inputWebCompany;
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
     * Creates a map with the fields that match a key set.
     *
     * @param keys a set of keys
     * @return a map with the provided keys and case's values
     * @throws IllegalAccessException when access to class not provided
     */
    public Map createMapOnKeySetFromCase(final Set keys) throws IllegalAccessException {
        Map myMap = new HashMap();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (keys.contains(field.getName())) {
                myMap.put(field.getName(), field.get(this));
            }
        }
        return myMap;
    }

    /**
     * Sets the case values with a map.
     *
     * @param map with the case's values
     * @throws InvocationTargetException when invocated method or constructor fail
     * @throws IllegalAccessException when access to class not provided
     */
    public void setCaseWithMap(final Map map)
            throws InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(this, map);
        setNullValuesToEmpty();
    }

    /**
     * Updates a Case to default values on salesforce.
     *
     * @param inputCaseNumber the self generated case number
     */
    public void updateCase(final String inputCaseNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy HH:mm");
        this.setDateTimeOpened(dateFormat.format(Date.from(Instant.now())));
        this.setCreatedBy(caseOwner.concat(", ").concat(dateTimeOpened));
        this.setLastModifiedBy(caseOwner.concat(", ").concat(dateTimeOpened));
        this.setCaseNumber(inputCaseNumber);
        this.commentsList.put(dateTimeOpened, internalComments);
        this.setInternalComments("");
        if (status.equals("")) {
            status = "New";
        }
        if (priority.equals("")) {
            priority = "Medium";
        }
    }
}
