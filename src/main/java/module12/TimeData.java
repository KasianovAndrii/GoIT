package module12;

public class TimeData implements Runnable{
    int second = 0;
    @Override
    public void run() {
        second++;
        System.out.println(second + " sec");
    }
}
