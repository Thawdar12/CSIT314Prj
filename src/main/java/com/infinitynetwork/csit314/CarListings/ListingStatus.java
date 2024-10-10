package com.infinitynetwork.csit314.CarListings;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ListingStatus {
    OPEN,
    CLOSED;

    @JsonCreator
    public static ListingStatus fromString(String string) {
        return string == null ? null : valueOf(string.toUpperCase());
    }
}
