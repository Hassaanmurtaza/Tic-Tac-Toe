public class Task3 {

     static int c=0;
     public static void main(String[] args) {
         Scanner in= new Scanner(System.in);
         System.out.println("Tic Tac Toe");
         System.out.println("Enter 1 for 1 player or 2 for 2 player game");
         System.out.println("Input");
         
         int abc=in.nextInt();
         
         if (abc==1){
             int turn = 1;
	int[][] game = new int[3][3];
	int move;
	int winner;
	while(true) {
	    if(turn == 1) {
		System.out.println("Your move, Enter (0-8)");
		move = -1;
		while (move<0 || move>9 || game[move/3][move%3] != 0) {
		   
		    move = in.nextInt();
		   
		
	    } }else {
		move = computer_move(game);
		System.out.println("I put it on " + move);
	    }
            
	    game[(int)(move/3)][move%3] = turn;
	    show(game);
	    winner = win(game);
	    if(winner != 0){
		break;}
	    if(turn == 1) {
		turn = 2;
	    } else {
		turn = 1;
	    }
    }
         }
         else if(abc==2){
              char arr [][] = new char [3][3]; 
        boolean notWin =true;
        int x=0;
        
        while(notWin==true && x<9 ){
          
            // Phela input 
        input(arr, x);    
         print(arr);
        if (check(arr,x,notWin)==false){
            System.out.println("Game over");
            break; 
        }
        x++;
              
        //Dosra input
        input(arr, x);
         print(arr);
        if (check(arr,x,notWin)==false){
            System.out.println("Game over");
            break; 
        }
        x++;
            }
             
         }
         else {
             System.out.println("Wrong input");
         }
               
         
     }
    

    
    public static void show(int[][] game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j==1||j==0){
                   System.out.print(avatar(game[i][j]));
	System.out.print("|"); 
        
            }
                else {
                    System.out.println(avatar(game[i][j]));
	System.out.println("-----");
                    }}
            
        }
	
    }
     public static char avatar(int b) {
	switch(b) {
	case (0):
	    return ' ';
	case (1):
	    return 'X';
	case (2):
	    return 'O';
	}
	return ' ';
    }
      public static int win(int[][] game) {
	
          for (int i = 0; i < 3; i++) {
              if((game[i][0] == game[i][1]) && (game[i][1] == game[i][2]))
	    return game[i][0];
          }
	         for (int i = 0; i < 3; i++) {
              if((game[0][i] == game[1][i]) && (game[1][i] == game[2][i]))
	    return game[0][i];
          }
            if((game[0][0] == game[1][1]) && (game[1][1] == game[2][2]))
	    return game[0][0];

	
	    if((game[0][2] == game[1][1]) && (game[1][1] == game[2][0]))
	    return game[0][2];

	// Check if the board is full
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game[i][j]==0)
                        return 0;
                }
          }
	return 3;
    }
       public static int computer_move(int[][] board) {
           
           
	int move = (int)(Math.random()*9);

	while(board[move/3][move%3] != 0) {
	    move = (int)(Math.random()*9);}
	return move;
    }
   
    
    //INPUT
    public static char[][] input(char[][]arr, int x){
        
         Scanner input = new Scanner (System.in);
          System.out.println("Enter row");
          int row= input.nextInt();
          
          System.out.println("Enter column");
          int col= input.nextInt();
          
         if((arr[row][col]== 'X') || (arr[row][col]== 'O')  ) {
             System.out.println("Already filled");
             x=x-1;
         }
         else{
         if(x%2==1)
         arr[row][col]= 'O';
         
         else
             arr[row][col]= 'X';
         }
            
        return arr;}
    
    public static boolean check(char[][] arr, int x, boolean notWin ){
             if(x>3){
                   //Rows Check
                 for(int i=0; i<3;i++){
                     
                     if((arr[i][0]== arr[i][1]) && (arr[i][1]==arr[i][2]) ){
                         System.out.println("Win Rows!");
                         notWin=false; 
                          
                     
                    }
                  }
                 
                 //Column Check
                 for(int i=0; i<3;i++){
                     
                     if((arr[0][i]== arr[1][i]) && (arr[1][i]==arr[2][i]) ){
                         System.out.println("Wins Column!");
                         notWin=false; 
                         
                     
                    }
                  }
             
                 //Left to right wali diagonal   
                 
                  if(((arr[0][0]==arr[1][1]) && (arr[1][1]==arr[2][2])) ) 
                  {
                      System.out.println("You win diagnolly");
                      notWin=false; 
                 }
                 
                 //dosri diaganol
                 
                  if(((arr[0][2]==arr[1][1]) && (arr[1][1]==arr[2][0])) ) 
                  {
                      System.out.println("You win diagnol dosri wali tongue emoticon");
                      notWin=false; 
                 }
             }
                    return notWin;}
             
            
    //PRINTING
    public static char[][] print(char[][] arr ){
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr.length;j++){
               if(j==0)System.out.print(" | ");
                System.out.print(arr[i][j]+ "  | ");
        }
        
            System.out.println();}
        
     return arr;   
   
}
}