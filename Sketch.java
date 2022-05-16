import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {
    // put your size call here
    size(300, 300);
  }

  float[] snowflakeY = new float[35];
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  float playerX = 200;
  float playerY = 200; 

  float[] clicked = new float[5];

  float clickedX;
  float clickedY;
  float newclick;

  int count = 0;

  public void setup() {
    for (int i = 0; i < snowflakeY.length; i++) {
      snowflakeY[i] = random(height);
    }
  }

  public void draw() {

    background(50);

    float z = 2;

    for (int i = 0; i < snowflakeY.length; i++) {

      float snowflakeX = width * i / snowflakeY.length;
      
      fill(225);
      ellipse(snowflakeX, snowflakeY[i], 10, 10);
      
      if (snowflakeX - clickedX < 2 && snowflakeY[i] - clickedY < 5) {
        snowflakeY[i] = newclick;
        fill(50);
        ellipse(clickedX, newclick, 15, 15);
      }
      
      snowflakeY[i] += z;
      newclick += z;

      if (snowflakeY[i] > height) {
        snowflakeY[i] = 0;
      }

      if (keyPressed) {
        if (keyCode == DOWN) {
          z = 3;
        }
        if (keyCode == UP) {
          z = 1;
        }
      }

      if (upPressed) {
        playerY--;
      }
      if (downPressed) {
        playerY++;
      }
      if (leftPressed) {
        playerX--;
      }
      if (rightPressed) {
        playerX++;
      }

      fill(0, 0, 255);
      ellipse(playerX, playerY, 20, 20);

      if (dist(playerX, playerY, snowflakeX, snowflakeY[i]) < 3 && dist(playerX, playerY, snowflakeX, snowflakeY[i]) > 2) {
        count++;
      }

      
    
    }

    if (count >= 3) {
      background(255);
      exit();
    } 

    for (int g = count; g <= 3; g++){
      rect(((g)*100), 50, 25, 25);
    }

    System.out.println(count);

  }

  public void mouseClicked() {
    clickedX = mouseX;
    clickedY = mouseY;
  }

  public void keyPressed() {

    if (key == 'w') {
      upPressed = true;
    } else if (key == 's') {
      downPressed = true;
    } else if (key == 'a') {
      leftPressed = true;
    } else if (key == 'd') {
      rightPressed = true;
    }

  }

  public void keyReleased() {

    if (key == 'w') {
      upPressed = false;
    } else if (key == 's') {
      downPressed = false;
    } else if (key == 'a') {
      leftPressed = false;
    } else if (key == 'd') {
      rightPressed = false;
    }
  }

}