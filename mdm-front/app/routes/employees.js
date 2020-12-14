import Route from '@ember/routing/route';

export default class EmployeesRoute extends Route {
 async model(){
   console.log('start request..');
   let response =await fetch('/employees');
    let { data } = await response.json();
   console.log('end request');
   // return Ember.$.ajax("/employees")
   // console.log(response.data);
 }
}
