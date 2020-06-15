package com.vinnichenko.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private Double carrying;
    private Double capacity;
    private List<Ball> balls = new ArrayList<>();

    public Basket(Double carrying, Double capacity) {
        this.carrying = carrying;
        this.capacity = capacity;
    }

    public Double getCarrying() {
        return carrying;
    }

    public Double getCapacity() {
        return capacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setCarrying(Double carrying) {
        this.carrying = carrying;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        if (carrying != null ? !carrying.equals(basket.carrying) : basket.carrying != null) return false;
        if (capacity != null ? !capacity.equals(basket.capacity) : basket.capacity != null) return false;
        return balls != null ? balls.equals(basket.balls) : basket.balls == null;
    }

    @Override
    public int hashCode() {
        int result = carrying != null ? carrying.hashCode() : 0;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (balls != null ? balls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("carrying=").append(carrying);
        sb.append(", capacity=").append(capacity);
        sb.append(", balls=").append(balls);
        sb.append('}');
        return sb.toString();
    }
}
