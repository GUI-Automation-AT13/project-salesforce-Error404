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
import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("ProductCode")
    public String productCode = "";
    @JsonProperty("Description")
    public String description = "";
    @JsonProperty("IsActive")
    public boolean isActive;
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
    @JsonProperty("Family")
    public String family = "";
    @JsonProperty("ExternalDataSourceId")
    public Object externalDataSourceId;
    @JsonProperty("ExternalId")
    public Object externalId;
    @JsonProperty("DisplayUrl")
    public Object displayUrl;
    @JsonProperty("QuantityUnitOfMeasure")
    public Object quantityUnitOfMeasure;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("IsArchived")
    public boolean isArchived;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("StockKeepingUnit")
    public Object stockKeepingUnit;

    /**
     * Gets the attribute.
     *
     * @return the attribute
     */
    public Attribute getAttributes() {
        return attributes;
    }

    /**
     * Sets the attribute.
     *
     * @param newAttributes to set
     */
    public void setAttributes(final Attribute newAttributes) {
        this.attributes = newAttributes;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param newId to set
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets the name.
     *
     * @return a name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param newName to set
     */
    public void setName(final String newName) {
        this.name = newName.concat(String.valueOf(LocalDate.now()));
    }

    /**
     * Gets the productCode.
     *
     * @return a productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the productCode.
     *
     * @param newProductCode to set
     */
    public void setProductCode(final String newProductCode) {
        this.productCode = newProductCode;
    }

    /**
     * Gets the description.
     *
     * @return a description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param newDescription to set
     */
    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * Gets if it is active.
     *
     * @return a tru if it is active
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the isActive.
     *
     * @param active to set
     */
    public void setActive(final boolean active) {
        isActive = active;
    }

    /**
     * Gets the createdDate.
     *
     * @return a createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the createdDate.
     *
     * @param newCreatedDate to set
     */
    public void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    /**
     * Gets the createdById.
     *
     * @return a createdById
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Sets the createdById.
     *
     * @param newCreatedById to set
     */
    public void setCreatedById(final String newCreatedById) {
        this.createdById = newCreatedById;
    }

    /**
     * Gets the lastModifiedDate.
     *
     * @return a lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate.
     *
     * @param newLastModifiedDate to set
     */
    public void setLastModifiedDate(final Date newLastModifiedDate) {
        this.lastModifiedDate = newLastModifiedDate;
    }

    /**
     * Gets the lastModifiedById.
     *
     * @return a lastModifiedById
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    /**
     * Sets the lastModifiedById.
     *
     * @param newLastModifiedById to set
     */
    public void setLastModifiedById(final String newLastModifiedById) {
        this.lastModifiedById = newLastModifiedById;
    }

    /**
     * Gets the systemModStamp.
     *
     * @return a systemModStamp
     */
    public Date getSystemModStamp() {
        return systemModStamp;
    }

    /**
     * Sets the systemModStamp.
     *
     * @param newSystemModStamp to set
     */
    public void setSystemModStamp(final Date newSystemModStamp) {
        this.systemModStamp = newSystemModStamp;
    }

    /**
     * Gets the family.
     *
     * @return a family
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the family.
     *
     * @param newFamily to set
     */
    public void setFamily(final String newFamily) {
        this.family = newFamily;
    }

    /**
     * Gets the externalDataSourceId.
     *
     * @return a externalDataSourceId
     */
    public Object getExternalDataSourceId() {
        return externalDataSourceId;
    }

    /**
     * Sets the externalDataSourceId.
     *
     * @param newExternalDataSourceId to set
     */
    public void setExternalDataSourceId(final Object newExternalDataSourceId) {
        this.externalDataSourceId = newExternalDataSourceId;
    }

    /**
     * Gets the externalId.
     *
     * @return a externalId
     */
    public Object getExternalId() {
        return externalId;
    }

    /**
     * Sets the externalId.
     *
     * @param newExternalId to set
     */
    public void setExternalId(final Object newExternalId) {
        this.externalId = newExternalId;
    }

    /**
     * Gets the displayUrl.
     *
     * @return a displayUrl
     */
    public Object getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the displayUrl.
     *
     * @param newDisplayUrl to set
     */
    public void setDisplayUrl(final Object newDisplayUrl) {
        this.displayUrl = newDisplayUrl;
    }

    /**
     * Gets the quantityUnitOfMeasure.
     *
     * @return a quantityUnitOfMeasure
     */
    public Object getQuantityUnitOfMeasure() {
        return quantityUnitOfMeasure;
    }

    /**
     * Sets the quantityUnitOfMeasure.
     *
     * @param newQuantityUnitOfMeasure to set
     */
    public void setQuantityUnitOfMeasure(final Object newQuantityUnitOfMeasure) {
        this.quantityUnitOfMeasure = newQuantityUnitOfMeasure;
    }

    /**
     * Gets if it is deleted.
     *
     * @return a true if it is deleted
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted to set
     */
    public void setDeleted(final boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Gets if it is archived.
     *
     * @return true if archived
     */
    public boolean isArchived() {
        return isArchived;
    }

    /**
     * Sets archived.
     *
     * @param archived to set
     */
    public void setArchived(final boolean archived) {
        isArchived = archived;
    }

    /**
     * Gets the lastViewedDate.
     *
     * @return a lastViewedDate
     */
    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    /**
     * Sets the lastViewedDate.
     *
     * @param newLastViewedDate to set
     */
    public void setLastViewedDate(final Date newLastViewedDate) {
        this.lastViewedDate = newLastViewedDate;
    }

    /**
     * Gets the lastReferencedDate.
     *
     * @return a lastReferencedDate
     */
    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    /**
     * Sets the lastReferencedDate.
     *
     * @param newLastReferencedDate to set
     */
    public void setLastReferencedDate(final Date newLastReferencedDate) {
        this.lastReferencedDate = newLastReferencedDate;
    }

    /**
     * Gets the stockKeepingUnit.
     *
     * @return a stockKeepingUnit
     */
    public Object getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    /**
     * Sets the stockKeepingUnit.
     *
     * @param newStockKeepingUnit to set
     */
    public void setStockKeepingUnit(final Object newStockKeepingUnit) {
        this.stockKeepingUnit = newStockKeepingUnit;
    }

    /**
     * Sets the product with given values.
     *
     * @param product the product with the values to set.
     */
    public void setProduct(final Product product) {
        name = product.getName();
        isActive = product.isActive();
        productCode = product.getProductCode();
        family = product.getFamily();
        description = product.getDescription();
    }
}
