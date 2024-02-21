package n11.assignment1.business.abstracts;

import n11.assignment1.entities.abstracts.BaseEntity;
import n11.assignment1.utils.RealEstateType;

import java.util.List;

public interface RealEstateService {

   double getTotalPriceOfRealEstateByType(RealEstateType hometype);
    double getTotalPriceOfAllRealEstate();

    double getAverageAreaOfRealEstateByType(RealEstateType hometype);

    double getAverageAreaOfAllRealEstate();

    List<BaseEntity> filterRealEstateByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms);




}
