package dimski.py.drf.order.dto;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseStd  implements Serializable {

    private HashMap<String, Object> keyJson = new HashMap<>();

    private ResponseStd(Integer status, Object coki){
        this.keyJson.put("status", status);
        this.keyJson.put("data", coki);
    }

    public static ResponseStd genResponse(Integer status, Object coki){
        return new ResponseStd(status, coki);
    }


    public HashMap<String, Object> getBodyJson(){
        return keyJson;
    }
}
