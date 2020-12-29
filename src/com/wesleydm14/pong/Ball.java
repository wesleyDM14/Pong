package com.wesleydm14.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public double dx, dy;
	double speed;
	public int width, height;
	
	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
		this.speed = 1.6;
		this.dx = new Random().nextGaussian();
		this.dy = new Random().nextGaussian();
	}
	
	public void tick() {
		
		if (this.x + (this.dx*this.speed) + this.width >= Game.WIDTH) {
			this.dx*= -1;
		}else if(this.x + (this.dx*this.speed) + this.width <= 0) {
			this.dx*= -1;
		}
		
		if (this.y >= Game.HEIGHT) {
			new Game();
			return;
		}else if (this.y < 0) {
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)),width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if (bounds.intersects(boundsPlayer)) {
			dy*= -1;
			speed += 0.1;
		}else if (bounds.intersects(boundsEnemy)) {
			dy*= -1;
			speed += 0.1;
		}
		
		this.x += this.dx*this.speed;
		this.y += this.dy*this.speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)x,(int) y, width, height);
	}

}
