package ustudy;

import java.util.*;

public class Session {

    private int NumOfintervals;//input from user
    private int sessionTime;//input from user
    private int breakTime;//input from user
//    static int overallTime;
private void stratSeesion(int sessionTime,int breakTime){
    int timeInSeconds=sessionTime*60;
    int timeInmilli=timeInSeconds*1000;
    do{
    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            System.out.println("it's time for your break! :)");
        }
    };
    timer.schedule(task, timeInmilli);
     startBreak(breakTime); 
     NumOfintervals--;   
    }while(NumOfintervals>0);

}  
private void startBreak(int breakTime){
  int timeInSeconds=breakTime*60;
    int timeInmilli=timeInSeconds*1000;

    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            System.out.println("time to go back! :)");
        }
    };
    timer.schedule(task, timeInmilli);

}
}
