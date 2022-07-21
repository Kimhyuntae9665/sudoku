package sudoku;

import java.util.Scanner;import com.sun.jdi.AbsentInformationException;

public class sudoku {
	
	public static int[][] arr = new int[9][9];
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				arr[i][j] = in.nextInt();
			}
			
		}
		
		sudoku(0,0);

	}
	
	public static void sudoku(int row,int col) { //�Է� �迭�� 0�� ������ ������ ���ڸ� ã���ִ� �Լ�
		// �ش� ���� �� ä�� ���� ��� ���� ���� ù ��° �� ���� ���� 
		
		if(col == 9) {
			sudoku(row+1,0);
			return;
		}
		
		if(row == 9) { //���� 0 ~ 8���� 9��  row == 9�̸� �����ٴ� ��
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) { //�������ϱ� ����ؾ���
					System.out.print(arr[i][j]+ " ");
				}
				
				System.out.println();
			}
			
			System.exit(0); // ��� �� �ý��� ����
		}
		
		if(arr[row][col] == 0) { //���� �ش� �迭�� ���� 0�̸� 1 ~ 9���� ������ ����� �� Ž��
			for(int i=0;i<=9;i++) {
				// 1 ~ 9������ ���� �ߺ����� �ʴ��� �˻�
				
				if(possibility(row,col,i)) { //Ÿ�缺 �˻� ��� �� 
					arr[row][col] =i; // �ߺ����� �ʴ� �� �ֱ� 
					sudoku(row,col+1); //���� ���� ���� ���� �̵� 
				}
			}
			
			arr[row][col] =0; // ��� ���� �̹� �ڸ��� ��� ������ 
			return ;
		}
		
		sudoku(row,col+1);
	}
	
	
	public static boolean possibility(int row,int col, int value) {
		//���� ���� �ߺ��Ǵ� ���� ������ �˻� 
		//���� �࿡ �ߺ��Ǵ� ���� ������ �˻�
		// 3x3 ĭ�� �ߺ��Ǵ� �� ������ �˻� 
		
		
		// ���� �࿡ �ߺ��Ǵ� �� ������ Ȯ�� 
		for(int i=0;i<9;i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		
		//���� ���� �ߺ��Ǵ� ���� ������ Ȯ�� 
		for(int i=0; i< 9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		int set_row = (row/3)*3; //3x3 �簢���� ���� �ֻ���� setting ��ġ�� ���Ѵ� 
		int set_col = (col/3)*3;
		
		for(int i = set_row;i<set_row;i++) { //���� �� Ȯ�� �ϸ� �������� ���� �Űܼ� Ȯ�� 
			for(int j = set_col; j<set_col;j++) {
				if(arr[i][j] == value) { //3x3�ȿ��� �ߺ��Ǵ� �� ������ possibility() �Լ��� false�� ���� 
					return false;
				}
			}
		}
		
		return true; // ���� �࿡�� ������ 3x3 �簢������ �ߺ��Ǵ� ���� ������ true�� ���� 
	}

}
