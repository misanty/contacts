// declare your enum here
enum DayOfWeek {
    FRIDAY,
    MONDAY,
    SUNDAY,
    THURSDAY,
    TUESDAY,
    WEDNESDAY,
    SATURDAY

}

public class Main {
    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
    }
}