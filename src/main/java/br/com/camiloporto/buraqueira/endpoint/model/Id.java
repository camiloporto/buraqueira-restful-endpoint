package br.com.camiloporto.buraqueira.endpoint.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by camiloporto on 10/04/16.
 */

@Embeddable
@Getter @Setter
public class Id implements Serializable {
    private String sender;
    private Long timestamp;

    public Id(String sender, long timestamp) {

        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        if (sender != null ? !sender.equals(id.sender) : id.sender != null) return false;
        return timestamp != null ? timestamp.equals(id.timestamp) : id.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
