package com.poweremabox.rfb.service;

import com.poweremabox.rfb.domain.RfbEventAttendance;
import com.poweremabox.rfb.repository.RfbEventAttendanceRepository;
import com.poweremabox.rfb.service.dto.RfbEventAttendanceDTO;
import com.poweremabox.rfb.service.mapper.RfbEventAttendanceMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbEventAttendance}.
 */
@Service
@Transactional
public class RfbEventAttendanceService {

    private final Logger log = LoggerFactory.getLogger(RfbEventAttendanceService.class);

    private final RfbEventAttendanceRepository rfbEventAttendanceRepository;

    private final RfbEventAttendanceMapper rfbEventAttendanceMapper;

    public RfbEventAttendanceService(
        RfbEventAttendanceRepository rfbEventAttendanceRepository,
        RfbEventAttendanceMapper rfbEventAttendanceMapper
    ) {
        this.rfbEventAttendanceRepository = rfbEventAttendanceRepository;
        this.rfbEventAttendanceMapper = rfbEventAttendanceMapper;
    }

    /**
     * Save a rfbEventAttendance.
     *
     * @param rfbEventAttendanceDTO the entity to save.
     * @return the persisted entity.
     */
    public RfbEventAttendanceDTO save(RfbEventAttendanceDTO rfbEventAttendanceDTO) {
        log.debug("Request to save RfbEventAttendance : {}", rfbEventAttendanceDTO);
        RfbEventAttendance rfbEventAttendance = rfbEventAttendanceMapper.toEntity(rfbEventAttendanceDTO);
        rfbEventAttendance = rfbEventAttendanceRepository.save(rfbEventAttendance);
        return rfbEventAttendanceMapper.toDto(rfbEventAttendance);
    }

    /**
     * Partially update a rfbEventAttendance.
     *
     * @param rfbEventAttendanceDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RfbEventAttendanceDTO> partialUpdate(RfbEventAttendanceDTO rfbEventAttendanceDTO) {
        log.debug("Request to partially update RfbEventAttendance : {}", rfbEventAttendanceDTO);

        return rfbEventAttendanceRepository
            .findById(rfbEventAttendanceDTO.getId())
            .map(
                existingRfbEventAttendance -> {
                    rfbEventAttendanceMapper.partialUpdate(existingRfbEventAttendance, rfbEventAttendanceDTO);
                    return existingRfbEventAttendance;
                }
            )
            .map(rfbEventAttendanceRepository::save)
            .map(rfbEventAttendanceMapper::toDto);
    }

    /**
     * Get all the rfbEventAttendances.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RfbEventAttendanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbEventAttendances");
        return rfbEventAttendanceRepository.findAll(pageable).map(rfbEventAttendanceMapper::toDto);
    }

    /**
     * Get one rfbEventAttendance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RfbEventAttendanceDTO> findOne(Long id) {
        log.debug("Request to get RfbEventAttendance : {}", id);
        return rfbEventAttendanceRepository.findById(id).map(rfbEventAttendanceMapper::toDto);
    }

    /**
     * Delete the rfbEventAttendance by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RfbEventAttendance : {}", id);
        rfbEventAttendanceRepository.deleteById(id);
    }
}
