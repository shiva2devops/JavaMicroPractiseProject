package com.shiva.app.exception;

public class ErrorResponse {

    public int getErrorCode(){
        return errorcode;

    }
    public void setErrorcode(int errorcode){
        this.errorcode=errorcode;

    }
    public String getMessege(){
        return messege;
    }

    public void setMessege(String messege){
        this.messege=messege;
    }

    private int errorcode;

    private  String messege;
}
