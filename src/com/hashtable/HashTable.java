package com.hashtable;

public class HashTable {
        private HashNode[] Buckets;
        private int noOfBuckets;
        private int size; // no of key value pair in hash table

        public HashTable() {
            this(10);
        }

        public HashTable(int capacity) {
            this.noOfBuckets = capacity;
            this.Buckets = new HashNode[noOfBuckets];
            this.size = 0;
        }

        class HashNode {
            private Integer key;
            private String value;
            private HashNode next;

            public HashNode(Integer key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        public int getBucketIndex(Integer key) {
            return key % noOfBuckets;
        }

        public void put(Integer key, String value) {
            if (key == null || value == null) {
                throw new IllegalArgumentException("key or value are null");
            }

            int bucketIndex = getBucketIndex(key);
            HashNode head = Buckets[bucketIndex];
            // check existing node in hash table
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            size++;
            head = Buckets[bucketIndex];
            HashNode node = new HashNode(key, value);
            node.next = head;
            Buckets[bucketIndex] = node;
        }

        public String getValueOfKey(Integer key) {
            int bucketIndex = getBucketIndex(key);
            HashNode head = Buckets[bucketIndex];
            // check existing node in hash table
            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;

                }
                head = head.next;
            }
            return null;
        }

        public static void main(String[] args) {
            HashTable hashTable = new HashTable();
            hashTable.put(25, "Chandan");
            hashTable.put(24, "mandeep");
            hashTable.put(28, "Ravi");
            System.out.println("size of hash table is : " + hashTable.size());
        }

        private int size() {
            return size;
        }

}
