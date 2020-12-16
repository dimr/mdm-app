import Controller from '@ember/controller';

import {action} from '@ember/object';

export default class NewEmployeeController extends Controller {


  @action
  add_employee(employee){
    console.log('added');
    let newEmployee = {

    }
    console.log(this.get('name'));
    $.ajax({
      type:'POST',
      url:'employees',

    })
  }

}
