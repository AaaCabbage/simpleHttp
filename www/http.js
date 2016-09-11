
var exec = require('cordova/exec');
var Http = {
    get:function(url,success,error){
        exec(success,error,"zHttp","get",[url]);
    },
    post:function(url,params,success,error){
        exec(success,error,"zHttp","post",[url,params]);
    }
}
module.exports = Http;
