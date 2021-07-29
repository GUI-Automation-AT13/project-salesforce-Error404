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
public class BillingAddress {
    public String city;
    public String country;
    public Object geocodeAccuracy;
    public Object latitude;
    public Object longitude;
    public String postalCode;
    public String state;
    public String street;

    /**
     * Gets the city.
     *
     * @return a String with the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param newCity a String with the city to set
     */
    public void setCity(final String newCity) {
        this.city = newCity;
    }

    /**
     * Gets the country.
     *
     * @return a String with the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param newCountry a String with the country to set
     */
    public void setCountry(final String newCountry) {
        this.country = newCountry;
    }

    /**
     * Gets the geocode accuracy.
     *
     * @return a String with the geocode accuracy
     */
    public Object getGeocodeAccuracy() {
        return geocodeAccuracy;
    }

    /**
     * Sets the geocode accuracy.
     *
     * @param newGeocodeAccuracy a String with the geocode accuracy to set
     */
    public void setGeocodeAccuracy(final Object newGeocodeAccuracy) {
        this.geocodeAccuracy = newGeocodeAccuracy;
    }

    /**
     * Gets the latitude.
     *
     * @return a String with the latitude
     */
    public Object getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param newLatitude a String with the latitude to set
     */
    public void setLatitude(final Object newLatitude) {
        this.latitude = newLatitude;
    }

    /**
     * Gets the longitude.
     *
     * @return a String with the longitude
     */
    public Object getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param newLongitude a String with the longitude to set
     */
    public void setLongitude(final Object newLongitude) {
        this.longitude = newLongitude;
    }

    /**
     * Gets the postal code.
     *
     * @return a String with the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param newPostalCode a String with the postal code to set
     */
    public void setPostalCode(final String newPostalCode) {
        this.postalCode = newPostalCode;
    }

    /**
     * Gets the street.
     *
     * @return a String with the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param newState a String with the state to set
     */
    public void setState(final String newState) {
        this.state = newState;
    }

    /**
     * Gets the street.
     *
     * @return a String with the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param newStreet a String with the street to set
     */
    public void setStreet(final String newStreet) {
        this.street = newStreet;
    }
}
