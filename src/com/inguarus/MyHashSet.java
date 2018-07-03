package com.inguarus;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet<E> implements MySet<E> {

    public MyHashSet(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    private static class Entry {
        Object key;
        Entry next;
    }

    private Entry[] buckets;
    private int size;


    @Override
    public boolean add(E e) {
        int index = hashFunction(e.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(e)) {
                return false;
            }
            current = current.next;
        }
        Entry entry = new Entry();
        entry.key = e;
        entry.next = buckets[index];
        buckets[index] = entry;
        size++;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        int index = hashFunction(e.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(E e) {
        int index = hashFunction(e.hashCode());
        Entry current = buckets[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equals(e)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        List<E> result = new ArrayList<>();
        for (Entry bucket : buckets) {
            if (bucket != null) {
                addChain(bucket, result);
            }
        }
        return result.toArray();
    }

    private void addChain(Entry bucket, List<E> list) {
        list.add((E) bucket.key);
        while (bucket.next != null) {
            list.add((E) bucket.key);
            bucket = bucket.next;
        }
    }


    private int hashFunction(int hashCode) {

        int index = hashCode;
        if (index < 0) {
            index = -index;
        }
        return index % buckets.length;
    }

    @Override
    public String toString() {
        Entry currentEntry = null;
        StringBuffer sb = new StringBuffer();

        for (int index = 0; index < buckets.length; index++) {
            if (buckets[index] != null) {
                currentEntry = buckets[index];
                sb.append("[" + index + "]");
                sb.append(" " + currentEntry.key.toString());
                while (currentEntry.next != null) {
                    currentEntry = currentEntry.next;
                    sb.append(" -> " + currentEntry.key.toString());
                }
                sb.append('\n');
            }
        }
        return sb.toString();
    }

}