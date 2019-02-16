package com.cybertek.utilities;

/**
 * This is just an excercise class, not an actual utility.
 * this class is not part of any tests
 */
public class ExcelExcercise {

    public static void main(String[] args) {
        // create utility for the users data

        String path = "./src/test/resources/test_data/light-side-test-data.xlsx";
        String userSheet = "light-side-users";

        ExcelUtil userData = new ExcelUtil(path, userSheet);

        System.out.println("userData.rowCount() = " + userData.rowCount());
        System.out.println("userData.columnCount() = " + userData.columnCount());

        System.out.println(userData.getColumnsNames());

        // go to  break now
        // come back when break is over in 15 mins at 12:14
    }
}
