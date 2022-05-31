package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiRejectReporteGt {
    public void apiRejectReporteGt(int reportId) throws IOException {
        URL url = new URL("https://api-salestools-uat.int.vinid.dev/core/v1/gts/reports/issue-status");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Authorization", "Basic b3BzOjV1N2dpZDJZd004aXByR1Y=");
        con.setRequestProperty("Content-Type", "application/json");
        String data = "{\n    \"issue_status\": \"REJECTED\", \n    \""+ reportId +"\": 1224\n}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = con.getOutputStream();
        stream.write(out);
        System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
        con.disconnect();
    }
}
