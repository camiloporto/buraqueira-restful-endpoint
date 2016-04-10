package br.com.camiloporto.buraqueira.endpoint.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by camiloporto on 10/04/16.
 */
@Getter @Setter
@Entity
public class AccelerometerData {

    @EmbeddedId
    private br.com.camiloporto.buraqueira.endpoint.model.Id id;

    private double x;
    private double y;
    private double z;


    public AccelerometerData() {
    }

    public AccelerometerData(String sender, double x, double y, double z, long timestamp) {
        id = new br.com.camiloporto.buraqueira.endpoint.model.Id(sender, timestamp);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public br.com.camiloporto.buraqueira.endpoint.model.Id getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
