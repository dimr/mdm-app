import Route from '@ember/routing/route';
import $ from "jquery";
export default class EmployeeRoute extends Route {
  async model(params){
    console.log('single emplpoyeee view..');
    // let response =await fetch('/employees');
    //  let { data } = await response.json();
    // console.log('end request');
    // return Ember.$.ajax("/employees")
    // console.log(response.data);
    //  console.log("Paramgs",params)
    // return $.ajax('/employees').then(data=>{
    //   let allData = data.content;
    //
    //   return allData.map(model=>{
    //     let {id, name,email,devices,company,attributes}=model;
    //     let test="function test";
    //     return {id,name,email,devices,company,...attributes};
    //   });
    // })
    console.log(params.employee_id)
    // var data = $.ajax("employees/")
    // var data= this.get('store').findRecord('employee',params.employee_id);
    // console.log(data)
    return $.getJSON('/employees/'+params.employee_id).then(data=>{
      console.log(data);
      return data;
    })
    // this.store.find('employee',params.employee_id).then(function(employee){
    //   console.log(employee);
    //   return employee;
    // })

    // return fetch('/api/employees').then(function(response){
    //  console.log(response);
    //   return response.json();
    // });
  }
}
