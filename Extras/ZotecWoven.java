import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Subscription {
    public Subscription() {}
    public Subscription(int id, int customerId, int monthlyPriceInDollars) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInDollars;
}

class User {
    public User() {}
    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        //If there are no active subscriptions or users, then the total cose is 0
        if(activeSubscription == null || users.length == 0)return 0.00;

        StringBuilder sb = new StringBuilder(month);
        sb.append("-15");
        LocalDate cur = LocalDate.parse(sb.toString());
//     System.out.println(cur);
        //Calculating the days in the current month
        //https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
        LocalDate firstDay = firstDayOfMonth(cur);
        LocalDate lastDay = lastDayOfMonth(cur);
        int lastDayInMonth = lastDay.getDayOfMonth();
        int firstDayInMonth = firstDay.getDayOfMonth();
        int numberOfDays = lastDayInMonth - firstDayInMonth + 1;

        //Daily Price calculated as per the given month
        double dailyPrice = ((double)activeSubscription.monthlyPriceInDollars)/(double)numberOfDays;
        double totalRunningCost = 0.0;
        for(int i = 0; i < users.length; i++){

            //The current user for which the cost is being calculated
            User temporary = users[i];
            int start = firstDayInMonth, end = lastDayInMonth;

            //Set the first and last days in month
            if(lastDay.compareTo(temporary.activatedOn) < 0){
                continue;
            }else if(firstDay.compareTo(temporary.activatedOn) >= 0){
                start = firstDayInMonth;
            }else{
                start = temporary.activatedOn.getDayOfMonth();
            }
            if(temporary.deactivatedOn != null){
                if(firstDay.compareTo(temporary.deactivatedOn) > 0){
                    continue;
                }else if(lastDay.compareTo(temporary.deactivatedOn) <= 0){
                    end = lastDayInMonth;
                }else{
                    end = temporary.deactivatedOn.getDayOfMonth();
                }
            }
            double subscribedNumberofDays = end - start + 1;
            totalRunningCost += (subscribedNumberofDays*dailyPrice);
        }

        //Formatting the return value to two decimal places
        //https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/#:~:text=There%20are%20four%20ways%20to%20round%20up%20a,round%20a%20given%20number%20to%20its%20nearest%20integer.
        DecimalFormat dFormat = new DecimalFormat("###.##");
        dFormat.format(totalRunningCost);

        return totalRunningCost;
    }

    /*******************
     * Helper functions *
     *******************/

    /**
     Takes a LocalDate object and returns a LocalDate which is the first day
     of that month. For example:

     firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the last day
     of that month. For example:

     lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the next day.
     For example:

     nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
     nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}