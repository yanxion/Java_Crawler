import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Created by P17179 on 2017/7/7.
 */
class MySQL {

    public  Statement connect(String DBname,String Account,String Password) throws Exception{
        Connection conn = null;
        Statement st = null;


        Class.forName("com.mysql.jdbc.Driver");
        String datasource = "jdbc:mysql://localhost/"+DBname+"?user="+Account+"&password="+Password;
        conn =  DriverManager.getConnection(datasource);
        return conn.createStatement();

                /*
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            String datasource = "jdbc:mysql://localhost/"+DBname+"?user="+Account+"&password="+Password;
            conn = DriverManager.getConnection(datasource);
            System.out.println("連接成功MySQL");
            st = conn.createStatement();
                */


    }
}
