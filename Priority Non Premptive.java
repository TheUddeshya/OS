public class priority_non_preemptive_scheduling {
}
class NonPreemptiveScheduling {
    public int[] getWaitingList(int[] process, int[] arrival, int[] burst)
    {

        if(arrival[0]!=0)
            return new int[]{0};
        if(process.length!=arrival.length & process.length!=burst.length & arrival.length!=burst.length)
            return new int[]{0};

        for(int i=0;i<burst.length;i++)
        {
            if(burst[i]>=10 | burst[i]<=0)
                return new int[]{0};
        }
        for(int i=0;i<arrival.length;i++)
        {
            for(int j=i;j<arrival.length;j++)
            {
                if(arrival[i]>arrival[j])
                    return new int []{0};
            }

        }

        for(int i=0;i<arrival.length;i++)
        {
            for(int j=i+1;j<arrival.length;j++)
            {
                if(arrival[i]==arrival[j])
                    return new int []{0};
            }
        }


        int sum[] = new int[process.length];
        for(int i=0;i<process.length;i++)
        {
            sum[i] = arrival[i]+burst[i];
        }

        int temp1,temp2,temp3;
        for(int i=1;i<process.length;i++)
        {
            for(int j=i;j<process.length;j++)
            {
                if(sum[i]>sum[j])
                {
                    temp1 = process[i];
                    process[i] = process[j];
                    process[j] = temp1;

                    temp2 = arrival[i];
                    arrival[i] = arrival[j];
                    arrival[j] = temp2;

                    temp3 = burst[i];
                    burst[i] = burst[j];
                    burst[j] = temp3;
                }
            }
        }

        int starttime[] = new int[process.length];
        int finaltime[] = new int[process.length];
        starttime[0] = arrival[0];
        finaltime[0] = burst[0];

        for(int i=1;i<process.length;i++)
        {
            starttime[i] = finaltime[i-1];
            finaltime[i] = starttime[i]+burst[i];
        }
        int waitingtime[] = new int[process.length];
        for(int i=1;i<process.length;i++)
        {
            waitingtime[i] = finaltime[i] - (arrival[i]+burst[i]);

        }
        int temp4,temp5;
        for(int i=0;i<process.length;i++)
        {
            for(int j=i;j<process.length;j++)
            {
                if(process[i]>process[j])
                {
                    temp4 = process[i];
                    process[i] = process[j];
                    process[j] = temp4;

                    temp5 = waitingtime[i];
                    waitingtime[i] = waitingtime[j];
                    waitingtime[j] = temp5;
                }
            }
        }

        return waitingtime;
    }




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        //testcase 1:
        try
        {
            int process[] = {1, 2, 3, 4};
            int arrival[] = {0, 2, 4, 5};
            int burst[] = {7, 4, 1, 4};
            int[] output = new NonPreemptiveScheduling().getWaitingList(process, arrival, burst);
            if(output!=null && output.length>0)
                for (int i = 0; i < output.length; i++)
                {
                    System.out.print(output[i]);
                }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//testcase 2:
        try
        {
            int process[] = {1, 2, 3};
            int arrival[] = {0, 4, 8};
            int burst[] = {6, 2, 1};
            int[] output = new NonPreemptiveScheduling().getWaitingList(process, arrival, burst);
            if(output!=null && output.length>0)
                for (int i = 0; i < output.length; i++)
                {
                    System.out.print(output[i]);
                }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//testcase 3:
        try
        {
            int process[] = {1, 2, 3, 4};
            int arrival[] = {2, 0, 4, 5};
            int burst[] = {7, 4, 1, 4};
            int[] output = new NonPreemptiveScheduling().getWaitingList(process, arrival, burst);
            if(output!=null && output.length>0)
                for (int i = 0; i < output.length; i++)
                {
                    System.out.print(output[i]);
                }
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}