//Height and Width (Size)
//Color
import processing.core.*;
//Start Location and end location
//void move{ (function to talk about how fast the waves move and where they move to.)
//void display{ (function to displaying the actual waves which will be an image) 
 class Waves{ 
  private PApplet p;
  private float speed;
  private float x;
  private float y;
  private float waveWidth;
  private PImage wave;
  private float width;
  Waves(float speed, float x, float y, float waveWidth, PImage wave, PApplet p){
    this.speed = speed;
    this.x = x;
    this.y = y;
    this.waveWidth = waveWidth;
    this.wave = wave;
    this.p = p;
  }
public void move(){         //Function that makes the waves constantly move throughout the game.
    x = x + speed;
    if (x > p.width || x < 0) {
      
      x = p.width/2; }
}
 
public void display(){     //This function helps display an image that I pick and the parameters of it.
  p.imageMode(p.CENTER);
   p.image(wave,x,y);

}   //to begin will draw in the shape of an ellipse until I upload an image.
}
