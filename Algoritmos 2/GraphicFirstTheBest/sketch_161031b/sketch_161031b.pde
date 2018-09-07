int [][] cubes;
int numberOfCubes=25, sizeOfCubes=20;
int xBegin,yBegin,xEnd,yEnd;
boolean finished;

void setup(){
  size(500,500);
  background(255);
  frameRate(10);
  cubes = new int[numberOfCubes][numberOfCubes];
  obstacles();
  beginEnd(true);
  beginEnd(false);
  paintGrid();
  finished = false;
  Solution s = new Solution(xBegin,yBegin,abs(xBegin-xEnd)+abs(yBegin-yEnd));
  myPriorityQueue.add(s);
}
void obstacles(){
  for (int i=0; i<numberOfCubes; i++) {
    for (int e=0; e<numberOfCubes; e++) {
      if(random(1)<=.2)
        cubes[i][e]=1;
    }
  }
}
void beginEnd(boolean begin){
  int x,y;
  do{
    x = (int) random(numberOfCubes);
    y = (int) random(numberOfCubes);
  }while(x<numberOfCubes && y<numberOfCubes && cubes[x][y]==0);

  if(begin==true){
    xBegin = 5; 
    yBegin = 6; 
    cubes[xBegin][yBegin] = 2;
  }else{
    xEnd = 19;
    yEnd = 18;
    cubes[xEnd][yEnd]=2;
  }
}
void paintGrid(){
  stroke(200);
  for (int x=0,ix=0;ix<numberOfCubes ;x+=sizeOfCubes,ix++) {
    for (int y=0,iy=0;iy<numberOfCubes ;y+=sizeOfCubes,iy++) {
      switch(cubes[ix][iy]){
        case 0: stroke (200); fill(255);break;
        case 1: stroke(0); fill(0); break;
      }
      rect(x,y,sizeOfCubes,sizeOfCubes);
    }
  }
  stroke(0,255,0);
  rect(xBegin*sizeOfCubes,yBegin*sizeOfCubes,sizeOfCubes,sizeOfCubes);
  stroke(255,0,0); fill(2500,0,0); 
  rect(xEnd*sizeOfCubes,yEnd*sizeOfCubes,sizeOfCubes,sizeOfCubes);

}
void paintSquare(int ix, int iy, int c){
  stroke(c); fill(c);
  rect(ix*sizeOfCubes,iy*sizeOfCubes,sizeOfCubes,sizeOfCubes);
}
void paintRoute(Solution s){
  for (int i=0;i<s.pX.size() ; i++) {
    paintSquare(s.pX.get(i), s.pY.get(i),100);
    println(s.pX.get(i)+","+s.pY.get(i));
  }
}
void draw(){
  if(myPriorityQueue.isEmpty() || finished == true) return;
  Solution s = myPriorityQueue.poll();
  if(visited[s.x][s.y] ==  true) return;
  if(s.x == xEnd && s.y == yEnd){
    finished = true;
    println("terminado");
    paintRoute(s);
    return;
  }
  visited[s.x][s.y] = true;
  if( !(s.x == xBegin && s.y == yBegin))
    paintSquare(s.x,s.y,200);

  int xN,yN;
  xN = s.x+1; yN = s.y;
  if(xN>=0 && yN>=0 && xN<numberOfCubes && yN<numberOfCubes && cubes[xN][yN]!=1 && !visited[xN][yN])
    myPriorityQueue.add( new Solution(s,xN,yN,abs(xN-xEnd)+abs(yN-yEnd) ));
  xN = s.x-1; yN = s.y;
  if(xN>=0 && yN>=0 && xN<numberOfCubes && yN<numberOfCubes && cubes[xN][yN]!=1 && !visited[xN][yN])
    myPriorityQueue.add( new Solution(s,xN,yN,abs(xN-xEnd)+abs(yN-yEnd) ));
  xN = s.x; yN = s.y+1;
  if(xN>=0 && yN>=0 && xN<numberOfCubes && yN<numberOfCubes && cubes[xN][yN]!=1 && !visited[xN][yN])
    myPriorityQueue.add( new Solution(s,xN,yN,abs(xN-xEnd)+abs(yN-yEnd) ));
  xN = s.x; yN = s.y-1;
  if(xN>=0 && yN>=0 && xN<numberOfCubes && yN<numberOfCubes && cubes[xN][yN]!=1 && !visited[xN][yN])
    myPriorityQueue.add( new Solution(s,xN,yN,abs(xN-xEnd)+abs(yN-yEnd) ));
}