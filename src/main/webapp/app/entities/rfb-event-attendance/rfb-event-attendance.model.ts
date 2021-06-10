import * as dayjs from 'dayjs';
import { IRfbUser } from 'app/entities/rfb-user/rfb-user.model';
import { IRfbEvent } from 'app/entities/rfb-event/rfb-event.model';

export interface IRfbEventAttendance {
  id?: number;
  attendanceDate?: dayjs.Dayjs | null;
  rfbUser?: IRfbUser | null;
  rfbEvent?: IRfbEvent | null;
}

export class RfbEventAttendance implements IRfbEventAttendance {
  constructor(
    public id?: number,
    public attendanceDate?: dayjs.Dayjs | null,
    public rfbUser?: IRfbUser | null,
    public rfbEvent?: IRfbEvent | null
  ) {}
}

export function getRfbEventAttendanceIdentifier(rfbEventAttendance: IRfbEventAttendance): number | undefined {
  return rfbEventAttendance.id;
}
