package com.poweremabox.rfb.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.poweremabox.rfb.domain.RfbUser} entity.
 */
public class RfbUserDTO implements Serializable {

    private Long id;

    private String userName;

    private RfbLocationDTO homeLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RfbLocationDTO getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(RfbLocationDTO homeLocation) {
        this.homeLocation = homeLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RfbUserDTO)) {
            return false;
        }

        RfbUserDTO rfbUserDTO = (RfbUserDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rfbUserDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RfbUserDTO{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", homeLocation=" + getHomeLocation() +
            "}";
    }
}
