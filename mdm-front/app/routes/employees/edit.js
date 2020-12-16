import Route from '@ember/routing/route';
import $ from "jquery";
export default class EmployeeEditRoute extends Route {
  async model(params){
    console.log('EDIT emplpoyeee view..');

    console.log(params.employee_id)
    // var data = $.ajax("employees/")
    // var data= this.get('store').findRecord('employee',params.employee_id);
    // console.log(data)
    return $.getJSON('/employees/'+params.employee_id).then(data=>{
      console.log(data);
      return data;
    })

  }
}
