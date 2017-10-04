background(128, 128, 128);
size(300, 300);

//-> 左上 
noStroke();
triangle(50, 5, 5, 95, 95, 95);

//-> 右上
stroke(0, 0, 0);
line(105, 5, 195, 95);
line(105, 95, 195, 5);

//-> 左下
stroke(255, 0, 0);  // 線の色
strokeWeight(5);  // 線の太さ
rect(5, 105, 90, 90);  // 四角

//-> 右下
stroke(0, 0, 255);
ellipse(150, 150, 90, 90);
point(150, 150);