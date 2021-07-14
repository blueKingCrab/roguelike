package src.cells;

import src.structures.floor.Floor;

public class Cell {

   private int MAX_CONTENTS = 4;
   private int currentContentCount;

   private int map_x;
   private int map_y;

   private int room_x;
   private int room_y;
   
   private boolean occupied;
   
   private Object[] contents;
   
   public Cell (int rx, int ry) {
      this.setRoomX(rx);
      this.setRoomY(ry);
      this.setOccupied(false);
      this.contents = new Object[MAX_CONTENTS];
      this.currentContentCount = 0;
   }

   public Cell (int rx, int ry, Object o) {
      this.setRoomX(rx);
      this.setRoomY(ry);
      this.setOccupied(false);
      this.contents = new Object[MAX_CONTENTS];
      this.currentContentCount = 0;
      boolean added = this.push(o);
   
   }
   
   //Objects in the cell
   public boolean push(Object o){
      boolean t = false;
      if(currentContentCount < MAX_CONTENTS) {
         this.contents[currentContentCount] = o;
         currentContentCount++;
         t = true;
      }
      return t;
      
   }
   
   public Object pop() {
      Object o = this.contents[currentContentCount];
      if(currentContentCount > 0) {
         currentContentCount--;
      }
      return o;
   }
   
   //Occupied   
   public void setOccupied(boolean t) {
      this.occupied = t;
   }
   
   public boolean isOccupied() {
      return this.occupied;
   }
   
   //Get and Set Room Locations
   public void setRoomX(int t) {
      this.room_x = t;
   }
   
   public int getRoomX() {
      return this.room_x;
   }
   
   public void setRoomY(int t) {
      this.room_y = t;
   }
   
   public int getRoomY() {
      return this.room_y;
   }
   
   public int[] getRoomLocation() {
   
      int tx = this.getRoomX();
      int ty = this.getRoomY();
      int[] t = {tx, ty};
      
      return t;
   }
   
   //Get and Set Map Locations
   public void setMapX(int t) {
      this.map_x = t;
   }
   
   public int getMapX() {
      return this.map_x;
   }
   
   public void setMapY(int t) {
      this.map_y = t;
   }
   
   public int getMapY() {
      return this.map_y;
   }
   
   public int[] getMapLocation() {
   
      int tx = this.getMapX();
      int ty = this.getMapY();
      int[] t = {tx, ty};
      
      return t;
   
   }
   
   public String toString() {
      return this.contents[currentContentCount-1].toString();
   }

}