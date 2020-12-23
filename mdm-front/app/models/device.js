import Model from '@ember-data/model';

export default class DeviceModel extends Model {
  @attr('string') type;
  @attr('string') serial_number;
  @attr('string') employee_id;

}
