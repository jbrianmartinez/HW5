
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian Martinez
 */
public class HashTable<Key, Value> {
    private Hashtable ht;
    private int collisionCnt;
    private int keyCnt;
    
    public HashTable() {
        ht = new Hashtable();
        collisionCnt = 0;
        keyCnt = 0;
    }
    
    public int CollisionCount() {
        return collisionCnt;
    }
    
    public int KeyCount() {
        return keyCnt;
    }
    
    public Object Search(Key key) {
        return ht.get(key);
    }
    
    public void Insert(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        
        if (ht.containsKey(key)) {
            collisionCnt++;
        }
        else
            keyCnt++;
        
        ht.put(key, val);
    }
    
    public Enumeration<Key> GetKeys() {
        return ht.keys();
    }
    public void Delete(Key key) {
        ht.remove(key);
    }
}
