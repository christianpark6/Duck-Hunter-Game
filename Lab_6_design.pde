import ddf.minim.*;
import javax.swing.JOptionPane; 
AudioPlayer gunFire; 
AudioPlayer ducks;
//Sorry for turning in the game so late, it took a while for me to figure out as I missed a week of class 
//critical to when you were able to help them finish the lab, it also took me a while to figure out how to make it run but it works really well.
//Thanks again, Christian.

//Design for Minesweeper game
//Christian Park
//11/1/2018
import processing.core.*;
//How will I encode/keep track of:
//Waves
//moving targets
//two sets of point systems
//recycle 
//gun sight
//Timer
boolean list = false;             
int savedTime;
int totalTime = 5000;
int playerScore;
Score yeet;
gunSight [] gunSight = new gunSight [1];      //Classes I am using
Waves [] waves = new Waves [2]; 
Targets [] targets = new Targets [8];
void setup() {
  size(500, 500);
  background(255);
  savedTime = millis();
  yeet = new Score(this);
  PImage rightduck = loadImage("rightduck.png");            //Uploads of images for these classes.
  PImage leftduck = loadImage("leftduck.png");
  Minim minim = new Minim(this);
  gunFire = minim.loadFile("gunshot.wav");      //Uploads of the sounds for the game.
  ducks = minim.loadFile("ducksound.wav");
  ducks.loop();
  rightduck.resize(width/6, height/6);
  leftduck.resize(width/6, height/6);
  gunSight[0] = new gunSight(50, this);
  playerScore = 0;
  
  targets[0] = new Targets(1, 0, 280, (int)random(1, 4) * 10, rightduck, this);      //Drawing of targets.
  targets[1] = new Targets(1, 150, 280, (int)random(1, 4) * 10, rightduck, this);   //Also helps create the scoring system of the targets.
  targets[2] = new Targets(1, 280, 280, (int)random(1, 4) * 10, rightduck, this);
  targets[3] = new Targets(1, 50, 150, (int)random(4, 7) * 10, leftduck, this);
  targets[4] = new Targets(1, 250, 150, (int)random(4, 7) * 10, leftduck, this);
  targets[5] = new Targets(1, 380, 150, (int)random(4, 7) * 10, leftduck, this);
  targets[6] = new Targets(1, 480, 150, (int)random(4, 7) * 10, leftduck, this);
  targets[7] = new Targets(1, 380, 280, (int)random(1, 4) * 10, rightduck, this);
  PImage wave = loadImage("wave1.png");
  wave.resize(width*2, height/2);        
  waves[0] = new Waves(5, width/2, 200, 70, wave, this);    //Making my moving waves.

  waves[1] = new Waves(-5, width/2, 400, 70, wave, this);
}

void draw() {
  background(255);
    int passedTime = millis() - savedTime;          //Creates time in the game.
    
   if (passedTime > totalTime) {        //Helps the game end after a certain time has passed.
     
     if(!list){
       yeet.score(playerScore);
       list = true;
     }
    yeet.display();
    
  }
  else{
  fill(0);
  text(playerScore, 250, 80);
  text((totalTime - passedTime) / 1000, 50,80);   //Using what I wrote in classes this helps show what the pictures are showing and doing.
  waves[0].display();                             //for the two waves.
  waves[0].move();
  waves[1].display();
  waves[1].move();
 
  for (int i = 0; i < 8; i++) {

    targets[i].display();    //Using what I wrote in the targets class this helps show what the pictures are showing and doing.
    targets[i].move();
    gunSight[0].display();
  }
}
}
void mousePressed() {
  gunFire.play(0);  //This plays the gun shot everytime the mouse is pressed.
  for (int i = 0; i < 8; i++) {   //Functon that helps player fire and destroy targets.

    if (targets [i].getX() <=mouseX  && targets[i].getY()<=mouseY && mouseX <= targets[i].getX()+width/6 && mouseY <= targets[i].getY()+height/6) {
      if (targets[i].getDeadDuck() == false) {

        targets[i].setDeadDuck (true); 
        playerScore = playerScore + targets[i].getDuckScore();  //Helps add the score on to the screen to tally up your total points.
      }
    }
  }
}
//background
//multiple targets and multiple waves
//draw one gunsight.
//draw the score when the targets are hit.
//Draw the score sheet when the game has ended.
//Draw the current score while playing the game.
