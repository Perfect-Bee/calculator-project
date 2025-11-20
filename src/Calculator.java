import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    // 숫자와 연산자 입력
    public static double cacluate(double value1, double value2, String operator){
        double result = 0;

        switch (operator){
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if(value2 == 0){
                    System.out.println("0으로 나눌 수 없습니다.");
                } else result = value1 / value2;
                break;
            case "%":
                if(value2 == 0){
                    System.out.println("0으로 나눌 수 없습니다.");
                } else result = value1 % value2;
                break;
            case "^":
                result = Math.pow(value1, value2);
                break;
            case "sqrt": // 이건 입력 할 때, 예외처리 해야함(두 번째 숫자 제거)
                if(value1 < 0){
                    System.out.println("음수는 제곱근을 구할 수 없습니다.");
                } else result = Math.sqrt(value1);
                break;
            default:
        
        }
        return result;
    }
    // 입력받은 숫자 연산자 부름 -> 계산 수행 매서드
    public static double performCalculation(double value1, double value2, String operator){
        return cacluate(value1, value2, operator);
    }

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
            System.out.println("0. 종료");    // 구현 완료
            System.out.print("선텩 : ");

            String number = scanner.next();

            switch (number){
                case "1":
                    System.out.println("계산하기 기능 실행");
                    // 계산기 기능 구현해야함
                    double value1 = 0;
                    double value2 = 0;
                    String operator = "";

                    // 계산하는 매서드 호출하자.
                    // 첫 번째 숫자 입력
                    while(true) {
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        // scanner.hasNextDouble() : double 자료형이 있는가? = 실수야?
                        if(scanner.hasNextDouble()){
                            value1 = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("숫자를 입력해주세요.");
                            scanner.next(); // 잘못된 입력 제거
                        }
                    }

                    // 연산자 입력(연산자 이상한거 걸러내는 용도)
                    while(true){
                        System.out.print("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt): ");
                        operator = scanner.next();
                        if(operator.equals("+") || operator.equals("-") || operator.equals("*") ||
                           operator.equals("/") || operator.equals("%") || operator.equals("^") ||
                           operator.equals("sqrt")) {
                            break;
                        } else {
                            System.out.println("지원하지 않는 연산자입니다. 다시 입력해주세요.");
                        }
                    }

                    // 두 번째 숫자 입력 (sqrt는 제외. 하나만 필요함)
                    if(!operator.equals("sqrt")) {
                        while(true){
                            System.out.print("두 번째 숫자를 입력하세요: ");
                            if(scanner.hasNextDouble()){
                                value2 = scanner.nextDouble();
                                break;
                            } else {
                                System.out.println("숫자를 입력해주세요.");
                                scanner.next(); // 잘못된 입력 제거
                            }
                        }
                    }
                    // performCalculation = 계산 수행 호출
                    double result = performCalculation(value1, value2, operator);

                    // 결과 출력
                    if(operator.equals("sqrt")){
                        System.out.printf("결과: √%.1f = %.1f%n", value1, result);
                    } else {
                        System.out.printf("결과: %.1f %s %.1f = %.1f%n", value1, operator, value2, result);
                    }
                    // 계산 결과를 기록에 저장
                    if(operator.equals("sqrt")){ // 예외처리 : 1개만
                        dataSave.add("√" + value1 + " = " + result);
                    } else {
                        dataSave.add(value1 + " " + operator + " " + value2 + " = " + result);
                    }

                    break; // 이거 붙여야 case 다음 연달아 안나옴

                case "2":
                    System.out.println("=== 계산 이력 ===");
                    // 계산 이력 확인 / 있으면 -> 보여주고, 없으면 -> 없다고 하고
                    if(dataSave.isEmpty()){
                        System.out.println("저장된 계산 이력이 없습니다.");
                    } else {
                        for(int i = 0; i < dataSave.size(); i++){
                            System.out.println((i+1) + ". " + dataSave.get(i));
                        }
                    }
                    break;
                case "3":
                    // 계산 이력 날려버리기
                    if(dataSave.isEmpty()){
                        System.out.println("삭제할 계산 이력이 없습니다.");
                    } else {
                        dataSave.clear();
                        System.out.println("모든 계산 이력이 삭제되었습니다.");
                    }
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
2. case 1. 그러니까 실질 계산은 어떻게 하지?
??? : 숫자냐 문자냐 구분하는 게 왜 이렇게 어렵지...
검색해서 확인한 .hasnextDouble 말고 딴거 없나?

3. case 2 :
*/