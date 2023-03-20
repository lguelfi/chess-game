package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // NORTHWEST
        p.setValues(position.getRow() - 1, position.getCollumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
            p.setValues(p.getRow() - 1, p.getCollumn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

         // NORTHEAST
         p.setValues(position.getRow() - 1, position.getCollumn() + 1);
         while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
             mat[p.getRow()][p.getCollumn()] = true;
             p.setValues(p.getRow() - 1, p.getCollumn() + 1);
         }
         if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
             mat[p.getRow()][p.getCollumn()] = true;
         }

          // SOUTHEAST
          p.setValues(position.getRow() + 1, position.getCollumn() + 1);
          while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
              mat[p.getRow()][p.getCollumn()] = true;
              p.setValues(p.getRow() + 1, p.getCollumn() + 1);
          }
          if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
              mat[p.getRow()][p.getCollumn()] = true;
          }

        // SOUTHWEST
        p.setValues(position.getRow() + 1, position.getCollumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
            p.setValues(p.getRow() + 1, p.getCollumn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        return mat;
    }
    
    @Override
    public String toString() {
        return "B";
    }
}
