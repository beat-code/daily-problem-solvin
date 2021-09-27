package java_ex.lld;

public class GenericCache {
    public interface Cache<K,V> {
        void put(K key, V value);
        V get(K key);
    }

    public static class LRUCache<K,V> implements Cache<K,V>{

        @Override
        public void put(K key, V value) {

        }

        @Override
        public V get(K key) {
            return null;
        }
    }

    public static class LFUCache<K,V> implements Cache<K,V>{

        @Override
        public void put(K key, V value) {

        }

        @Override
        public V get(K key) {
            return null;
        }
    }

    public static class CacheFactory<K,V>{
        public Cache<K,V> getCache(CacheStrategy strategy){
            if(strategy.equals(CacheStrategy.LRU)) return new LRUCache<>();
            return new LFUCache<>();
        }
    }

    public static enum CacheStrategy{
        LRU,LFU,TIMEOUT;
    }
}
