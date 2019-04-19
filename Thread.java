class  MyThread extends Thread
{   public MyThread(String name)
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
public class Theus {
public static void main(String[] args) throws InterruptedException
    {
      MyThread t=new MyThread("threaddd");
      t.start();
    for(int i=0;i<10;i++)
      {
      System.out.println("parent");
      }
    }
}
