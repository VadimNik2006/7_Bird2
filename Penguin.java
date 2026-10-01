public class Penguin extends Bird{
    private static int count = 0;

    public Penguin(){
        count++;
        System.out.println("Я пингвин.");
        //System.out.println("Я пингвин." + " Всего пингвинов: " + count + ".");
    }

    @Override
    public void fly(){
        //;
        System.out.println("Пингвины не летают!");
    }

    public static void printCount(){
        System.out.println("Всего пингвинов: " + count + ".");
    }

    public void hello(Parrot p){
        System.out.println("Привет, попугай " + p.getName() + "! Я пингвин!");
    }

    public void hello(Penguin p){
        System.out.println("Привет, пингвин! Я пингвин!");
    }
}
