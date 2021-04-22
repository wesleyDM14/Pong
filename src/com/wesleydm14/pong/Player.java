package com.wesleydm14.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean up, down;
	public int x,y, width, height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 40;
	}
	
	public void tick() {
		if (this.down) {
			y+=2;
		}else if (this.up) {
			y-=2;
		}
		
		if (this.y + height > Game.HEIGHT ) {
			this.y = Game.HEIGHT - this.height;
		}else if (this.y < 0) {
			this.y = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
		
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}

}
