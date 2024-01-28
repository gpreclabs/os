import java.util.concurrent.Semaphore;
class Que {
 int item;
 static Semaphore Con = new Semaphore(0);
 static Semaphore Prod = new Semaphore(1);
 // to get an item from buffer
 void get() {
 try {
 // Before consumer can consume an item,
 // it must acquire a permit from Con
 Con.acquire();
 } catch (InterruptedException e) {
 System.out.println("InterruptedException caught");
 }
 System.out.println("Consumer consumed item: " + item);
 Prod.release();
 }
 void put(int item) {
 try {

 Prod.acquire();
 } catch (InterruptedException e) {
 System.out.println("InterruptedException caught");
 }
 this.item = item;
 System.out.println("Producer produced item: " + item);
 Con.release();
 }
}
class Producer implements Runnable {
 Que q;
 Producer(Que q) {
 this.q = q;
 new Thread(this, "Producer").start();
 }
 public void run() {
 for (int i = 0; i < 5; i++) q.put(i);
 }
}
class Consumer implements Runnable {
 Que q;
 Consumer(Que q) {
 this.q = q;
 new Thread(this, "Consumer").start();
 }
 public void run() {
 for (int i = 0; i < 5; i++) // consumer get items
 q.get();
 }
}
class Main {
 public static void main(String args[]) {
 // creating buffer queue
 Que q = new Que();
 // starting consumer thread
 new Consumer(q);
 // starting producer thread
 new Producer(q);
 }
}
