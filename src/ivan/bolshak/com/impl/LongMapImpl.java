package ivan.bolshak.com.impl;

import ivan.bolshak.com.LongMap;

import java.util.LinkedList;
import java.util.List;

public class LongMapImpl<V> implements LongMap<V> {
    private int sizeOfBasketsTable;
    private double loadBasket;
    private List[] baskets;

    private final static int DEFAULT_SIZE_OF_BASKETS_TABLE = 16;
    private final static double DEFAULT_LOAD_BASKET = 0.75;

//  ----------constructors

    public LongMapImpl() {
        this(DEFAULT_SIZE_OF_BASKETS_TABLE);
    }

    public LongMapImpl(int sizeOfBasketsTable){
       this(sizeOfBasketsTable, DEFAULT_LOAD_BASKET);
    }

    public LongMapImpl(int sizeOfBasketsTable, double loadBasket ) {
        this.sizeOfBasketsTable = sizeOfBasketsTable;
        this.loadBasket = loadBasket;
        this.baskets = new List[sizeOfBasketsTable];
    }

//  -------------body

    @Override
    public V put(long key, V value){
        int basketIndex = getBasketIndexByKey(key);
        Entity entityNew = new Entity(key, value);

        if(baskets[basketIndex]==null){
            List<Entity> entityList = new LinkedList<>();
            entityList.add(entityNew);
            baskets[getBasketIndexByKey(key)] = entityList;
            return value;
        }

        List<Entity> entityList = baskets[basketIndex];

        for (Entity entityTemp: entityList){
            if (entityNew.getKey()==entityTemp.getKey()){
                entityTemp.setValue(entityNew.getValue());
                return value;
            }
        }

        entityList.add(entityNew);
        if (entityList.size()>(sizeOfBasketsTable*loadBasket)){
            doublingBaskets();
        }

        return value;
    }

    @Override
    public V get(long key){
        int basketIndex = getBasketIndexByKey(key);

        if (null == baskets[basketIndex]) {
            return null;
        }

        List<Entity> entityList = baskets[basketIndex];

        for (Entity entityTemp: entityList){
            if (key==entityTemp.getKey()){
                return entityTemp.getValue();
            }
        }
        return null;
    }

    @Override
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

    @Override
    public boolean isEmpty(){
       for (int i=0; i<sizeOfBasketsTable; i++){
           if (baskets[i]!=null)
               return false;
       }
        return true;
    }

    @Override
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

    @Override
    public boolean containsValue(V value){
       V [] values = values();
        for (V str: values){
            if (value.equals(str)){
                return true;
            }
        }
        return false;
    }

    @Override
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

//    @Override
//    public V[] values(){
//        int sizeArr = (int) size();
//        V []arr = (V[]) new Object[sizeArr];
//        int countPoint = 0;
//
//        for (int i=0; i<sizeOfBasketsTable; i++){
//            if (baskets[i]!=null){
//                List<Entity> entityList = baskets[i];
//                for (Entity entityTemp: entityList){
//                    arr[countPoint] = entityTemp.getValue();
//                    countPoint++;
//                }
//            }
//        }
//
//        return arr;
//    }

    @Override
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

        return result;
    }

    @Override
    public long size(){
        long sizeCount = 0;
        for (int i=0; i<sizeOfBasketsTable; i++){
            if (baskets[i]!=null) {
                sizeCount += (long)baskets[i].size();
            }
        }
        return sizeCount;
    }

    @Override
    public void clear(){
        baskets = new List[DEFAULT_SIZE_OF_BASKETS_TABLE];
    }

//    -----------private methods------------

    private void doublingBaskets(){
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

        basketsOld = null;
    }

    private int getBasketIndexByKey(long key){
//        return  hashCodeForKey(key)%sizeOfBasketsTable;
     return (int)key%sizeOfBasketsTable;
    }

    private int hashCodeForKey(long key) { /*used with previos method getBasketIndexByKey() if needed use hashCode*/
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

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }


    }
}
