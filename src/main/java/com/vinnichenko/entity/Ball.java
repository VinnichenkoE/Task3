package com.vinnichenko.entity;

public class Ball {

    private BallColor color;
    private Double weight;
    private Double volume;

    public Ball(BallColor color, Double weight, Double volume) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (color != ball.color) return false;
        if (weight != null ? !weight.equals(ball.weight) : ball.weight != null) return false;
        return volume != null ? volume.equals(ball.volume) : ball.volume == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
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
