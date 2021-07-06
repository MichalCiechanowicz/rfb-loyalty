package com.poweremabox.rfb.service.mapper;

import com.poweremabox.rfb.domain.*;
import com.poweremabox.rfb.service.dto.RfbEventAttendanceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RfbEventAttendance} and its DTO {@link RfbEventAttendanceDTO}.
 */
@Mapper(componentModel = "spring", uses = { RfbEventMapper.class, RfbUserMapper.class })
public interface RfbEventAttendanceMapper extends EntityMapper<RfbEventAttendanceDTO, RfbEventAttendance> {
    @Mapping(target = "rfbEvent", source = "rfbEvent", qualifiedByName = "id")
    @Mapping(target = "rfbUser", source = "rfbUser", qualifiedByName = "id")
    RfbEventAttendanceDTO toDto(RfbEventAttendance s);
}
