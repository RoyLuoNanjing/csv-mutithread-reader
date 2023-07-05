package utils;

import model.UserData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Use this util to help process the csv in terms of reading and writing.
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public class CsvUtil {
    private static final String DELIMITER_ROW = ",";

    /**
     * Read the csv files and convert all rows of data into a list of string
     *
     * @param path a path of selected file
     * @return A list of string lists containing each row
     */
    public static List<List<String>> readCsv(String path) {
        //create a list for each row of user data
        List<List<String>> csvStringList = new ArrayList<>();
        if (path == null) {
            return csvStringList;
        }

        //Read each row and store the information into a list
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rowStr;
            while ((rowStr = br.readLine()) != null) {
                String[] rowArray = rowStr.split(DELIMITER_ROW);
                List<String> row = Arrays.asList(rowArray);
                csvStringList.add(row);
            }
        } catch (Exception ex) {
            System.out.printf("warn:%s%n", ex);
        }

        return csvStringList;
    }


    /**
     * To write a list of user strings into a new csv file
     *
     * @param strList     a list of strings containing values of user id and their properties
     * @param header     the headers we defined before for the new file
     * @param outputPath the path of result file
     */
    public static void writeCsv(String outputPath, String header, List<String> strList) {
        //Create a new csv
        try (FileWriter csvWriter = new FileWriter(outputPath, StandardCharsets.UTF_8)) {
            //Create the row of headers
            csvWriter.write(header);
            //Get all the information of each user from its Object
            for (String str : strList) {
                //It is noted that the empty property will be stored as "null" in csv
                csvWriter.write(str + "\n");
            }
        } catch (Exception ex) {
            System.out.printf("warn:%s%n", ex);
        }

    }
}
