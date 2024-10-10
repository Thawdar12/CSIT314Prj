package com.infinitynetwork.csit314.AppUsers;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {
    ADMIN,
    AGENT,
    BUYER,
    SELLER;

    @JsonCreator
    public static UserType fromString(String string) {
        return string == null ? null : UserType.valueOf(string.toUpperCase());
    }
}
