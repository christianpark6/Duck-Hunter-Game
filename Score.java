//Height and Width (Size)
import processing.core.*;
import javax.swing.JOptionPane; 
//Color
//Location of the text 
//void display(){ (function to display the current score of the game and changes as more targets are being shot.)
//String name [] = new String [10] (keeps track of all the names listed on the top 10 scores.)
//int scores [] = new int [10] (keeps track of the top 10 scores.)
//void scoreList(){ (stores all the previous names and scores.)
//void topScore(){ (Compare new score to the scoreList and see whether it is greater than a previous score on the list to get stored.)
class Score{
  //load file
  private String [ ] names;
  private int [ ] scores = new int [10]; 
  private PApplet b;
Score(PApplet b) {
  this.b = b;
  names = b.loadStrings("names.txt");

String  [ ]  score = b.loadStrings("scores.txt");

for (int i = 0; i < 10; i++) {
 scores [i] = Integer.parseInt(score [i]);
}
}

public String toString(){
  return ("This is the score class");
}
  
void display(){
  
  b.stroke(0);
  b.noFill();
  b.rect(150,0,200,350);
  b.stroke(0);
  b.text("Top Scores",220,9);
  for (int i = 0; i < 10; i++) {
    b.text(scores[i],250,(i * 30) + 20);
    b.text(names[i], 160, (i * 30) + 20);
  }
  //big rect with a list of names in it that uses the text file
  //with the top ten scores.
}
void score(int yaw){
  if (scores[9] < yaw) {
  String name = JOptionPane.showInputDialog("Please enter your name to be placed in the Top 10");
  update(name,yaw);
}

}
void update(String name, int yaw){    //Function that helps class update the file with new names with high scores.
  for (int i = 0; i < 10; i++) {
    if(yaw > scores[i]) {
      for(int j = 9; j > i; j--){
       scores[j] = scores[j-1];
       names[j] = names[j-1];
      }
      scores[i] = yaw;
      names[i] = name;
      
      String string [] = new String [10];
      for (int k = 0; k < 10; k++){
        string [k] = String.valueOf(scores[k]);
      }
      b.saveStrings("names.txt",names);
      b.saveStrings("scores.txt",string);
    
      return;
    }
  }
}
}

      
        
