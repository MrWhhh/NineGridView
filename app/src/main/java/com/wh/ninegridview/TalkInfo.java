package com.wh.ninegridview;

import java.util.List;

/**
 * @author MrWhhh .
 * @date : 2017/4/20 .
 * @description : .
 */
public class TalkInfo {
    public String name;
    public String content;
    public List<PhotoInfo> photo;

    public TalkInfo(String name,String content,List<PhotoInfo> photo){
        this.name = name;
        this.content = content;
        this.photo = photo;
    }

    public static class PhotoInfo{
        public int ids;
        public PhotoInfo(int ids){
            this.ids = ids;
        }
    }
}
