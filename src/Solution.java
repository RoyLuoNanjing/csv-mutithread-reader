import biz.GetUserDataBiz;
import dao.impl.BufferedReaderReadUserFile;
import model.UserData;
import utils.CsvUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Read all the given csv files and join the user's properties
 * Write the result into a new file called result.csv in src/data file
 * Better decoupling hence reducing the load for maintainance
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        //test sample files
        String[] smallFile = {"src/data/dev/small_file_1.csv", "src/data/dev/small_file_2.csv", "src/data/dev/small_file_3.csv", "src/data/dev/small_file_4.csv", "src/data/dev/small_file_5.csv"};
        String[] largeFile = {"src/data/live/large_file_1.csv", "src/data/live/large_file_2.csv", "src/data/live/large_file_3.csv", "src/data/live/large_file_4.csv", "src/data/live/large_file_5.csv"};

        //output path
        String outputPath = "src/data/result.csv";

        //Start time
        long startTime = System.currentTimeMillis();

        //Inversion of Control implemented by Dependency Injection and Interface

        //Use BufferedReader implemented by ReadUserFile to read all the files
        BufferedReaderReadUserFile readerReadUserFile = new BufferedReaderReadUserFile();
        // Dependency Injection
        GetUserDataBiz getUserDataBiz = new GetUserDataBiz(readerReadUserFile);

        //Use multi-thread to read all the files and store a list of user objects including its properties
        List<UserData> userData = getUserDataBiz.process(largeFile);

        //Convert user objects into strings for writing the result into a new csv
        List<String> strList = userData.stream().map(UserData::toString).collect(Collectors.toList());

        //write the headers first
        String strHeader = "ID,Property_1,Property_2,Property_3,Property_4,Property_5,Property_6,Property_7"+"\n";

        //write the rest
        CsvUtil.writeCsv(outputPath, strHeader, strList);


        //Output the total operating time
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " milliseconds");

    }
}