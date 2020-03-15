import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {
	int EMPTY_UNCLICKED_CELL=0;
	int EMPTY_CLICKED_CELL=10;
	int UNCLICKED_MINE_CELL=-1;
	int CLICKED_MINE_CELL=-10;
	int CLICK = 10;
	int[] board;
	int rows=16;
	int cols=16;
	int totalCells=rows*cols;
	int mines=40;
	int minesLeft=mines;
	private JLabel cell;
	Random rand;
	
	public int getsize() {return cols;}
	
	public Board() {
		rand = new Random();
		initializeBoard();
	}
	
	public int[] getBoard() {
		return board;
	}
	
	public void initializeBoard() {
		board = new int[totalCells];
		int curr;
		int currMines=0;
		for (int cell:board) {
			cell=EMPTY_UNCLICKED_CELL;
		}
		while(currMines<mines) {
			int rand_int = rand.nextInt(totalCells);
			if(board[rand_int]!=UNCLICKED_MINE_CELL) {
				board[rand_int]=UNCLICKED_MINE_CELL;
				currMines++;
				int col= rand_int % cols;
				if(col>0) {
					//top left
					curr = rand_int-cols-1;
                    if (curr >= 0) {
                        if (board[curr] != UNCLICKED_MINE_CELL) {
                            board[curr] += 1;
                        }
                    }
                    //left
                    curr = rand_int-1;
                    if (curr >= 0) {
                        if (board[curr] != UNCLICKED_MINE_CELL) {
                            board[curr] += 1;
                        }
                    }
                    //bottom left
                    if(col<cols-1) {
                    	curr = rand_int+cols-1;
                        if (curr <totalCells) {
                            if (board[curr] != UNCLICKED_MINE_CELL) {
                                board[curr] += 1;
                            }
                        }
                    }
				}
                //above
                curr = rand_int-cols;
                if (curr >= 0) {
                    if (board[curr] != UNCLICKED_MINE_CELL) {
                        board[curr] += 1;
                    }
                }
                //below
                curr = rand_int+cols;
                if (curr <totalCells) {
                    if (board[curr] != UNCLICKED_MINE_CELL) {
                        board[curr] += 1;
                    }
                }
                //top right
                if (rand_int < (cols - 1)) {
                	curr = rand_int+1-cols;
                    if (curr >= 0) {
                        if (board[curr] != UNCLICKED_MINE_CELL) {
                            board[curr] += 1;
                        }
                    }
                    //right
                    curr = rand_int+1;
                    if (curr <totalCells) {
                        if (board[curr] != UNCLICKED_MINE_CELL) {
                            board[curr] += 1;
                        }
                    }
                    //bottom right
                    curr = rand_int+1+cols;
                    if (curr <totalCells) {
                        if (board[curr] != UNCLICKED_MINE_CELL) {
                            board[curr] += 1;
                        }
                    }
                    
				}
			}
		}
	}
	
	public void uncoverFreeCells(int coord) {
		int curr;
		int col= coord % cols;
		curr = coord - cols - 1;
		if (col > 0) {
	        if (curr >= 0) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	
	        curr = coord - 1;
	        if (curr >= 0) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	
	        curr = coord + cols - 1;
	        if (curr < totalCells) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	    }
	
	    curr = coord - cols;
	    if (curr >= 0) {
	        if (board[curr] > UNCLICKED_MINE_CELL) {
	            board[curr] += CLICK;
	            if (board[curr] == EMPTY_CLICKED_CELL) {
	                uncoverFreeCells(curr);
	            }
	        }
	    }
	
	    curr = coord + cols;
	    if (curr < totalCells) {
	        if (board[curr] > UNCLICKED_MINE_CELL) {
	            board[curr] += CLICK;
	            if (board[curr] == EMPTY_CLICKED_CELL) {
	                uncoverFreeCells(curr);
	            }
	        }
	    }
	
	    if (col < (cols - 1)) {
	        curr = coord - cols + 1;
	        if (curr >= 0) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	
	        curr = coord + cols + 1;
	        if (curr < totalCells) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	
	        curr = coord + 1;
	        if (curr < totalCells) {
	            if (board[curr] > UNCLICKED_MINE_CELL) {
	                board[curr] += CLICK;
	                if (board[curr] == EMPTY_CLICKED_CELL) {
	                    uncoverFreeCells(curr);
	                }
	            }
	        }
	    }
	}
	
	public void click(int coord) {
		if(board[coord]==UNCLICKED_MINE_CELL) {
			
			for(int i=0;i<rows*cols;i++) {
				if(board[i]<10&&board[i]>=0)
					board[i]+=CLICK;
				else if(board[i]<0)
					board[i]-=CLICK;
			}
			//GAME OVER
		}
		else if(board[coord]>=0&&board[coord]<10) {
			board[coord]+=CLICK;
			/*
			board[coord]+=CLICK;
			if(board[coord]==EMPTY_CLICKED_CELL) {
				uncoverFreeCells(coord);
			}*/
		}
	}
	/*@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		visualizeComponents();
	}*/
	
	public void visualizeComponents(){
		System.out.print(" ");
		printBoard();
		this.removeAll();
		this.revalidate();
		this.repaint();
		setLayout(new GridLayout(rows, cols));
		JButton curr= new JButton();
		for(int i=0;i<totalCells;i++) {
			int coord=i;
			if(board[i]<10&&board[i]>-2) {
				ImageIcon ic = new ImageIcon("./Images/unclicked.png");
				curr = new JButton(ic);
				curr.addActionListener(new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
						    fieldClick(coord,e);
						  } 
						} );
			}
			else if(board[i]==10) {
				ImageIcon ic = new ImageIcon("./Images/blank.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==11) {
				
				ImageIcon ic = new ImageIcon("./Images/1.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==12) {
				ImageIcon ic = new ImageIcon("./Images/2.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==13) {
				ImageIcon ic = new ImageIcon("./Images/3.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==14) {
				ImageIcon ic = new ImageIcon("./Images/4.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==15) {
				ImageIcon ic = new ImageIcon("./Images/5.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==16) {
				ImageIcon ic = new ImageIcon("./Images/6.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==17) {
				ImageIcon ic = new ImageIcon("./Images/7.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==18) {
				ImageIcon ic = new ImageIcon("./Images/8.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			else if(board[i]==-11) {
				ImageIcon ic = new ImageIcon("./Images/bomb.png");
				curr = new JButton(ic);
				curr.setEnabled(false);
			}
			add(curr);
			/*gc.gridx = gc.gridx + 1;
			cell = new JLabel(String.valueOf(board[i]));
			//add(cell, gc);
			add(curr,gc);
			if((i+1)%cols==0) {
				gc.gridx = 0;
				gc.gridy = gc.gridy + 1;
			}*/
		}
	}
	
	public void fieldClick(int i, ActionEvent e) {
		
		click(i);
		visualizeComponents();
		//repaint();
	}

	public void printBoard() {
		for(int i=0;i<totalCells;i++) {
			System.out.print(board[i]+" ");
			if((i+1)%cols==0) {
				System.out.print("\n");
			}
		}
	}
}

/*class MyActionListener implements ActionListener
{
	public void actionPerformed (ActionEvent e)
	{
	}
}*/
