package ivan.bolshak.com.impl;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 15.08.2016.
 */
public class LongMapImpl {
    private int sizeOfBasketsTable;
    private double loadBasket;
//    private List<List<Entity>> baskets;
    private List[] baskets;

    private final static int DEFAULT_SIZE_OF_BASKETS_TABLE = 16;
    private final static double DEFAULT_LOAD_BASKET = 0.75;
//--------------constructors
    public LongMapImpl() {
        this(DEFAULT_SIZE_OF_BASKETS_TABLE);

    }

    public LongMapImpl(int sizeOfBasketsTable){
       this(sizeOfBasketsTable, DEFAULT_LOAD_BASKET);
    }

    public LongMapImpl(int sizeOfBasketsTable, double loadBasket ) {
        this.sizeOfBasketsTable = sizeOfBasketsTable;
        this.loadBasket = loadBasket;
//        this.baskets = new ArrayList<List<Entity>>(sizeOfBasketsTable);
        this.baskets = new List[sizeOfBasketsTable];


    }
//-------------body

    public void put(long key, String value){
        Entity entityNew = new Entity(key, value);
//        System.out.println("getBasketIndexByKey: "+(getBasketIndexByKey(key)));
//        System.out.println("baskets size: "+baskets.length);


        if(baskets[getBasketIndexByKey(key)]==null){
            List<Entity> entityList = new LinkedList<>();
            entityList.add(entityNew);
            baskets[getBasketIndexByKey(key)] = entityList;
//            System.out.println("put1");
            return;
        }

        List<Entity> entityList = baskets[getBasketIndexByKey(key)];

        for (Entity entityTemp: entityList){
            if (entityNew.getKey()==entityTemp.getKey()){
                entityTemp.setValue(entityNew.getValue());
//                System.out.println("put2");
                return;
            }
        }
        entityList.add(entityNew);
//        System.out.println("put3");

    }

    public String get(long key){
        int basketIndex = getBasketIndexByKey(key);

        if (null == baskets[basketIndex]) {
            return null;
        }




        List<Entity> entityList = baskets[basketIndex];
//        System.out.println("getBasketIndexByKey in GET: "+(getBasketIndexByKey(key)));
//        System.out.println("baskets size in GET: "+baskets.length);

        for (Entity entityTemp: entityList){
            if (key==entityTemp.getKey()){
                return entityTemp.getValue();
            }
        }
        return null;
    }





    private int getBasketIndexByKey(long key){
//        return  (hashCodeForKey(key)%sizeOfBasketsTable)-1;
//        return  (int)(entityNew.getKey()%sizeOfBasketsTable)-1;
      return (int)(key%sizeOfBasketsTable)-1;
    }
    private int hashCodeForKey(long key) {
        return (int) (key ^ (key >>> 32));
    }


    //    ---------------inner classes----------------

    public class Entity {
        private long key;
        private String value;

        public Entity() {
        }

        public Entity(long key, String value) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

//        public void setKey(long key) {
//            this.key = key;
//        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }


    }


}
