import Route from '@ember/routing/route';
import $ from "jquery";
export default class EmployeesRoute extends Route {
 async model(params){
   console.log('start request..');
   // let response =await fetch('/employees');
   //  let { data } = await response.json();
   // console.log('end request');
   // return Ember.$.ajax("/employees")
   // console.log(response.data);
    console.log("Paramgs",params)
    return $.ajax('/employees').then(data=>{
      return data.content;
    })
   // return fetch('/api/employees').then(function(response){
   //  console.log(response);
   //   return response.json();
   // });
 }
}
