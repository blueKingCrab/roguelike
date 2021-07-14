package src.rooms;

import src.cells.Cell;
import src.generate.room.RoomGenerator;

public class Room {

   private final int LENGTH = 8;
   private final int WIDTH = 8;

   Cell[][] cells;
   
   private int map_x;
   private int map_y;
   
   private boolean empty;
   
   RoomGenerator generateRoom = new RoomGenerator();


   public Room(int x, int y) {
   
      this.map_x = x;
      this.map_y = y;
   
      cells = new Cell[LENGTH][WIDTH];
      this.empty = true;
      
      generateRoom.fillEmptyRoom(this.cells);

   }
   
   public Room(int x, int y, boolean f) {
   
      this.map_x = x;
      this.map_y = y;
   
      cells = new Cell[LENGTH][WIDTH];
      
      
      if(!f) {
         generateRoom.fillRoom(this.cells);
      } else {
         generateRoom.fillEmptyRoom(this.cells);
      }
      this.empty = f;

   }
   
   public void startRoom() {
      generateRoom.startRoom(cells);
      this.empty = false;
   }
   
   public boolean isEmpty() {
      return this.empty;
   }
   
   public Cell[][] getCells() {
      return this.cells;
   }
   
   public void setCells(Cell[][] newCells) {
      this.cells = newCells;
   }
      
   public String toString() {
      
      String output = "";
      for(int i = 0; i < 8; i++) {
         for(int j = 0; j < 8; j++) {
            output += cells[i][j].toString();
         }
         output += System.lineSeparator();
      }
      return output;
   }
   
   public String toString(int row) {
      
      String output = "";
      for(int i = 0; i < 8; i++) {
         output += cells[row][i].toString();
      }
      return output;
   }

}