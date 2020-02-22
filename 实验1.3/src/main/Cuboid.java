package main;

public class Cuboid extends Rectangle{
	float high;
	public Cuboid(float lenth, float width ,float high) {
		super(lenth, width);
		this.high=high;
	}
	public float calculateVolume() {
		return this.calculateAcreage()*high;
	}
}
