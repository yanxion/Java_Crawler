/**
 * Created by P17179 on 2017/7/7.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        MySQL News_DB = new MySQL();
        Crawler News = new Crawler();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String [] List_Array = null ;
        String [] News_Data = null;
        String sql_query = null;
        try {
            st = News_DB.connect("test", "user", "user");

            //sql_query = "INSERT INTO News_Item (url,sitename,type,title,time,content,author) VALUES ('1','2','3','4','5','6','7');";

            //st.execute(sql_query);
            List_Array = News.Crawl_List("http://www.taiwandaily.net/gp2.aspx?_p=qSVC5QJMmrgSnMLB3faGiTKNGj06VlbL","台灣政治");
            for (int i=0;i<List_Array.length;i++){
                System.out.println(List_Array[i]);
                News_Data = News.Crawl_Item(List_Array[i],"台灣政治");
                sql_query = "INSERT INTO News_Item (url,sitename,type,title,time,content,author) VALUES ('"+News_Data[0]+"','"+News_Data[1]+"','"+News_Data[2]+"','"+News_Data[3]+"','"+News_Data[4]+"','"+News_Data[5]+"','"+News_Data[6]+"');";
                //System.out.println(sql_query);
                st.execute(sql_query);
            }

        }catch(Exception e) {
            // handle the exception
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
