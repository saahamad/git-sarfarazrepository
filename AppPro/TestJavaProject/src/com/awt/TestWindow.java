package com.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestWindow extends Frame implements ActionListener{
	
	static Dialog dialog;
	TextField t1;
	TextField t2;
	Label label;
		public TestWindow() {
			System.out.println("Start...");
			 t1 = new TextField("Enter a number here");
			 t2 = new TextField("Enter a number here");
			 label = new Label("Result.");
			 label.setSize(200,200);
			Button b =  new  Button("Add me!!");
			
			b.addActionListener(this);
			
			dialog = new Dialog(this,"Dailog!!!",true);
			
			dialog.add(t1);
			dialog.add(t2);
			dialog.add(b);
			dialog.add(label);
			dialog.setLayout(new FlowLayout());
			dialog.setSize(1000, 1000);			
			dialog.setVisible(true);
		}
		
	public static void main(String[] args) {
		
		TestWindow testWindow = new TestWindow();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int a = Integer.parseInt(t1.getText());
		int b = Integer.parseInt(t2.getText());
		
		label.setText("Addition is:"+(a+b));
	}

}