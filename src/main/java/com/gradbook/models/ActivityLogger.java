package com.gradbook.models;

import java.sql.Timestamp;

/**
 * Created by Monjur-E-Morshed on 10-Aug-17.
 */
public class ActivityLogger {

  private Long id;

  private String userId;

  private Timestamp accessTime;

  private String className;

  private String methodName;

  public ActivityLogger() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long pId) {
    id = pId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String pUserId) {
    userId = pUserId;
  }

  public Timestamp getAccessTime() {
    return accessTime;
  }

  public void setAccessTime(Timestamp pAccessTime) {
    accessTime = pAccessTime;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String pClassName) {
    className = pClassName;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String pMethodName) {
    methodName = pMethodName;
  }
}
