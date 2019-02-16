package com.cybertek.utilities;

import java.util.List;
import java.util.Map;

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

        List<Map<String, String>> userList = userData.getDataList();

        System.out.println(userList.size());
        // first user in the excel sheet
        System.out.println(userList.get(1));

        // get the name of the first user
        System.out.println(userList.get(4).get("email"));


        // get the same information using 2d array
        // get the name of the first user
        String[][] userArray = userData.getDataArray();
        System.out.println(userArray[4][6]);


    }
}
