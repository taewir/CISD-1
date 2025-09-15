package org.example;

import java.util.Objects;

public class DieselEngine extends InternalCombustionEngine {
    private String emissionClass;
    private double torque;

    public DieselEngine() {
        super();
        this.emissionClass = "Euro5";
        this.torque = 200;
    }

    public DieselEngine(String name, double power, String fuelType, int rpm,
                        String emissionClass, double torque) {
        super(name, power, fuelType, rpm);
        setEmissionClass(emissionClass);
        setTorque(torque);
    }

    public void setEmissionClass(String emissionClass) {
        if (emissionClass == null || emissionClass.isBlank())
            throw new IllegalArgumentException("Emission class cannot be empty");
        this.emissionClass = emissionClass;
    }

    public void setTorque(double torque) {
        if (torque < 0 || torque > 10000)
            throw new IllegalArgumentException("Torque out of range");
        this.torque = torque;
    }

    @Override
    public String toString() {
        return super.toString() + ", emissionClass='" + emissionClass + "', torque=" + torque;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof DieselEngine)) return false;
        DieselEngine that = (DieselEngine) o;
        return Double.compare(that.torque, torque) == 0 &&
                Objects.equals(emissionClass, that.emissionClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emissionClass, torque);
    }
}
