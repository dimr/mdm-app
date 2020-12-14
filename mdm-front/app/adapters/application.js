import JSONAPIAdapter from '@ember-data/adapter/json-api';
import { computed } from '@ember/object';
export default class ApplicationAdapter extends JSONAPIAdapter {
  host='http://localhost:8080';
}
