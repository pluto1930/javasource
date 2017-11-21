package baseball;

import java.util.Scanner;

public class BBgame {
	// �ʵ�
	private static int[] bbAnswer;		// ������ ������ �迭
	private int out = 0;				
	private int strike = 0;					
	private int ball = 0;					
	
	// ������
	BBgame(){
		// ������ ������ �迭�� ��üȭ
		bbAnswer = new int[3];			
	}
	
	// ��üũ �޼���
	public int[] get() {
		int[] num = new int[bbAnswer.length];
		num = bbAnswer;
		return num;
	}
	
	// ���� ���� �޼���
	public void randomAnswer() {
		// ������ �ӽ÷� ������ �迭
		int[] answerTemp = new int[bbAnswer.length];
		boolean run = true;
		int cnt = 0;
		
		// �信 �ߺ��� �Ȼ��涧���� �ݺ�
		while(run) {
			// �������� ���ڸ� �����ؼ� �迭�� �ִ� �ݺ���
			for(int i = 0; i < answerTemp.length; i++) {
				answerTemp[i] = (int)(Math.random() * 10);
			}
			
			// cnt�� 0���� �ʱ�ȭ ����, �ߺ��� üũ
			for(int i = 0; i < answerTemp.length; i++) {
				for(int j = i + 1; j < 3; j++) {
					if(answerTemp[i] == answerTemp[j]) {
						cnt++;
					}
				}
			}
			
			// cnt�� 0�� �ƴ� �ٸ� ������ ��� ���� �ݺ����� ��� ����, 0�̸� �ߺ� ���ſϷ� �Ǵ� ��������
			if(cnt == 0) {
				System.out.println("���� : " + answerTemp[0] + answerTemp[1] + answerTemp[2]);
				bbAnswer = answerTemp;
				run = false;
			}
			
			// cnt�� 0���� �ʱ�ȭ
			cnt = 0;
		}
	}
	
	// �Է� �޴� ���� ��� �޼���
	public void printSentence(){
		System.out.println("���ڸ� �Է��ϼ���.");
		System.out.print("�Է� > ");
	}
	
	public boolean printResult() {
		// strike�� 3�� ��� �ݺ��� ����
		if(this.strike == 3) {
			System.out.println("����~! �����մϴ�~");
		}
		
		// out�� 3�� ��� �ݺ��� ����
		if(this.out == 3) {
			System.out.println("���ӿ���");
		}
		return false;
	}
	
	// ���� �Է� �޴� �޼���
	public int scanAnswer() {
		Scanner scan = new Scanner(System.in);
		int inputNum = 0;
		inputNum = scan.nextInt();
		return inputNum;
	}
	
	public void playOn() {
		boolean run = true;
		int inputNum = 0;
		
		// �ʱ� ��¹�
		System.out.println("���ھ߱� ������ �����մϴ�.");
		
		// ���� �޼��� ȣ��
		randomAnswer();
		
		// strike�� 3�̰ų�, out�� 3�ϰ�� �ݺ��� ����
		while(run) {
			// ��¹� ȣ��
			printSentence();
			
			// �Է¹��� 3�ڸ� ���ڸ� inputNum�� ����
			inputNum = scanAnswer();
			
			// ���� �޼��带 ȣ��, inputNum�� �Ű������� �ϸ�, �����޼����� strike��ȯ ���� strike�� ����
			bbJudgment(inputNum);
			
			if((this.strike == 3) || (this.out == 3)) {
				run = printResult();
			}
			
			// ��ȸ bbgame�� strike, ball �ʵ尪�� 0���� �ʱ�ȭ
			this.strike = 0;
			this.ball = 0;
		}
	}
	
	// ���� �޼���
	public void bbJudgment(int answer) {
		// �Է¹��� ���ڸ� ���ڸ� ������ �迭
		int[] answerTemp = new int[bbAnswer.length];

		// �Է¹��� ���ڸ� ���� ������ �迭�� ����
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
		
		// ��Ʈ����ũ, ��, �ƿ� ����
		for(int i = 0; i < answerTemp.length; i++) {
			// ���� ��ġ�� ���� ������ ���
			if(bbAnswer[i] == answerTemp[i]) {
				this.strike++;
			}
			for(int j = 0; j < answerTemp.length; j++) {
				// �ٸ���ġ��
				if(i != j) {
					// ���� ������ ���
					if(bbAnswer[i] == answerTemp[j]) {
						this.ball++;
					}
				}
			}
		}
		
		// �ƿ� ����
		if((this.strike == 0) && (this.ball == 0)) {
			this.out++;
		}
		
		// ��� ���
		System.out.println(this.strike + "��Ʈ����ũ " + this.ball + "�� " + this.out + "�ƿ�");
	}
}
