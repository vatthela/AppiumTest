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


public class ApiGetGtIsReported {
    public ApiGetGtIsReported(int gt_id){
        CommonGetAPI common = new CommonGetAPI();
        String curl = "https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports?gt_id=" + gt_id + "&status=WAITING";
        String basicAuth = "b3BzOjV1N2dpZDJZd004aXByR1Y=";
        String rs = common.getResponseFromAPI(curl, basicAuth, "GET");
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        GtReportedObject gtReportObject = gson.fromJson(rs, GtReportedObject.class);
        System.out.println(gtReportObject.data.get(0).id);
    }
}
