import processing.core.*;
//Height and Width (size)
//Start point 
//void move() { (function for player to move the gun sight)
//void display() { (function for the gunsight to be displayed and how it looks.) (ellipse)
class gunSight{
  private PApplet a; 
  private float x;
  private float y;
  private float sightWidth = 50;


gunSight(float sightWidth, PApplet a) {

   
    this.sightWidth = sightWidth;
    this.a = a;
}
public void display() {    //Helps allow the player to move the sight.
  a.noFill();
  a.stroke(0);
  a.ellipse(a.mouseX,a.mouseY,sightWidth,50);
  
  //fill with white but outline black.
  //draw an ellipse with the center cut out.
}
public String toString() {
  return ("This is the Gun Sight class");
}

}
