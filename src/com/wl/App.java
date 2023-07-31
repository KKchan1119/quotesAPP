package com.wl;

import com.wl.system.controller.SystemController;
import com.wl.wiselist.controller.WiseListController;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseListController wiselistcontroller = new WiseListController();

        while (true) {
            System.out.printf("명령) ");
            //trim() = 좌우 공백 제거
            String cmd = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiselistcontroller.write();
                    break;
                case "목록":
                    wiselistcontroller.list();
                    break;
                case "삭제":
                    wiselistcontroller.remove(rq);
                    break;
                case "수정":
                    wiselistcontroller.update(rq);
                    break;
            }
        }
    }
}