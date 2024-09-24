public class ClockDisplay {
    private int hour;
    private int minute;
    private int second;

    public ClockDisplay() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void timeTick() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
                    hour = 0;
                }
            }
        }
    }

    public String gettime() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
