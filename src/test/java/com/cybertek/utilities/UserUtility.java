package com.cybertek.utilities;

import java.util.List;
import java.util.Map;

public class UserUtility {

    // method to get user email and password

    /**
     * returns email and password of a user based on role and location
     * @param role
     * @param location
     * @return
     */
    public Map<String, String> getUserCredentials(String role, String location){
        // point to the correct file path based on location argument
        String file = null;
        switch (location) {
            case ApplicationConstants.IL:
                file = "./src/test/resources/test_data/il-users.xlsx";
                break;
            case ApplicationConstants.DARK_SIDE:
                file = "./src/test/resources/test_data/dark-side-users.xlsx";
                break;
            case ApplicationConstants.LIGHT_SIDE:
                file = "./src/test/resources/test_data/light-side-users.xlsx";
                break;
        }
        // read the file based on filepath and get the data
        List<Map<String, String>> userData = new ExcelUtil(file, "Sheet1").getDataList();

        return null;
    }
}
