package utils;

import java.time.Instant;

public class GenarateRandomData {   
    // Gen 011 + 8 number form Timestamp
    public static String randomPhone() {
        Long longTimeSecond = Instant.now().getEpochSecond();
        String stringTimeStamp = String.valueOf(longTimeSecond);
        String randomPhone = "011" + stringTimeStamp.substring(2, 9);
        return randomPhone;
    }

    public static void main(String[] args) {
        
        System.out.println(randomPhone());
    }
}
