abstract public class Bird {
    private static int count = 0;
    private Point point;

    public Bird(){
        count++;
        //System.out.println("Я птица." + " Всего птиц: " + count + ".");

        point = new Point(
                (int)(Math.random() * 800),
                (int)(Math.random() * 600)
        );

        System.out.println("x = " + point.getX() + ", y = " + point.getY());
        System.out.println("Я птица.");
    }

    public void fly(){
        System.out.println("Я лечу!");
    }

    public static void printCount(){
        System.out.println("Всего птиц: " + count + ".");
    }

    public Point getPoint(){
        return point;
    }

    public void setPoint(Point point){
        this.point = point;
    }
}
