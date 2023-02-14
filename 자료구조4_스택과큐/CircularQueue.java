package 자료구조4_스택과큐;

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
//private int capacity;         // 큐의 크기 -> 이것도 주석
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
  front = rear = -1;
  //capacity = maxlen;
  try {
      que = new Item[capacity];          // 큐 본체용 배열을 생성
  } catch (OutOfMemoryError e) {        // 생성할 수 없음
      capacity = 0;
  }
}


//--- 큐에 데이터를 push ---//
public int push(int x) throws OverflowCircularQueueException {
	 // front == rear 1)empty 2)full
	 // if((rear + 1) % capacity == front) // 원형queue
  //if (num >= capacity)
	 if (rear == front && isEmpty)
      throw new OverflowCircularQueueException();            // 큐가 가득 찼음
  que[rear++] = x;
  isEmpty = false;
  //num++;
  if (rear == capacity)
      rear = 0;
  return x;
}

//--- 큐에서 데이터를 pop ---//
public Item pop() throws EmptyCircularQueueException {
  //if (num <= 0)
	  if (rear == front && isEmpty)
      throw new EmptyCircularQueueException();            // 큐가 비어있음
	  
  int x = que[front++];
  //num--;
  if (front == capacity)
      front = 0;
  return x;
}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
public int peek() throws EmptyCircularQueueException {
  if (num <= 0)
      throw new EmptyCircularQueueException();            // 큐가 비어있음
  return que[front];
}

//--- 큐를 비움 ---//
public void clear() {
  front = rear = 0;
}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
public int indexOf(int x) {
  for (int i = 0; i < num; i++) {
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
  return num;
}

//--- 큐가 비어있는가? ---//
public boolean isEmpty() {
  return isEmpty = true;
}

//--- 큐가 가득 찼는가? ---//
public boolean isFull() {
  return num >= capacity;
}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
public void dump() {
  if (num <= 0)
      System.out.println("큐가 비어있습니다.");
  else {
      for (int i = 0; i < num; i++)
          System.out.print(que[(i + front) % capacity] + " ");
      System.out.println();
  }
}
}
