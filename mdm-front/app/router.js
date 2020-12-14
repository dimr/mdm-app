import EmberRouter from '@ember/routing/router';
import config from 'mdm-front/config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
}

Router.map(function() {
  this.route('employees', function(){
    this.route("/employee_id")
  });
  // this.route('employee',{path:'/employee/:employee_id'});
  this.route('devices');
});
