
var exec = require('cordova/exec');
var Http = {
    get:function(url,success,error){
        exec(success,error,"SimpleHttp","get",[url]);
    },
    post:function(url,params,success,error){
        exec(success,error,"SimpleHttp","post",[url,params]);
    }
}
module.exports = Http;
