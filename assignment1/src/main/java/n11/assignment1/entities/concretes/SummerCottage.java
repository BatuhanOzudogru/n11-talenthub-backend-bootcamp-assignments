package n11.assignment1.entities.concretes;

import n11.assignment1.entities.abstracts.BaseEntity;
import n11.assignment1.utils.RealEstateType;

public class SummerCottage extends BaseEntity {

    private RealEstateType realEstateType;
    public SummerCottage() {
        super();
    }

    public SummerCottage(double totalArea, double price, int numberOfRooms, int numberOfLivingRooms) {
        super(totalArea, price, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public RealEstateType getHomeType() {
        return RealEstateType.SUMMER_COTTAGE;
    }

    @Override
    public String toString() {
        return "{" +
                "realEstateType=" + getHomeType() +
                ", totalArea=" + getTotalArea() +
                ", price=" + getPrice() +
                ", numberfRooms=" + getNumberfRooms() +
                ", numberofLivingRooms=" + getNumberofLivingRooms() +
                '}';
    }

}
