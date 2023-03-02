import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine();
            if(cmd.equals("등록")){
                System.out.printf("명언 : ");
                String input = sc.nextLine();
                System.out.printf("작가 : ");
                String writer = sc.nextLine();
            }
            if(cmd.equals("종료")){
                break;
            }
        }
    }
}