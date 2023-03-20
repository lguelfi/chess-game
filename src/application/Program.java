package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while (!chessMatch.getCheckMate() || !chessMatch.getStaleMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, capturedPieces);
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Alvo: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);   
                if (capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                } 

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Informe a peca para promocao (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("Q") && !type.equals("R")) {
                        System.out.print("Letra invalida, a letra deve ser (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();    
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            } 
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, capturedPieces);
        
    }
}