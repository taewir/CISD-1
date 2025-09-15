package org.example;

import java.util.Objects;

public class JetEngine extends Engine {
    private String model;
    private double thrust;

    public JetEngine() {
        super();
        this.model = "DefaultModel";
        this.thrust = 0;
    }

    public JetEngine(String name, double power, String model, double thrust) {
        super(name, power);
        setModel(model);
        setThrust(thrust);
    }

    public void setModel(String model) {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;
    }

    public void setThrust(double thrust) {
        if (thrust < 0 || thrust > 100000)
            throw new IllegalArgumentException("Thrust out of range");
        this.thrust = thrust;
    }

    @Override
    public String toString() {
        return super.toString() + ", model='" + model + "', thrust=" + thrust;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof JetEngine)) return false;
        JetEngine that = (JetEngine) o;
        return Double.compare(that.thrust, thrust) == 0 &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, thrust);
    }
}
