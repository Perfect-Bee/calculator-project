import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // 스캐너
        Scanner scanner = new Scanner(System.in);
        // 연산기록저장용
        ArrayList<String> dataSave = new ArrayList<>();

        // System.out.println("=== Java 계산기 ===");
        // 종료 시 이걸 true -> false 할거임
        boolean running = true;
        
        while(running){
            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 이력 보기");
            System.out.println("3. 이력 지우기");
            System.out.println("0. 종료");
            System.out.print("선텩 : ");

            String number = scanner.next();

            switch (number){
                case "1":
                    System.out.println("계산하기 기능 실행");
                    // 계산기 기능 구현해야함
                    break;
                case "2":
                    System.out.println("=== 계산 이력 ===");
                    // 계산 이력 확인 / 있으면 -> 보여주고, 없으면 -> 없다고 하고
                    break;
                case "3":
                    // 계산 이력 날려버리기
                    break;
                case "0":
                    // 계산기 종료. -> while의 true를 꺼버려야 함.
                    // 첫 번째 while를 변수로 작동시키자.
                    System.out.println("계산기를 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("1, 2, 3, 0 중 하나를 선택하세요");
                    break;
            }
        }

        scanner.close();
    }



}
/*
1. 우선 역순으로. 큰 틀 부터 잡고 시작해보자

*/