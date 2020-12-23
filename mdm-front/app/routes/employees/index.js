import Route from '@ember/routing/route';
import $ from "jquery";
export default class IndexRoute extends Route {
 async model(){

    return $.ajax('/api/employees').then(data=>{
      let allData = data.content;

      return allData.map(model=>{
        let {id, name,email,devices,company,attributes}=model;
        let test="function test";
        return {id,name,email,devices,company,...attributes};
      });
    })

 }
}
