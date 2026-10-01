import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Scene extends JPanel {
    private BirdFlock flock;
    private int circleX;
    private int circleY;
    private int radius;

    private Point branchStart;
    private Point branchEnd;

    private static final int BIRD_SIZE = 10;

    public Scene(BirdFlock flock, int circleX, int circleY, int radius){
        this.flock = flock;
        this.circleX = circleX;
        this.circleY = circleY;
        this.radius = radius;

        branchStart = new Point(
                (int)(Math.random() * 800),
                (int)(Math.random() * 600)
        );

        branchEnd = new Point(
                (int)(Math.random() * 800),
                (int)(Math.random() * 600)
        );

        setPreferredSize(new Dimension(800, 600));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.drawOval(circleX - radius, circleY - radius,
                radius * 2, radius * 2);

        g.setColor(Color.DARK_GRAY);
        g.drawLine(branchStart.getX(), branchStart.getY(),
                branchEnd.getX(), branchEnd.getY());

        g.setColor(Color.BLACK);
        for(Bird b: flock){
            int x = b.getPoint().getX();
            int y = b.getPoint().getY();
            g.fillOval(x - BIRD_SIZE / 2, y - BIRD_SIZE / 2,
                    BIRD_SIZE, BIRD_SIZE);
        }

        drawRectangle(g, 1, Color.RED);
        drawRectangle(g, 2, Color.BLUE);
        drawRectangle(g, 3, Color.GREEN);
        drawRectangle(g, 0, Color.BLACK);
    }

    public void sitBirdsOnBranch(){
        int dx = branchEnd.getX() - branchStart.getX();
        int dy = branchEnd.getY() - branchStart.getY();

        double length = Math.sqrt(dx * dx + dy * dy);

        int places = (int)(length / BIRD_SIZE);
        int birdsToSit = places;

        if(birdsToSit > flock.size()){
            birdsToSit = flock.size();
        }

        for(int i = 0; i < birdsToSit; i++){
            double part = (double)(i + 1) / (places + 1);

            int x = branchStart.getX() + (int)(dx * part);
            int y = branchStart.getY() + (int)(dy * part);

            flock.get(i).setPoint(new Point(x, y));
        }

        System.out.println("Мест на ветке: " + places);
        System.out.println("Птиц село на ветку: " + birdsToSit);
    }

    private void drawRectangle(Graphics g, int type, Color color){
        boolean first = true;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        for(Bird b: flock){
            boolean needed = type == 0 ||
                    type == 1 && b instanceof Parrot ||
                    type == 2 && b instanceof Penguin ||
                    type == 3 && b instanceof Sparrow;

            if(needed){
                int x = b.getPoint().getX();
                int y = b.getPoint().getY();

                if(first){
                    minX = maxX = x;
                    minY = maxY = y;
                    first = false;
                }
                else{
                    if(x < minX) minX = x;
                    if(x > maxX) maxX = x;
                    if(y < minY) minY = y;
                    if(y > maxY) maxY = y;
                }
            }
        }

        if(!first){
            g.setColor(color);
            g.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
    }
}
