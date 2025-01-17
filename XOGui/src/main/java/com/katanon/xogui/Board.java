/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.katanon.xogui;

/**
 *
 * @author nonku
 */
public class Board {

    private char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    private Player p1;
    private Player p2;
    private Player currentPlayer;

    public Board(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        currentPlayer = p1;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean setRowCol(int row, int col) {
        if (board[row][col] != '-') {
            return false;
        }
        board[row][col] = currentPlayer.getSymbol();
        return true;
    }

    public void switchTurn() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else if (currentPlayer == p2) {
            currentPlayer = p1;
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWinner() {
        // check row
        if ((board[0][0] == currentPlayer.getSymbol() && board[0][1] == currentPlayer.getSymbol() && board[0][2] == currentPlayer.getSymbol())
                || (board[1][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[1][2] == currentPlayer.getSymbol())
                || (board[2][0] == currentPlayer.getSymbol() && board[2][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol())) {
            return true;
        } // check col
        else if ((board[0][0] == currentPlayer.getSymbol() && board[1][0] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol())
                || (board[0][1] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][1] == currentPlayer.getSymbol())
                || (board[0][2] == currentPlayer.getSymbol() && board[1][2] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol())) {
            return true;
        } // check X
        else if (board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol()
                || board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol()) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean results() {
        if (checkWinner()) {
            printBoard();
            System.out.println(currentPlayer);
            return true;
        } else if (isBoardFull()) {
            printBoard();
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }

    public void updateStat() {
        if (checkWinner()) {
            if (currentPlayer == p1) {
                p1.incWinCount();
                p2.incLoseCount();
            } else if (currentPlayer == p2) {
                p2.incWinCount();
                p1.incLoseCount();
            } else {
                
            }
        }
        if (isBoardFull()) {
            p2.incDrawCount();
            p1.incDrawCount();
        }
    }

    @Override
    public String toString() {
        return "Board{" + "board=" + board + ", p1=" + p1 + ", p2=" + p2 + '}';
    }
}
