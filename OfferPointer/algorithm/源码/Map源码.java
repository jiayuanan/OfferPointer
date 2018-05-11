package Դ��;
/**
 * 2018��4��17�� @author jiayuanan
 * MapԴ��.java
 * 
 */
import java.io.IOException;
import java.io.Serializable;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
public class MapԴ�� {

}

class HashMap<K,V>  
extends AbstractMap<K,V>  
implements Map<K,V>, Cloneable, Serializable  
{  

// Ĭ�ϵĳ�ʼ����������ΪHashMap�в۵���Ŀ����16����ʵ������������2���������ݡ�  
static final int DEFAULT_INITIAL_CAPACITY = 16;  

// ���������������2������С��2��30�η��������������󽫱����ֵ�滻��  
static final int MAXIMUM_CAPACITY = 1 << 30;  

// Ĭ�ϼ�������Ϊ0.75 
static final float DEFAULT_LOAD_FACTOR = 0.75f;  

// �洢���ݵ�Entry���飬������2���ݡ�  
// HashMap�������������ͻ��ÿһ��Entry��������һ����������  
transient Entry[] table;  

// HashMap�ĵײ����������ò۵�����  
transient int size;  

// HashMap����ֵ�������ж��Ƿ���Ҫ����HashMap��������threshold = ����*�������ӣ�  
int threshold;  

// ��������ʵ�ʴ�С  
final float loadFactor;  

// HashMap���ı�Ĵ���  
transient volatile int modCount;  

// ָ����������С���͡��������ӡ��Ĺ��캯��  
public HashMap(int initialCapacity, float loadFactor) {  
    if (initialCapacity < 0)  
        throw new IllegalArgumentException("Illegal initial capacity: " +  
                                           initialCapacity);  
    // HashMap���������ֻ����MAXIMUM_CAPACITY  
    if (initialCapacity > MAXIMUM_CAPACITY)  
        initialCapacity = MAXIMUM_CAPACITY;  
    //������˲���С��0
    if (loadFactor <= 0 || Float.isNaN(loadFactor))  
        throw new IllegalArgumentException("Illegal load factor: " +  
                                           loadFactor);  

    // �ҳ�������initialCapacity������С��2����  
    int capacity = 1;  
    while (capacity < initialCapacity)  
        capacity <<= 1;  

    // ���á��������ӡ�  
    this.loadFactor = loadFactor;  
    // ���á�HashMap��ֵ������HashMap�д洢���ݵ������ﵽthresholdʱ������Ҫ��HashMap�������ӱ���  
    threshold = (int)(capacity * loadFactor);  
    // ����Entry���飬������������  
    table = new Entry[capacity];  
    //init();  
}  

// ָ����������С���Ĺ��캯��  
public HashMap(int initialCapacity) {  
    this(initialCapacity, DEFAULT_LOAD_FACTOR);  
}  

// Ĭ�Ϲ��캯����  
public HashMap() {  
    // ���á��������ӡ�ΪĬ�ϼ�������0.75  
    this.loadFactor = DEFAULT_LOAD_FACTOR;  
    // ���á�HashMap��ֵ������HashMap�д洢���ݵ������ﵽthresholdʱ������Ҫ��HashMap�������ӱ���  
    threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);  
    // ����Entry���飬������������  
    table = new Entry[DEFAULT_INITIAL_CAPACITY];  
    //init();  
}  

// ��������Map���Ĺ��캯��  
public HashMap(Map<? extends K, ? extends V> m) {  
    this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,  
                  DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);  
    // ��m�е�ȫ��Ԫ�������ӵ�HashMap��  
    putAllForCreate(m);  
}  

//��hashֵ�ķ��������¼���hashֵ
static int hash(int h) {  
    h ^= (h >>> 20) ^ (h >>> 12);  
    return h ^ (h >>> 7) ^ (h >>> 4);  
}  

// ����h�������е�����ֵ��������&����ȡģ��ּ������Ч�� 
// h & (length-1)��֤����ֵ��С��length  
static int indexFor(int h, int length) {  
    return h & (length-1);  
}  

public int size() {  
    return size;  
}  

public boolean isEmpty() {  
    return size == 0;  
}  

// ��ȡkey��Ӧ��value  
public V get(Object key) {  
    if (key == null)  
        return getForNullKey();  
    // ��ȡkey��hashֵ  
    int hash = hash(key.hashCode());  
    // �ڡ���hashֵ��Ӧ�������ϲ��ҡ���ֵ����key����Ԫ��  
    for (Entry<K,V> e = table[indexFor(hash, table.length)];  
         e != null;  
         e = e.next) {  
        Object k;  
        //�ж�key�Ƿ���ͬ
        if (e.hash == hash && ((k = e.key) == key || key.equals(k)))  
            return e.value;  
    }
    //û�ҵ��򷵻�null
    return null;  
}  

// ��ȡ��keyΪnull����Ԫ�ص�ֵ  
// HashMap����keyΪnull����Ԫ�ش洢��table[0]λ�ã�����һ���Ǹ�����ĵ�һ��λ�ã�  
private V getForNullKey() {  
    for (Entry<K,V> e = table[0]; e != null; e = e.next) {  
        if (e.key == null)  
            return e.value;  
    }  
    return null;  
}  

// HashMap�Ƿ����key  
public boolean containsKey(Object key) {  
    return getEntry(key) != null;  
}  

// ���ء���Ϊkey���ļ�ֵ��  
final Entry<K,V> getEntry(Object key) {  
    // ��ȡ��ϣֵ  
    // HashMap����keyΪnull����Ԫ�ش洢��table[0]λ�ã���key��Ϊnull���������hash()�����ϣֵ  
    int hash = (key == null) ? 0 : hash(key.hashCode());  
    // �ڡ���hashֵ��Ӧ�������ϲ��ҡ���ֵ����key����Ԫ��  
    for (Entry<K,V> e = table[indexFor(hash, table.length)];  
         e != null;  
         e = e.next) {  
        Object k;  
        if (e.hash == hash &&  
            ((k = e.key) == key || (key != null && key.equals(k))))  
            return e;  
    }  
    return null;  
}  

// ����key-value����ӵ�HashMap��  
public V put(K key, V value) {  
    // ����keyΪnull�����򽫸ü�ֵ����ӵ�table[0]�С�  
    if (key == null)  
        return putForNullKey(value);  
    // ����key��Ϊnull����������key�Ĺ�ϣֵ��Ȼ������ӵ��ù�ϣֵ��Ӧ�������С�  
    int hash = hash(key.hashCode());  
    int i = indexFor(hash, table.length);  
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {  
        Object k;  
        // ������key����Ӧ�ļ�ֵ���Ѿ����ڣ������µ�valueȡ���ɵ�value��Ȼ���˳���  
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {  
            V oldValue = e.value;  
            e.value = value;  
            e.recordAccess(this);  
            return oldValue;  
        }  
    }  

    // ������key����Ӧ�ļ�ֵ�Բ����ڣ��򽫡�key-value����ӵ�table��  
    modCount++;
    //��key-value��ӵ�table[i]��
    addEntry(hash, key, value, i);  
    return null;  
}  

// putForNullKey()�������ǽ���keyΪnull����ֵ����ӵ�table[0]λ��  
private V putForNullKey(V value) {  
    for (Entry<K,V> e = table[0]; e != null; e = e.next) {  
        if (e.key == null) {  
            V oldValue = e.value;  
            e.value = value;  
            e.recordAccess(this);  
            return oldValue;  
        }  
    }  
    // ���û�д���keyΪnull�ļ�ֵ�ԣ���ֱ���Ⱒ����table[0]��!  
    modCount++;  
    addEntry(0, null, value, 0);  
    return null;  
}  

// ����HashMap��Ӧ�ġ���ӷ�������  
// ����put()��ͬ��putForCreate()���ڲ��������������캯���ȵ��ã���������HashMap  
// ��put()�Ƕ����ṩ����HashMap�����Ԫ�صķ�����  
private void putForCreate(K key, V value) {  
    int hash = (key == null) ? 0 : hash(key.hashCode());  
    int i = indexFor(hash, table.length);  

    // ����HashMap���д��ڡ���ֵ����key����Ԫ�أ����滻��Ԫ�ص�valueֵ  
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {  
        Object k;  
        if (e.hash == hash &&  
            ((k = e.key) == key || (key != null && key.equals(k)))) {  
            e.value = value;  
            return;  
        }  
    }  

    // ����HashMap���в����ڡ���ֵ����key����Ԫ�أ��򽫸�key-value��ӵ�HashMap��  
    createEntry(hash, key, value, i);  
}  

// ����m���е�ȫ��Ԫ�ض���ӵ�HashMap�С�  
// �÷������ڲ��Ĺ���HashMap�ķ��������á�  
private void putAllForCreate(Map<? extends K, ? extends V> m) {  
    // ���õ�������Ԫ�������ӵ�HashMap��  
    for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {  
        Map.Entry<? extends K, ? extends V> e = i.next();  
        putForCreate(e.getKey(), e.getValue());  
    }  
}  

// ���µ���HashMap�Ĵ�С��newCapacity�ǵ����������  
void resize(int newCapacity) {  
    Entry[] oldTable = table;  
    int oldCapacity = oldTable.length; 
    //����������Ѿ��ﵽ�����ֵ�����������ݣ�ֱ�ӷ���
    if (oldCapacity == MAXIMUM_CAPACITY) {  
        threshold = Integer.MAX_VALUE;  
        return;  
    }  

    // �½�һ��HashMap��������HashMap����ȫ��Ԫ����ӵ�����HashMap���У�  
    // Ȼ�󣬽�����HashMap����ֵ������HashMap����  
    Entry[] newTable = new Entry[newCapacity];  
    transfer(newTable);  
    table = newTable;  
    threshold = (int)(newCapacity * loadFactor);  
}  

// ��HashMap�е�ȫ��Ԫ�ض���ӵ�newTable��  
void transfer(Entry[] newTable) {  
    Entry[] src = table;  
    int newCapacity = newTable.length;  
    for (int j = 0; j < src.length; j++) {  
        Entry<K,V> e = src[j];  
        if (e != null) {  
            src[j] = null;  
            do {  
                Entry<K,V> next = e.next;  
                int i = indexFor(e.hash, newCapacity);  
                e.next = newTable[i];  
                newTable[i] = e;  
                e = next;  
            } while (e != null);  
        }  
    }  
}  

// ��"m"��ȫ��Ԫ�ض���ӵ�HashMap��  
public void putAll(Map<? extends K, ? extends V> m) {  
    // ��Ч���ж�  
    int numKeysToBeAdded = m.size();  
    if (numKeysToBeAdded == 0)  
        return;  

    // ���������Ƿ��㹻��  
    // ������ǰ��ֵ���� < ��Ҫ����������������x2��  
    if (numKeysToBeAdded > threshold) {  
        int targetCapacity = (int)(numKeysToBeAdded / loadFactor + 1);  
        if (targetCapacity > MAXIMUM_CAPACITY)  
            targetCapacity = MAXIMUM_CAPACITY;  
        int newCapacity = table.length;  
        while (newCapacity < targetCapacity)  
            newCapacity <<= 1;  
        if (newCapacity > table.length)  
            resize(newCapacity);  
    }  

    // ͨ��������������m���е�Ԫ�������ӵ�HashMap�С�  
    for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {  
        Map.Entry<? extends K, ? extends V> e = i.next();  
        put(e.getKey(), e.getValue());  
    }  
}  

// ɾ������Ϊkey��Ԫ��  
public V remove(Object key) {  
    Entry<K,V> e = removeEntryForKey(key);  
    return (e == null ? null : e.value);  
}  

// ɾ������Ϊkey����Ԫ��  
final Entry<K,V> removeEntryForKey(Object key) {  
    // ��ȡ��ϣֵ����keyΪnull�����ϣֵΪ0���������hash()���м���  
    int hash = (key == null) ? 0 : hash(key.hashCode());  
    int i = indexFor(hash, table.length);  
    Entry<K,V> prev = table[i];  
    Entry<K,V> e = prev;  

    // ɾ�������С���Ϊkey����Ԫ��  
    // �����ǡ�ɾ�����������еĽڵ㡱  
    while (e != null) {  
        Entry<K,V> next = e.next;  
        Object k;  
        if (e.hash == hash &&  
            ((k = e.key) == key || (key != null && key.equals(k)))) {  
            modCount++;  
            size--;  
            if (prev == e)  
                table[i] = next;  
            else
                prev.next = next;  
            e.recordRemoval(this);  
            return e;  
        }  
        prev = e;  
        e = next;  
    }  

    return e;  
}  

// ɾ������ֵ�ԡ�  
final Entry<K,V> removeMapping(Object o) {  
    if (!(o instanceof Map.Entry))  
        return null;  

    Map.Entry<K,V> entry = (Map.Entry<K,V>) o;  
    Object key = entry.getKey();  
    int hash = (key == null) ? 0 : hash(key.hashCode());  
    int i = indexFor(hash, table.length);  
    Entry<K,V> prev = table[i];  
    Entry<K,V> e = prev;  

    // ɾ�������еġ���ֵ��e��  
    // �����ǡ�ɾ�����������еĽڵ㡱  
    while (e != null) {  
        Entry<K,V> next = e.next;  
        if (e.hash == hash && e.equals(entry)) {  
            modCount++;  
            size--;  
            if (prev == e)  
                table[i] = next;  
            else
                prev.next = next;  
            e.recordRemoval(this);  
            return e;  
        }  
        prev = e;  
        e = next;  
    }  

    return e;  
}  

// ���HashMap�������е�Ԫ����Ϊnull  
public void clear() {  
    modCount++;  
    Entry[] tab = table;  
    for (int i = 0; i < tab.length; i++)  
        tab[i] = null;  
    size = 0;  
}  

// �Ƿ������ֵΪvalue����Ԫ��  
public boolean containsValue(Object value) {  
// ����valueΪnull���������containsNullValue()����  
if (value == null)  
        return containsNullValue();  

// ����value��Ϊnull���������HashMap���Ƿ���ֵΪvalue�Ľڵ㡣  
Entry[] tab = table;  
    for (int i = 0; i < tab.length ; i++)  
        for (Entry e = tab[i] ; e != null ; e = e.next)  
            if (value.equals(e.value))  
                return true;  
return false;  
}  

// �Ƿ����nullֵ  
private boolean containsNullValue() {  
Entry[] tab = table;  
    for (int i = 0; i < tab.length ; i++)  
        for (Entry e = tab[i] ; e != null ; e = e.next)  
            if (e.value == null)  
                return true;  
return false;  
}  

// ��¡һ��HashMap��������Object����  
public Object clone() {  
    HashMap<K,V> result = null;  
    try {  
        result = (HashMap<K,V>)super.clone();  
    } catch (CloneNotSupportedException e) {  
        // assert false;  
    }  
    result.table = new Entry[table.length];  
    result.entrySet = null;  
    result.modCount = 0;  
    result.size = 0;  
    result.init();  
    // ����putAllForCreate()��ȫ��Ԫ����ӵ�HashMap��  
    result.putAllForCreate(this);  

    return result;  
}  

// Entry�ǵ�������  
// ���� ��HashMap��ʽ�洢������Ӧ������  
// ��ʵ����Map.Entry �ӿڣ���ʵ��getKey(), getValue(), setValue(V value), equals(Object o), hashCode()��Щ����  
static class Entry<K,V> implements Map.Entry<K,V> {  
    final K key;  
    V value;  
    // ָ����һ���ڵ�  
    Entry<K,V> next;  
    final int hash;  

    // ���캯����  
    // �����������"��ϣֵ(h)", "��(k)", "ֵ(v)", "��һ�ڵ�(n)"  
    Entry(int h, K k, V v, Entry<K,V> n) {  
        value = v;  
        next = n;  
        key = k;  
        hash = h;  
    }  

    public final K getKey() {  
        return key;  
    }  

    public final V getValue() {  
        return value;  
    }  

    public final V setValue(V newValue) {  
        V oldValue = value;  
        value = newValue;  
        return oldValue;  
    }  

    // �ж�����Entry�Ƿ����  
    // ������Entry�ġ�key���͡�value������ȣ��򷵻�true��  
    // ���򣬷���false  
    public final boolean equals(Object o) {  
        if (!(o instanceof Map.Entry))  
            return false;  
        Map.Entry e = (Map.Entry)o;  
        Object k1 = getKey();  
        Object k2 = e.getKey();  
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {  
            Object v1 = getValue();  
            Object v2 = e.getValue();  
            if (v1 == v2 || (v1 != null && v1.equals(v2)))  
                return true;  
        }  
        return false;  
    }  

    // ʵ��hashCode()  
    public final int hashCode() {  
        return (key==null   ? 0 : key.hashCode()) ^  
               (value==null ? 0 : value.hashCode());  
    }  

    public final String toString() {  
        return getKey() + "=" + getValue();  
    }  

    // ����HashMap�����Ԫ��ʱ�������recordAccess()��  
    // ���ﲻ���κδ���  
    void recordAccess(HashMap<K,V> m) {  
    }  

    // ����HashMap��ɾ��Ԫ��ʱ�������recordRemoval()��  
    // ���ﲻ���κδ���  
    void recordRemoval(HashMap<K,V> m) {  
    }  
}  

// ����Entry������key-value������ָ��λ�ã�bucketIndex��λ��������  
void addEntry(int hash, K key, V value, int bucketIndex) {  
    // ���桰bucketIndex��λ�õ�ֵ����e����  
    Entry<K,V> e = table[bucketIndex];  
    // ���á�bucketIndex��λ�õ�Ԫ��Ϊ����Entry����  
    // ���á�e��Ϊ����Entry����һ���ڵ㡱  
    table[bucketIndex] = new Entry<K,V>(hash, key, value, e);  
    // ��HashMap��ʵ�ʴ�С ��С�� ����ֵ���������HashMap�Ĵ�С  
    if (size++ >= threshold)  
        resize(2 * table.length);  
}  

// ����Entry������key-value������ָ��λ�á�  
void createEntry(int hash, K key, V value, int bucketIndex) {  
    // ���桰bucketIndex��λ�õ�ֵ����e����  
    Entry<K,V> e = table[bucketIndex];  
    // ���á�bucketIndex��λ�õ�Ԫ��Ϊ����Entry����  
    // ���á�e��Ϊ����Entry����һ���ڵ㡱  
    table[bucketIndex] = new Entry<K,V>(hash, key, value, e);  
    size++;  
}  

// HashIterator��HashMap�������ĳ�������ĸ��࣬ʵ���˹����˺�����  
// ��������key������(KeyIterator)������Value������(ValueIterator)���͡�Entry������(EntryIterator)��3�����ࡣ  
private abstract class HashIterator<E> implements Iterator<E> {  
    // ��һ��Ԫ��  
    Entry<K,V> next;  
    // expectedModCount����ʵ��fast-fail���ơ�  
    int expectedModCount;  
    // ��ǰ����  
    int index;  
    // ��ǰԪ��  
    Entry<K,V> current;  

    HashIterator() {  
        expectedModCount = modCount;  
        if (size > 0) { // advance to first entry  
            Entry[] t = table;  
            // ��nextָ��table�е�һ����Ϊnull��Ԫ�ء�  
            // ����������index�ĳ�ʼֵΪ0����0��ʼ������������ֱ���ҵ���Ϊnull��Ԫ�ؾ��˳�ѭ����  
            while (index < t.length && (next = t[index++]) == null)  
                ;  
        }  
    }  

    public final boolean hasNext() {  
        return next != null;  
    }  

    // ��ȡ��һ��Ԫ��  
    final Entry<K,V> nextEntry() {  
        if (modCount != expectedModCount)  
            throw new ConcurrentModificationException();  
        Entry<K,V> e = next;  
        if (e == null)  
            throw new NoSuchElementException();  

        // ע�⣡����  
        // һ��Entry����һ����������  
        // ����Entry����һ���ڵ㲻Ϊ�գ��ͽ�nextָ����һ���ڵ�;  
        // ���򣬽�nextָ����һ������(Ҳ����һ��Entry)�Ĳ�Ϊnull�Ľڵ㡣  
        if ((next = e.next) == null) {  
            Entry[] t = table;  
            while (index < t.length && (next = t[index++]) == null)  
                ;  
        }  
        current = e;  
        return e;  
    }  

    // ɾ����ǰԪ��  
    public void remove() {  
        if (current == null)  
            throw new IllegalStateException();  
        if (modCount != expectedModCount)  
            throw new ConcurrentModificationException();  
        Object k = current.key;  
        current = null;  
        HashMap.this.removeEntryForKey(k);  
        expectedModCount = modCount;  
    }  

}  

// value�ĵ�����  
private final class ValueIterator extends HashIterator<V> {  
    public V next() {  
        return nextEntry().value;  
    }  
}  

// key�ĵ�����  
private final class KeyIterator extends HashIterator<K> {  
    public K next() {  
        return nextEntry().getKey();  
    }  
}  

// Entry�ĵ�����  
private final class EntryIterator extends HashIterator<Map.Entry<K,V>> {  
    public Map.Entry<K,V> next() {  
        return nextEntry();  
    }  
}  

// ����һ����key��������  
Iterator<K> newKeyIterator()   {  
    return new KeyIterator();  
}  
// ����һ����value��������  
Iterator<V> newValueIterator()   {  
    return new ValueIterator();  
}  
// ����һ����entry��������  
Iterator<Map.Entry<K,V>> newEntryIterator()   {  
    return new EntryIterator();  
}  

// HashMap��Entry��Ӧ�ļ���  
private transient Set<Map.Entry<K,V>> entrySet = null;  

// ���ء�key�ļ��ϡ���ʵ���Ϸ���һ����KeySet����  
/*public Set<K> keySet() {  
    Set<K> ks = keySet;  
    return (ks != null ? ks : (keySet = new KeySet()));  
} */ 

// Key��Ӧ�ļ���  
// KeySet�̳���AbstractSet��˵���ü�����û���ظ���Key��  
private final class KeySet extends AbstractSet<K> {  
    public Iterator<K> iterator() {  
        return newKeyIterator();  
    }  
    public int size() {  
        return size;  
    }  
    public boolean contains(Object o) {  
        return containsKey(o);  
    }  
    public boolean remove(Object o) {  
        return HashMap.this.removeEntryForKey(o) != null;  
    }  
    public void clear() {  
        HashMap.this.clear();  
    }  
}  

// ���ء�value���ϡ���ʵ���Ϸ��ص���һ��Values����  
/*public Collection<V> values() {  
    Collection<V> vs = values;  
    return (vs != null ? vs : (values = new Values()));  
} */ 

// ��value���ϡ�  
// Values�̳���AbstractCollection����ͬ�ڡ�KeySet�̳���AbstractSet����  
// Values�е�Ԫ���ܹ��ظ�����Ϊ��ͬ��key����ָ����ͬ��value��  
private final class Values extends AbstractCollection<V> {  
    public Iterator<V> iterator() {  
        return newValueIterator();  
    }  
    public int size() {  
        return size;  
    }  
    public boolean contains(Object o) {  
        return containsValue(o);  
    }  
    public void clear() {  
        HashMap.this.clear();  
    }  
}  

// ���ء�HashMap��Entry���ϡ�  
public Set<Map.Entry<K,V>> entrySet() {  
    return entrySet0();  
}  

// ���ء�HashMap��Entry���ϡ�����ʵ���Ƿ���һ��EntrySet����  
private Set<Map.Entry<K,V>> entrySet0() {  
    Set<Map.Entry<K,V>> es = entrySet;  
    return es != null ? es : (entrySet = new EntrySet());  
}  

// EntrySet��Ӧ�ļ���  
// EntrySet�̳���AbstractSet��˵���ü�����û���ظ���EntrySet��  
private final class EntrySet extends AbstractSet<Map.Entry<K,V>> {  
    public Iterator<Map.Entry<K,V>> iterator() {  
        return newEntryIterator();  
    }  
    public boolean contains(Object o) {  
        if (!(o instanceof Map.Entry))  
            return false;  
        Map.Entry<K,V> e = (Map.Entry<K,V>) o;  
        Entry<K,V> candidate = getEntry(e.getKey());  
        return candidate != null && candidate.equals(e);  
    }  
    public boolean remove(Object o) {  
        return removeMapping(o) != null;  
    }  
    public int size() {  
        return size;  
    }  
    public void clear() {  
        HashMap.this.clear();  
    }  
}  

// java.io.Serializable��д�뺯��  
// ��HashMap�ġ��ܵ�������ʵ�����������е�Entry����д�뵽�������  
private void writeObject(java.io.ObjectOutputStream s)  
    throws IOException  
{  
    Iterator<Map.Entry<K,V>> i =  
        (size > 0) ? entrySet0().iterator() : null;  

    // Write out the threshold, loadfactor, and any hidden stuff  
    s.defaultWriteObject();  

    // Write out number of buckets  
    s.writeInt(table.length);  

    // Write out size (number of Mappings)  
    s.writeInt(size);  

    // Write out keys and values (alternating)  
    if (i != null) {  
        while (i.hasNext()) {  
        Map.Entry<K,V> e = i.next();  
        s.writeObject(e.getKey());  
        s.writeObject(e.getValue());  
        }  
    }  
}  

private static final long serialVersionUID = 362498820763181265L;  

// java.io.Serializable�Ķ�ȡ����������д�뷽ʽ����  
// ��HashMap�ġ��ܵ�������ʵ�����������е�Entry�����ζ���  
private void readObject(java.io.ObjectInputStream s)  
     throws IOException, ClassNotFoundException  
{  
    // Read in the threshold, loadfactor, and any hidden stuff  
    s.defaultReadObject();  

    // Read in number of buckets and allocate the bucket array;  
    int numBuckets = s.readInt();  
    table = new Entry[numBuckets];  

    //init();  // Give subclass a chance to do its thing.  

    // Read in size (number of Mappings)  
    int size = s.readInt();  

    // Read the keys and values, and put the mappings in the HashMap  
    for (int i=0; i<size; i++) {  
        K key = (K) s.readObject();  
        V value = (V) s.readObject();  
        putForCreate(key, value);  
    }  
}  

// ���ء�HashMap�ܵ�������  
int   capacity()     { return table.length; }  
// ���ء�HashMap�ļ������ӡ�  
float loadFactor()   { return loadFactor;   }  
}