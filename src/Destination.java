import java.util.ArrayList;

public class Destination {
    private String name;
    private ArrayList<Activity> activities;

    public Destination(String name){
        this.name = name;
        activities = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addActivity(Activity activity){
        if(activities.contains(activity)) return;
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }

    public void removeActivity(Activity activity){
        if(activities.contains(activity)){
            activities.remove(activity);
        }
    }

    public void printActivities(){
        for(Activity activity:activities){
            System.out.println("\t" + activity.getName());
            System.out.println("\t" + activity.getDescription());
            System.out.println("\tCost: $" + activity.getCost());
            System.out.println("\tCapacity: " + activity.getCapacity() + " people");
            if(activity instanceof WalkingTour){
                System.out.println("\tWalking Distance: " + ((WalkingTour) activity).getDistance() + " m");
            }
            if(activity instanceof TheatreShow){
                System.out.println("\tCast:");
                ((TheatreShow) activity).printStars();
            }
            System.out.println();
        }
    }
}
