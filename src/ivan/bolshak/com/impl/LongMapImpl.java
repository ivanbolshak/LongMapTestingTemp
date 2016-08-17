package ivan.bolshak.com.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 15.08.2016.
 */
public class LongMapImpl {
    private int sizeOfBasketsTable;
    private double loadBasket;
    private List<List<Entity>> baskets;

    private final static int DEFAULT_SIZE_OF_BASKETS_TABLE = 16;
    private final static double DEFAULT_LOAD_BASKET = 0.75;
//--------------constructors
    public LongMapImpl() {
        this(DEFAULT_SIZE_OF_BASKETS_TABLE);
//        this.sizeOfBasketsTable = 16;
//        this.loadBasket = 0.75;
//        this.baskets = new ArrayList<>(16);
    }

    public LongMapImpl(int sizeOfBasketsTable){
       this(sizeOfBasketsTable, DEFAULT_LOAD_BASKET);
    }

    public LongMapImpl(int sizeOfBasketsTable, double loadBasket ) {
        this.sizeOfBasketsTable = sizeOfBasketsTable;
        this.loadBasket = loadBasket;
        this.baskets = new ArrayList<List<Entity>>(sizeOfBasketsTable);


    }
//-------------body

    public void put(long key, String value){
        Entity entityNew = new Entity(key, value);
//        System.out.println("getBasketIndexByKey: "+getBasketIndexByKey(key));
        System.out.println("baskets size: "+baskets.size());
        List<Entity> entityList = baskets.get(getBasketIndexByKey(key)-1);

        if(entityList==null){
            entityList = new LinkedList<>();
            entityList.add(entityNew);
            return;
        }

        for (Entity entityTemp: entityList){
            if (entityNew.getKey()==entityTemp.getKey()){
                entityTemp.setValue(entityNew.getValue());
                return;
            }
        }
        entityList.add(entityNew);

    }

    public String get(long key){
        List<Entity> entityList = baskets.get(getBasketIndexByKey(key)-1);
        for (Entity entityTemp: entityList){
            if (key==entityTemp.getKey()){
                return entityTemp.getValue();
            }
        }
        return null;
    }





    private int getBasketIndexByKey(long key){
        return  hashCodeForKey(key)%sizeOfBasketsTable;
//        return  (int)entityNew.getKey()%sizeOfBasketsTable;
//      return (int)key%sizeOfBasketsTable;
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
