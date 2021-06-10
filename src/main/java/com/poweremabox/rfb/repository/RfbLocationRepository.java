package com.poweremabox.rfb.repository;

import com.poweremabox.rfb.domain.RfbLocation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the RfbLocation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbLocationRepository extends JpaRepository<RfbLocation, Long> {}
