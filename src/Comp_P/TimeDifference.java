package Comp_P;

import java.util.Scanner;

class TimeDifferenceHandler
{
    String date1,date2;
    int d1[],d2[];
    int months[]={31,28,31,30,31,30,31,31,30,31,30,31};
    final  int for11=337;
    void input(String date1,String date2)
    {
        this.date1=date1;
        this.date2=date2;
        String t1[]=date1.split(":");
        String t2[]=date2.split(":");
        d1=new int[t1.length];
        d2=new int[t2.length];
        int i=0;
        for (String temp:t1)
        {
            d1[i++]=Integer.parseInt(temp);

        }
        i=0;
        for (String temp:t2)
        {
            d2[i++]=Integer.parseInt(temp);

        }

    }
    void getDifference()
    {

        int totaldays=0;
        int counter=0;
        for(int i=d1[2];i<=d2[2];i++)
        {


            if(counter==4)
            {
                months[1]=29;
                counter=0;
            }

            if(i!=d1[2]&&i!=d2[2])
            {
                totaldays+=for11+months[1];
            }
            else
            {
                if(i==d1[2]) {
                    int temp = 0;
                    for (int j = 0; j < d1[1]; j++)
                        temp += months[j];
                    temp+=d1[0];
                    if(d1[2]==d2[2])
                    {
                        int temp1 = 0;
                        for (int j = 0; j < d2[1]; j++)
                            temp1 += months[j];
                        temp1+=d2[0];
                        totaldays+=temp1-temp;
                    }
                    else
                    totaldays+=for11+months[1]-temp;
                }
                else
                {
                    int temp = 0;
                    for (int j = 0; j < d2[1]; j++)
                        temp += months[j];
                    temp+=d2[0];
                    totaldays+=temp;
                }

            }
                  counter++;
        }
        System.out.println("The Total Days are "+totaldays);
        int year=totaldays/365;
        int remaining_days=totaldays%365;
        int month=remaining_days/31;
        int days=remaining_days%31;
        System.out.println("Year:Month:Days In 365 days/Year 31 Days/Month - "+ year+" : "+month+" : "+days);

    }

}
public class TimeDifference {
    public static void main(String[] args) {
          TimeDifferenceHandler handler=new TimeDifferenceHandler();
          System.out.println("Enter First Date in format DD:MM:YYYY");
        Scanner scanner=new Scanner(System.in);
        String date1=scanner.nextLine();
        System.out.println("Enter Second Date in format DD:MM:YYYY");
        String date2=scanner.nextLine();
        handler.input(date1,date2);
        handler.getDifference();
    }
}
