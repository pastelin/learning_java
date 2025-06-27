package org.example_switch;

public class Main {
    public static void main(String[] args) {

        int switchValue = 20;


        // Traditional switch statement
        switch (switchValue) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value is 3 or 4 or 5");
                break;
            default:
                System.out.println("Value is something else");
                break;
        }

        // Enhanced switch statement (Java 12+)
        String result = switch (switchValue) {
            case 1 -> "Value is 1";
            case 2 -> "Value is 2";
            case 3, 4, 5 -> "Value is 3 or 4 or 5";
            default -> "Value is something else";
        };

        String month = "MARCH";
        //System.out.println(month + " is in the " + getQuarter(month) + " quarter.");
        //System.out.println(findNATOWord('A'));

        printDayOfWeek(0); // Sunday
        printDayOfWeek(1); // Monday
        printDayOfWeek(2); // Tuesday
        printDayOfWeek(3); // Wednesday
        printDayOfWeek(4); // Thursday
        printDayOfWeek(5); // Friday
        printDayOfWeek(6); // Saturday
        printDayOfWeek(7); // Invalid Day


        printDayOfWeekWithIfElse(0); // Sunday
        printDayOfWeekWithIfElse(1); // Monday
        printDayOfWeekWithIfElse(2); // Tuesday
        printDayOfWeekWithIfElse(3); // Wednesday
        printDayOfWeekWithIfElse(4); // Thursday
        printDayOfWeekWithIfElse(5); // Friday
        printDayOfWeekWithIfElse(6); // Saturday
        printDayOfWeekWithIfElse(7); // Invalid Day
    }

    public static String getQuarter(String month) {

        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse;
            }
        };

    }

    public static String findNATOWord(char character) {

        switch (character) {
            case 'A':
                return "A is Able";
            case 'B':
                return "B  is Baker";
            case 'C':
                return "C is Charlie";
            case 'D':
                return "D is Dog";
            case 'E':
                return "E is Easy";
            default:
                return "Unknown";
        }
    }

    public static void printDayOfWeek(int day) {
        switch (day) {
            case 0 -> System.out.println(day + " is Sunday");
            case 1 -> System.out.println(day + " is Monday");
            case 2 -> System.out.println(day + " is Tuesday");
            case 3 -> System.out.println(day + " is Wednesday");
            case 4 -> System.out.println(day + " is Thursday");
            case 5 -> System.out.println(day + " is Friday");
            case 6 -> System.out.println(day + " is Saturday");
            default -> System.out.println("Invalid Day");
        }
    }

    public static void printDayOfWeekWithIfElse(int day) {

        if (day == 0) {
            System.out.println(day + " is Sunday");
        } else if (day == 1) {
            System.out.println(day + " is Monday");
        } else if (day == 2) {
            System.out.println(day + " is Tuesday");
        } else if (day == 3) {
            System.out.println(day + " is Wednesday");
        } else if (day == 4) {
            System.out.println(day + " is Thursday");
        } else if (day == 5) {
            System.out.println(day + " is Friday");
        } else if (day == 6) {
            System.out.println(day + " is Friday");
        } else {
            System.out.println("Invalid Day");

        }
    }
}