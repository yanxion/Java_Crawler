/**
 * Created by P17179 on 2017/7/7.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class MySQL {

    public  Statement connect(String DBname,String Account,String Password) throws Exception{
        Connection conn = null;
        Statement st = null;

        Class.forName("com.mysql.jdbc.Driver");
        String datasource = "jdbc:mysql://localhost/"+DBname+"?user="+Account+"&password="+Password;
        conn =  DriverManager.getConnection(datasource);
        return conn.createStatement();
    }
}
