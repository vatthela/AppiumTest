package utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.remote.http.HttpResponse;

import model.GtReportedObject;


public class CommonGetAPI {
    public String getResponseFromAPI (String curl, String basicAuth, String method) {
        URL url = null;
        try {
            url = new URL(curl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
            HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        con.setRequestProperty("accept", "application/json");
        con.setRequestProperty("authorization", "Basic "+basicAuth);

        try {
            con.setRequestMethod(method);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        con.setDoOutput(true);
        int responseCode = 0;
        try {
            responseCode = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        if (responseCode >= 200 && responseCode < 400) {
            try {
                inputStreamReader = new InputStreamReader(con.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            inputStreamReader = new InputStreamReader(con.getErrorStream());
        }
        BufferedReader in = new BufferedReader(inputStreamReader);
        String inputLine = null;
        StringBuilder response = new StringBuilder();
        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.append(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();    
    }
}
