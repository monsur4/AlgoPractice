package com.mon.algosgigster;

import java.util.*;
import java.io.*;
import java.net.*;

public class JSONStringManipulation {
    /*
    * Java REST GET Simple
    In the Java file, write a program to perform a GET request on the route
    https://coderbyte.com/api/challenges/json/rest-get-simple and then print to
    the console the hobbies property in the following format: ITEM1, ITEM2, ...

    Example Output
    running, painting
    * */

    public static void main (String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String output = bufferedReader.readLine();

                // formatting output => String output = "{\"name\":\"John Smith\",\"age\":25,\"hobbies\":[\"running\",\"coding\",\"camping\"]}";
                String fromHobbies = output.substring(output.indexOf("hobbies")); // {"name":"John Smith","age":25,"hobbies":["running","coding","camping"]}
                String allHobbies = fromHobbies.substring(fromHobbies.indexOf("[") + 1, fromHobbies.indexOf("]")); // "running","coding","camping"
                String[] hobbiesArr = allHobbies.split(",");
                StringBuilder sol = new StringBuilder();
                for(String hobby: hobbiesArr){
                    String hobbyString = hobby.substring(1, hobby.length()-1);
                    if(sol.isEmpty()) sol.append(hobbyString);
                    else sol.append(", ").append(hobbyString);
                }
                System.out.println(sol);
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}
