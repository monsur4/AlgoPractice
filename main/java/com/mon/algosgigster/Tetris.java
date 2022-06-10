package com.mon.algosgigster;

import java.util.*;
import java.util.stream.IntStream;

/*
* Tetris Move
Have the function TetrisMove(strArr) take strArr parameter being passed which will be an array containing one letter followed by 12 numbers representing a Tetris piece followed by the fill levels for the 12 columns of the board. Calculate the greatest number of horizontal lines that can be completed when the piece arrives at the bottom assuming it is dropped immediately after being rotated and moved horizontally from the top. Tricky combinations of vertical and horizontal movements are excluded. The piece types are represented by capital letters.



For example, with an input of ["L","3","4","4","5","6","2","0","6","5","3","6","6"], the board will look something like this:



Your result should be 3 because the L piece can be rotated and dropped in column 6-7 which will complete 3 full rows of blocks.
Examples
Input: new String[] {"I", "2", "4", "3", "4", "5", "2", "0", "2", "2", "3", "3", "3"}
Output: 2
Input: new String[] {"O", "4", "3", "2", "3", "5", "1", "0", "1", "2", "4", "3", "4"}
Output: 0
* */

public class Tetris {

    private static final int GAME_WIDTH = 12;
    private static final int GAME_HEIGHT = 10;

    public static int solve(String[] strArr){
        // create a map of the pieces
        int[][] I = new int[][]{{1, 1, 1, 1}};
        int[][] J = new int[][]{{1, 1, 1}, {0, 0, 1}};
        int[][] L = new int[][]{{1, 1, 1}, {1, 0, 0}};
        int[][] O = new int[][]{{1, 1}, {1, 1}};
        int[][] S = new int[][]{{0, 1, 1}, {1, 1, 0}};
        int[][] T = new int[][]{{1, 1, 1}, {0, 1, 0}};
        int[][] Z = new int[][]{{1, 1, 0}, {0, 1, 1}};

        Map<String, int[][]> pieces = new HashMap<>();
        pieces.put("I", I);
        pieces.put("J", J);
        pieces.put("L", L);
        pieces.put("O", O);
        pieces.put("S", S);
        pieces.put("T", T);
        pieces.put("Z", Z);

        // fill board to given game state
        int[][] board = new int[GAME_HEIGHT][GAME_WIDTH]; // empty board initialized with zeros

        int arrLength = strArr.length;
        IntStream.range(1, arrLength).forEach(i -> {
            int fillLevel = Integer.parseInt(strArr[i]);
                for(int r = 0; r < fillLevel; r++){
                    board[GAME_HEIGHT - r - 1][i-1] = 1;
                }
        });

        // current piece
        String pieceKey = strArr[0];
        int[][] piece = pieces.get(pieceKey);

        // add all rotations of the piece to a piecesToTry List
        List<int[][]> piecesToTry = new ArrayList<>();
        piecesToTry.add(piece);

        piece = rotateCCW(piece);
        piecesToTry.add(piece);
        piece = rotateCCW(piece);
        piecesToTry.add(piece);
        piece = rotateCCW(piece);
        piecesToTry.add(piece);

        // try each rotated piece and update the maximum score
        int maxScore = 0;
        for(int[][] p: piecesToTry) {
            int pieceHeight = p.length;
            int pieceWidth = p[0].length;

            // evaluate piece on every game possibilty
            for (int row = 0, maxRow = GAME_HEIGHT - pieceHeight; row <= maxRow; row++) {
                for (int col = 0, maxCol = GAME_WIDTH - pieceWidth; col <= maxCol; col++) {
                    if (isValidState(board, p, row, col) && isValidBottomState(board, p, row, col)) {
                        int score = calculateScore(board, p, row, col);
                        if (score > maxScore) {
                            maxScore = score;
                        }
                    }
                }
            }
        }

        // return the maximum score
        return maxScore;
    }

    private static int[][] rotateCCW(int[][] piece){
        int pieceHeight = piece.length;
        int pieceWidth = piece[0].length;

        // initialize an empty piece
        int[][] newPiece = new int[pieceWidth][pieceHeight];
        for(int r = 0; r < pieceHeight; r++){
            for(int c = 0; c < pieceWidth; c++){
                newPiece[c][pieceHeight - 1 - r] = piece[r][c];
            }
        }
        return  newPiece;
    }

    private static boolean isValidState(int[][] board, int[][] piece, int row, int col){
        for (int r =0; r<piece.length; r++){
            for (int c=0; c<piece[0].length; c++){
                if(board[row+r][col+c] == 1 && piece[r][c] == 1){
                //if(board[row-r][col+c] == 1 && piece[r][c] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidBottomState(int[][] board, int[][] piece, int row, int col){
        for(int c = 0, max = piece[0].length; c < max; c++){
            for(int r = piece.length-1; r >= 0; r--){
            //for(int r = 0; r < piece.length; r++){
                if(piece[r][c] == 1){
                    // Check if we are the bottom of the board or the piece rests on a solid block
                    // should probably be row + r + 1 == board.length, but to do defensive programming >= is used
                    if(row + r + 1 >= board.length || board[row + r + 1][col + c] == 1){
                    //if(row - + 1 >= board.length || board[row + r + 1][col + c] == 1){
                        return true;
                    }
                    // otherwise, this is the lowest row in this column, and it doesn't rest on a solid block,
                    // break from checking higher rows in this column and continue searching in the other columns
                    break;
                }
            }
        }
        // if there is no row of all the columns that satisfies the condition, then return false
        return false;
    }

    private static int calculateScore(int[][] board, int[][] piece, int row, int col){
        // make a copy of the board
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int r = 0; r< board.length; r++){
            boardCopy[r] = board[r].clone();
        }

        // insert piece into the board
        for (int r = 0; r< piece.length; r++){
            for (int c = 0; c< piece[0].length; c++){
                if(piece[r][c] == 1) {
                    boardCopy[row + r][col + c] = 1;
                }
            }
        }

        int score = (int)Arrays.stream(boardCopy).filter(elRow -> Arrays.stream(elRow).allMatch(x -> x == 1)).count();
        //System.out.println("Score is: " + score);
        return score;
    }
    public static void main(String[] args) {
        int[][] initial = new int[][]{{1, 2}, {4, 5}, {7, 8}};
        /* [
          [7, 8]
          [4, 5]
          [1, 2]
         ]
         which is 3 x 2 ==> height(rows) = 3; width(columns) = 2

         after ccw rotation
         [8, 5, 2]
         [7, 4, 1]
         r x c == 2 x 3*/
        int[][] sol = rotateCCW(initial);
        // printing from up to down
        /*for (int r = initial.length-1; r >=0; r--){
            StringBuilder sb = new StringBuilder("|");
            for(int c = 0; c<initial[0].length; c++){
                sb.append(initial[r][c]).append("|");
            }
            System.out.println(sb);
            System.out.println("-------");
        }

        System.out.println("transformed");
        for (int r = sol.length-1; r >=0; r--){
            StringBuilder sb = new StringBuilder("|");
            for(int c = 0; c<sol[0].length; c++){
                sb.append(sol[r][c]).append("|");
            }
            System.out.println(sb);
            System.out.println("-------");
        }*/

//        int[][] boardCopy = new int[][]{{1, 1, 1}, {1, 0, 1}, {0, 0, 0}, {1, 1, 0}, {1, 1, 1}, {1, 1, 1}};
//        int score = (int)Arrays.stream(boardCopy).filter(elRow -> Arrays.stream(elRow).allMatch(x -> x == 1)).count();
//
//        System.out.println(score);

        int ans = solve(new String[]{"L","3","4","4","5","6","2","0","6","5","3","6","6"});
        int ans2 = solve(new String[]{"I",
                "5",
                "5", "5",
                "5",
                "5",
                "5",
                "0",
                "7",
                "6",
                "7",
                "6",
                "7"});
        System.out.println(ans);
        System.out.println(ans2);
    }
}
