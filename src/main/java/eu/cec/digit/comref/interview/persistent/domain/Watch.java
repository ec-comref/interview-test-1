package eu.cec.digit.comref.interview.persistent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "WATCH")
public class Watch implements Serializable {

    private static final long serialVersionUID = 3366899548222964675L;

    public Watch() {
    }

    public Watch(String name, Integer value, Integer sold, Boolean available) {
        this.name = name;
        this.value = value;
        this.sold = sold;
        this.available = available;
    }

    @Id
    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "value")
    private Integer value;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "available")
    private Boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
