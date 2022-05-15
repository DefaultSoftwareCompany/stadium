package com.dsc.stadium.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double latitude;

    private Double longitude;

    private String address;

    private BigDecimal price;

    @Column(columnDefinition = "text")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stadium stadium = (Stadium) o;
        return Objects.equals(id, stadium.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
