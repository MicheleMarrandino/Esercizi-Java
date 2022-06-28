package Showroom;

import Vehicles.Car;
import Vehicles.Motocycle;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static Showroom.Manager.*;

public class ShowRoom {
    public static void main(String[] args) {
        //I create mock objects.
        Motocycle Honda = new Motocycle("Honda CB750", "Honda",10000.0, 1969, true, false);
        Motocycle Vespa = new Motocycle("Vespa", "Vespa",2000.0, 1909, true, false);
        Car Tesla = new Car("Tesla", "Tesla",3030.0, 2020, 2);
        Car Ferrari = new Car("Ferrari", "Ferrari",4030.0, 2022, 1);

        //I create 3 lists, whole catalogue, and  divided by type.
        List<Vehicle> carList = new ArrayList<>();
        List<Vehicle> motocycleList = new ArrayList<>();
        motocycleList.add(Honda);
        motocycleList.add(Vespa);
        carList.add(Tesla);
        carList.add(Ferrari);

       List<Vehicle> list = new ArrayList<>();
        list.addAll(motocycleList);
        list.addAll(carList);

        //I solved the problem by using generics and just 3 methods.
        System.out.println("Prezzo medio motociclette è " + SortPrice(motocycleList));
        System.out.println("Motocicletta piu' vecchia è " + SortOldest(motocycleList).getName());
        System.out.println("Motocicletta piu' nuova è " + SortNewest(motocycleList).getName() +'\n');

        System.out.println("Prezzo medio macchine è " + SortPrice(carList));
        System.out.println("Macchina piu' vecchia è " + SortOldest(carList).getName());
        System.out.println("Macchina piu' nuova è " + SortNewest(carList).getName()+'\n');

        System.out.println("Prezzo medio totale è " + SortPrice(list));
        System.out.println("Veicolo piu' vecchio è " + SortOldest(list).getName());
        System.out.println("Veicolo piu' nuovo è " + SortNewest(list).getName()+'\n');

    }
}
