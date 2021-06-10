package com.poweremabox.rfb.service;

import com.poweremabox.rfb.domain.RfbLocation;
import com.poweremabox.rfb.repository.RfbLocationRepository;
import com.poweremabox.rfb.service.dto.RfbLocationDTO;
import com.poweremabox.rfb.service.mapper.RfbLocationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbLocation}.
 */
@Service
@Transactional
public class RfbLocationService {

    private final Logger log = LoggerFactory.getLogger(RfbLocationService.class);

    private final RfbLocationRepository rfbLocationRepository;

    private final RfbLocationMapper rfbLocationMapper;

    public RfbLocationService(RfbLocationRepository rfbLocationRepository, RfbLocationMapper rfbLocationMapper) {
        this.rfbLocationRepository = rfbLocationRepository;
        this.rfbLocationMapper = rfbLocationMapper;
    }

    /**
     * Save a rfbLocation.
     *
     * @param rfbLocationDTO the entity to save.
     * @return the persisted entity.
     */
    public RfbLocationDTO save(RfbLocationDTO rfbLocationDTO) {
        log.debug("Request to save RfbLocation : {}", rfbLocationDTO);
        RfbLocation rfbLocation = rfbLocationMapper.toEntity(rfbLocationDTO);
        rfbLocation = rfbLocationRepository.save(rfbLocation);
        return rfbLocationMapper.toDto(rfbLocation);
    }

    /**
     * Partially update a rfbLocation.
     *
     * @param rfbLocationDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RfbLocationDTO> partialUpdate(RfbLocationDTO rfbLocationDTO) {
        log.debug("Request to partially update RfbLocation : {}", rfbLocationDTO);

        return rfbLocationRepository
            .findById(rfbLocationDTO.getId())
            .map(
                existingRfbLocation -> {
                    rfbLocationMapper.partialUpdate(existingRfbLocation, rfbLocationDTO);
                    return existingRfbLocation;
                }
            )
            .map(rfbLocationRepository::save)
            .map(rfbLocationMapper::toDto);
    }

    /**
     * Get all the rfbLocations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RfbLocationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbLocations");
        return rfbLocationRepository.findAll(pageable).map(rfbLocationMapper::toDto);
    }

    /**
     * Get one rfbLocation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RfbLocationDTO> findOne(Long id) {
        log.debug("Request to get RfbLocation : {}", id);
        return rfbLocationRepository.findById(id).map(rfbLocationMapper::toDto);
    }

    /**
     * Delete the rfbLocation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RfbLocation : {}", id);
        rfbLocationRepository.deleteById(id);
    }
}
