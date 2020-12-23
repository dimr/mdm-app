import Route from '@ember/routing/route';
import $ from "jquery";
import { action } from '@ember/object';


export default class EmployeeEditRoute extends Route {
  async model(params){
    return $.getJSON('/api/employees/'+params.employee_id).then(data=>{
      console.log(data);
      return data;
    })

  }
  @action
  edit_employee(employee){
    console.log("___",employee.company.name)
    let data ={id:employee.id,
      name:employee.name,
      email:employee.email,
    companyName:employee.company.name
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
