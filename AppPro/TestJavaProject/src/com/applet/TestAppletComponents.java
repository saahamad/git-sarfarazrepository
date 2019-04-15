package com.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestAppletComponents extends Applet implements ActionListener {
	
	Button b;
	TextField t;
	
	@Override
public void init() {
		
	b = new Button("Click me!");
	t = new TextField(20);
	
	add(b);
	add(t);
	b.addActionListener(this);
  }
	
	@Override
	public void paint(Graphics g) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b)
		t.setText("User name is valid..");
	}

}

/*

<html>
  <applet code="TestAppletComponents.class" height="500" width="500" />
</html>

*/