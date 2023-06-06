package utils;

public class Convert {
    public static int convertMoneyToNumber(String stringText) {
        String[] arryMoney  = stringText.split("đ");
        int number = Integer.parseInt(arryMoney[0].replaceAll(",", ""));
        return number;
    }
}
