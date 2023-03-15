import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        System.out.print("Enter start date (yyyyMMdd): ");
        LocalDate startDate = LocalDate.parse(scanner.next(), formatter);

        System.out.print("Enter close date (yyyyMMdd): ");
        LocalDate closeDate = LocalDate.parse(scanner.next(), formatter);

        System.out.print("Enter number of months to add: ");
        int monthsToAdd = scanner.nextInt();

        closeDate = calculateCloseDate(startDate, closeDate, monthsToAdd);

        System.out.println("Close date: " + closeDate.format(formatter));
    }

    public static LocalDate calculateCloseDate(LocalDate startDate, LocalDate closeDate, int monthsToAdd) {
        LocalDate newCloseDate = closeDate.plusMonths(monthsToAdd);

        if (startDate.getDayOfMonth() == startDate.lengthOfMonth()) {
            newCloseDate = newCloseDate.withDayOfMonth(newCloseDate.lengthOfMonth());
        }

        return newCloseDate;
    }
}
