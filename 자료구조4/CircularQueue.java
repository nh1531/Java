package 자료구조4;

import java.util.Scanner;

//p.148
//4장 원형큐

class Item{
	int data;
	public Item (int data) {		
		this.data = data;
	}
}

public class CircularQueue  {
private Item[] que;            // 큐용 배열
private int capacity;         // 큐의 크기 
private int front;            // 맨 처음 요소 커서
private int rear;             // 맨 끝 요소 커서
static boolean isEmpty; 		// front == rear
//private int num;              // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
public class EmptyCircularQueueException extends RuntimeException {
  public EmptyCircularQueueException() { }
}

//--- 실행시 예외: 큐가 가득 찼음 ---//
public class OverflowCircularQueueException extends RuntimeException {
  public OverflowCircularQueueException() { }
}

//--- 생성자(constructor) ---//
public CircularQueue(int maxlen) {
  front = rear = 0;
  capacity = maxlen;
  isEmpty = true;
  try {
      que = new Item[capacity];          // 큐 본체용 배열을 생성
  } catch (OutOfMemoryError e) {        // 생성할 수 없음
      capacity = 0;
  }
}



//--- 큐에 데이터를 push ---//
public void push(Item x) throws OverflowCircularQueueException {
	if(rear == front && !isEmpty) {
      throw new OverflowCircularQueueException();            // 큐가 가득 찼음
	}
  que[rear++] = x;
  isEmpty = false;
  rear %= capacity; //rear = rear % capacity;
  
}

//--- 큐에서 데이터를 pop ---//
public Item pop(Item x) throws EmptyCircularQueueException {
	  if (front == rear && isEmpty) {		  
		  throw new EmptyCircularQueueException();            // 큐가 비어있음
	  }
  que[front++] = x;
  if(front == capacity) {
	  isEmpty = true;
  }
  front %= capacity;
  return x;
}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
public Item peek() throws EmptyCircularQueueException {
  if (isEmpty)
      throw new EmptyCircularQueueException();            // 큐가 비어있음
  return que[front];
}

//--- 큐를 비움 ---//
public void clear() {
  front = rear = 0;
}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
public int indexOf(Item x) {
  for (int i = 0; i < que.length; i++) {
      int idx = (i + front) % capacity;
      if (que[idx] == x)                // 검색 성공
          return idx;
  }
  return -1;                            // 검색 실패
}

//--- 큐의 크기를 반환 ---//
public int getCapacity() {
  return capacity;
}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
public int size() {
  return que.length;
}

//--- 큐가 비어있는가? ---//
public boolean isEmpty() {
  return isEmpty = true;
}

//--- 큐가 가득 찼는가? ---//
public boolean isFull() {
  return que.length >= capacity;
}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
public void dump() {
  if (que.length <= 0)
      System.out.println("큐가 비어있습니다.");
  else {
      for (int i = 0; i < que.length; i++)
          System.out.print(que[(i + front) % capacity] + " ");
      System.out.println();
  }
}

public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    IntQueue s = new IntQueue(4);    // 최대 4개를 인큐할 수 있는 큐

    while (true) {
    	System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
        System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
        System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

        int menu = stdIn.nextInt();
        if (menu == 0) break;

        int x;
        switch (menu) {
         case 1:                                // 인큐
            System.out.print("데이터: ");
            x = stdIn.nextInt();
            try {
                s.enque(x);
             } catch (IntQueue.OverflowIntQueueException e) {
                System.out.println("큐가 가득 찼습니다.");
            }
            break;

         case 2:                                // 디큐
            try {
                 x = s.deque();
                System.out.println("디큐한 데이터는 " + x + "입니다.");
             } catch (IntQueue.EmptyIntQueueException e) {
                System.out.println("큐가 비어 있습니다.");
            }
            break;

         case 3:                                // 피크
            try {
                 x = s.peek();
                System.out.println("피크한 데이터는 " + x + "입니다.");
             } catch (IntQueue.EmptyIntQueueException e) {
                System.out.println("큐가 비어 있습니다.");
            }
            break;

         case 4:                                // 덤프
            s.dump();
            break;
        }
    }
}

}
