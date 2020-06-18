package com.vinnichenko.task3.entity;

public class Ball {

    private BallColor color;
    private double weight;
    private double volume;

    public Ball(BallColor color, double weight, double volume) {
        this.color = color;
        this.weight = weight;
        this.volume = volume;
    }

    public BallColor getColor() {
        return color;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        if (Double.compare(ball.weight, weight) != 0) {
            return false;
        }
        if (Double.compare(ball.volume, volume) != 0) {
            return false;
        }
        return color == ball.color;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = color != null ? color.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("color=").append(color);
        sb.append(", weight=").append(weight);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
