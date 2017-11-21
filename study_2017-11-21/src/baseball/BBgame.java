package baseball;

import java.util.Scanner;

public class BBgame {
	// 필드
	private static int[] bbAnswer;		// 정답을 저장할 배열
	private int out = 0;				
	private int strike = 0;					
	private int ball = 0;					
	
	// 생성자
	BBgame(){
		// 정답을 저장할 배열을 객체화
		bbAnswer = new int[3];			
	}
	
	// 답체크 메서드
	public int[] get() {
		int[] num = new int[bbAnswer.length];
		num = bbAnswer;
		return num;
	}
	
	// 정답 생성 메서드
	public void randomAnswer() {
		// 정답을 임시로 저장할 배열
		int[] answerTemp = new int[bbAnswer.length];
		boolean run = true;
		int cnt = 0;
		
		// 답에 중복이 안생길때까지 반복
		while(run) {
			// 랜덤으로 숫자를 생성해서 배열에 넣는 반복문
			for(int i = 0; i < answerTemp.length; i++) {
				answerTemp[i] = (int)(Math.random() * 10);
			}
			
			// cnt는 0으로 초기화 상태, 중복을 체크
			for(int i = 0; i < answerTemp.length; i++) {
				for(int j = i + 1; j < 3; j++) {
					if(answerTemp[i] == answerTemp[j]) {
						cnt++;
					}
				}
			}
			
			// cnt가 0이 아닌 다른 숫자의 경우 위의 반복문을 계속 실행, 0이면 중복 제거완료 판단 빠져나옴
			if(cnt == 0) {
				System.out.println("정답 : " + answerTemp[0] + answerTemp[1] + answerTemp[2]);
				bbAnswer = answerTemp;
				run = false;
			}
			
			// cnt를 0으로 초기화
			cnt = 0;
		}
	}
	
	// 입력 받는 문구 출력 메서드
	public void printSentence(){
		System.out.println("숫자를 입력하세요.");
		System.out.print("입력 > ");
	}
	
	public boolean printResult() {
		// strike가 3일 경우 반복문 종료
		if(this.strike == 3) {
			System.out.println("정답~! 축하합니다~");
		}
		
		// out이 3일 경우 반복문 종료
		if(this.out == 3) {
			System.out.println("게임오버");
		}
		return false;
	}
	
	// 숫자 입력 받는 메서드
	public int scanAnswer() {
		Scanner scan = new Scanner(System.in);
		int inputNum = 0;
		inputNum = scan.nextInt();
		return inputNum;
	}
	
	public void playOn() {
		boolean run = true;
		int inputNum = 0;
		
		// 초기 출력문
		System.out.println("숫자야구 게임을 시작합니다.");
		
		// 랜덤 메서드 호출
		randomAnswer();
		
		// strike가 3이거나, out이 3일경우 반복문 종료
		while(run) {
			// 출력문 호출
			printSentence();
			
			// 입력받은 3자리 숫자를 inputNum에 저장
			inputNum = scanAnswer();
			
			// 판정 메서드를 호출, inputNum을 매개변수로 하며, 판정메서드의 strike반환 값을 strike에 저장
			bbJudgment(inputNum);
			
			if((this.strike == 3) || (this.out == 3)) {
				run = printResult();
			}
			
			// 매회 bbgame의 strike, ball 필드값을 0으로 초기화
			this.strike = 0;
			this.ball = 0;
		}
	}
	
	// 판정 메서드
	public void bbJudgment(int answer) {
		// 입력받은 세자리 숫자를 저장할 배열
		int[] answerTemp = new int[bbAnswer.length];

		// 입력받은 세자리 숫자 나눠서 배열에 저장
		for(int i = 0; i < answerTemp.length; i++) {
			switch(i) {
			case 0:
				answerTemp[0] = answer / 100;
				break;
			case 1:
				answerTemp[1] = (answer / 10) % 10;
				break;
			case 2:
				answerTemp[2] = answer % 10;
				break;
			}
		}
		
		// 스트라이크, 볼, 아웃 판정
		for(int i = 0; i < answerTemp.length; i++) {
			// 같은 위치에 같은 숫자일 경우
			if(bbAnswer[i] == answerTemp[i]) {
				this.strike++;
			}
			for(int j = 0; j < answerTemp.length; j++) {
				// 다른위치에
				if(i != j) {
					// 같은 숫자일 경우
					if(bbAnswer[i] == answerTemp[j]) {
						this.ball++;
					}
				}
			}
		}
		
		// 아웃 판정
		if((this.strike == 0) && (this.ball == 0)) {
			this.out++;
		}
		
		// 결과 출력
		System.out.println(this.strike + "스트라이크 " + this.ball + "볼 " + this.out + "아웃");
	}
}
