package ivan.bolshak.com.impl;

import ivan.bolshak.com.LongMap;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 15.08.2016.
 */

public class LongMapImpl<V> implements LongMap<V> {
    private int sizeOfBasketsTable;
    private double loadBasket;
    private List[] baskets;

    private final static int DEFAULT_SIZE_OF_BASKETS_TABLE = 16;
    private final static double DEFAULT_LOAD_BASKET = 0.75;

//  --------------constructors

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

//  -------------body

    public V put(long key, V value){
        Entity entityNew = new Entity(key, value);
//        System.out.println("getBasketIndexByKey: "+(getBasketIndexByKey(key)));
//        System.out.println("baskets size: "+baskets.length);


        if(baskets[getBasketIndexByKey(key)]==null){
            List<Entity> entityList = new LinkedList<>();
            entityList.add(entityNew);
            baskets[getBasketIndexByKey(key)] = entityList;
//            System.out.println("put1");
            return value;
        }

        List<Entity> entityList = baskets[getBasketIndexByKey(key)];

        for (Entity entityTemp: entityList){
            if (entityNew.getKey()==entityTemp.getKey()){
                entityTemp.setValue(entityNew.getValue());
//                System.out.println("put2");
                return value;
            }
        }

        entityList.add(entityNew);
//        System.out.println("put3");
        if (entityList.size()>(sizeOfBasketsTable*loadBasket)){
            doublingBaskets();
        }

        return value;
    }

    public V get(long key){
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

    public V remove(long key){
        int basketIndex = getBasketIndexByKey(key);

        if (null == baskets[basketIndex]) {
            return null;
        }
        List<Entity> entityList = baskets[basketIndex];

        for (Entity entityTemp: entityList){
            if (key==entityTemp.getKey()){
                entityList.remove(entityTemp);
                return entityTemp.getValue();
            }
        }
        return null;
    }


    public boolean isEmpty(){
       for (int i=0; i<sizeOfBasketsTable; i++){
           if (baskets[i]!=null)
               return false;
       }
        return true;
    }

    public boolean containsKey(long key){
        int basketIndex = getBasketIndexByKey(key);
        if (null == baskets[basketIndex]) {
            return false;
        }
        List<Entity> entityList = baskets[basketIndex];
        for (Entity entityTemp: entityList){
            if (key==entityTemp.getKey()){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value){
       V [] values = values();
        for (V str: values){
            if (value.equals(str)){
                return true;
            }
        }
        return false;
    }


    public long[] keys(){
        int sizeArr = (int) size();
        long []arr = new long[sizeArr];
        int countPoint = 0;

             for (int i=0; i<sizeOfBasketsTable; i++){
                if (baskets[i]!=null){
                    List<Entity> entityList = baskets[i];
                    for (Entity entityTemp: entityList){
                        arr[countPoint] = entityTemp.getKey();
                        countPoint++;
                    }
                }
            }

        return arr;
    }

    public V[] values(){
        List<V> values = new LinkedList<>();

        for (List<Entity> entities: baskets ){
            if (entities!=null) {
                for (Entity entity : entities) {
                    values.add(entity.getValue());
                }
            }
        }

        V [] result = (V[]) values.toArray();

//        for (int i=0; i<result.length; i++){
//            System.out.println("Value result index: "+i+" ; value: "+result[i]);
//        }

        return result;

    }


    public long size(){
        long sizeCount = 0;
        for (int i=0; i<sizeOfBasketsTable; i++){
            if (baskets[i]!=null) {
                sizeCount += (long)baskets[i].size();
            }
        }
        return sizeCount;
    }

    public void clear(){
//        baskets = null;
        baskets = new List[DEFAULT_SIZE_OF_BASKETS_TABLE];
    }


//    -----------private methods------------

    public void doublingBaskets(){
        List[] basketsOld = baskets;
        sizeOfBasketsTable = sizeOfBasketsTable*2;
        baskets = new List[sizeOfBasketsTable];

        for (List<Entity> entitiesOld: basketsOld ){
            if (entitiesOld!=null) {
                for (Entity entity : entitiesOld) {
                    put(entity.getKey(), entity.getValue());

                }
            }
        }

        System.out.println("New Baskets length: "+baskets.length);

        basketsOld = null;

    }

    private int getBasketIndexByKey(long key){
//        return  (hashCodeForKey(key)%sizeOfBasketsTable)-1;
     return (int)(key%sizeOfBasketsTable)-1;
    }

    private int hashCodeForKey(long key) {
        return (int) (key ^ (key >>> 32));
    }

//    ---------------inner classes----------------

    public class Entity {
        private long key;
        private V value;

        public Entity() {
        }

        public Entity(long key, V value) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

//        public void setKey(long key) {
//            this.key = key;
//        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }


    }


}

//    public long[] keys(){
//        List<Long> longs = new LinkedList<>();
//
//        for (List<Entity> entities: baskets ){
//            for (Entity entity: entities){
//                longs.add(entity.getKey());
//            }
//        }
//
//        long [] result = longs.toArray(new Long[longs.size()]);
//        return result;
//    }
