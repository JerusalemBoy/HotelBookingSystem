package model;
import java.util.Date;

public class Booking {
    private int id;
    private int userId;
    private int roomId;
    private Date checkIn;
    private Date checkOut;
    private String status;

    public Booking(){}
    public Booking(int id,int userId,int roomId,Date checkIn,Date checkOut,String status){
        this.id=id; this.userId=userId; this.roomId=roomId; this.checkIn=checkIn; this.checkOut=checkOut; this.status=status;
    }

    // Getters & setters
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public int getRoomId(){return roomId;}
    public void setRoomId(int roomId){this.roomId=roomId;}
    public Date getCheckIn(){return checkIn;}
    public void setCheckIn(Date checkIn){this.checkIn=checkIn;}
    public Date getCheckOut(){return checkOut;}
    public void setCheckOut(Date checkOut){this.checkOut=checkOut;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}
