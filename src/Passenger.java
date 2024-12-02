import java.util.ArrayList;

public class Passenger {
    private String name;
    private int passengerNumber;
    private ArrayList<Activity> activityList = new ArrayList<>();
    private static int passengers = 1;
    private double balance;
    private double discount;

    public String getName(){
        return name;
    }

    public int getPassengerNumber(){
        return passengerNumber;
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengerNumber(){
        passengerNumber = passengers;
        passengers++;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public void signUpActivity(Activity activity){
        if(checkActivityDest(activity.getDestination())){
            return;
        }
        if(activity.getCapacity() - activity.getCurrentSize() <1){
            return;
        }
        if(balance < discount * activity.getCost()){
            return;
        }
        activityList.add(activity);
        activity.updateSize();
        balance -= activity.getCost() * discount;

    }

    private boolean checkActivityDest(String dest){
        for(Activity ac:activityList){
            if(ac.getDestination().equals(dest)) return true;
        }
        return false;
    }

    public void printActivities(){
        for(Activity activity:activityList){
            System.out.println("\t" + activity.getName());
            System.out.println("\t\t"  + activity.getDescription());
            System.out.println("\t\t"  + activity.getDestination());
            int cost = activity.getCost();
            if(discount == 0){
                System.out.println("\t\tCost: Free");
            }else{
                System.out.println("\t\tCost: $" + cost*discount);
            }
        }
    }

}
