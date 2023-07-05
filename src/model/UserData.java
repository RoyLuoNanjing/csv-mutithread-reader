package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Use this class to store users' data
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public class UserData {
    String id;
    String property1;
    String property2;
    String property3;
    String property4;
    String property5;
    String property6;
    String property7;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    public String getProperty4() {
        return property4;
    }

    public void setProperty4(String property4) {
        this.property4 = property4;
    }

    public String getProperty5() {
        return property5;
    }

    public void setProperty5(String property5) {
        this.property5 = property5;
    }

    public String getProperty6() {
        return property6;
    }

    public void setProperty6(String property6) {
        this.property6 = property6;
    }

    public String getProperty7() {
        return property7;
    }

    public void setProperty7(String property7) {
        this.property7 = property7;
    }

    /**
     * To read all the CSV files and join each user's properties together
     *
     * @return A string of user's attributes in a specific format
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", id, property1, property2, property3, property4,property5,property6,property7);
    }

}
