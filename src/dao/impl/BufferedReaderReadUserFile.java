package dao.impl;

import dao.ReadUserFile;
import dao.entity.*;
import utils.CsvUtil;

import java.util.List;
import java.util.stream.Collectors;
/**
 * An implementation of reading the files by using BufferedWriter
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public class BufferedReaderReadUserFile implements ReadUserFile {
    /**
     * Read the first file and return a list of entity objects
     *
     * @param path the path of the first file
     * @return a list of Entity Objects from the first file
     */
    @Override
    public List<UserFile1Entity> getUserProperty1EntityByPath(String path) {
        //Read the file and store a list of each rows in string
        List<List<String>> fileStringList = CsvUtil.readCsv(path);
        List<UserFile1Entity> result = fileStringList.stream().map(this::toUserFile1Entity).collect(Collectors.toList());
        return  result;
    }

    /**
     * Read the second file and return a list of entity objects
     *
     * @param path the path of the second file
     * @return a list of Entity Objects from the second file
     */
    @Override
    public List<UserFile2Entity> getUserProperty2EntityByPath(String path)  {
        List<List<String>> fileStringList = CsvUtil.readCsv(path);
        List<UserFile2Entity> result = fileStringList.stream().map(this::toUserFile2Entity).collect(Collectors.toList());
        return  result;
    }


    /**
     * Read the third file and return a list of entity objects
     *
     * @param path the path of the third file
     * @return a list of Entity Objects from the third file
     */
    @Override
    public List<UserFile3Entity> getUserProperty3EntityByPath(String path){
        List<List<String>> fileStringList = CsvUtil.readCsv(path);
        List<UserFile3Entity> result = fileStringList.stream().map(this::toUserFile3Entity).collect(Collectors.toList());
        return  result;
    }


    /**
     * Read the fourth file and return a list of entity objects
     *
     * @param path the path of the fourth file
     * @return a list of Entity Objects from the fourth file
     */
    @Override
    public List<UserFile4Entity> getUserProperty4EntityByPath(String path){
        List<List<String>> fileStringList = CsvUtil.readCsv(path);
        List<UserFile4Entity> result = fileStringList.stream().map(this::toUserFile4Entity).collect(Collectors.toList());
        return  result;
    }

    /**
     * Read the fifth file and return a list of entity objects
     *
     * @param path the path of the fifth file
     * @return a list of Entity Objects from the fifth file
     */
    @Override
    public List<UserFile5Entity> getUserProperty5EntityByPath(String path)  {
        List<List<String>> fileStringList = CsvUtil.readCsv(path);
        List<UserFile5Entity> result =  fileStringList.stream().map(this::toUserFile5Entity).collect(Collectors.toList());
        return  result;
    }


    /**
     * Convert each row of the file into an entity objects
     *
     * @param rowStringList a string list stored all the list in the file
     * @return an Entity Object from the first file
     */
    private UserFile1Entity toUserFile1Entity(List<String> rowStringList) {
        UserFile1Entity entity = new UserFile1Entity();
        entity.setId(rowStringList.get(0));
        entity.setProperty1(rowStringList.get(1));
        return entity;
    }

    /**
     * Convert each row of the file into an entity objects
     *
     * @param rowStringList a string list stored all the list in the file
     * @return an Entity Object from the second file
     */
    private UserFile2Entity toUserFile2Entity(List<String> rowStringList) {
        UserFile2Entity entity = new UserFile2Entity();
        entity.setId(rowStringList.get(0));
        entity.setProperty2(rowStringList.get(1));
        entity.setProperty3(rowStringList.get(2));
        return entity;
    }

    /**
     * Convert each row of the file into an entity objects
     *
     * @param rowStringList a string list stored all the list in the file
     * @return an Entity Object from the third file
     */
    private UserFile3Entity toUserFile3Entity(List<String> rowStringList) {
        UserFile3Entity entity = new UserFile3Entity();
        entity.setId(rowStringList.get(0));
        entity.setProperty4(rowStringList.get(1));
        return entity;
    }

    /**
     * Convert each row of the file into an entity objects
     *
     * @param rowStringList a string list stored all the list in the file
     * @return an Entity Object from the fourth file
     */
    private UserFile4Entity toUserFile4Entity(List<String> rowStringList) {
        UserFile4Entity entity = new UserFile4Entity();
        entity.setId(rowStringList.get(0));
        entity.setProperty5(rowStringList.get(1));
        entity.setProperty6(rowStringList.get(2));
        return entity;
    }

    /**
     * Convert each row of the file into an entity objects
     *
     * @param rowStringList a string list stored all the list in the file
     * @return an Entity Object from the fifth file
     */
    private UserFile5Entity toUserFile5Entity(List<String> rowStringList) {
        UserFile5Entity entity = new UserFile5Entity();
        entity.setId(rowStringList.get(0));
        entity.setProperty7(rowStringList.get(1));
        return entity;
    }
}
