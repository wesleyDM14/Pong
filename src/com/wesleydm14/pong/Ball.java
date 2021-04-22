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
		
		int angle = new Random().nextInt(90);
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		
		if (this.y + (this.dy*this.speed) + this.height >= Game.HEIGHT) {
			this.dy*= -1;
		}else if(this.y + (this.dy*this.speed) + this.height <= 0) {
			this.dy*= -1;
		}
		
		if (this.x >= Game.WIDTH) {
			new Game();
			return;
		}else if (this.x < 0) {
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)),width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if (bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			this.dy = Math.cos(Math.toRadians(angle));
			this.dx = Math.sin(Math.toRadians(angle));
			if (dx > 0 ) {
				dx*= -1;
			}
			speed += 0.1;
			
		}else if (bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			this.dy = Math.cos(Math.toRadians(angle));
			this.dx = Math.sin(Math.toRadians(angle));
			if (dx < 0 ) {
				dx*= -1;
			}
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
