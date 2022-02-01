package connection;

import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RunningScript {

    private static String url = "jdbc:mysql://localhost:3306/bmr";
    private static String user = "root";
    private static String password = "root";
    String sqlScriptLink = new File("").getAbsolutePath() + "\\crudApplication\\src\\main\\resources\\simpleScript.sql";

    public void startScript() {

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader(sqlScriptLink));
            sr.runScript(reader);
            reader.close();
            con.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }

}
