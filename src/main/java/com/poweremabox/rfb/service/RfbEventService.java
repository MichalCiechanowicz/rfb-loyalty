package com.poweremabox.rfb.service;

import com.poweremabox.rfb.domain.RfbEvent;
import com.poweremabox.rfb.repository.RfbEventRepository;
import com.poweremabox.rfb.service.dto.RfbEventDTO;
import com.poweremabox.rfb.service.mapper.RfbEventMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbEvent}.
 */
@Service
@Transactional
public class RfbEventService {

    private final Logger log = LoggerFactory.getLogger(RfbEventService.class);

    private final RfbEventRepository rfbEventRepository;

    private final RfbEventMapper rfbEventMapper;

    public RfbEventService(RfbEventRepository rfbEventRepository, RfbEventMapper rfbEventMapper) {
        this.rfbEventRepository = rfbEventRepository;
        this.rfbEventMapper = rfbEventMapper;
    }

    /**
     * Save a rfbEvent.
     *
     * @param rfbEventDTO the entity to save.
     * @return the persisted entity.
     */
    public RfbEventDTO save(RfbEventDTO rfbEventDTO) {
        log.debug("Request to save RfbEvent : {}", rfbEventDTO);
        RfbEvent rfbEvent = rfbEventMapper.toEntity(rfbEventDTO);
        rfbEvent = rfbEventRepository.save(rfbEvent);
        return rfbEventMapper.toDto(rfbEvent);
    }

    /**
     * Partially update a rfbEvent.
     *
     * @param rfbEventDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RfbEventDTO> partialUpdate(RfbEventDTO rfbEventDTO) {
        log.debug("Request to partially update RfbEvent : {}", rfbEventDTO);

        return rfbEventRepository
            .findById(rfbEventDTO.getId())
            .map(
                existingRfbEvent -> {
                    rfbEventMapper.partialUpdate(existingRfbEvent, rfbEventDTO);
                    return existingRfbEvent;
                }
            )
            .map(rfbEventRepository::save)
            .map(rfbEventMapper::toDto);
    }

    /**
     * Get all the rfbEvents.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RfbEventDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbEvents");
        return rfbEventRepository.findAll(pageable).map(rfbEventMapper::toDto);
    }

    /**
     * Get one rfbEvent by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RfbEventDTO> findOne(Long id) {
        log.debug("Request to get RfbEvent : {}", id);
        return rfbEventRepository.findById(id).map(rfbEventMapper::toDto);
    }

    /**
     * Delete the rfbEvent by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RfbEvent : {}", id);
        rfbEventRepository.deleteById(id);
    }
}
