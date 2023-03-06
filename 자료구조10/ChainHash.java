package 자료구조10;

import 자료구조8.SimpleObjectList;

//체인법에 의한 해시

/*
simple object 사용 버전-> comparator 사용 버전
simple object는 key가 없음

v->simpleobject
k->미사용

add( )
remove( )
dump( )
search( )
*/

public class ChainHash<K,V> {

 //--- 해시를 구성하는 노드 ---//
 class Node<V> {
     //private K key;                 // 키값
     private V data;                // 데이터
     private Node<V> next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

     //--- 생성자(constructor) ---//
     Node(V data, Node<K,V> next) {
         //this.key  = key;
         this.data = data;
         this.next = next;
     }

     //--- 키값을 반환 ---//
     //K getKey() {
     //    return key;
     //}

     //--- 데이터를 반환 ---//
     V getValue() {
         return data;
     }

     //--- 키의 해시값을 반환 ---//
     public int hashCode() {
         //return key.hashCode();
    	 //Integer.parseInt() 사용 
    	 // 자바에서 문자열을 
    	 SimpleObject so = this.;
    	 int number = Integer.parseInt(sno);
     }
 }

 private int    size;              // 해시 테이블의 크기
 private Node<K,V>[] table;        // 해시 테이블

 //--- 생성자(constructor) ---//
 public ChainHash(int capacity) {
     try {
         table = new Node[capacity];
         this.size = capacity;
     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
         this.size = 0;
     }
 }

 //--- 해시값을 구함 ---//
 public int hashValue(Object key) {
     return key.hashCode() % size;
 }

 //--- 키값이 key인 요소를 검색(데이터를 반환) ---//
 public V search(SimpleObject so) {
                         
 }

 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
 public int add(K key, V data) {
    
 }

 //--- 키값이 key인 요소를 삭제 ---//
 public int remove(V data) {
	 // data -> SimpleObject
                       
 }

 //--- 해시 테이블을 덤프(dump) ---//
 public void dump() {
     
 }
}
