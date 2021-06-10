package com.poweremabox.rfb.service;

import com.poweremabox.rfb.domain.RfbUser;
import com.poweremabox.rfb.repository.RfbUserRepository;
import com.poweremabox.rfb.service.dto.RfbUserDTO;
import com.poweremabox.rfb.service.mapper.RfbUserMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbUser}.
 */
@Service
@Transactional
public class RfbUserService {

    private final Logger log = LoggerFactory.getLogger(RfbUserService.class);

    private final RfbUserRepository rfbUserRepository;

    private final RfbUserMapper rfbUserMapper;

    public RfbUserService(RfbUserRepository rfbUserRepository, RfbUserMapper rfbUserMapper) {
        this.rfbUserRepository = rfbUserRepository;
        this.rfbUserMapper = rfbUserMapper;
    }

    /**
     * Save a rfbUser.
     *
     * @param rfbUserDTO the entity to save.
     * @return the persisted entity.
     */
    public RfbUserDTO save(RfbUserDTO rfbUserDTO) {
        log.debug("Request to save RfbUser : {}", rfbUserDTO);
        RfbUser rfbUser = rfbUserMapper.toEntity(rfbUserDTO);
        rfbUser = rfbUserRepository.save(rfbUser);
        return rfbUserMapper.toDto(rfbUser);
    }

    /**
     * Partially update a rfbUser.
     *
     * @param rfbUserDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RfbUserDTO> partialUpdate(RfbUserDTO rfbUserDTO) {
        log.debug("Request to partially update RfbUser : {}", rfbUserDTO);

        return rfbUserRepository
            .findById(rfbUserDTO.getId())
            .map(
                existingRfbUser -> {
                    rfbUserMapper.partialUpdate(existingRfbUser, rfbUserDTO);
                    return existingRfbUser;
                }
            )
            .map(rfbUserRepository::save)
            .map(rfbUserMapper::toDto);
    }

    /**
     * Get all the rfbUsers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RfbUserDTO> findAll() {
        log.debug("Request to get all RfbUsers");
        return rfbUserRepository.findAll().stream().map(rfbUserMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one rfbUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RfbUserDTO> findOne(Long id) {
        log.debug("Request to get RfbUser : {}", id);
        return rfbUserRepository.findById(id).map(rfbUserMapper::toDto);
    }

    /**
     * Delete the rfbUser by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RfbUser : {}", id);
        rfbUserRepository.deleteById(id);
    }
}
