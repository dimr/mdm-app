import Route from '@ember/routing/route';
import $ from "jquery";

export default class DevicesRoute extends Route {
  async model(){

    return $.ajax('/devices').then(data=>{
      console.log(data);
      return data._embedded.devices;
    })

  }
}
