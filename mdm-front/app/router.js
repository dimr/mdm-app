import EmberRouter from '@ember/routing/router';
import config from 'mdm-front/config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
}

Router.map(function() {
  this.route('employees', function(){
    this.route("employee",{path:'/:employee_id'});
    this.route("index",{path:'/'});
    this.route('new');
    this.route('edit',{path:'/edit/:employee_id'});
  });
  this.route('devices',function(){
    this.route('index',{path:"/"});
    this.route('new');
  });
});
