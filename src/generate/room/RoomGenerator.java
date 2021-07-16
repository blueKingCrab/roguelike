package src.generate.room;

import src.cells.Cell;

public class RoomGenerator {

   private final int LENGTH = 8;
   private final int WIDTH = 8;

   public RoomGenerator() {}
   
   public void startRoom(Cell[][] cells) {
   
      String[][] tempRoom = {
         {"#","#","#"," "," ","#","#","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#"," "," "," "," "," "," ","#"},
         {" "," "," "," ","@"," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {"#"," "," "," "," "," "," ","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#","#","#"," "," ","#","#","#"}
      };
      
      this.setCells(cells, tempRoom);
   }
   
   public void fillRoom(Cell[][] cells) {
   
      String[][] tempRoom;
   
      String[][] tempRoom1 = {
         {"#","#","#"," "," ","#","#","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#"," ","#"," "," ","#"," ","#"},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {"#"," ","#"," "," ","#"," ","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#","#","#"," "," ","#","#","#"}
      };
      
      String[][] tempRoom2 = {
         {"#","#","#"," "," ","#","#","#"},
         {"#"," ","#"," "," "," "," ","#"},
         {"#"," ","#","#"," ","#"," ","#"},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {"#"," ","#"," "," ","#"," ","#"},
         {"#"," "," "," "," ","#"," ","#"},
         {"#","#","#"," "," ","#","#","#"}
      };
      
      String[][] tempRoom3 = {
         {"#","#","#"," "," ","#","#","#"},
         {"#"," "," "," "," "," ","#","#"},
         {"#"," ","#","#"," ","#","#","#"},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {"#"," ","#"," "," ","#"," ","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#","#","#"," "," ","#","#","#"}
      };
      
      String[][] tempRoom4 = {
         {"#","#","#"," "," ","#","#","#"},
         {"#"," "," "," "," "," "," ","#"},
         {"#"," ","#"," "," ","#"," ","#"},
         {" "," "," "," "," "," "," "," "},
         {" "," "," ","#"," "," "," "," "},
         {"#","#","#"," "," ","#"," ","#"},
         {"#","#","#"," "," "," "," ","#"},
         {"#","#","#"," "," ","#","#","#"}
      };
      
      Object[] tempRooms = {tempRoom1, tempRoom2, tempRoom3, tempRoom4};
      
      int rand = (int)Math.floor(Math.random()*(4));
      
      tempRoom = (String[][])tempRooms[rand];
      
      this.setCells(cells, tempRoom);
      
   }
   
   public void fillEmptyRoom(Cell[][] cells) {
   
      String[][] tempRoom = {
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "},
         {" "," "," "," "," "," "," "," "}
      };
      
      this.setCells(cells, tempRoom);
      
   }
   
   private void setCells(Cell[][] cells, String[][] tempRoom) {
      for(int i = 0; i < LENGTH; i++) {
         for(int j = 0; j < WIDTH; j++) {
            cells[i][j] = new Cell(i, j, tempRoom[i][j]);
         }
      }
   }
   
   public Cell[][] fillWalls(Cell[][] cells, boolean n, boolean e, boolean s, boolean w) {
      if(n) {
         cells[0][3].pop();
         cells[0][4].pop();
         cells[0][3].push("#");
         cells[0][4].push("#");
      }
      
      if(e) {
         cells[3][7].pop();
         cells[4][7].pop();
         cells[3][7].push("#");
         cells[4][7].push("#");
      }
      
      if(s) {
         cells[7][3].pop();
         cells[7][4].pop();
         cells[7][3].push("#");
         cells[7][4].push("#");
      }
      
      if(w) {
         cells[3][0].pop();
         cells[4][0].pop();
         cells[3][0].push("#");
         cells[4][0].push("#");
      }
      return cells;
   }
}