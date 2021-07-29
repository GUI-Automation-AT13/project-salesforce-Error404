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
public class ShippingAddress {
    public String city;
    public String country;
    public Object geocodeAccuracy;
    public Object latitude;
    public Object longitude;
    public String postalCode;
    public String state;
    public String street;

    /**
     * Gets city of ShippingAddress.
     *
     * @return city of ShippingAddress.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city of ShippingAddress.
     *
     * @param newCity of ShippingAddress.
     */
    public void setCity(final String newCity) {
        this.city = newCity;
    }

    /**
     * Gets country of ShippingAddress.
     *
     * @return country of ShippingAddress.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country of ShippingAddress.
     *
     * @param newCountry of ShippingAddress.
     */
    public void setCountry(final String newCountry) {
        this.country = newCountry;
    }

    /**
     * Gets geocodeAccuracy of ShippingAddress.
     *
     * @return geocodeAccuracy of ShippingAddress.
     */
    public Object getGeocodeAccuracy() {
        return geocodeAccuracy;
    }

    /**
     * Sets geocodeAccuracy of ShippingAddress.
     *
     * @param newGeocodeAccuracy of ShippingAddress.
     */
    public void setGeocodeAccuracy(final Object newGeocodeAccuracy) {
        this.geocodeAccuracy = newGeocodeAccuracy;
    }

    /**
     * Gets latitude of ShippingAddress.
     *
     * @return latitude of ShippingAddress.
     */
    public Object getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude of ShippingAddress.
     *
     * @param newLatitude of ShippingAddress.
     */
    public void setLatitude(final Object newLatitude) {
        this.latitude = newLatitude;
    }

    /**
     * Gets longitude of ShippingAddress.
     *
     * @return longitude of ShippingAddress.
     */
    public Object getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude of ShippingAddress.
     *
     * @param newLongitude of ShippingAddress.
     */
    public void setLongitude(final Object newLongitude) {
        this.longitude = newLongitude;
    }

    /**
     * Gets postalCode of ShippingAddress.
     *
     * @return postalCode of ShippingAddress.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postalCode of ShippingAddress.
     *
     * @param newPostalCode of ShippingAddress.
     */
    public void setPostalCode(final String newPostalCode) {
        this.postalCode = newPostalCode;
    }

    /**
     * Gets state of ShippingAddress.
     *
     * @return state of ShippingAddress.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state of ShippingAddress.
     *
     * @param newState of ShippingAddress.
     */
    public void setState(final String newState) {
        this.state = newState;
    }

    /**
     * Gets street of ShippingAddress.
     *
     * @return street of ShippingAddress.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street of ShippingAddress.
     *
     * @param newStreet of ShippingAddress.
     */
    public void setStreet(final String newStreet) {
        this.street = newStreet;
    }
}
