package codeblocks.and.methods.overloading;

public class SecondsAndMinutes {

    public static void main(String[] args) {
        // Test cases for the getDurarionString methods
        System.out.println(getDurarionString(65)); // 1h 5m 0s
        System.out.println(getDurarionString(3600)); // 1h 0m 0s
        System.out.println(getDurarionString(61, 59)); // 1h 1m 59s
        System.out.println(getDurarionString(120, 59)); // 2h 0m 59s
        System.out.println(getDurarionString(-5)); // Invalid Value - seconds cannot be negative
        System.out.println(getDurarionString(10, -5)); // Invalid Value - minutes and seconds must be non-negative, and seconds must be less than 60
    }

public static String getDurarionString(int seconds) {
    if (seconds < 0) {
        return "Invalid Value - seconds cannot be negative";
    }

    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;

    return getDurarionString(minutes, remainingSeconds);
}

public static String getDurarionString(int minutes, int seconds) {

    if (minutes < 0 || seconds < 0 || seconds >= 60) {
        return "Invalid Value - minutes and seconds must be non-negative, and seconds must be less than 60";
    }

    int hours = minutes / 60;
    int remainingMinutes = minutes % 60;

    String hoursString = hours + "h";
    String minutesString = remainingMinutes + "m";
    String secondsString = seconds + "s";

    return hoursString + " " + minutesString + " " + secondsString;

}
}

// XXh YYm ZZs