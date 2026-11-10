package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private int order_id;
    private int user_id;
    private String city;
    private BigDecimal order_total;
    private LocalDate date;

    public Order(int user_id, String city, BigDecimal order_total, LocalDate date){
        this.user_id = user_id;
        this.city = city;
        this.order_total = order_total;
        this.date = date;
    }

    public Order(int order_id, int user_id, String city, BigDecimal order_total, LocalDate date){
        this.order_id = order_id;
        this.user_id = user_id;
        this.city = city;
        this.order_total = order_total;
        this.date = date;
    }

    public int getOrder_id(){
        return order_id;
    }

    public int getUser_id(){
        return user_id;
    }

    public String getCity(){
        return city;
    }

    public BigDecimal getOrder_total(){
        return order_total;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setOrder_id(int order_id){
        this.order_id = order_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setOrder_total(BigDecimal order_total){
        this.order_total = order_total;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

}
