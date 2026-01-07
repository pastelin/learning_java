package enum_;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.THURSDAY;
        System.out.println("Today is: " + weekDay);

        for(int i = 0; i < 10; i++) {
            weekDay = getRamdomDay();

            System.out.printf("Ordinal value of %s is: %d%n", weekDay.name(), weekDay.ordinal());

            if(weekDay == DayOfTheWeek.SATURDAY || weekDay == DayOfTheWeek.SUNDAY) {
                System.out.println("It's weekend!");
            } else {
                System.out.println("It's a weekday.");

            }
        }

        switchDayOfWeek(weekDay);

        for (Topping topping : Topping.values()) {
            System.out.printf("Topping: %s, Price: $%.2f%n", topping.name(), topping.getPrice());
        }

    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;

       switch (weekDay) {
              case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY ->
                     System.out.println("It's a weekday, day number: " + weekDayInteger);
              case SATURDAY, SUNDAY ->
                     System.out.println("It's weekend, day number: " + weekDayInteger);
           default ->
               System.out.println(weekDay.name().charAt(0) + weekDay.name().substring(1).toLowerCase() + " is not a valid day of the week.");
       }

    }

    public static DayOfTheWeek getRamdomDay() {
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }
}
