package com.vinnichenko.task3.entity;

import java.util.List;

public class Basket {
    private double carrying;
    private double capacity;
    private List<Ball> balls;

    public Basket(double carrying, double capacity, List<Ball> balls) {
        this.carrying = carrying;
        this.capacity = capacity;
        this.balls = balls;
    }

    public double getCarrying() {
        return carrying;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public boolean isFit(Ball ball) {
        return getCarrying() - ball.getWeight() >= 0 && getCapacity() - ball.getVolume() >= 0;
    }

    public boolean add(Ball ball) {
        if (ball == null) {
            return false;
        }
        if (isFit(ball)) {
            capacity -= ball.getVolume();
            carrying -= ball.getWeight();
            return balls.add(ball);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        if (Double.compare(basket.carrying, carrying) != 0) {
            return false;
        }
        if (Double.compare(basket.capacity, capacity) != 0) {
            return false;
        }
        return balls != null ? balls.equals(basket.balls) : basket.balls == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(carrying);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
