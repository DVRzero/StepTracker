public class Month {
    private String name;
    private int[] days;

    public void setStepsPerDays(int day, int steps) {
        this.days[day] = steps;
    }

    public int[] getDays() {
        return days;
    }

    public Month() {
        this.days = new int[30];
        for (int i = 0; i < days.length; i++) {
            days[i] = 0;
        }
    }
}
