abstract public class Bird {
    private static int count = 0;

    public Bird(){
        count++;
        System.out.println("Я птица.");
        //System.out.println("Я птица." + " Всего птиц: " + count + ".");
    }

    public void fly(){
        System.out.println("Я лечу!");
    }

    public static void printCount(){
        System.out.println("Всего птиц: " + count + ".");
    }
}
