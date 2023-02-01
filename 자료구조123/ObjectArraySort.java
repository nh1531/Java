// 3장객체배열검색
package 자료구조123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//Comparable 인터페이스를 사용하려면 compareTo() method를 구현

// interface -> implements
class Fruit implements Comparable<Fruit> {
	    private String name;
	    private int price;
	    public Fruit(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "<" + name + ", " + price + ">";
	    }

		@Override
		// 추상 method
		// compareTo 직접 부르지 않아도 호출됨
		public int compareTo(Fruit o) {
			System.out.println("this = " + this.name + "o = " + o.name);
			// this는 객체
			//구현할 부분 : 이름으로 비교하고 이름이 같으면 가격까지 비교
			if(this.name.compareTo(o.name) > 0) 
				return 1;
			else if(this.name.compareTo(o.name) < 0) {
				return -1;
			} else {
				return 0;
			}
			
		
		}
	public int getPrice() {
		return price;
	}
}

//===========================
/* 
대문자는 class
Collection.sort(List); 
Arrays.sort(배열);
Sort(){
	구현
}

* Arrays.asList
comparable : 사용자가 만든 class에서 구현 . compareTo() 
Fruit f;
f.compareTo(f1); - 객체o
comparator : 추상method compare
*/

// 3장 객체정렬
public class ObjectArraySort {
	public static void main(String[] args) {
//	String[] s = { "sort", "string", "array" };
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.naturalOrder());
//	Arrays.sort(s, Comparator.reverseOrder()); 
	
	/*
	Arrays.sort(s, new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
	        return o2.compareTo(o1);            // 내림차순으로 정렬
	    }
	});
	*/
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//	Collections.sort(Arrays.asList(s));
	Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),
	        new Fruit("바나나", 50),
	        new Fruit("수박", 880),
	        new Fruit("체리", 10)
	};
	
  System.out.println(arr);
  System.out.println("정렬전::");
  for ( Fruit city: arr)
  	System.out.print(" " + city);
  	// 람다식 
	//Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //Fruit에 compareTo()가 있어도 람다식 우선 적용 (람다식 14장)
  	Arrays.sort(arr);
  	
//  int count = arr.length;
//  for (int i = 0; i < count; i++)
//  	for (int j = i +1; j < count; j++) {
//  		if (arr[i].compareTo(arr[j]) > 0)
//  		{
//  			Fruit temp; temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
//  		}
//  	}
  System.out.println();
  System.out.println("정렬후::");
  for ( Fruit city: arr)
  	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	System.out.println();
	System.out.println("새로운 리스트2::");
  for ( Fruit city: lst2)
  	System.out.print(" " + city);
//  Arrays.sort(lst2); 에러 -> 배열 아님
  Collections.sort(lst2);
	System.out.println();
	System.out.println("새로운 리스트2::");
  for ( Fruit city: lst2)
  	System.out.print(" " + city);
  
  ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	Fruit data1 = iter1.next();
	Fruit data2 = iter2.next();
	 if (data1.compareTo(data2)> 0)
		 System.out.println("++++++++++++++");
  	//구현할 부분 (이터레이터 사용해서 lst3 구현)
	System.out.println();
  System.out.println("merge:: ");
  for ( Fruit city: lst3)
  	System.out.print(city+ " ");
  Fruit newFruit = new Fruit("참외", 100);
  /*** binary search
  Comparator<Fruit> cc = new Comparator<Fruit>() {//익명클래스 사용 
      public int compare(Fruit u1, Fruit u2) {
        return u1.compareTo(u2);
      }
    };
    */
  // int res = cc.compare(data1, newFruit);
   System.out.println("data1 = "+ data1);
   //System.out.println("res = " + res);
   //if (res < 0)
  	// System.out.println("\ndata1 > newFruit\n");
    //*
  System.out.println();
  // 비교연산 cc
  int result = Collections.binarySearch(lst3, newFruit);
	if (result > 0)	System.out.println("\nCollections.binarySearch() 조회결과::" + lst3.get(result));
	//*/

	Fruit [] fa = new Fruit[lst3.size()];
	// .toArray 배열 만듦 
	fa = lst3.toArray(fa);
  int result3 = Arrays.binarySearch(fa, newFruit);
  System.out.println("result3 = " + result3);
	
  System.out.println("\nArrays.binarySearch() 조회결과::" + lst3.get(result3));
	/*
	int result2 = binSearch(fa, lst3.size(), newFruit);
	System.out.println("\nbinSearch() 조회결과:" + lst3.get(result2));
	*/
	
	}
	// 교재 113,115 페이지 참조하여 구현
	static int binSearch(Fruit[]a, int n, Fruit f) {
	//구현할 부분 if문 대신 compareTo 사용
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2 ;
			if(a[pc].compareTo(f) == 0) return pc;
			else if (a[pc].compareTo(f) < 0) pl = pc + 1;
			else pr = pc - 1;
		} while (pl <= pr);
		
		return -1;
	}
}

