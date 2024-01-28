import java.util.*;
public class Bankers {
public static void main(String arg[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter no of processes : ");
int p=sc.nextInt();
System.out.println("Enter no of resources : ");
int r=sc.nextInt();
int ans[]=new int[p];
int ind=0;
int al[][]=new int[p][r];
int max[][]=new int[p][r];
int avl[]=new int[r];
int need[][]=new int[p][r];
int f[]=new int[p];
System.out.println("Enter allocation : ");
for(int i=0;i<p;i++)
{
for(int j=0;j<r;j++)
{
al[i][j]=sc.nextInt();
}
}
System.out.println("Enter max : ");
for(int i=0;i<p;i++)
{
for(int j=0;j<r;j++)
{
max[i][j]=sc.nextInt();
}
}
System.out.println("Availables: ");
for(int i=0;i<r;i++)
{
avl[i]=sc.nextInt();
}
for(int i=0;i<p;i++)
{
for(int j=0;j<r;j++)
{
need[i][j]=max[i][j]-al[i][j];
}
}
System.out.println("Needs are : ");
for(int i=0;i<p;i++)
{
for(int j=0;j<r;j++)
{
System.out.print(need[i][j] +" ");
}
System.out.println("\n");
}
for(int i=0;i<p;i++)
{
f[i]=0;
}
int y = 0;
for (int k = 0; k < p; k++) {
for (int i = 0; i < p; i++) {
if (f[i] == 0) {
int flag = 0;
for (int j = 0; j < r; j++) {
if (need[i][j] > avl[j]){
flag = 1;
break;
}
}
if (flag == 0) {
ans[ind++] = i;
for (y = 0; y < r; y++)
avl[y] += al[i][y];
f[i] = 1;
}
}
}
}
int flag = 1;
for(int i=0;i<p;i++)
{
if(f[i]==0)
{
flag=0;
System.out.println("The following system is not safe");
break;
}
}
if(flag==1)
{
System.out.println("Following is the SAFE Sequence\n");
for (int i = 0; i < p ; i++)
System.out.println(" P ->"+ans[i]);
}
}
}
