import Route from '@ember/routing/route';
import $ from "jquery";

export default class DevicesRoute extends Route {
  async model(){

    return $.ajax('/api/devices').then(data=>{
      console.log(data);
      return data.content;
    })

  }
}
