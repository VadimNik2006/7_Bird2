public class Parrot extends Bird{
    private String name;
    private static int count = 0;

    public Parrot(){
        count++;
        System.out.println("Я попугай.");
        //System.out.println("Я попугай." + " Всего попугаев: " + count + ".");
        name = "Кеша";
    }

    public Parrot(String name){
        count++;
        System.out.println("Я попугай.");
        //System.out.println("Я попугай." + " Всего попугаев: " + count + ".");
        this.name = name;
    }

    //public void fly(){
    //    System.out.println("Я лечу!");
    //}

    public void speak(){
        System.out.println("Меня зовут " + name + ".");
    }

    //public void rename(String name){
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name; //this.name
    }

    public static void printCount(){
        System.out.println("Всего попугаев: " + count + ".");
    }

    public void hello(Parrot p){
        System.out.println("Привет, попугай " + p.name + "! Я попугай, меня зовут " + this.name + "!");
    }

    public void hello(Penguin p){
        System.out.println("Привет, попугай! Я попугай, меня зовут " + this.name + "!");
    }
}
