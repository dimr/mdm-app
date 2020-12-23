import Route from '@ember/routing/route';
import { action } from '@ember/object';
import $ from "jquery";
export default class DevicesNewRoute extends Route {
  @action
  add_device(employee){
    let data = {
      serial_number:this.controller.get('serial_number'),
      email:this.controller.get('email'),
      type:this.controller.get('type'),
      employee_id:this.controller.get('employee_id')
    }
    $.ajax({
      type:"POST",
      url:'/api/devices',
      data: JSON.stringify(data),
      dataType:'json',
      contentType: "application/json; charset=utf-8",
    }).done(function(data){
      console.log("=====",data);
    }).fail(function(xhr,status,error){
      console.log(error,status,xhr)
    })
    // this.transitionTo("employees.index").refresh();
  }
}
