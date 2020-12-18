import Route from '@ember/routing/route';
import { action } from '@ember/object';
import $ from "jquery";
export default class EmployeesNewRoute extends Route {
  @action
  add_employee(employee){
    console.log("add employee--");
    console.log(this.controller.get('name'));
    console.log(this.controller.get('email'));
    console.log(this.controller.get('companyName'));
    let data = {
      name:this.controller.get('name'),
      email:this.controller.get('email'),
      companyName:this.controller.get('companyName'),
    }
    $.ajax({
      type:"POST",
      url:'/api/employee',
      data: JSON.stringify(data),
      dataType:'json',
      contentType: "application/json; charset=utf-8",
    }).done(function(data){
      console.log("=====",data);
    }).fail(function(xhr,status,error){
      console.log(error,status,xhr)
    })
  }
}
