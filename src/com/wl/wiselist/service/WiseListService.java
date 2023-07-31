package com.wl.wiselist.service;

import com.wl.wiselist.entity.WiseList;

import java.util.ArrayList;
import java.util.List;

public class WiseListService {
    private int lastWiseListId;
    private List<WiseList> wiselists;

    public WiseListService(){
        lastWiseListId = 0;
        wiselists = new ArrayList<>();
    }
    public WiseList findById(int id){
        for(WiseList wiseList : wiselists){
            if(wiseList.getId() == id){
                return wiseList;
            }
        }
        return null;
    }
    public List<WiseList> findAll(){
        return wiselists;
    }
    public int Write(String wise, String writer){
        int id = lastWiseListId + 1;
        WiseList wiseList = new WiseList(id, wise, writer);
        wiselists.add(wiseList);
        lastWiseListId = id;
        return id;
    }

    public void remove(WiseList wiseList){
        wiselists.remove(wiseList);
    }
    public void update(WiseList wiseList, String wise, String writer){
        wiseList.setWise(wise);
        wiseList.setWriterName(writer);
    }

}
