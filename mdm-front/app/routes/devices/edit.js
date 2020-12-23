import Route from '@ember/routing/route';
import $ from "jquery";
import { action } from '@ember/object';


export default class DeviceEditRoute extends Route {
  async model(params){
    console.log('EDIT DEVICE view..');

    console.log(params.employee_id)
    // var data = $.ajax("employees/")
    // var data= this.get('store').findRecord('employee',params.employee_id);
    // console.log(data)
    return $.getJSON('/api/devices/'+params.device_id).then(data=>{
      console.log(data);
      return data;
    })

  }
  @action
  edit_device(device){
    console.log("___",device)
    console.log("g;dflgkfd;lg");
    let data ={id:device.id,
      serial_number:device.serial_number,
      type:device.type,
      employee_id:device.employee_id
    }
    console.log(data);
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
    console.log("end",data)
  }
}
