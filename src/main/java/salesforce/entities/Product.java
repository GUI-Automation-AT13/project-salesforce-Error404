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
     * @param attributes to set
     */
    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
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
     * @param id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return a name
     */
    public String getName() {
        return name.concat(String.valueOf(LocalDate.now()));
    }

    /**
     * Sets the name.
     *
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @param productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
     * @param description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
    public void setActive(boolean active) {
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
     * @param createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
     * @param createdById to set
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
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
     * @param lastModifiedDate to set
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
     * @param lastModifiedById to set
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
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
     * @param systemModStamp to set
     */
    public void setSystemModStamp(Date systemModStamp) {
        this.systemModStamp = systemModStamp;
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
     * @param family to set
     */
    public void setFamily(String family) {
        this.family = family;
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
     * @param externalDataSourceId to set
     */
    public void setExternalDataSourceId(Object externalDataSourceId) {
        this.externalDataSourceId = externalDataSourceId;
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
     * @param externalId to set
     */
    public void setExternalId(Object externalId) {
        this.externalId = externalId;
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
     * @param displayUrl to set
     */
    public void setDisplayUrl(Object displayUrl) {
        this.displayUrl = displayUrl;
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
     * @param quantityUnitOfMeasure to set
     */
    public void setQuantityUnitOfMeasure(Object quantityUnitOfMeasure) {
        this.quantityUnitOfMeasure = quantityUnitOfMeasure;
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
    public void setDeleted(boolean deleted) {
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
    public void setArchived(boolean archived) {
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
     * @param lastViewedDate to set
     */
    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
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
     * @param lastReferencedDate to set
     */
    public void setLastReferencedDate(Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
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
     * @param stockKeepingUnit to set
     */
    public void setStockKeepingUnit(Object stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }
}
