import java.util.Scanner;
public class FirstCFS {
    public static void main(String[] args) {
        instruc ob=new instruc();
        float tTime=0,TwaitTime=0;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the no of process you want to enter: ");
        int num=sc.nextInt();
        int temp;
        for(int i=0;i<num;i++)
        {
            ob.pid[i]=i+1;
            System.out.println("Enter the Arrival Time of process "+i+1+" :");
            ob.arriTime[i]=sc.nextInt();
            System.out.println("Enter the Burst time of process "+i+1+" :");
            ob.bursTime[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num-(i+1);j++)
            {
                if(ob.arriTime[j]>ob.arriTime[j+1])
                {
                    temp=ob.arriTime[j];
                    ob.arriTime[j]=ob.arriTime[j+1];
                    ob.arriTime[j+1]=temp;
                    temp=ob.bursTime[j];
                   ob.bursTime[j]=ob.bursTime[j+1];
                    ob.bursTime[j+1]=temp;
                    temp=ob.pid[j];
                    ob.pid[j]=ob.pid[j+1];
                    ob.pid[j+1]=temp;
                }
            }
        }
        for(int i=0;i<num;i++)
        {
            if(i==0)
            {
                ob.compTime[i]=ob.arriTime[i]+ob.bursTime[i];
            }
            else
            {
                if(ob.arriTime[i]>ob.compTime[i-1])
                {
                    ob.compTime[i]=ob.arriTime[i]+ob.bursTime[i];
                }
                else
                    ob.compTime[i]=ob.compTime[i-1]+ob.bursTime[i];
            }
            ob.TurnATime[i]=ob.compTime[i]-ob.arriTime[i] ;
            ob.WaitTime[i]=ob.TurnATime[i]-ob.bursTime[i] ;
            TwaitTime=TwaitTime+ob.WaitTime[i] ;
            tTime=tTime+ob.TurnATime[i] ;
        }
        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num-(i+1);j++)
            {
                if(ob.pid[j]>ob.pid[j+1])
                {
                    temp=ob.arriTime[j];
                    ob.arriTime[j]=ob.arriTime[j+1];
                    ob.arriTime[j+1]=temp;
                    temp=ob.bursTime[j];
                    ob.bursTime[j]=ob.bursTime[j+1];
                    ob.bursTime[j+1]=temp;
                    temp=ob.compTime[j];
                    ob.compTime[j]=ob.compTime[j+1];
                    ob.compTime[j+1]=temp;
                    temp=ob.pid[j];
                    ob.pid[j]=ob.pid[j+1];
                    ob.pid[j+1]=temp;
                    temp=ob.TurnATime[j];
                    ob.TurnATime[j]=ob.TurnATime[j+1];
                    ob.TurnATime[j+1]=temp;
                    temp=ob.WaitTime[j];
                    ob.WaitTime[j]=ob.WaitTime[j+1];
                    ob.WaitTime[j+1]=temp;
                }
            }
        }
        System.out.println("\nPId  Arrival  Brust  Complete Turn Waiting");
        for(int i=0;i<num;i++)
        {
            System.out.println(ob.pid[i]+"\t"+ob.arriTime[i]+"\t"+ob.bursTime[i]+"\t"+ob.compTime[i]+"\t"+ob.TurnATime[i]+"\t"+ob.WaitTime[i]) ;
        }
        System.out.println("\nAverage Waiting Time: "+ (TwaitTime/num));
        System.out.println("Average Turn Around Time:"+(tTime/num));
    }
}
class instruc{
    int num;
    int pid[]=new int[num];
    int arriTime[]=new int [num];
    int bursTime[]=new int[num];
    int compTime[]=new int[num];
    int TurnATime[]=new int [num];
    int WaitTime[]=new int[num];
}
