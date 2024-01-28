import java.util.*;
public class Lru
{
public static void main(String[] args) {
	 	 Scanner sc=new Scanner(System.in);
	 	 System.out.println("Enter number of pages: ");
	 	 int n=sc.nextInt();
	 	 System.out.println("Enter pages: ");
	 	 int a[]=new int [n];
	 	 for(int i=0;i<n;i++)
	 	 a[i]=sc.nextInt();
	 	 System.out.println("Enter number of frames: ");
	 	 int f=sc.nextInt();
	 	 LinkedList<Integer> l=new LinkedList();
	 	 int pf=0;
	 	 for(int i=0;i<n;i++)
	 	 {
	 	 if(l.contains(a[i]))
	 	 {
	 	 l.remove(l.indexOf(a[i]));
	 	 l.add(a[i]);
	 	 }
	 	 else{
	 	 if(l.size()<f)
	 	 l.add(a[i]);
	 	 else
	 	 {
	 	 l.remove(0);
	 	 l.add(a[i]);
	 	 }
	 	 pf++;
	 	 }
	 	 }
	 	 System.out.println(pf);
}
}
