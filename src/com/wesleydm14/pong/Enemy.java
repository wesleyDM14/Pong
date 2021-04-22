package com.wesleydm14.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	public double x,y;
	public int width, height;
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 40;
	}
	
	public void tick() {
		this.y += (Game.ball.y - this.y - 5) * 0.2;
		if (this.y + height > Game.HEIGHT ) {
			this.y = Game.HEIGHT - this.height;
		}else if (this.y < 0) {
			this.y = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int) y, width, height);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return this.x;
	}
		
	public double getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
