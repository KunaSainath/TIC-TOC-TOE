import java.util.Scanner;
public class Tictoctoe
{
	public static void main(String args[])
	{
		BoardCreate bc = new BoardCreate();
		Player p = new Player();
		CheckWinner cw = new CheckWinner();
		bc.designBoard();
		System.out.println("Use numbers 1/2/3.");
		while(true)
		{
			p.firstChoice();
			bc.designBoard();
			if(cw.check() != "NO")
			{
				System.out.println(cw.check());
				System.exit(0);
			}
			p.secondChoice();
			bc.designBoard();
			if(cw.check() != "NO")
			{
				System.out.println(cw.check());
				System.exit(0);
			}
		}
	}	
}
class CheckWinner 
{
	int i;
	boolean a = true, b = true;
	String check()
	{
		BoardCreate bc = new BoardCreate();
		for(i=0; i<3; i++)
		{
			if((bc.gameBoard[i][0] == 88 && bc.gameBoard[i][1] == 88 && bc.gameBoard[i][2] == 88) || (bc.gameBoard[i][0] == 89 && bc.gameBoard[i][1] == 89 && bc.gameBoard[i][2] == 89))
			{
				if(bc.gameBoard[i][0] == 88)
				{
					return "WINNER IS FirstPlayer";
				}
				else
				{
					return "WINNER IS SecondPlayer";
				}
			}
		}
		
		for(i=0; i<3; i++)
		{
			if((bc.gameBoard[0][i] == 88 && bc.gameBoard[1][i] == 88 && bc.gameBoard[2][i] == 88) || (bc.gameBoard[0][i] == 89 && bc.gameBoard[1][i] == 89 && bc.gameBoard[2][i] == 89))
			{
				if(bc.gameBoard[0][i] == 88)
				{
					return "WINNER IS FirstPlayer";
				}
				else
				{
					return "WINNER IS SecondPlayer";
				}
			}
		}
		if((bc.gameBoard[0][0] == 89 && bc.gameBoard[1][1] == 89 && bc.gameBoard[2][2] == 89) || (bc.gameBoard[0][2] == 89 && bc.gameBoard[1][1] == 89 && bc.gameBoard[2][0] == 89))
		{
			return "WINNER IS SecondPlayer";
		}
		else if((bc.gameBoard[0][0] == 88 && bc.gameBoard[1][1] == 88 && bc.gameBoard[2][2] == 88) || (bc.gameBoard[0][2] == 88 && bc.gameBoard[1][1] == 88 && bc.gameBoard[2][0] == 88))
		{
			return "WINNER IS FirstPlayer";
		}
		return "NO";
	}
	
}

class BoardCreate 
{
    static int gameBoard[][] = new int[3][3];
	int i, j, k, l;
	void designBoard()
	{
		for(j=0; j<=3; j++)
		{
			System.out.println("|-----|-----|-----|");
			if(j<3)
			{
				if(j == 0)
				{
					for(int i : gameBoard[0])
					{
						if(i == 88 || i == 89)
						{
							System.out.print("|  " + (char) i + "  ");
						}
						else 
						{
							System.out.print("|  " + i + "  ");
						}
					}
					System.out.println("|");
				}
				else if(j == 1)
				{
					for(int i : gameBoard[1])
					{
						if(i == 88 || i == 89)
						{
							System.out.print("|  " + (char) i + "  ");
						}
						else 
						{
							System.out.print("|  " + i + "  ");
						}
					}
					System.out.println("|");
				}
				else if(j == 2)
				{
					for(int i : gameBoard[2])
					{
						if(i == 88 || i == 89)
						{
							System.out.print("|  " + (char) i + "  ");
						}
						else 
						{
							System.out.print("|  " + i + "  ");
						}
					}
					System.out.println("|");
				}
			}
		}
		int count = 0;
		for(k=0; k<3; k++)
		{
			for(l=0; l<3; l++)
			{
				if(gameBoard[k][l] != 0)
				{
					count++;
				}
			}
		}
		if(count == 9)
		{
			System.out.println("Match Drawn");
			System.exit(0);
		}
	}
}

class Player 
{
	int row1, col1, row2, col2;
	BoardCreate b = new BoardCreate();
	Scanner scan = new Scanner(System.in);
	public void firstChoice()
	{
		int i=0, j=0;
		System.out.println("First player's choice");
		System.out.print("Row and column numbers: ");
		row1 = scan.nextInt();
		col1 = scan.nextInt();
		while(true)
		{
			if(b.gameBoard[row1-1][col1-1] == 0)
			{
				b.gameBoard[row1-1][col1-1] = 88;
				break;
			}
			else
			{
				System.out.print("	Move already made. Select a new move :");
				row1 = scan.nextInt();
				col1 = scan.nextInt();
			}
		}
		
	}
	
	public void secondChoice()
	{
		int i=0, j=0;
		System.out.println("Second player's choice");
		System.out.print("Row and column numbers: ");
		row2 = scan.nextInt();
		col2 = scan.nextInt();
		
		while(true)
		{
			if(b.gameBoard[row2-1][col2-1] == 0)
			{
				b.gameBoard[row2-1][col2-1] = 89;
				break;
			}
			else
			{
				System.out.print("	Move already made. Select a new move: ");
				row2 = scan.nextInt();
				col2 = scan.nextInt();
			}
		}
	}
}
