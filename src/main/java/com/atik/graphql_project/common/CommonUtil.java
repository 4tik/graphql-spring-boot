package com.atik.graphql_project.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class CommonUtil {
//    string to date
    public static LocalDate stringToDate(String stringDate) {
        if(stringDate == null || stringDate == "") return null;
        return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
