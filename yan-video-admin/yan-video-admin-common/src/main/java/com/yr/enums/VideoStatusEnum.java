package com.yr.enums;


/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/15 15:14
 *视频状态枚举
 */
public enum  VideoStatusEnum {
    SUCCESS(1,"成功发布"),      //成功发布
    FORBID(2,"禁止播放");       //禁止播放

    public final  int value;
    public final  String msg;

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    VideoStatusEnum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }}
