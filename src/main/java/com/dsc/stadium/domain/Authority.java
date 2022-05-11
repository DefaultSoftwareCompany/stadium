package com.dsc.stadium.domain;

import com.dsc.stadium.utils.AuthorityConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @Enumerated(EnumType.STRING)
    private AuthorityConstants authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Authority authority1 = (Authority) o;
        return authority != null && Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
