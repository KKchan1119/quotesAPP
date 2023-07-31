package com.wl.wiselist.controller;



import com.wl.Container;
import com.wl.Rq;
import com.wl.wiselist.entity.*;
import com.wl.wiselist.service.WiseListService;

import java.util.List;

public class WiseListController {
    private final WiseListService wiseListService;


    public WiseListController(){
        wiseListService = new WiseListService();
    }

    public void write(){

        System.out.printf("명언 : ");
        String inputWise = Container.getScanner().nextLine();
        System.out.printf("작가 : ");
        String inputWriter = Container.getScanner().nextLine();
        int id = wiseListService.Write(inputWise, inputWriter);
        System.out.println(id+"번 명언이 등록되었습니다.");
    }

    public void list(){
        List<WiseList> wiselists = wiseListService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for(int i = 0; i < wiselists.size(); i++) {
            WiseList wiseList1 = wiselists.get(i);

            System.out.printf("%d / %s / %s\n", wiseList1.getId(), wiseList1.getWriterName(), wiseList1.getWise());

        }
    }

    public void remove(Rq rq){
        int id = rq.getIntParam("id", -1);

        if(id == -1){
            System.out.println("id(정수) 입력요망");
            return;
        }
        WiseList wiselist = wiseListService.findById(id);
        if(wiselist == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wiseListService.remove(wiselist);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void update(Rq rq){
        int id = rq.getIntParam("id", -1);
        if(id == -1){
            System.out.println("id(정수) 입력요망");
            return;
        }
        WiseList wiselist = wiseListService.findById(id);
        if(wiselist == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("기존 명언 : "+ wiselist.getWise());
        System.out.print("새 명언: ");
        String inputWise = Container.getScanner().nextLine().trim();

        System.out.println("기존 작가 : "+ wiselist.getWriterName());
        System.out.print("새 작가: ");
        String inputWriter = Container.getScanner().nextLine().trim();

        wiseListService.update(wiselist, inputWise, inputWriter);


    }


}