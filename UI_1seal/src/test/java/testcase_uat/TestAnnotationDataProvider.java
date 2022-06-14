package testcase_uat;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.DataProvider;

public class TestAnnotationDataProvider {
  
    public static Object[][] dataProviderMethod() {


        return new Object[][] {{ "data one"}, { "data two"  }, { "data three"  } } ;
    }


    public static void main(String[] args) {

        Object[][] a = new Object[][] {{ "data one"}, { "data two"  }, { "data three"  } } ;

        Object tenmang1chieu;
        Object[][] tenmang2chieu;


        System.out.println("Data is: " + String.valueOf(a[0][0]));
        int b = a.length;
        System.out.println(b);


        ArrayList list = new ArrayList<>();
        List<String> arrayList = new ArrayList<String>();



        ArrayList<String> arrayList2 = new ArrayList<String>();

        
        arrayList.add("e");
    }


}
