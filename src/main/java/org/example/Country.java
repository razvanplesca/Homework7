package org.example;

import lombok.Getter;

enum Country {
    UNDEFINED(0, "Undefined"),
    SK(1, "Slovakia"),
    UK(2, "United Kingdom"),
    CZ(3, "Czech Republic");

    @Getter
    private final int id;
    private final String name;

    Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Country getById(int id) {
        for (Country country : Country.values()) {
            if (country.getId() == id) {
                return country;
            }
        }
        return Country.UNDEFINED;
    }
}
