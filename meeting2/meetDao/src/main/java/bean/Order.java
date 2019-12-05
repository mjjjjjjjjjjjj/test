package bean;

import java.util.Date;

public class Order {
    private int id,mid;
    private Date orderTime,startTime,endTime;

    public Order() {
    }

    public Order(int id, int mid, Date orderTime, Date startTime, Date endTime) {
        this.id = id;
        this.mid = mid;
        this.orderTime = orderTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", mid=" + mid +
                ", orderTime=" + orderTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
