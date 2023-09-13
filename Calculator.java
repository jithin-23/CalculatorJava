package guiPrograms;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class calc extends JFrame implements ActionListener
{
	JButton b[]=new JButton[16];
	JTextField l;
	
	calc()
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		b[0]=new JButton("1");
		b[1]=new JButton("2");
		b[2]=new JButton("3");
		b[3]=new JButton("/");
		b[4]=new JButton("4");
		b[5]=new JButton("5");
		b[6]=new JButton("6");
		b[7]=new JButton("x");
		b[8]=new JButton("7");
		b[9]=new JButton("8");
		b[10]=new JButton("9");
		b[11]=new JButton("-");
		b[12]=new JButton("0");
		b[13]=new JButton("C");
		b[14]=new JButton("=");
		b[15]=new JButton("+");
		
		l=new JTextField();
		l.setHorizontalAlignment(JTextField.CENTER);
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(4,4));
		
		for(int i=0;i<16;i++)
		{
			b[i].addActionListener(this);
			p2.add(b[i]);
		}
		
		setTitle("Calculator");
		add(l,BorderLayout.NORTH);
		l.setPreferredSize(new Dimension(100,40));
		add(p2);
		setSize(250,280);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	String text="";
	int no1, no2;
	char op;
	
	public void actionPerformed(ActionEvent ae)
	{
		JButton b=(JButton)ae.getSource();
		String c=b.getText();
		
		if(text=="Math ERROR"||text=="Syntax ERROR")
			clear();
		
		if(c=="C")
			clear();
		else if(c=="=")
			getResult();
		else
		{
			text=text+c;
			l.setText(text);
		}
	}
	
	void getResult()
	{
		text=l.getText();
		boolean opf=false;
		try
		{
			int l=text.length();
			String temp="";
			for(int i=0;i<l;i++)
			{
				char c;
				c=text.charAt(i);
				if(c=='+'||c=='-'||c=='x'||c=='/')
				{
					op=c;
					no1=Integer.parseInt(temp);
					temp="";
					opf=true;
				}
				else
					temp=temp+c;
			
			}
			no2=Integer.parseInt(temp);
			
			if(opf)
				evaluate();
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
			text="Math ERROR";
			l.setText(text);
		}
		catch(Exception e)
		{
			System.out.println(e);
			text="Syntax ERROR";
			l.setText(text);
		}
	}
	
	void evaluate()
	{
		int result;
		
		if(op=='+')
			result=no1+no2;
		else if(op=='-')
			result=no1-no2;
		else if(op=='x')
			result=no1*no2;
		else
			result=no1/no2;
		System.out.println(no1+""+op+""+no2+"="+result);
		
		text=String.valueOf(result);
		l.setText(text);
			
	}
	
	void clear()
	{
		text="";
		l.setText(text);
	}
	
}
public class Calculator 
{
	public static void main(String args[])
	{
		new calc();
	}

}
