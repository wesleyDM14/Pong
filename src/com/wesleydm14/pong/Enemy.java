package com.wesleydm14.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	public double x,y;
	public int width, height;
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		this.x += (Game.ball.x - this.x - 5) * 0.2;
		if (this.x + width > Game.WIDTH ) {
			this.x = Game.WIDTH - this.width;
		}else if (this.x < 0) {
			this.x = 0;
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
