package ivan.bolshak.com;

import ivan.bolshak.com.impl.LongMapImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 15.08.2016.
 */
public class app {

    public static void main(String[] args) {
        LongMapImpl longMap = new LongMapImpl();

        longMap.put(20, "str_20");
        longMap.put(2, "str_2");
        longMap.put(3, "str_22");
        longMap.put(33, "str_33");
        longMap.put(44, "str_44");
        longMap.put(55, "str_55");


        System.out.println("Get from map by index 1: "+longMap.get(1));
        System.out.println("Get from map by index 2 : "+longMap.get(2));
        System.out.println("Get from map by index 3: "+longMap.get(3));
        System.out.println("Get from map by index 33: "+longMap.get(33));
        System.out.println("Get from map by index 44: "+longMap.get(44));
        System.out.println("Get from map by index 55: "+longMap.get(55));




    }
}

//
//    List<String> arr1 = new ArrayList<>();
//
//    List<String> arr2 = new ArrayList<>(6);
//
//    String [] arr = new String[6];
//
//for (int i = 0;i<6;i++){
//        arr1.add(null);
//        }
//
//        for (String str: arr){
//        System.out.println("for arr: "+str);
//        }
//
//
//
//
//        System.out.println("arr1: "+arr1.indexOf(2));
//        System.out.println("arr2: "+arr2.size());
//        System.out.println("arr: "+arr.length);
