package Showroom;

import Vehicles.Car;
import Vehicles.Motocycle;
import Vehicles.Vehicle;

import java.util.List;

public class Manager {

    public static Double SortPrice(List<Vehicle> x){
        Double total = 0.0;
        for(Vehicle y: x){
            total += y.getPrice();
        }
        return (total/x.size());
    };

    public static Vehicle SortOldest(List<Vehicle> x){
        Vehicle z = x.get(0);
        for(Vehicle y: x){
            if(y.getYear() <= z.getYear()){
                z = y;
            }
        }
        return z;
    };

    public static Vehicle SortNewest(List<Vehicle> x){
        Vehicle z = x.get(0);
        for(Vehicle y: x){
            if(y.getYear() >= z.getYear()){
                z = y;
            }
        }
        return z;
    };

}
