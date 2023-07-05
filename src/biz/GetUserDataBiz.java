package biz;

import dao.ReadUserFile;
import dao.entity.*;
import model.UserData;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


/**
 * Get all the users' data
 *
 * @author Liangliang Luo
 * @version 04-09-2023
 */
public class GetUserDataBiz {

    private ReadUserFile readUserFile;

    /**
     * Select the specific ReaderUserFile to implement
     *
     * @param readUserFile  the specific ReaderUserFile
     */
    public GetUserDataBiz(ReadUserFile readUserFile) {
        this.readUserFile = readUserFile;
    }


    /**
     * Read all the files and store datas in a list of Entity Objects
     * Then convert entities into userData objects
     * Multi-thread is used here for acceleration
     *
     * @param filePathArr An array of target files
     * @return A list of userdata objects
     */
    public List<UserData> process(String[] filePathArr) throws Exception {
        List<UserData> dataList = new ArrayList<>();

        // Obtain the data(Multi-thread)
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<List<UserFile1Entity>> future1 = executorService.submit(() -> readUserFile.getUserProperty1EntityByPath(filePathArr[0]));
        Future<List<UserFile2Entity>> future2 = executorService.submit(() -> readUserFile.getUserProperty2EntityByPath(filePathArr[1]));
        Future<List<UserFile3Entity>> future3 = executorService.submit(() -> readUserFile.getUserProperty3EntityByPath(filePathArr[2]));
        Future<List<UserFile4Entity>> future4 = executorService.submit(() -> readUserFile.getUserProperty4EntityByPath(filePathArr[3]));
        Future<List<UserFile5Entity>> future5 = executorService.submit(() -> readUserFile.getUserProperty5EntityByPath(filePathArr[4]));

        // Excute all the threads at the same time
        List<UserFile1Entity> userProperty1EntityList = future1.get();
        List<UserFile2Entity> userProperty2EntityList = future2.get();
        List<UserFile3Entity> userProperty3EntityList = future3.get();
        List<UserFile4Entity> userProperty4EntityList = future4.get();
        List<UserFile5Entity> userProperty5EntityList = future5.get();

        executorService.shutdown();
        //Collect all the user ID
        Set<String> userIdSet = new HashSet<>();
        userIdSet.addAll(userProperty1EntityList.stream().map(UserFile1Entity::getId).collect(Collectors.toList()));
        userIdSet.addAll(userProperty2EntityList.stream().map(UserFile2Entity::getId).collect(Collectors.toList()));
        userIdSet.addAll(userProperty3EntityList.stream().map(UserFile3Entity::getId).collect(Collectors.toList()));
        userIdSet.addAll(userProperty4EntityList.stream().map(UserFile4Entity::getId).collect(Collectors.toList()));
        userIdSet.addAll(userProperty5EntityList.stream().map(UserFile5Entity::getId).collect(Collectors.toList()));

        // Convert the entityList into a map of user id (K) and its object (v)
        Map<String, UserFile1Entity> map1 = userProperty1EntityList.stream().collect(Collectors.toMap(UserFile1Entity::getId, userFile1Entity -> userFile1Entity));
        Map<String, UserFile2Entity> map2 = userProperty2EntityList.stream().collect(Collectors.toMap(UserFile2Entity::getId, userFile2Entity -> userFile2Entity));
        Map<String, UserFile3Entity> map3 = userProperty3EntityList.stream().collect(Collectors.toMap(UserFile3Entity::getId, userFile3Entity -> userFile3Entity));
        Map<String, UserFile4Entity> map4 = userProperty4EntityList.stream().collect(Collectors.toMap(UserFile4Entity::getId, userFile4Entity -> userFile4Entity));
        Map<String, UserFile5Entity> map5 = userProperty5EntityList.stream().collect(Collectors.toMap(UserFile5Entity::getId, userFile5Entity -> userFile5Entity));

        //Loop the ID Set and create User Object as well as the property setting
        for (String id : userIdSet) {
            UserData userData = new UserData();
            userData.setId(id);

            UserFile1Entity entity1 = map1.get(id);
            UserFile2Entity entity2 = map2.get(id);
            UserFile3Entity entity3 = map3.get(id);
            UserFile4Entity entity4 = map4.get(id);
            UserFile5Entity entity5 = map5.get(id);

            userData.setProperty1(entity1 == null ? null : entity1.getProperty1());
            userData.setProperty2(entity2 == null ? null : entity2.getProperty2());
            userData.setProperty3(entity2 == null ? null : entity2.getProperty3());
            userData.setProperty4(entity3 == null ? null : entity3.getProperty4());
            userData.setProperty5(entity4 == null ? null : entity4.getProperty5());
            userData.setProperty6(entity4 == null ? null : entity4.getProperty6());
            userData.setProperty7(entity5 == null ? null : entity5.getProperty7());

            dataList.add(userData);
        }
        return dataList;
    }
}
