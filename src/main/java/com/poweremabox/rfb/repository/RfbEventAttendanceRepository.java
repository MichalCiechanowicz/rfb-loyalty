package com.poweremabox.rfb.repository;

import com.poweremabox.rfb.domain.RfbEventAttendance;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the RfbEventAttendance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbEventAttendanceRepository extends JpaRepository<RfbEventAttendance, Long> {}
