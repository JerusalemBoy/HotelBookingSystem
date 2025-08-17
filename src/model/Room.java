package model;

public class Room {
    private int id;
    private int roomNumber;
    private String type;
    private double price;
    private boolean isAvailable;

    public Room() {}
    public Room(int id, int roomNumber, String type, double price, boolean isAvailable){
        this.id=id; this.roomNumber=roomNumber; this.type=type; this.price=price; this.isAvailable=isAvailable;
    }

    // Getters & setters
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getRoomNumber(){return roomNumber;}
    public void setRoomNumber(int roomNumber){this.roomNumber=roomNumber;}
    public String getType(){return type;}
    public void setType(String type){this.type=type;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
    public boolean isAvailable(){return isAvailable;}
    public void setAvailable(boolean available){this.isAvailable=available;}
}
