package com.tms.entity;



// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "CHAT_MESSAGE".
 */

public class ChatMessage {

    
    private Long cid;

    
    private String content;

    
    private String fromWhom;

    
    private String toWhom;
    
    
    private long time;

    
    private String type;

    
    private String status;

    
    public ChatMessage() {
    }

    public ChatMessage(Long cid) {
        this.cid = cid;
    }

    
    public ChatMessage(Long cid, String content, String fromWhom, String toWhom, long time, String type, String status) {
        this.cid = cid;
        this.content = content;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.time = time;
        this.type = type;
        this.status = status;
    }

    public Long getCid() {
        return cid;
    }

    public void setId(Long cid) {
        this.cid = cid;
    }

    
    public String getContent() {
        return content;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContent( String content) {
        this.content = content;
    }

    
    public String getFromWhom() {
        return fromWhom;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setFromWhom( String fromWhom) {
        this.fromWhom = fromWhom;
    }

    
    public String getToWhom() {
        return toWhom;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setToWhom( String toWhom) {
        this.toWhom = toWhom;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    
    public String getType() {
        return type;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setType( String type) {
        this.type = type;
    }

    
    public String getStatus() {
        return status;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStatus( String status) {
        this.status = status;
    }

}
