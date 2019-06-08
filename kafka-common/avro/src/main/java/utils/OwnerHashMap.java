package utils;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-07 18:57
 **/
public class OwnerHashMap<K,V> {
    public NodeMap<K,V>[] table;
    public int size;

    public OwnerHashMap() {
        table = new NodeMap[16];
    }

    public V get(K key){

        NodeMap<K, V> temp = table[getHash(key.hashCode(), table.length)];
        V value = null;
        if(temp !=null){
            while (temp != null){
                if(temp.key.equals(key)){
                    value =  temp.value;
                    break;
                }else {
                    temp =  temp.next;
                }
            }
        }
        return value;
    }
    public void put(K key, V value){

        NodeMap<K, V> nodeMap = new NodeMap<K, V>();

        nodeMap.hash = getHash(key.hashCode(), table.length);
        nodeMap.key = key;
        nodeMap.value = value;
        nodeMap.next = null;

        NodeMap<K, V> temp = table[nodeMap.hash];
        NodeMap<K, V> lastNode = null;
        if(temp == null){
            table[nodeMap.hash] = nodeMap;
        }else {

            while (temp != null){
                if(temp.key.equals(key)){
                    temp.value = value;
                }else {
                    lastNode = temp;
                    temp =  temp.next;
                }

            }
            lastNode.next = nodeMap;
        }
    }

    private int getHash(int v, int length) {
        return v&(length-1);
    }

    class NodeMap<K, V> {
        private int hash;
        private K key;
        private V value;
        private NodeMap<K, V> next;
    }

    public static void main(String[] args) {
        OwnerHashMap hashMap = new OwnerHashMap();
        hashMap.put("12663",123);
        hashMap.put("1234", 1234);
        hashMap.put("12345", 12345);

        System.out.println(hashMap.toString());
        System.out.println(hashMap.get("1234"));
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<table.length; i++){
            NodeMap<K, V> temp = table[i];
            while (temp != null){
                sb.append("\n").append("key").append(":").append(temp.key).append("-").append("value").append(":").append(temp.value);
                temp = temp.next;
            }
        }
        return sb.toString();
    }
}
