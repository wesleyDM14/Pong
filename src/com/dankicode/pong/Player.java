package com.dankicode.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right, left;
	public int x,y, width, height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		if (this.right) {
			x+=2;
		}else if (this.left) {
			x-=2;
		}
		
		if (this.x + width > Game.WIDTH ) {
			this.x = Game.WIDTH - this.width;
		}else if (this.x < 0) {
			this.x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public boolean getRight() {
		return this.right;
	}
	
	public void setX(int x) {
		this.x = x;
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
