package org.example;

import java.util.Objects;

public class InternalCombustionEngine extends Engine {
    private String fuelType;
    private int rpm;

    public InternalCombustionEngine() {
        super();
        this.fuelType = "Petrol";
        this.rpm = 1000;
    }

    public InternalCombustionEngine(String name, double power, String fuelType, int rpm) {
        super(name, power);
        setFuelType(fuelType);
        setRpm(rpm);
    }

    public void setFuelType(String fuelType) {
        if (fuelType == null || fuelType.isBlank())
            throw new IllegalArgumentException("Fuel type cannot be empty");
        this.fuelType = fuelType;
    }

    public void setRpm(int rpm) {
        if (rpm < 0 || rpm > 20000)
            throw new IllegalArgumentException("RPM out of range");
        this.rpm = rpm;
    }

    @Override
    public String toString() {
        return super.toString() + ", fuelType='" + fuelType + "', rpm=" + rpm;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof InternalCombustionEngine)) return false;
        InternalCombustionEngine that = (InternalCombustionEngine) o;
        return rpm == that.rpm && Objects.equals(fuelType, that.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelType, rpm);
    }
}
