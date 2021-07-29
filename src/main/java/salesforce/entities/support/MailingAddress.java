/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities.support;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailingAddress {
    public String city;
    public String country;
    public Object geocodeAccuracy;
    public Object latitude;
    public Object longitude;
    public String postalCode;
    public String state;
    public String street;

    /**
     * Gets city of MailingAddress.
     *
     * @return city of MailingAddress.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city of MailingAddress.
     *
     * @param newCity of MailingAddress.
     */
    public void setCity(final String newCity) {
        this.city = newCity;
    }

    /**
     * Gets country of MailingAddress.
     *
     * @return country of MailingAddress.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country of MailingAddress.
     *
     * @param newCountry of MailingAddress.
     */
    public void setCountry(final String newCountry) {
        this.country = newCountry;
    }

    /**
     * Gets geocodeAccuracy of MailingAddress.
     *
     * @return geocodeAccuracy of MailingAddress.
     */
    public Object getGeocodeAccuracy() {
        return geocodeAccuracy;
    }

    /**
     * Sets geocodeAccuracy of MailingAddress.
     *
     * @param newGeocodeAccuracy of MailingAddress.
     */
    public void setGeocodeAccuracy(final Object newGeocodeAccuracy) {
        this.geocodeAccuracy = newGeocodeAccuracy;
    }

    /**
     * Gets latitude of MailingAddress.
     *
     * @return latitude of MailingAddress.
     */
    public Object getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude of MailingAddress.
     *
     * @param newLatitude of MailingAddress.
     */
    public void setLatitude(final Object newLatitude) {
        this.latitude = newLatitude;
    }

    /**
     * Gets longitude of MailingAddress.
     *
     * @return longitude of MailingAddress.
     */
    public Object getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude of MailingAddress.
     *
     * @param newLongitude of MailingAddress.
     */
    public void setLongitude(final Object newLongitude) {
        this.longitude = newLongitude;
    }

    /**
     * Gets postalCode of MailingAddress.
     *
     * @return postalCode of MailingAddress.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postalCode of MailingAddress.
     *
     * @param newPostalCode of MailingAddress.
     */
    public void setPostalCode(final String newPostalCode) {
        this.postalCode = newPostalCode;
    }

    /**
     * Gets state of MailingAddress.
     *
     * @return state of MailingAddress.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state of MailingAddress.
     *
     * @param newState of MailingAddress.
     */
    public void setState(final String newState) {
        this.state = newState;
    }

    /**
     * Gets street of MailingAddress.
     *
     * @return street of MailingAddress.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street of MailingAddress.
     *
     * @param newStreet of MailingAddress.
     */
    public void setStreet(final String newStreet) {
        this.street = newStreet;
    }
}
