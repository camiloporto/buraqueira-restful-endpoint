package br.com.camiloporto.buraqueira.endpoint.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by camiloporto on 10/04/16.
 */
@Getter @Setter
@Entity
@IdClass(br.com.camiloporto.buraqueira.endpoint.model.Id.class)
public class AccelerometerData {

//    @EmbeddedId
//    private br.com.camiloporto.buraqueira.endpoint.model.Id id;

    @Id
    private String sender;
    @Id
    private Long timestamp;
    private double x;
    private double y;
    private double z;


    public AccelerometerData() {
    }

    public AccelerometerData(String sender, double x, double y, double z, long timestamp) {
        this.sender = sender;
//        id = new br.com.camiloporto.buraqueira.endpoint.model.Id(sender, timestamp);
        this.x = x;
        this.y = y;
        this.z = z;
        this.timestamp = timestamp;
    }

//    public br.com.camiloporto.buraqueira.endpoint.model.Id getId() {
//        return id;
//    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getSender() {
        return sender;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
