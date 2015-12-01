package srv;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by bkniroula on 12/1/15.
 */
public class Servlet1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str1;
        while( (str1 = br.readLine()) != null ){
            sb.append(str1);
            System.out.println(str1);
        }
        JSONObject jObj = null;
        try {
            jObj = new JSONObject(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //assigning json to map
        Map map = new HashMap<String,String>();


        Iterator <String> itt = jObj.keys();
        String jsonKey;
        while (itt.hasNext()){
            jsonKey = itt.next();
            System.out.println(jsonKey);
            try {
                map.put(jsonKey,jObj.get(jsonKey));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        System.out.println("this is java map"+map);
        //printing map key value pair

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<String> itr = map.keySet().iterator();
        Collection<String> col = map.values();

        System.out.println("\n \n this is set");

        for (Map.Entry<String, String> entry : entrySet) {

            if(entry.getKey().toString() == "array"){
                System.out.println(entry.getKey());
            }else {
              //  System.out.println(entry.getKey() + "   :    " + entry.getValue());
            }
        }


        System.out.println("\n \n this is iterator");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println( "\n \n this is collection");
//        for(String str:col){
//            System.out.println(str);
//
//        }









        JSONObject jsonObject=new JSONObject();




        try {
            jsonObject.put("key1","hi");
            jsonObject.put("key2","value2");
            jsonObject.put("key3","value3");
            jsonObject.put("key4","value4");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //response object
        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toString());
        





//        PrintWriter out = response.getWriter();
//        out.print(ja);
//        out.flush();



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
