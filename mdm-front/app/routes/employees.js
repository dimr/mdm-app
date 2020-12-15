import Route from '@ember/routing/route';
import $ from "jquery";
export default class EmployeesRoute extends Route {
 async model(){
   console.log('start request..');
   // let response =await fetch('/employees');
   //  let { data } = await response.json();
   // console.log('end request');
   // return Ember.$.ajax("/employees")
   // console.log(response.data);
   //  console.log("Paramgs",params)
    return $.ajax('/employees').then(data=>{
      let allData = data.content;

      return allData.map(model=>{
        let {id, name,email,devices,company,attributes}=model;
        let test="function test";
        return {id,name,email,devices,company,...attributes};
      });
    })
   // return fetch('/api/employees').then(function(response){
   //  console.log(response);
   //   return response.json();
   // });
 }
}
