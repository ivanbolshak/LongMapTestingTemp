package ivan.bolshak.com;

import ivan.bolshak.com.impl.LongMapImpl;

import java.util.*;

/**
 * Created by Ivan on 15.08.2016.
 */
public class app {

    public static void main(String[] args) {
        LongMap<String> longMap = new LongMapImpl<>();

//        System.out.println("is Empty test befor: "+longMap.isEmpty());
//        System.out.println("size befor: "+longMap.size());
//        longMap.put(1, 1);
//        longMap.put(2, 1);
//        longMap.put(3, 3);
//        longMap.put(33, 33);
//        longMap.put(44, 44);
//        longMap.put(1, 111);
//
//
//        System.out.println("Get from map by index 1: "+longMap.get(1));
//        System.out.println("Get from map by index 2 : "+longMap.get(2));
//        System.out.println("Get from map by index 3: "+longMap.get(3));
//        System.out.println("Get from map by index 33: "+longMap.get(33));
//        System.out.println("Get from map by index 44: "+longMap.get(44));
//        System.out.println("Get from map by index str_1_again: "+longMap.get(1));

        int k = 55;

        for (int i=0; i<k; i++){
//            System.out.println("i: "+i);
            longMap.put((long) i, String.valueOf("str_"+(i+1)));
        }
        System.out.println("size: "+longMap.size());
        System.out.println("Values must by true: "+longMap.containsValue("str_1"));
//        for (int i=0; i<k/2; i++){
//            System.out.println("i: "+i);
//            longMap.remove((long) i*12);
//        }
        System.out.println("size: "+longMap.size());

        Object [] arrValue = longMap.values();
        int i =0;
        for (Object obj: arrValue ){

            System.out.println("i: "+(i++)+" ;obj: "+obj);
        }



//--------------------
        int indexRemove = 3;
//        System.out.println("Remove by index= "+indexRemove);
        System.out.println("Remove V: "+longMap.remove(indexRemove));

        System.out.println("Get from map by index 20: "+longMap.get(1));
        System.out.println("Get from map by index 2 : "+longMap.get(2));
        System.out.println("Get from map by index 3: "+longMap.get(3));
        System.out.println("Get from map by index 33: "+longMap.get(33));
        System.out.println("Get from map by index 44: "+longMap.get(44));
        System.out.println("Get from map by index str_1_again: "+longMap.get(1));
//
        System.out.println("is Empty test after: "+longMap.isEmpty());
//
        System.out.println("containsKey test remove index: "+longMap.containsKey(indexRemove));
        System.out.println("containsKey test real index: "+longMap.containsKey(33));
//
//        System.out.println("containsValue test true value: "+longMap.containsValue(33));
//        System.out.println("containsValue test false value: "+longMap.containsValue(99999));
//
        System.out.println("size in the END: "+longMap.size());
//
//
//        long arr[] = longMap.keys();
//
//        for (long l: arr) {
//            System.out.println("long[] keys(): "+l);
//        }
//---------------------

//        String[] valuesArr = (String[])longMap.values();
//        Integer [] valuesArr = longMap.values();




//        String[] arrValues = longMap.values();
//
//        for (String str: arrValues) {
//            System.out.println("String[] values(): "+str);
//        }

        longMap.clear();
        System.out.println("Size after clear: "+longMap.size());
        System.out.println("isEmpty after clear: "+longMap.isEmpty());
        System.out.println("Get from map by index 1 after clear: "+longMap.get(1));

//        longMap.doublingBaskets();
//        System.out.println("Size after doubling map: "+longMap.size());
////
//        System.out.println("Get from map by index 1: "+longMap.get(1));
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
