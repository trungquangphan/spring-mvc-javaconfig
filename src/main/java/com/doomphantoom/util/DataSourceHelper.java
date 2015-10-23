package com.doomphantoom.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doomphantom on 23/10/2015.
 */
public final class DataSourceHelper {
    public static List<String> getListCountryThatRequireState() {
        List<String> countries = new ArrayList<String>() {{
            add("US");
            add("AU");
            add("MX");
        }};
        return countries;
    }
}
