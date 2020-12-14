import Model from '@ember-data/model';
import attr from 'ember-data/attr';

export default class EmployeeModel extends Model {

  @attr('integer') employee_id;
  @attr('string') name;
  @attr('string') email;
  @attr('integer') numberOfDevices;
  @attr devices;
  @attr company;




}
