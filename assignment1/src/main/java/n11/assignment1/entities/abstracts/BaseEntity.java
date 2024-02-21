package n11.assignment1.entities.abstracts;

import n11.assignment1.utils.RealEstateType;

public abstract class BaseEntity {
    private double totalArea;
    private double price;
    private int numberfRooms;
    private int numberofLivingRooms;

    public BaseEntity() {
    }

    public BaseEntity(double totalArea, double price, int numberfRooms, int numberofLivingRooms) {
        this.totalArea = totalArea;
        this.price = price;
        this.numberfRooms = numberfRooms;
        this.numberofLivingRooms = numberofLivingRooms;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberfRooms() {
        return numberfRooms;
    }

    public void setNumberfRooms(int numberfRooms) {
        this.numberfRooms = numberfRooms;
    }

    public int getNumberofLivingRooms() {
        return numberofLivingRooms;
    }

    public void setNumberofLivingRooms(int numberofLivingRooms) {
        this.numberofLivingRooms = numberofLivingRooms;
    }

    public abstract RealEstateType getHomeType();
}
