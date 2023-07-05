package dao;

import dao.entity.*;

import java.util.List;

/**
 * An interface to serve different categories of files as well as their reading methods
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public interface ReadUserFile {

    List<UserFile1Entity> getUserProperty1EntityByPath(String path);

    List<UserFile2Entity> getUserProperty2EntityByPath(String path) ;

    List<UserFile3Entity> getUserProperty3EntityByPath(String path) ;

    List<UserFile4Entity> getUserProperty4EntityByPath(String path) ;

    List<UserFile5Entity> getUserProperty5EntityByPath(String path) ;


}
