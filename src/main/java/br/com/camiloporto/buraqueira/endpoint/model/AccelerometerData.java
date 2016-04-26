package br.com.camiloporto.buraqueira.endpoint.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by camiloporto on 10/04/16.
 */
@Getter @Setter
@Document(collection = "vibration")
//@Entity
//@IdClass(br.com.camiloporto.buraqueira.endpoint.model.Id.class)
public class AccelerometerData {

    @Id
    private br.com.camiloporto.buraqueira.endpoint.model.Id id;


    private double x;
    private double y;
    private double z;


    public AccelerometerData() {
    }

    public AccelerometerData(String sender, double x, double y, double z, long timestamp) {
//        this.sender = sender;
        id = new br.com.camiloporto.buraqueira.endpoint.model.Id(sender, timestamp);
        this.x = x;
        this.y = y;
        this.z = z;
//        this.timestamp = timestamp;
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
        return id.getSender();
    }

    public Long getTimestamp() {
        return id.getTimestamp();
    }


}
