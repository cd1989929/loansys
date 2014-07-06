package spd.speeder.spdsample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private static final String url = "jdbc:db2://192.168.2.121:50000/SAMPLE";

    private static final String className = "com.ibm.db2.jcc.DB2Driver";

    private static final String user = "db2admin";

    private static final String password = "123456";

    public static void example(String[] args) {

        Connection con;
        try {
            Class.forName(className);

        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, "db2admin", "123456");
            Statement sta = con.createStatement();
            String sql = "";
            sql = "create table mg_MeetingRoomApply (ID integer not null unique, aduitReson varchar(255), "
                    + "aduitTimeStr varchar(255), applyPersonTel varchar(255), applyStatus integer not null, "
                    + "applyType integer not null, applyUsername varchar(255) not null, checkEquipments varchar(255), "
                    + "continueApplyEndDateStr varchar(255), continueApplyStartDateStr varchar(255), contractPerson varchar(255), "
                    + "contractTel varchar(255), isCheckEquipment integer not null, isNoticeAttendPersons integer not null, "
                    + "isNoticeByMail integer not null, isNoticeByMessage integer not null, meetStatus varchar(255), "
                    + "meetingApplyDateTimeStr varchar(255), meetingApplyDepartmentName varchar(255), meetingAttendPersonSize integer not null, "
                    + "meetingEndTime varchar(255), meetingID integer not null, meetingRemark varchar(255), meetingStartDateStr varchar(255), "
                    + "meetingStartTime varchar(255), meetingTopic varchar(255) not null, meetingApplyDepartment_ID integer, meetingRoomRes_ID integer, "
                    + "user_ID integer, primary key (ID))";
            //            sql = "CREATE TABLE T_POST(id integer not null unique,deleted CHAR(1) DEFAULT 0,"
            //                    + "creation_datetime Timestamp,modification_datetime Timestamp,"
            //                    + "title varchar(255) NULL,content varchar(2000) NULL,PRIMARY KEY (id))";
            sql = "INSERT INTO T_POST (id,deleted,creation_datetime,Modification_datetime,title, content) "
                    + "VALUES (1,1,'2014-6-25 22:27:44','2014-6-25 22:27:44','Emphasis classes', 'Convey meaning through')";
            boolean iscreate = sta.execute(sql);
            System.out.println(iscreate);
            con.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    /**
     * create table mg_MeetingRoomApply (ID integer not null unique, aduitReson varchar(255), "
        + "aduitTimeStr varchar(255), applyPersonTel varchar(255), applyStatus integer not null, "
        + "applyType integer not null, applyUsername varchar(255) not null, checkEquipments varchar(255), "
        + "continueApplyEndDateStr varchar(255), continueApplyStartDateStr varchar(255), contractPerson varchar(255), "
        + "contractTel varchar(255), isCheckEquipment integer not null, isNoticeAttendPersons integer not null, "
        + "isNoticeByMail integer not null, isNoticeByMessage integer not null, meetStatus varchar(255), "
        + "meetingApplyDateTimeStr varchar(255), meetingApplyDepartmentName varchar(255), meetingAttendPersonSize integer not null, "
        + "meetingEndTime varchar(255), meetingID integer not null, meetingRemark varchar(255), meetingStartDateStr varchar(255), "
        + "meetingStartTime varchar(255), meetingTopic varchar(255) not null, meetingApplyDepartment_ID integer, meetingRoomRes_ID integer, "
        + "user_ID integer, primary key (ID))
     * @param sql
     * @return
     */
    public static String createtable(String sql) {
        boolean iscreate = true;
        Connection con;
        try {
            Class.forName(className);
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            Statement sta = con.createStatement();
            iscreate = sta.execute(sql);
            con.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("SQLException: " + ex.getMessage());
        }
        return iscreate ? "0" : "1";
    }
}
