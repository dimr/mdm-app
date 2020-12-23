import Route from '@ember/routing/route';
import $ from "jquery";
import { action } from '@ember/object';
export default class EmployeeRoute extends Route {
  async model(params){

    console.log(params.employee_id)
    return $.getJSON('/api/employees/'+params.employee_id).then(data=>{
      console.log(data);
      return data;
    })
  }

  @action
  delete_employee(employee){
    console.log(employee)

    $.ajax({
      type:"DELETE",
      url:'/api/employees/'+employee.id,
      dataType:'json',
      contentType: "application/json; charset=utf-8",
    })
    this.transitionTo('employees.index');

  }
}
