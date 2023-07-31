package com.wl.wiselist.entity;

public class WiseList {
    private int id;
    private String wise;
    private String writerName;
    public WiseList(int id, String content, String writerName){
        this.id = id ;
        this.wise = content;
        this.writerName = writerName;
    }

    public int getId() {
        return id;
    }

    public String getWise() {
        return wise;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWise(String wise) {
        this.wise = wise;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}