
import java.util.Arrays;

int[] pixels = new int[240000];
int[][] conections = new int[960000][4];
boolean[] used = new boolean[240000];
color auxColor = color(255,160,122);
int uno = 255;
int dos = 160;
int tres = 122;

color black = color(0);
int conectionsCont=0;

void setup(){
  background(255);
  size(600,400);
  background(255);
  fill(0);
  rect(25,25,25,25);
    rect(75,25,25,25);
    frameRate(100);
}
void draw(){

}
void mouseClicked(){
  search();
}
void search(){
  
  for (int i=0; i<400; i++) {
    for (int e=0; e<600; e++) {
      if(get(e,i)==black){
        if(i+1<400){
          if(get(i+1,e)==black){
            conections[conectionsCont][0]=e;
            conections[conectionsCont][1]=i;
            conections[conectionsCont][2]=e;
            conections[conectionsCont][3]=i+1;
            conectionsCont++;
          }
        }
        if(i-1>0){
          if(get(i+1,e)==black){
            conections[conectionsCont][0]=e;
            conections[conectionsCont][1]=i;
            conections[conectionsCont][2]=e;
            conections[conectionsCont][3]=i-1;
            conectionsCont++;
          }
        }
        if(e+1<600){
          if(get(i+1,e)==black){
            conections[conectionsCont][0]=e;
            conections[conectionsCont][1]=i;
            conections[conectionsCont][2]=e+1;
            conections[conectionsCont][3]=i;
            conectionsCont++;
          }
        }
        if(e-1<600){
          if(get(i+1,e)==black){
            conections[conectionsCont][0]=e;
            conections[conectionsCont][1]=i;
            conections[conectionsCont][2]=e-1;
            conections[conectionsCont][3]=i;
            conectionsCont++;
          }
        }
        pixels[(i*600)+e] = (i*600)+e;
      }
    }
  }
  
  for (int i=0; i<conectionsCont; i++) {
    union(conections[i][1]*600+conections[i][0],conections[i][3]*600+conections[i][2]);
  }
  for (int i=0; i<240000; i++) {
    if(pixels[i]>0 && !used[i]){
      paint(i);
      uno -=5;
      dos +=5;
      tres +=5;
      auxColor = color(uno,dos,tres);
    }
  }

}
void paint(int pixel){
  set(pixel%600,pixel/600,auxColor);
  used[pixel] = true;
  if(pixels[pixel]!=pixel)
    paint(pixels[pixel]);
}
int buscar(int v){
  if(pixels[v]==v)
    return v;
  else
    return buscar(pixels[v]);
}
void union(int a, int b){
  int ra = buscar(a);
  int rb = buscar(b);
  pixels[ra]= rb;
}