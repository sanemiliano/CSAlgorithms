import java.util.*;

int x= -1;
int y=-1;
ArrayList<Integer> xs = new ArrayList();
ArrayList<Integer> ys = new ArrayList();
Stack<Integer> xss = new Stack();
Stack<Integer> yss = new Stack();

int xaux;
int yaux;

color white = color(255);
color black = color(0);

void setup(){
  background(255);
  size(600,400);
  background(255);
  fill(255);
  rect(50,50,50,50);
    rect(150,50,50,50);
    frameRate(100);
}

void draw(){
        if(get(x,y)==white){
         set(x,y,black); 
          xs.add(x);
          ys.add(y);
        }
  if(xs.size()>0){
            xaux = xs.remove(0);
            yaux = ys.remove(0);          
            System.out.println(xaux+"."+yaux);
            
            if(get(xaux+1,yaux)==white){
               set(xaux+1,yaux,black); 
                xs.add(xaux+1);
                ys.add(yaux);
              }
            if(get(xaux-1,yaux)==white){
               set(xaux-1,yaux,black); 
              xs.add(xaux-1);
              ys.add(yaux);
            }
            if(get(xaux,yaux+1)==white){
               set(xaux,yaux+1,black); 
              xs.add(xaux);
              ys.add(yaux+1);
            }
            if(get(xaux,yaux-1)==white){
               set(xaux,yaux-1,black); 
              xs.add(xaux);
              ys.add(yaux-1);
            }
  }
  if(!xss.isEmpty()){
    xaux = xss.pop();
    yaux = yss.pop();
        
        if(get(xaux+1,yaux)==white){
          set(xaux+1,yaux,black);
          xss.add(xaux+1);
          yss.add(yaux);
        }
        if(get(xaux-1,yaux)==white){
          set(xaux-1,yaux,black);
          xss.add(xaux-1);
          yss.add(yaux);
        }
        if(get(xaux,yaux+1)==white){
          set(xaux,yaux+1,black);
          xss.add(xaux);
          yss.add(yaux+1);
        }
        if(get(xaux,yaux-1)==white){
          set(xaux,yaux-1,black);
          xss.add(xaux);
          yss.add(yaux-1);
        }
    }
}

void mouseClicked(){
  x = mouseX;
  y = mouseY;
  
  //paintBreath(x,y);
  
}

void paintBreath(int x, int y){
      if(get(x,y)==white){
         set(x,y,black); 
          xs.add(x);
          ys.add(y);
          int xaux=0;
          int yaux=0;
          
          while(xs.size()>0)
          {  
            
            xaux = xs.remove(0);
            yaux = ys.remove(0);          
            System.out.println(xaux+"."+yaux);
            
            if(get(xaux+1,yaux)==white){
               set(xaux+1,yaux,black); 
                xs.add(xaux+1);
                ys.add(yaux);
              }
            if(get(xaux-1,yaux)==white){
               set(xaux-1,yaux,black); 
              xs.add(xaux-1);
              ys.add(yaux);
            }
            if(get(xaux,yaux+1)==white){
               set(xaux,yaux+1,black); 
              xs.add(xaux);
              ys.add(yaux+1);
            }
            if(get(xaux,yaux-1)==white){
               set(xaux,yaux-1,black); 
              xs.add(xaux);
              ys.add(yaux-1);
            }
            
          }
      }
}
void paintDepth(int x, int y){
    if(get(x,y)==white){
        set(x,y,black);
        if(get(x+1,y)==white)
          paintDepth(x+1,y);
        if(get(x-1,y)==white)
          paintDepth(x-1,y);
        if(get(x,y+1)==white)
          paintDepth(x,y+1);
        if(get(x,y-1)==white)
          paintDepth(x,y-1);
    }
}