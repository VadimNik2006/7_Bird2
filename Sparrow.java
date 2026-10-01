public class Sparrow extends Bird {
    private static int count = 0;

    public Sparrow(){
        count++;
        System.out.println("Я воробей.");
    }

    public static void printCount(){
        System.out.println("Всего воробьёв: " + count + ".");
    }
}
