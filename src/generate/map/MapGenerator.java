package src.generate.map;
import src.rooms.Room;
import src.generate.room.RoomGenerator;

public class MapGenerator {

   private final int MAX_ROOMS = 10;
   private final int LENGTH = 8;
   private final int WIDTH = 8;
   
   private RoomGenerator generateRoom = new RoomGenerator();

   public MapGenerator() {}
   
   public void fillMap(Room[][] rooms, int level) {
      
      int randStartX = (int)Math.floor(Math.random()*(LENGTH));
      int randStartY = (int)Math.floor(Math.random()*(WIDTH));
      
      int randX;
      int randY;
      
      int tempX;
      int tempY;
      
      int rand;
      
      int currentRoomCount = 0;
      int randomRoomCount = 0;
      
      int[][] randomRoomLoc = new int[1][2];
      
      rooms[randStartX][randStartY] = new Room(randStartX, randStartY);
      rooms[randStartX][randStartY].startRoom();
      
      //System.out.println("Starting Point: [" + randStartX + "," + randStartY + "]");
      
      tempX = randStartX - 1;
      if(tempX >= 0) {
         randomRoomLoc[randomRoomLoc.length-1][0] = tempX;
         randomRoomLoc[randomRoomLoc.length-1][1] = randStartY;
         randomRoomCount++;
      }
      
      tempY = randStartY - 1;
      if(tempY >= 0) {
         randomRoomLoc = this.growRandomRooms(randomRoomLoc);
         randomRoomLoc[randomRoomLoc.length-1][0] = randStartX;
         randomRoomLoc[randomRoomLoc.length-1][1] = tempY;
         randomRoomCount++;
      }
      
      tempX = randStartX + 1;
      if(tempX <= 7) {
         randomRoomLoc = this.growRandomRooms(randomRoomLoc);
         randomRoomLoc[randomRoomLoc.length-1][0] = tempX;
         randomRoomLoc[randomRoomLoc.length-1][1] = randStartY;
         randomRoomCount++;
      }
      tempY = randStartY + 1;
      if(tempY <= 7) {
         randomRoomLoc = this.growRandomRooms(randomRoomLoc);
         randomRoomLoc[randomRoomLoc.length-1][0] = randStartX;
         randomRoomLoc[randomRoomLoc.length-1][1] = tempY;
         randomRoomCount++;
      }
      
      //System.out.println("Starting Points: " + Arrays.deepToString(randomRoomLoc));

      while(currentRoomCount < MAX_ROOMS * level) {
      
         rand = (int)Math.floor(Math.random()*(randomRoomLoc.length));
         randX = randomRoomLoc[rand][0];
         tempX = randX;
         
         randY = randomRoomLoc[rand][1];
         tempY = randY;
         
         if(rooms[tempX][randY] == null) {
            rooms[tempX][tempY] = new Room(tempX, randY, false);
            currentRoomCount++;
         }
         
         //System.out.println(currentRoomCount + " Selected Room: [" + tempX + "," + tempY +"]");
         
         randomRoomLoc = this.removeRandomRoom(randomRoomLoc, rand);
         
         tempX = randX - 1;
         if(tempX >= 0 && rooms[tempX][randY] == null && !this.alreadyContainsRoom(randomRoomLoc, tempX, randY)) {
            randomRoomLoc = this.growRandomRooms(randomRoomLoc);
            randomRoomLoc[randomRoomLoc.length-1][0] = tempX;
            randomRoomLoc[randomRoomLoc.length-1][1] = randY;
            randomRoomCount++;
         }
         
         tempY = randY - 1;
         if(tempY >= 0 && rooms[randX][tempY] == null && !this.alreadyContainsRoom(randomRoomLoc, randX, tempY)) {
            randomRoomLoc = this.growRandomRooms(randomRoomLoc);
            randomRoomLoc[randomRoomLoc.length-1][0] = randX;
            randomRoomLoc[randomRoomLoc.length-1][1] = tempY;
            randomRoomCount++;
         }
         
         tempX = randX + 1;
         if(tempX <= 7 && rooms[tempX][randY] == null && !this.alreadyContainsRoom(randomRoomLoc, tempX, randY)) {
            randomRoomLoc = this.growRandomRooms(randomRoomLoc);
            randomRoomLoc[randomRoomLoc.length-1][0] = tempX;
            randomRoomLoc[randomRoomLoc.length-1][1] = randY;
            randomRoomCount++;
         }
         tempY = randY + 1;
         if(tempY <= 7 && rooms[randX][tempY] == null && !this.alreadyContainsRoom(randomRoomLoc, randX, tempY)) {
            randomRoomLoc = this.growRandomRooms(randomRoomLoc);
            randomRoomLoc[randomRoomLoc.length-1][0] = randX;
            randomRoomLoc[randomRoomLoc.length-1][1] = tempY;
            randomRoomCount++;
         }
         
         //System.out.println(currentRoomCount + " Room List:     " + Arrays.deepToString(randomRoomLoc));
         
      }
      
      
      for(int i = 0; i < LENGTH; i++) {
         for(int j = 0; j < WIDTH; j++) {
            if(rooms[i][j] == null) {
               rooms[i][j] = new Room(i, j, true);
               //System.out.print("[" + i + "," + j + "]");
            } else {
               //System.out.print("[ROM]");
            }
         }
         //System.out.println();
      }
      
   }
   
   private int[][] growRandomRooms(int[][] smallList) {
   
      int[][] newList = new int[smallList.length+1][2];
      
      for(int i = 0; i < smallList.length; i++) {
         newList[i][0] = smallList[i][0];
         newList[i][1] = smallList[i][1];
      }
      return newList;
   }
   
   private int[][] removeRandomRoom(int[][] oldList, int index) {
      
      int[][] newList = new int[oldList.length-1][2];
      
      for(int i = 0, k = 0; i < oldList.length; i++) {
         if(i != index) {
            newList[k][0] = oldList[i][0];
            newList[k][1] = oldList[i][1];
            k++;
         }
      }
      
      return newList;
   
   }
   
   private boolean alreadyContainsRoom(int[][] list, int x, int y) {
      for(int i = 0; i < list.length; i++) {
         if(list[i][0] == x && list[i][1] == y) {
            return true;
         }
      }
      return false;   
   }
   
   public void fillWalls(Room[][] rooms) {
   
      boolean north = false;
      boolean east = false;
      boolean south = false;
      boolean west = false;
   
      for(int i = 0; i < 8; i++) {
         for(int j = 0; j < 8; j++) {
            if(!rooms[i][j].isEmpty()) {
               if(i == 0 || rooms[i-1][j].isEmpty()) {
                  north = true;
               }
               if(j == 7 || rooms[i][j+1].isEmpty()) {
                  east = true;
               }
               if(i == 7 || rooms[i+1][j].isEmpty()) {
                  south = true;
               }
               if(j == 0 || rooms[i][j-1].isEmpty()) {
                  west = true;
               }
               if(north || east || south || west) {
                  rooms[i][j].setCells(generateRoom.fillWalls(rooms[i][j].getCells(), north, east, south, west));
               }
            }
            
            north = false;
            east = false;
            south = false;
            west = false;
         }
      }
   
   }


}