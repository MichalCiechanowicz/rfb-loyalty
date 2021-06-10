import { IRfbLocation } from 'app/entities/rfb-location/rfb-location.model';

export interface IRfbUser {
  id?: number;
  userName?: string | null;
  homeLocation?: IRfbLocation | null;
}

export class RfbUser implements IRfbUser {
  constructor(public id?: number, public userName?: string | null, public homeLocation?: IRfbLocation | null) {}
}

export function getRfbUserIdentifier(rfbUser: IRfbUser): number | undefined {
  return rfbUser.id;
}
