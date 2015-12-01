package srv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Perplex on 12/1/2015.
 */
@WebServlet(name = "ServletArray")
public class ServletArray extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        System.out.println(br);
        String str1;
        while( (str1 = br.readLine()) != null ){
            sb.append(str1);

        }
        JSONArray jObj = null;
        try {
            jObj = new JSONArray(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(jObj);

        for (int i=0;i<jObj.length();i++){
            try {
                System.out.println(jObj.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        ArrayList<String> al = new ArrayList();
        al.add("hello bro ");
        al.add("Where are ");
        al.add("you ");
        al.add("?");

        JSONArray ja = new JSONArray();
        ja.put("hello bro ");
        ja.put("Where are ");
        ja.put("you ");
        ja.put("?");

        //ja.put(al);
        System.out.println(ja);

        response.setContentType("application/json");
        response.getWriter().write(ja.toString());



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
