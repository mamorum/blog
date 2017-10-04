int px=200, py=350;  // 自機の座標
int pw=40, ph=20;  // 自機の幅, 高
int ow=30, oh=30; // 落下物の幅, 高
int[] oy = new int[10];
int[] oColor = new int[10];

void setup() {
  size(400, 400);
  frameRate(60);
  noStroke();
  for (int i=0; i<10; i++) {
    objInit(i);
  }
}
void draw() {
  background(0);
  objMove();
  objDisp();
  playerMove();
  playerDisp();
}
void playerMove() {
  px = mouseX;
  //-> 自機移動はウィンドウ幅まで
  if ((px+pw) > width) {
    px = width - pw;
  }
}
void playerDisp() {
  fill(255);
  rect(px, py, pw, ph, 5);
}
void objMove() {
  for (int i=0; i<10; i++) {
    oy[i] += 2;
    if (oy[i] > height) {
      objInit(i);
    }
  }
}
void objDisp() {
  for (int i=0; i<10; i++) {
    if (oColor[i] == 0) {
      fill(255, 0, 0);
    } else {
      fill(0, 255, 0);      
    }
    rect(i*40+5, oy[i], ow, oh, 5);
  }
}
void objInit(int no) {
  oy[no] = 40;
  oColor[no] = int(random(2));
}
