import com.sun.org.apache.bcel.internal.generic.NEW;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by P17179 on 2017/7/7.
 */
class Crawler {
    public String [] Crawl_List(String Web_url,String News_Type) throws Exception{
        String [] List_Array;
        Document doc = Jsoup.connect(Web_url).get();
        List_Array = new String [doc.select("div#Panel_Content table td img").size()];
        for (int i=0;i<doc.select("div#Panel_Content table td img").size();i++) {
            //Name : //System.out.println(doc.select("div#Panel_Content table td a").eq(i).text());
            //Url :  //System.out.println(doc.select("div#Panel_Content table td a").eq(i).attr("abs:href"));
            List_Array[i] = doc.select("div#Panel_Content table td a").eq(i).attr("abs:href");
        }
        return List_Array;
    }
    public String[] Crawl_Item(String Web_url,String News_Type) throws Exception{
        String [] News_Data = new String[7];
        Document doc = Jsoup.connect(Web_url).get();
        String time_temp,time_temp2;
        //url
        News_Data[0] = Web_url;

        //sitename
        News_Data[1] = doc.select("title").text();

        //type
        News_Data[2] = News_Type;

        //title
        News_Data[3] = doc.select("div#Panel_Content table span h1").text();

        //time
        time_temp = doc.select("div#Panel_Content table span#ctl03_Label_News").text();
        time_temp2 = time_temp.substring(time_temp.length()-4,time_temp.length());
        News_Data[4] = "2017-"+time_temp2.substring(0,2)+"-"+time_temp2.substring(2,4)+" 00:00:00";
        //System.out.println(News_Data[4]);

        //content
        News_Data[5] = doc.select("div#Panel_Content table span#ctl03_Label_News").text();

        //author
        News_Data[6] = "www.taiwandaily.net";

        return News_Data;

    }

}

