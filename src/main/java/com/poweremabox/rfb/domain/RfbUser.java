package com.poweremabox.rfb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A RfbUser.
 */
@Entity
@Table(name = "rfb_user")
public class RfbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @JsonIgnoreProperties(value = { "rfbEvents" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private RfbLocation homeLocation;

    @OneToMany(mappedBy = "rfbUser")
    @JsonIgnoreProperties(value = { "rfbEvent", "rfbUser" }, allowSetters = true)
    private Set<RfbEventAttendance> rfbEventAttendances = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RfbUser id(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return this.userName;
    }

    public RfbUser userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RfbLocation getHomeLocation() {
        return this.homeLocation;
    }

    public RfbUser homeLocation(RfbLocation rfbLocation) {
        this.setHomeLocation(rfbLocation);
        return this;
    }

    public void setHomeLocation(RfbLocation rfbLocation) {
        this.homeLocation = rfbLocation;
    }

    public Set<RfbEventAttendance> getRfbEventAttendances() {
        return this.rfbEventAttendances;
    }

    public RfbUser rfbEventAttendances(Set<RfbEventAttendance> rfbEventAttendances) {
        this.setRfbEventAttendances(rfbEventAttendances);
        return this;
    }

    public RfbUser addRfbEventAttendance(RfbEventAttendance rfbEventAttendance) {
        this.rfbEventAttendances.add(rfbEventAttendance);
        rfbEventAttendance.setRfbUser(this);
        return this;
    }

    public RfbUser removeRfbEventAttendance(RfbEventAttendance rfbEventAttendance) {
        this.rfbEventAttendances.remove(rfbEventAttendance);
        rfbEventAttendance.setRfbUser(null);
        return this;
    }

    public void setRfbEventAttendances(Set<RfbEventAttendance> rfbEventAttendances) {
        if (this.rfbEventAttendances != null) {
            this.rfbEventAttendances.forEach(i -> i.setRfbUser(null));
        }
        if (rfbEventAttendances != null) {
            rfbEventAttendances.forEach(i -> i.setRfbUser(this));
        }
        this.rfbEventAttendances = rfbEventAttendances;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RfbUser)) {
            return false;
        }
        return id != null && id.equals(((RfbUser) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RfbUser{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            "}";
    }
}
