package br.com.camiloporto.buraqueira.endpoint.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by camiloporto on 25/04/16.
 */
@Getter
@Setter
@Document(collection = "location")
public class Location {

    @org.springframework.data.annotation.Id
    private Id id;

    private BigDecimal lat;
    private BigDecimal lng;

    public Location() {
    }

    public Location(String sender, long timestamp, BigDecimal lat, BigDecimal lng) {
        this.id = new Id(sender, timestamp);
        this.lat = lat;
        this.lng = lng;
    }

    public Long getTimestamp() {
        return id.getTimestamp();
    }

    public String getSender() {
        return id.getSender();
    }
}
