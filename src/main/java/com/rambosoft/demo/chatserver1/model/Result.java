package com.rambosoft.demo.chatserver1.model;

/**
 * Created by rambo on 2019/3/24.
 */
public class Result<T> {
   private T date;
   private String msg;
   private Boolean isSuccess;

   public T getDate() {
      return date;
   }

   public void setDate(T date) {
      this.date = date;
   }

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public Boolean getSuccess() {
      return isSuccess;
   }

   public void setSuccess(Boolean success) {
      isSuccess = success;
   }

   public Integer getStatusCode() {
      return statusCode;
   }

   public void setStatusCode(Integer statusCode) {
      this.statusCode = statusCode;
   }

   private Integer statusCode;
}
