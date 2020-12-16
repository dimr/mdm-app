import JSONAPISerializer from '@ember-data/serializer/json-api';
import JSONSerializer from '@ember-data/serializer/json';


export default class EmployeeSerializer extends JSONSerializer {
  // extract(store,primaryType,payload){
  //   console.log(payload);
  //   return payload;
  // }
  // normalizeResponse(store, primaryModelClass, payload, id, requestType){
  //   console.log(payload)
  //   delete payload.companyName;
  //   delete payload.company;
  //   store._hasModelFor('employee');
  //   console.log({
  //     "data":payload
  //   })
  //   return payload;
  // }
  //   console.log(payload.id);
  //   console.log(primaryModelClass.modelName);
  //   // store._hasModelFor('employee');
  //   if (requestType=='findRecord'){
  //     return this.normalize(primaryModelClass.modelName, {"data": {id: 8, email: "sdgsdg;l"}})
  //   }
    // return {
    //   data: {'payload':43,
    //   id:4}
    // }
  // }
}
