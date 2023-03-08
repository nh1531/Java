package 자료구조8;

import java.util.Comparator;
import java.util.Scanner;

//import Chap8_List.SimpleLinkedList.Menu;
//객체들의 데이터는 스트링으로 저장한다.
//리스트 객체들은 이름 순서로 하고 이름이 같으면 회원번호 순서로 정렬한다.

class SimpleObject {

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	// 생성자
	public SimpleObject(String no, String name) {
		this.no = no;
		this.name = name;
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0 ) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node1 {
	SimpleObject data;
	Node1 link;
	public Node1(SimpleObject element) {
		link = null;
		data = element;
	}
}

class LinkedList1 {
	Node1 first;
	
	public LinkedList1() {
		first = null;
	}
	public boolean Delete(SimpleObject element, Comparator<? super SimpleObject> c) //delete the element
	{
		Node1 p = first, q = null;
		while (p != null) {
			if(p.data == element) { // 삭제			
				if(q == null) {
					first=p.link;
					return true;
				}
				q.link = p.link;
			}
			else if (c.compare(p.data, element) < 0) {
				 q = p;
				 p = p.link; 
			}
			
		}
		return false;
	}
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first, q = null;
		if(p==null) {
			System.out.print("리스트 없음");
		}
		
		while(p != null) {
			System.out.print(p.data + " " );
			p = p.link;
		}

	}
	public void Add(SimpleObject element, Comparator<? super SimpleObject> c) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
	{
		Node1 newNode = new Node1(element);
		Node1 p = first, q = null;
		if (p == null) { // 맨 처음
			first = newNode;
			return;
		}
		while (p != null) {
			if (c.compare(p.data, element) > 0) {
				newNode.link = p;
				if (q == null)
					first = newNode;
				else
					q.link = newNode;
				break;
			} else { // p < element
				q = p;
				p = p.link;
				if (p == null) {
					// insert
					q.link = newNode;
					break;
				}			
			}

		}

	}
	public boolean Search(SimpleObject data, Comparator<? super SimpleObject> c) { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first, q = null;
		while(p != null) {
			if(c.compare(p.data, data) == 0) {
				return true;
			}
			p = p.link;
		}
		return false;
	}
}
public class SimpleObjectList {

	 enum Menu {
	        Add( "삽입"),
	        Delete( "삭제"),
	        Show( "인쇄"),
	        Search( "검색"),
	        Exit( "종료");

	        private final String message;                // 표시할 문자열

	        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
	            for (Menu m : Menu.values())
	                if (m.ordinal() == idx)
	                    return m;
	            return null;
	        }

	        Menu(String string) {                        // 생성자(constructor)
	            message = string;
	        }

	        String getMessage() {                        // 표시할 문자열을 반환
	            return message;
	        }
	    }

	    //--- 메뉴 선택 ---//
	    static Menu SelectMenu() {
			Scanner sc = new Scanner(System.in);
	        int key;
	        do {
	            for (Menu m : Menu.values()) {
	                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	                if ((m.ordinal() % 3) == 2 &&
	                      m.ordinal() != Menu.Exit.ordinal())
	                    System.out.println();
	            }
	            System.out.print(" : ");
	            key = sc.nextInt();
	        } while (key < Menu.Add.ordinal() || 
	                                            key > Menu.Exit.ordinal());
	        return Menu.MenuAt(key);
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴 
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		SimpleObject data = null;
    System.out.println("inserted");
	     l.Show();		
	        do {
	            switch (menu = SelectMenu()) {	             
	             case Add :
	            	 System.out.println("회원번호를 입력하세요 : ");
	            	 String snumber = sc.next();
	            	 System.out.println("이름을 입력하세요 : ");
	            	 String sname = sc.next();
	            	 // 머리노드 삽입
	            	 data = new SimpleObject(snumber, sname);
	    	         l.Add(data,SimpleObject.NO_ORDER);            
	                     break;
	             case Delete :                          // 머리 노드 삭제
	            	 System.out.println("삭제할 번호를 입력하세요 : ");
	            	 String snumber1  = sc.next();
	            	 System.out.println("이름을 입력하세요 : ");
	            	 String sname1 = sc.next();
	            	 data = new SimpleObject(snumber1, sname1);
	            	 l.Delete(data, SimpleObject.NO_ORDER);
	            	 System.out.println("삭제된 데이터는 " + snumber1);
	            	 System.out.println("삭제된 데이터는 " + sname1);
	                    break;
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	             case Search :                           // 회원 번호 검색          	
	            	 System.out.println("회원번호를 입력하세요 : ");
	            	 String snumber2 = sc.next();
	            	 System.out.println("이름을 입력하세요 : ");
	            	 String sname2 = sc.next();
	            	 // 머리노드 삽입
	            	 data = new SimpleObject(snumber2, sname2);
	            	 l.Search(data, SimpleObject.NO_ORDER);
	            	 if(snumber2 != null )
	            		 System.out.println("검색 값 = " + snumber2 + " 데이터가 존재합니다.");
	            	 else
                        System.out.println("검색 값 = " + snumber2 + " 데이터가 없습니다.");
	                     break;
	            	
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}


