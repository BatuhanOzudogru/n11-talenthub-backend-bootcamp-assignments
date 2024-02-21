package n11.assignment1;


import n11.assignment1.business.concretes.RealEstateManager;
import n11.assignment1.entities.abstracts.BaseEntity;
import n11.assignment1.entities.concretes.House;
import n11.assignment1.entities.concretes.SummerCottage;
import n11.assignment1.entities.concretes.Villa;
import n11.assignment1.utils.RealEstateType;

import java.util.List;

public class App {
    public static void main(String[] args) {

        BaseEntity house1 = new House(100, 100000, 3, 1);
        BaseEntity house2 = new House(150, 150000, 3, 1);
        BaseEntity house3 = new House(200,200000, 4, 1);
        BaseEntity villa1 = new Villa(300, 250000, 6, 2);
        BaseEntity villa2 = new Villa(400, 300000, 7, 2);
        BaseEntity villa3 = new Villa(500, 350000, 8, 2);
        BaseEntity summerCottage1 = new SummerCottage(600, 400000, 9, 3);
        BaseEntity summerCottage2 = new SummerCottage(700, 450000, 10, 3);
        BaseEntity summerCottage3 = new SummerCottage(800, 500000, 11, 3);

        List<BaseEntity> allEntities = List.of(house1, house2, house3, villa1, villa2, villa3, summerCottage1, summerCottage2, summerCottage3);
        RealEstateManager realEstateManager = new RealEstateManager(allEntities);

        System.out.println("Total price of all real estate: " + realEstateManager.getTotalPriceOfAllRealEstate());
        System.out.println("Total price of all houses: " + realEstateManager.getTotalPriceOfRealEstateByType(RealEstateType.HOUSE));
        System.out.println("Total price of all villas: " + realEstateManager.getTotalPriceOfRealEstateByType(RealEstateType.VILLA));
        System.out.println("Total price of all summer cottages: " + realEstateManager.getTotalPriceOfRealEstateByType(RealEstateType.SUMMER_COTTAGE));
        System.out.println("Average area of all real estate: " + realEstateManager.getAverageAreaOfAllRealEstate());
        System.out.println("Average area of all houses: " + realEstateManager.getAverageAreaOfRealEstateByType(RealEstateType.HOUSE));
        System.out.println("Average area of all villas: " + realEstateManager.getAverageAreaOfRealEstateByType(RealEstateType.VILLA));
        System.out.println("Average area of all summer cottages: " + realEstateManager.getAverageAreaOfRealEstateByType(RealEstateType.SUMMER_COTTAGE));
        System.out.println("Real Estate with 3 rooms and 1 living room: " + realEstateManager.filterRealEstateByRoomAndLivingRoom(3, 1).toString());
    }
}
