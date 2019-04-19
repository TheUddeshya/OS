class  MyThread extends Thread
{
    public MyThread(String name)
    {
        super(name);
    }
 public void run()
 {  for(int i=0;i<10;i++)
 {
    System.out.println("child");
    System.out.println(Thread.currentThread().getName());
 }
 }
}
public class Vijay2 {

  
    public static void main(String[] args) throws InterruptedException
    {
      MyThread t=new MyThread("t1");
      t.start();
      
      //t.setName("vijay");
      for(int i=0;i<10;i++)
      {
      System.out.println("parent");
      //System.out.println(Thread.currentThread().getName());
      }
    }
    