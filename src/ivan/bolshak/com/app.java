package ivan.bolshak.com;

import ivan.bolshak.com.impl.LongMapImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 15.08.2016.
 */
public class app {

    public static void main(String[] args) {
        LongMapImpl longMap = new LongMapImpl();

        System.out.println("is Empty test befor: "+longMap.isEmpty());
        System.out.println("size befor: "+longMap.size());
        longMap.put(1, "str_1");
        longMap.put(2, "str_2");
        longMap.put(3, "str_3");
        longMap.put(33, "str_33");
        longMap.put(44, "str_44");
        longMap.put(1, "str_1_again");


        System.out.println("Get from map by index 1: "+longMap.get(1));
        System.out.println("Get from map by index 2 : "+longMap.get(2));
        System.out.println("Get from map by index 3: "+longMap.get(3));
        System.out.println("Get from map by index 33: "+longMap.get(33));
        System.out.println("Get from map by index 44: "+longMap.get(44));
        System.out.println("Get from map by index str_1_again: "+longMap.get(1));

        int indexRemove = 3;
        System.out.println("Remove by index= "+indexRemove);
        longMap.remove(indexRemove);

        System.out.println("Get from map by index 20: "+longMap.get(1));
        System.out.println("Get from map by index 2 : "+longMap.get(2));
        System.out.println("Get from map by index 3: "+longMap.get(3));
        System.out.println("Get from map by index 33: "+longMap.get(33));
        System.out.println("Get from map by index 44: "+longMap.get(44));
        System.out.println("Get from map by index str_1_again: "+longMap.get(1));

        System.out.println("is Empty test after: "+longMap.isEmpty());

        System.out.println("containsKey test remove index: "+longMap.containsKey(indexRemove));
        System.out.println("containsKey test real index: "+longMap.containsKey(33));

        System.out.println("containsValue test true value: "+longMap.containsValue("str_33"));
        System.out.println("containsValue test false value: "+longMap.containsValue("ex"));

        System.out.println("size in the END: "+longMap.size());


        long arr[] = longMap.keys();

        for (long l: arr) {
            System.out.println("long[] keys(): "+l);
        }

        String  arrValues[] = longMap.values();

        for (String str: arrValues) {
            System.out.println("String[] values(): "+str);
        }

//        longMap.clear();
//        System.out.println("Size after clear: "+longMap.size());
//        System.out.println("isEmpty after clear: "+longMap.isEmpty());
//        System.out.println("Get from map by index 1 after clear: "+longMap.get(1));

//        longMap.doublingBaskets();
//        System.out.println("Size after doubling map: "+longMap.size());
//
//        System.out.println("Get from map by index 20: "+longMap.get(1));
//        System.out.println("Get from map by index 2 : "+longMap.get(2));
//        System.out.println("Get from map by index 3: "+longMap.get(3));
//        System.out.println("Get from map by index 33: "+longMap.get(33));
//        System.out.println("Get from map by index 44: "+longMap.get(44));
//        System.out.println("Get from map by index str_1_again: "+longMap.get(1));



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
