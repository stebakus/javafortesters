public class MinOfThree {
    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        if (Math.min (a, b) > c)
        return c;
        else return Math.min(a, b);

    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
