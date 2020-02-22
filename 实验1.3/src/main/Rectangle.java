package main;

public class Rectangle {
	float lenth;
	float width;
	public Rectangle(float lenth,float width){
		this.lenth=lenth;
		this.width=width;
	}
	public float calculateAcreage() {
		return lenth*width;
	}
}
