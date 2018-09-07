import java.util.*;

class Solution{
  int x;
  int y;
  public int r;
  int h;
  int prioridad;
  ArrayList<Integer> pX = new ArrayList();
  ArrayList<Integer> pY = new ArrayList();
  
  Solution(int x, int y,int h){
    this.x = x;
    this.y = y;
    this.h = h;
    this.prioridad = this.r + this.h;
    this.pX = new ArrayList<Integer>();
    this.pY = new ArrayList<Integer>();
    pX.add(this.x);
    pY.add(this.y);
  }  
  Solution(Solution s ,int x, int y, int h){
    this.x = x;
    this.y = y;
    this.r = s.r+1;
    this.h = h;
    this.prioridad = this.r + this.h;
    this.pX = (ArrayList<Integer>)s.pX.clone();
    this.pY = (ArrayList<Integer>)s.pY.clone();
    pX.add(this.x);
    pY.add(this.y);
  }
  void agregar(int x,int y){
    pX.add(x);
    pY.add(y);
  }
}

boolean visited[][] = new boolean[numberOfCubes][numberOfCubes];
PriorityQueue<Solution> myPriorityQueue = new PriorityQueue(6,new Comparator<Solution>(){
  public int compare(Solution s1, Solution s2){
    if(s1.prioridad <= s2.prioridad) return 0;
    else return 1;
  }
});