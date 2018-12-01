package com.example.IskconErpAPI.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sahil on 3/10/18.
 */
public class CommonResponseVO {

    String message;
    List<String> responses = new LinkedList<>();
    String type;

    public CommonResponseVO(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public static CommonResponseVO successResponse(String message){
        return  new CommonResponseVO(message, "success");
    }

    public static CommonResponseVO errorResponse(String message){
        return  new CommonResponseVO(message, "error");
    }

    public static CommonResponseVO warningResponse(String message){
        return  new CommonResponseVO(message, "warning");
    }
}
