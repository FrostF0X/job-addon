package com.frost_fox.jenkins.job_addon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ids {

    public static final List<String> IDS = Arrays.asList("1", "2", "3");
    public static final List<String> IDS2 = Arrays.asList("15", "17", "19");
    public static final String ID_FROM_IDS2 = "15";
    public static final String ID_FROM_IDS = "1";
    public static final String ID_NOT_FROM_IDS = "10";

    public static final String ID = "some id";

    @SuppressWarnings("WeakerAccess")
    public static final String THAT_SINGLE_ID = "5";
    public static final List<String> SINGLE = Collections.singletonList(THAT_SINGLE_ID);

    public static List<String> exactCount(int count) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strings.add(String.valueOf(i));
        }
        return strings;
    }
}