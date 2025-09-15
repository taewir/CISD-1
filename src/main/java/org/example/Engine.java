package org.example;

import java.util.Objects;

public class Engine {
    protected String name;
    protected double power; // kW

    public Engine() {
        this.name = "Unknown";
        this.power = 0;
    }

    public Engine(String name, double power) {
        setName(name);
        setPower(power);
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setPower(double power) {
        if (power < 0 || power > 10000)
            throw new IllegalArgumentException("Power out of range");
        this.power = power;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', power=" + power + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine that = (Engine) o;
        return Double.compare(that.power, power) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
