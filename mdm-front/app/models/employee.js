import Model from '@ember-data/model';

export default class EmployeeModel extends Model {

  @attr('integer') id;
  @attr('string') name;
  @attr('string') email;
  @attr('integer') numberOfDevices;
  @attr devices;
  @attr company;




}
