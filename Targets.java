//Height Width (Size)
//Color 
import processing.core.*;
//Target Location (x,y)
//Point value
// void move() { (function for the target moving.)
// void display() { (function displaying the actual target) (Image of a duck)
// void Shot() { (Function that keeps track if the mouse x,y matches with the targets x,y within the size.)
class Targets {
  private PApplet a;
  private float speed = 2;
  private float x;
  private float y;
  private int duckScore;
  private PImage duck;
  private boolean deadDuck;

  Targets(float speed, float x, float y, int duckScore, PImage duck, PApplet a) { 
    this.speed = speed;
    this.x = x;
    this.y = y;
    this.duckScore = duckScore;
    this.duck = duck;
    this.a = a;
    this.deadDuck = false;
  }
  float getX(){ return x;}
  float getY() {return y;}
  int getDuckScore() {return duckScore;}
  
  boolean getDeadDuck() {return deadDuck;}
  void  setDeadDuck(boolean deadDuck){
    this.deadDuck = deadDuck; }
  
  public void move() {        //Function that makes the ducks move.
    x = x + speed;
    if (x > a.width) {
      x = 0;
      deadDuck = false;
    }
    //use the speed to make the targets move across the box.
  }
  public String toString() {
    return ("This is the Targets class");
  }

  public void display() {     //Function that displays what happens once the duck is clicked on.
    if (deadDuck == false) {
      a.imageMode(a.CORNER);
    a.image(duck, x, y);
    
    //fill with the red color
    //to begin will draw in the shape of an ellipse until I upload an image.
  }else{
  a.text(duckScore,x,y);
  }
  }
  public void shot() {
    //uses the current mouse x and mouse y to determine whether the
    //mouse x and mouse y are on any part of the target.
  }
}
