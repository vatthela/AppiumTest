package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import model.GtReportedObject;

public class ApiReportGtOPS {

    // Input variable "gt_id" or "gt_phone"
    public static int apiGetGtIsReported(String type, int gt) {
        CommonGetAPI common = new CommonGetAPI();
        String curl = "";
        if (type == "gt_id") {
            curl = "https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports?gt_id=" + gt + "&status=WAITING";
        }
        if (type == "gt_phone") {
            curl = "https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports?gt_phone=" + gt + "&status=WAITING";
        }
        String basicAuth = "b3BzOjV1N2dpZDJZd004aXByR1Y=";
        String rs = common.getResponseFromAPI(curl, basicAuth, "GET");
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        GtReportedObject gtReportObject = gson.fromJson(rs, GtReportedObject.class);
        int reportId = gtReportObject.data.get(0).id;
        return reportId;
    }

    public static void apiRejectedReportGt(int reportId) throws IOException {
        URL url = new URL("https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports/issue-status");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Basic b3BzOjV1N2dpZDJZd004aXByR1Y=");
        con.setRequestProperty("Content-Type", "application/json");
        String data = "{\n    \"issue_status\": \"REJECTED\", \n    \"report_id\": " + reportId + "\n}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = con.getOutputStream();
        stream.write(out);
        System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
        con.disconnect();
    }

    public static void apiApprovedReportGt(int reportId) throws IOException {
        URL url = new URL("https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports/issue-status");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Basic b3BzOjV1N2dpZDJZd004aXByR1Y=");
        con.setRequestProperty("Content-Type", "application/json");
        String data = "{\n    \"issue_status\": \"REJECTED\", \n    \"report_id\": " + reportId + "\n}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = con.getOutputStream();
        stream.write(out);
        System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
        con.disconnect();
    }
}
