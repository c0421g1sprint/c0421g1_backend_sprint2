package com.codegym.dto;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.order.OrderDetail;

public class FoodAndDrinkDto {
    private Integer fadId;

    private String fadName;

    private String fadImage;

    private boolean deleteFlag;

    private String fadCode;

    private double fadPrice;

    private Integer fadWaitTime;

    private Category category;

    private OrderDetail orderDetail;

   public FoodAndDrinkDto(){

   }

    public FoodAndDrinkDto(Integer fadId, String fadName, String fadImage, boolean deleteFlag, String fadCode, double fadPrice, Integer fadWaitTime, Category category, OrderDetail orderDetail) {
        this.fadId = fadId;
        this.fadName = fadName;
        this.fadImage = fadImage;
        this.deleteFlag = deleteFlag;
        this.fadCode = fadCode;
        this.fadPrice = fadPrice;
        this.fadWaitTime = fadWaitTime;
        this.category = category;
        this.orderDetail = orderDetail;
    }

    public Integer getFadId() {
        return fadId;
    }

    public void setFadId(Integer fadId) {
        this.fadId = fadId;
    }

    public String getFadName() {
        return fadName;
    }

    public void setFadName(String fadName) {
        this.fadName = fadName;
    }

    public String getFadImage() {
        return fadImage;
    }

    public void setFadImage(String fadImage) {
        this.fadImage = fadImage;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getFadCode() {
        return fadCode;
    }

    public void setFadCode(String fadCode) {
        this.fadCode = fadCode;
    }

    public double getFadPrice() {
        return fadPrice;
    }

    public void setFadPrice(double fadPrice) {
        this.fadPrice = fadPrice;
    }

    public Integer getFadWaitTime() {
        return fadWaitTime;
    }

    public void setFadWaitTime(Integer fadWaitTime) {
        this.fadWaitTime = fadWaitTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
