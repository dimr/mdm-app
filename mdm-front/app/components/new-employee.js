import Component from '@glimmer/component';
import { action } from '@ember/object';
export default class NewEmployeeComponent extends Component {

  @action
  add_employee(employee){
    console.log(employee);

    console.log('dummy action');
  }
}
