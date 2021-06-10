package com.poweremabox.rfb.service.mapper;

import com.poweremabox.rfb.domain.*;
import com.poweremabox.rfb.service.dto.RfbEventAttendanceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RfbEventAttendance} and its DTO {@link RfbEventAttendanceDTO}.
 */
@Mapper(componentModel = "spring", uses = { RfbUserMapper.class, RfbEventMapper.class })
public interface RfbEventAttendanceMapper extends EntityMapper<RfbEventAttendanceDTO, RfbEventAttendance> {
    @Mapping(target = "rfbUser", source = "rfbUser", qualifiedByName = "id")
    @Mapping(target = "rfbEvent", source = "rfbEvent", qualifiedByName = "id")
    RfbEventAttendanceDTO toDto(RfbEventAttendance s);
}
