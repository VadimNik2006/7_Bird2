import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        //System.out.println("Привет, Мир!");
        //int a = 5;
        //a = 8;

        //Bird b = new Bird();
        //b = new Bird();
        //b.fly();
        //b.fly();

        Scanner in = new Scanner(System.in);

        System.out.print("Введите x центра окружности: ");
        int x = in.nextInt();

        System.out.print("Введите y центра окружности: ");
        int y = in.nextInt();

        System.out.print("Введите радиус окружности: ");
        int radius = in.nextInt();

        Parrot p1 = new Parrot();
        //p1.fly();
        //p1.speak();
        //p1.name = "Qqq";

        Parrot p2 = new Parrot("Клёпа");
        //p2.speak();
        //p2.rename("Qqq");
        //p2.setName("Qqq");
        //p2.speak();
        //System.out.println(p2.getName());

        Penguin p3 = new Penguin();
        //p3.fly();

        //System.out.println(p3 instanceof Penguin);
        //System.out.println(p3 instanceof Bird);
        //System.out.println(p3 instanceof Object);

        Bird p4 = new Parrot();
        //p4.fly();
        //((Parrot)p4).speak();

        Bird[] birds = new Bird[]{p1, p2, p3, p4, p4};
        //for(int i = 0; i < birds.length; i++){
        //    birds[i].fly();
        //}

        //for(Bird b: birds){
        //    b.fly();
        //}

        Penguin p5 = new Penguin();

        //Parrot.printCount();
        //Penguin.printCount();
        //Bird.printCount();

        //BirdFlock f1 = new BirdFlock();
        //f1.add(p1);
        //f1.add(p2);
        //f1.add(p3);
        //f1.add(p2);
        //System.out.println("Общее количество птиц в группе: " + f1.count());
        //f1.fly();

        //p1.hello(p2);
        //p1.hello(p1);
        //p1.hello((Parrot)p4);
        //p1.hello(p3);
        //p3.hello(p1);
        //p3.hello(p5);

        BirdFlock flock = new BirdFlock();
        flock.add(p1);
        flock.add(p2);
        flock.add(p3);
        flock.add(p4);
        flock.add(p5);
        flock.add(new Sparrow());
        flock.add(new Sparrow());
        flock.add(new Sparrow());

        System.out.println("Птиц в окружности: " +
                flock.countInCircle(x, y, radius));

        JFrame window = new JFrame("Birds");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scene scene = new Scene(flock, x, y, radius);
        window.add(scene);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        in.nextLine();
        System.out.print("Введите команду sit: ");
        String command = in.nextLine();

        if(command.equals("sit")){
            scene.sitBirdsOnBranch();
            scene.repaint();
        }
    }
}
