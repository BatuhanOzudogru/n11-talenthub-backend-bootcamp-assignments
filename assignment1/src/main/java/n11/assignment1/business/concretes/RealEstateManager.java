package n11.assignment1.business.concretes;

import n11.assignment1.business.abstracts.RealEstateService;
import n11.assignment1.entities.abstracts.BaseEntity;
import n11.assignment1.utils.RealEstateType;

import java.util.ArrayList;
import java.util.List;

public class RealEstateManager implements RealEstateService {
    private final List<BaseEntity> realEstate;

    public RealEstateManager(List<BaseEntity> realEstateList) {
        this.realEstate = realEstateList;
    }

    @Override
    public double getTotalPriceOfRealEstateByType(RealEstateType realEstateType) {
        double totalPrice = 0;
        for (BaseEntity realEstate : realEstate) {
            if (realEstate.getHomeType() == realEstateType) {
                totalPrice += realEstate.getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public double getTotalPriceOfAllRealEstate() {
        double totalPrice = 0;
        for (BaseEntity realEstate : realEstate) {
            totalPrice += realEstate.getPrice();
        }
        return totalPrice;
    }

    @Override
    public double getAverageAreaOfRealEstateByType(RealEstateType realEstateType) {
        double area = 0;
        int count = 0;
        for (BaseEntity realEstate : realEstate) {
            if (realEstate.getHomeType() == realEstateType) {
                area += realEstate.getTotalArea();
                count++;
            }
        }
        return area / count;

    }

    @Override
    public double getAverageAreaOfAllRealEstate() {
        double area = 0;
        int count = 0;
        for (BaseEntity realEstate : realEstate) {
            area += realEstate.getTotalArea();
            count++;
        }
        return area / count;
    }

    @Override
    public List<BaseEntity> filterRealEstateByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms) {

        List<BaseEntity> filteredRealEstate = new ArrayList<>();
        for (BaseEntity realEstate : realEstate) {
            if (realEstate.getNumberfRooms() == numberOfRooms && realEstate.getNumberofLivingRooms() == numberOfLivingRooms) {
                filteredRealEstate.add(realEstate);
            }
        }
        return filteredRealEstate;

    }
}
