package src.maps;

import src.rooms.Room;
import src.generate.map.MapGenerator;
import java.util.Arrays;


public class Map {

   private final int LENGTH = 8;
   private final int WIDTH = 8;
   
   private MapGenerator generateMap = new MapGenerator();
   
   private int level;
   
   Room[][] rooms;

   public Map() {
   
      rooms = new Room[LENGTH][WIDTH];
      this.level = 1;   
   
      generateMap.fillMap(rooms, this.level);
      generateMap.fillWalls(rooms);
   }
      
   public String toString() {
      
      String output = "";

      for(int row = 0; row < 8; row++) {
         for(int roomrow = 0; roomrow < 8; roomrow++) {
            for(int subrow = 0; subrow < 8; subrow++) {
               output += rooms[row][subrow].toString(roomrow);
            }
            output += System.lineSeparator();
         }
      }
      
      return output;
   }

}