import java.util.ArrayList;

public class BirdFlock {
    private ArrayList<Bird> birds;

    public BirdFlock(){
        birds = new ArrayList<>();
    }

    public void add(Bird b){
        if(birds.indexOf(b) == -1)
            birds.add(b);
    }

    public int count(){
        return birds.size();
    }

    public void fly(){
        for(Bird b: birds)
            b.fly();
    }

}
