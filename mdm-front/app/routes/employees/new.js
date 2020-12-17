import Route from '@ember/routing/route';
import { action } from '@ember/object';
export default class EmployeesNewRoute extends Route {
  @action
  add_employee(employee){
    console.log("add employee--");
    console.log(employee);
    console.log(this.get('email'))
  }
}
