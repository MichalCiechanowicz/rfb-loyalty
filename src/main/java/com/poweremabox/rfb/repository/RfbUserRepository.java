package com.poweremabox.rfb.repository;

import com.poweremabox.rfb.domain.RfbUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the RfbUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbUserRepository extends JpaRepository<RfbUser, Long> {}
