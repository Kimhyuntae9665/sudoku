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
	
	public static void sudoku(int row,int col) { //입력 배열에 0이 있으면 적절한 숫자를 찾아주는 함수
		// 해당 행이 다 채워 졌을 경우 다음 행의 첫 번째 열 부터 시작 
		
		if(col == 9) {
			sudoku(row+1,0);
			return;
		}
		
		if(row == 9) { //행은 0 ~ 8까지 9개  row == 9이면 끝났다는 뜻
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) { //끝났으니까 출력해야지
					System.out.print(arr[i][j]+ " ");
				}
				
				System.out.println();
			}
			
			System.exit(0); // 출력 뒤 시스템 종료
		}
		
		if(arr[row][col] == 0) { //만약 해당 배열의 값이 0이면 1 ~ 9까지 가능한 경우의 수 탐색
			for(int i=0;i<=9;i++) {
				// 1 ~ 9까지의 값이 중복되지 않는지 검사
				
				if(possibility(row,col,i)) { //타당성 검사 통과 시 
					arr[row][col] =i; // 중복되지 않는 값 넣기 
					sudoku(row,col+1); //같은 행의 다음 열로 이동 
				}
			}
			
			arr[row][col] =0; // 모든 값이 이미 자리를 잡고 있으면 
			return ;
		}
		
		sudoku(row,col+1);
	}
	
	
	public static boolean possibility(int row,int col, int value) {
		//같은 열에 중복되는 값이 없는지 검사 
		//같은 행에 중복되는 값이 없는지 검사
		// 3x3 칸에 중복되는 값 없는지 검사 
		
		
		// 같은 행에 중복되는 값 없는지 확인 
		for(int i=0;i<9;i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		
		//같은 열에 중복되는 원소 없는지 확인 
		for(int i=0; i< 9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		int set_row = (row/3)*3; //3x3 사각형의 왼쪽 최상단을 setting 위치로 정한다 
		int set_col = (col/3)*3;
		
		for(int i = set_row;i<set_row;i++) { //열을 다 확인 하면 다음으로 행을 옮겨서 확인 
			for(int j = set_col; j<set_col;j++) {
				if(arr[i][j] == value) { //3x3안에서 중복되는 값 있으면 possibility() 함수가 false를 리턴 
					return false;
				}
			}
		}
		
		return true; // 같은 행에도 열에도 3x3 사각형에도 중복되는 값이 없으면 true를 리턴 
	}

}
