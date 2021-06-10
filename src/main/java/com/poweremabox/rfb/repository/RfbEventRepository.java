package com.poweremabox.rfb.repository;

import com.poweremabox.rfb.domain.RfbEvent;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the RfbEvent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbEventRepository extends JpaRepository<RfbEvent, Long> {}
