package MyPro.ONE.entity;

public class Depository {
    private static String userName="";
    private static int activNews_id;

    public static int getActivNews_id() {
        return activNews_id;
    }

    public static void setActivNews_id(int activNews_id) {
        Depository.activNews_id = activNews_id;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Depository.userName = userName;
    }
}
