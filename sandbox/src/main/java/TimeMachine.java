public class TimeMachine {

    public void goToFuture(int currentYear) {

        currentYear = currentYear+10;
    }

    public void goToPast(int currentYear) {

        currentYear = currentYear-10;
    }

    public static void main(String[] args) {

        TimeMachine timeMachine = new TimeMachine();
        Cat barsik = new Cat();
        barsik.currentYear = 2020;
        int currentYear = 2020;
        timeMachine.goToFuture(barsik.currentYear);

        System.out.println("Where barsik now");
        System.out.println(currentYear);

        timeMachine.goToPast(barsik.currentYear);
        System.out.println("and now?");
        System.out.println(currentYear);
    }
}