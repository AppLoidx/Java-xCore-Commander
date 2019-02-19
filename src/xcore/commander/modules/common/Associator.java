package xcore.commander.modules.common;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Arthur Kupriyanov
 */
public class Associator <K,V>{
    public HashMap<HashSet<K>,V> associations = new HashMap<>();
    private HashSet<V> values = new HashSet<>();

    public void putAssociation(@NotNull HashSet<K> hashSetKey, V value){
        if (values.contains(value)){
            HashSet<K> oldKey = null;
            for(HashSet<K> k: associations.keySet() ){
                if (associations.get(k).equals(value)){
                    oldKey = k;
                    break;
                }
            }
            HashSet<K> newKey = oldKey;
            Objects.requireNonNull(newKey).addAll(hashSetKey);
            removeAsscociation(oldKey);
            this.putAssociation(newKey, value);
        }
        associations.put(hashSetKey, value);
        values.add(value);
    }

    private void removeAsscociation(HashSet<K> key){
        values.remove(associations.get(key));
        associations.remove(key);
    }

    public V getAssociation(K association) throws AssociationNotFoundException {
        for(HashSet<K> k: associations.keySet() ){
            for (K k1 : k) {
                if (k1.equals(association)) {
                    return this.associations.get(k);
                }
            }
        }

        throw new AssociationNotFoundException("Ассоциация не найдена!");
    }

    public String tryGetAssociation(K association){
        for(HashSet<K> k: associations.keySet() ){
            for (K k1 : k) {
                if (k1.equals(association)) {
                    return this.associations.get(k).toString();
                }
            }
        }

        return association.toString();
    }


}
class AssociationNotFoundException extends Exception{
    AssociationNotFoundException(String msg){
        super(msg, new Exception(), true, false);
    }
}
