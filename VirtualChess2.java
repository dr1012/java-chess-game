import java.util.Scanner;

public class VirtualChess2 {
	public enum Chessmen {
		WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY;
	}

	public static void main(String[] args) {

		Chessmen[][] chessboard = new Chessmen[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 1) {
					chessboard[1][j] = Chessmen.BLACK_PAWN;
				} else if (i == 6) {
					chessboard[6][j] = Chessmen.WHITE_PAWN;
				} else if (i > 1 && i < 6) {
					chessboard[i][j] = Chessmen.EMPTY;
				} else {

					chessboard[0][0] = Chessmen.BLACK_ROOK;
					chessboard[0][1] = Chessmen.BLACK_KNIGHT;
					chessboard[0][2] = Chessmen.BLACK_BISHOP;
					chessboard[0][3] = Chessmen.BLACK_QUEEN;
					chessboard[0][4] = Chessmen.BLACK_KING;
					chessboard[0][7] = Chessmen.BLACK_ROOK;
					chessboard[0][6] = Chessmen.BLACK_KNIGHT;
					chessboard[0][5] = Chessmen.BLACK_BISHOP;

					chessboard[7][0] = Chessmen.WHITE_ROOK;
					chessboard[7][1] = Chessmen.WHITE_KNIGHT;
					chessboard[7][2] = Chessmen.WHITE_BISHOP;
					chessboard[7][3] = Chessmen.WHITE_QUEEN;
					chessboard[7][4] = Chessmen.WHITE_KING;
					chessboard[7][7] = Chessmen.WHITE_ROOK;
					chessboard[7][6] = Chessmen.WHITE_KNIGHT;
					chessboard[7][5] = Chessmen.WHITE_BISHOP;
				}

			}

		}
		Object[] WhiteRook = { Chessmen.WHITE_ROOK, "\u2656", "wR" };
		Object[] WhiteKnight = { Chessmen.WHITE_KNIGHT, "\u2658", "wK" };
		Object[] WhiteBishop = { Chessmen.WHITE_BISHOP, "\u2657", "wB" };
		Object[] WhiteQueen = { Chessmen.WHITE_QUEEN, "\u2655", "wQ" };
		Object[] WhiteKing = { Chessmen.WHITE_KING, "\u2654", "wKK" };
		Object[] WhitePawn = { Chessmen.WHITE_PAWN, "\u2659", "wP" };
		Object[] BlackRook = { Chessmen.BLACK_ROOK, "\u265C", "bR" };
		Object[] BlackKnight = { Chessmen.BLACK_KNIGHT, "\u265E", "bK" };
		Object[] BlackBishop = { Chessmen.BLACK_BISHOP, "\u265D", "bB" };
		Object[] BlackQueen = { Chessmen.BLACK_QUEEN, "\u265B", "bQ" };
		Object[] BlackKing = { Chessmen.BLACK_KING, "\u265A", "bK" };
		Object[] BlackPawn = { Chessmen.BLACK_PAWN, "\u265F", "bP" };
		Object[] Empty = { Chessmen.EMPTY, " " };
		Object[][] print_array = { WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing, WhitePawn, BlackRook,
				BlackKnight, BlackBishop, BlackQueen, BlackKing, BlackPawn, Empty };

		String letters[] = { "a", "b", "c", "d", "e", "f", "g", "h" };
		String numbers[] = { "8", "7", "6", "5", "4", "3", "2", "1" };
		String reference[][] = new String[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				reference[i][j] = letters[j] + numbers[i]; // creates the reference chess array to match the user input
															// to the chess board
				// System.out.print(reference[i][j] + " ");
			}
			// System.out.println();
		}
		// System.out.println();

		System.out.println("   " + "a " + "b " + "c " + "d " + "e " + "f " + "g " + "h ");
		for (int i = 0; i < 8; i++) {
			System.out.print((8 - i) + "." + " ");
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 13; k++) {
					if (chessboard[i][j] == print_array[k][0]) {
						System.out.print(print_array[k][1] + " ");
					} else {
						continue;
					}
				}
			}

			System.out.println();
		}

		String answer = "default";
		int newx = 0;
		int newy = 0;
		int oldx = 0;
		int oldy = 0;
		
		while (!answer.equalsIgnoreCase("exit")) {
			System.out.println("Move from:");
			Scanner input = new Scanner(System.in);
			String case1 = input.nextLine();
			answer = case1;
			System.out.println("Move to:");
			Scanner input2 = new Scanner(System.in);
			String case2 = input2.nextLine();


			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (case1.equals(reference[i][j])) {

						oldx = i;
						oldy = j;
						//System.out.println(oldx);
						//System.out.println(oldy);
					}
					else {
						continue;
					}
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (case2.equals(reference[i][j])) {
						newx = i;
						newy = j;
					} else {
						continue;
					}

				}
			}

			boolean white_pawn = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_PAWN) {
				if (oldx == newx && newy == oldy + 1 && chessboard[newx][newy] == Chessmen.EMPTY) {
					white_pawn = Boolean.TRUE;
				} else if ((newx == oldx + 1 && newy == oldy + 1) || (newx == oldx - 1 && newy == oldy + 1)) {
					if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_pawn = Boolean.TRUE;
					} else {
						white_pawn = Boolean.FALSE;
					}
				} else {
					white_pawn = Boolean.FALSE;
				}
			} else {
				white_pawn = Boolean.FALSE;
			}

			boolean white_rook = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_ROOK) {
				if (newx == oldx || newx == oldx + 1 || newx == oldx + 2 || newx == oldx + 3 || newx == oldx + 4
						|| newx == oldx + 5 || newx == oldx + 6 || newx == oldx + 7) {
					if (newy == oldy || newy == oldy + 1 || newy == oldy + 2 || newy == oldy + 3 || newy == oldy + 4
							|| newy == oldy + 5 || newy == oldy + 6 || newy == oldy + 7) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_rook = Boolean.TRUE;
						} else {
							white_rook = Boolean.FALSE;
						}
					} else {
						white_rook = Boolean.FALSE;
					}
				} else {
					white_rook = Boolean.FALSE;
				}
			} else {
				white_rook = Boolean.FALSE;
			}

			boolean white_knight = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KNIGHT) {
				if (newx == oldx + 3 || newx == oldx - 3) {
					if (newy == oldy + 2 || newy == oldy - 2) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_knight = Boolean.TRUE;
						} else {
							white_knight = Boolean.FALSE;
						}
					} else {
						white_knight = Boolean.FALSE;
					}
				} else if (newx == oldx + 2 || newx == oldx - 2) {
					if (newy == oldy + 3 || newy == oldy - 3) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_knight = Boolean.TRUE;
						} else {
							white_knight = Boolean.FALSE;
						}
					} else {
						white_knight = Boolean.FALSE;
					}
				}
			} else {
				white_knight = Boolean.FALSE;
			}

			boolean white_bishop = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KNIGHT) {
				if (((newx == oldx - 1 || newx == oldx + 1) && (newy == oldy - 1 || newy == oldy + 1))
						|| ((newx == oldx - 2 || newx == oldx + 2) && (newy == oldy - 2 || newy == oldy + 2))
						|| ((newx == oldx - 3 || newx == oldx + 3) && (newy == oldy - 3 || newy == oldy + 3))
						|| ((newx == oldx - 4 || newx == oldx + 4) && (newy == oldy - 4 || newy == oldy + 4))
						|| ((newx == oldx - 5 || newx == oldx + 5) && (newy == oldy - 5 || newy == oldy + 5))
						|| ((newx == oldx - 6 || newx == oldx + 6) && (newy == oldy - 6 || newy == oldy + 6))
						|| ((newx == oldx - 7 || newx == oldx + 7) && (newy == oldy - 7 || newy == oldy + 7))) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_bishop = Boolean.TRUE;
					} else {
						white_bishop = Boolean.FALSE;
					}
				} else {
					white_bishop = Boolean.FALSE;
				}
			} else {
				white_bishop = Boolean.FALSE;
			}

			boolean white_queen = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_QUEEN) {
				if (((newx == oldx - 1 || newx == oldx + 1) && (newy == oldy - 1 || newy == oldy + 1))
						|| ((newx == oldx - 2 || newx == oldx + 2) && (newy == oldy - 2 || newy == oldy + 2))
						|| ((newx == oldx - 3 || newx == oldx + 3) && (newy == oldy - 3 || newy == oldy + 3))
						|| ((newx == oldx - 4 || newx == oldx + 4) && (newy == oldy - 4 || newy == oldy + 4))
						|| ((newx == oldx - 5 || newx == oldx + 5) && (newy == oldy - 5 || newy == oldy + 5))
						|| ((newx == oldx - 6 || newx == oldx + 6) && (newy == oldy - 6 || newy == oldy + 6))
						|| ((newx == oldx - 7 || newx == oldx + 7) && (newy == oldy - 7 || newy == oldy + 7))) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_queen = Boolean.TRUE;
					} else {
						white_queen = Boolean.TRUE;
					}
				} else if (newx == oldx || newx == oldx + 1 || newx == oldx + 2 || newx == oldx + 3 || newx == oldx + 4
						|| newx == oldx + 5 || newx == oldx + 6 || newx == oldx + 7) {
					if (newy == oldy || newy == oldy + 1 || newy == oldy + 2 || newy == oldy + 3 || newy == oldy + 4
							|| newy == oldy + 5 || newy == oldy + 6 || newy == oldy + 7) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
							white_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
							white_queen = Boolean.TRUE;
						} else {
							white_queen = Boolean.FALSE;
						}
					} else {
						white_queen = Boolean.TRUE;
					}
				} else {
					white_queen = Boolean.TRUE;
				}
			} else {
				white_queen = Boolean.TRUE;
			}

			boolean white_king = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KING) {
				if ((newx == oldx && newy == oldy + 1) || (newx == oldx && newy == oldy - 1)
						|| (newy == oldy && newx == oldx + 1) || (newy == oldy && newx == oldx - 1)
						|| (newy == oldy + 1 && newx == oldx + 1) || (newy == oldy + 1 && newx == oldx - 1)
						|| (newy == oldy - 1 && newx == oldx + 1) || (newy == oldy - 1 && newx == oldx - 1)) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_ROOK) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KNIGHT) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_PAWN) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_QUEEN) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_KING) {
						white_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.BLACK_BISHOP) {
						white_king = Boolean.TRUE;
					} else {
						white_king = Boolean.FALSE;
					}

				}
			} else {
				white_king = Boolean.FALSE;
			}

			///////////////////////////////////////////////////////////////////

			boolean black_pawn = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_PAWN) {
				if (oldx == newx && newy == oldy + 1 && chessboard[newx][newy] == Chessmen.EMPTY) {
					black_pawn = Boolean.TRUE;
				} else if ((newx == oldx + 1 && newy == oldy + 1) || (newx == oldx - 1 && newy == oldy + 1)) {
					if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_pawn = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_pawn = Boolean.TRUE;
					} else {
						black_pawn = Boolean.FALSE;
					}
				} else {
					black_pawn = Boolean.FALSE;
				}
			} else {
				black_pawn = Boolean.FALSE;
			}

			boolean black_rook = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_ROOK) {
				if (newx == oldx || newx == oldx + 1 || newx == oldx + 2 || newx == oldx + 3 || newx == oldx + 4
						|| newx == oldx + 5 || newx == oldx + 6 || newx == oldx + 7) {
					if (newy == oldy || newy == oldy + 1 || newy == oldy + 2 || newy == oldy + 3 || newy == oldy + 4
							|| newy == oldy + 5 || newy == oldy + 6 || newy == oldy + 7) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_rook = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_rook = Boolean.TRUE;
						} else {
							black_rook = Boolean.FALSE;
						}
					} else {
						black_rook = Boolean.FALSE;
					}
				} else {
					black_rook = Boolean.FALSE;
				}
			} else {
				black_rook = Boolean.FALSE;
			}

			boolean black_knight = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KNIGHT) {
				if (newx == oldx + 3 || newx == oldx - 3) {
					if (newy == oldy + 2 || newy == oldy - 2) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_knight = Boolean.TRUE;
						} else {
							black_knight = Boolean.FALSE;
						}
					} else {
						black_knight = Boolean.FALSE;
					}
				} else if (newx == oldx + 2 || newx == oldx - 2) {
					if (newy == oldy + 3 || newy == oldy - 3) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_knight = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_knight = Boolean.TRUE;
						} else {
							black_knight = Boolean.FALSE;
						}
					} else {
						black_knight = Boolean.FALSE;
					}
				}
			} else {
				black_knight = Boolean.FALSE;
			}

			boolean black_bishop = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KNIGHT) {
				if (((newx == oldx - 1 || newx == oldx + 1) && (newy == oldy - 1 || newy == oldy + 1))
						|| ((newx == oldx - 2 || newx == oldx + 2) && (newy == oldy - 2 || newy == oldy + 2))
						|| ((newx == oldx - 3 || newx == oldx + 3) && (newy == oldy - 3 || newy == oldy + 3))
						|| ((newx == oldx - 4 || newx == oldx + 4) && (newy == oldy - 4 || newy == oldy + 4))
						|| ((newx == oldx - 5 || newx == oldx + 5) && (newy == oldy - 5 || newy == oldy + 5))
						|| ((newx == oldx - 6 || newx == oldx + 6) && (newy == oldy - 6 || newy == oldy + 6))
						|| ((newx == oldx - 7 || newx == oldx + 7) && (newy == oldy - 7 || newy == oldy + 7))) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_bishop = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_bishop = Boolean.TRUE;
					} else {
						black_bishop = Boolean.FALSE;
					}
				} else {
					black_bishop = Boolean.FALSE;
				}
			}

			boolean black_queen = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_QUEEN) {
				if (((newx == oldx - 1 || newx == oldx + 1) && (newy == oldy - 1 || newy == oldy + 1))
						|| ((newx == oldx - 2 || newx == oldx + 2) && (newy == oldy - 2 || newy == oldy + 2))
						|| ((newx == oldx - 3 || newx == oldx + 3) && (newy == oldy - 3 || newy == oldy + 3))
						|| ((newx == oldx - 4 || newx == oldx + 4) && (newy == oldy - 4 || newy == oldy + 4))
						|| ((newx == oldx - 5 || newx == oldx + 5) && (newy == oldy - 5 || newy == oldy + 5))
						|| ((newx == oldx - 6 || newx == oldx + 6) && (newy == oldy - 6 || newy == oldy + 6))
						|| ((newx == oldx - 7 || newx == oldx + 7) && (newy == oldy - 7 || newy == oldy + 7))) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_queen = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_queen = Boolean.TRUE;
					} else {
						black_queen = Boolean.TRUE;
					}
				} else if (newx == oldx || newx == oldx + 1 || newx == oldx + 2 || newx == oldx + 3 || newx == oldx + 4
						|| newx == oldx + 5 || newx == oldx + 6 || newx == oldx + 7) {
					if (newy == oldy || newy == oldy + 1 || newy == oldy + 2 || newy == oldy + 3 || newy == oldy + 4
							|| newy == oldy + 5 || newy == oldy + 6 || newy == oldy + 7) {
						if (chessboard[newx][newy] == Chessmen.EMPTY) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
							black_queen = Boolean.TRUE;
						} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
							black_queen = Boolean.TRUE;
						} else {
							black_queen = Boolean.FALSE;
						}
					} else {
						black_queen = Boolean.TRUE;
					}
				} else {
					black_queen = Boolean.TRUE;
				}
			} else {
				black_queen = Boolean.TRUE;
			}

			boolean black_king = Boolean.FALSE;
			if (chessboard[oldx][oldy] == Chessmen.WHITE_KING) {
				if ((newx == oldx && newy == oldy + 1) || (newx == oldx && newy == oldy - 1)
						|| (newy == oldy && newx == oldx + 1) || (newy == oldy && newx == oldx - 1)
						|| (newy == oldy + 1 && newx == oldx + 1) || (newy == oldy + 1 && newx == oldx - 1)
						|| (newy == oldy - 1 && newx == oldx + 1) || (newy == oldy - 1 && newx == oldx - 1)) {
					if (chessboard[newx][newy] == Chessmen.EMPTY) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_ROOK) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KNIGHT) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_PAWN) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_QUEEN) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_KING) {
						black_king = Boolean.TRUE;
					} else if (chessboard[newx][newy] == Chessmen.WHITE_BISHOP) {
						black_king = Boolean.TRUE;
					} else {
						black_king = Boolean.FALSE;
					}

				}
			} else {
				black_king = Boolean.FALSE;
			}

			if (white_pawn == Boolean.TRUE || white_rook == Boolean.TRUE || white_knight == Boolean.TRUE
					|| white_bishop == Boolean.TRUE || white_queen == Boolean.TRUE || white_king == Boolean.TRUE
					|| black_pawn == Boolean.TRUE || black_rook == Boolean.TRUE || black_knight == Boolean.TRUE
					|| black_bishop == Boolean.TRUE || black_queen == Boolean.TRUE || black_king == Boolean.TRUE) {
				chessboard[newx][newy] = chessboard[oldx][oldy];
				chessboard[oldx][oldy] = Chessmen.EMPTY;
			} else {
				System.out.println("Incorrect move");
			}
			System.out.println("   " + "a " + "b " + "c " + "d " + "e " + "f " + "g " + "h ");
			for (int i = 0; i < 8; i++) {
				System.out.print((8 - i) + "." + " ");
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 13; k++) {
						if (chessboard[i][j] == print_array[k][0]) {
							System.out.print(print_array[k][1] + " ");
						} else {
							continue;
						}
					}
				}

				System.out.println();
			}

		}
		System.out.println("Goodbye");

	}

}
