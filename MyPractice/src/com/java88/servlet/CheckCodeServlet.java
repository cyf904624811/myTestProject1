package com.java88.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Image;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private List<String> words = new ArrayList<String>();

    public CheckCodeServlet() {
        super();
    }
    
    @Override
    public void init()
    {
    	String path = this.getServletContext().getRealPath("WEB-INF/words.txt");
    	try {
			InputStreamReader is = new InputStreamReader(new FileInputStream(path),"utf-8");
			BufferedReader bf = new BufferedReader(is);
			String line = "";
			while((line = bf.readLine()) != null)
			{
				words.add(line);
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    	
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int width = 120;
		int height = 30;
		int x = 10;
		BufferedImage bi  = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//画笔
		Graphics graphics = bi.getGraphics();
		//画边框与背景
		graphics.setColor(getRandColor(160, 200));
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width-1, height-1);
		
		Graphics2D graphics2D =(Graphics2D)graphics;
		graphics2D.setFont(new Font("宋体",Font.BOLD,18));
		Random random = new Random();
		int index = random.nextInt(words.size());
		String word = words.get(index);
		for(int i =0;i<word.length();i++)
		{
			graphics2D.setColor(new Color(20+random.nextInt(110), 20+random.nextInt(110), 20+random.nextInt(110)));
			int angle = random.nextInt(60)-30;
			double radian = angle*Math.PI/180;
			char c =word.charAt(i);
			
			//绘制图
			graphics2D.rotate(radian,x,20);
			graphics2D.drawString(String.valueOf(c), x, 20);
			graphics2D.rotate(-radian,x,20);
			x += 30;
			
		}
		this.getServletContext().setAttribute("checkCode", word);
		request.getSession().setAttribute("checkCode_session", word);
		
		//绘制干扰线 未实装
		
		graphics.dispose();
		ImageIO.write(bi, "jpg", response.getOutputStream());


		//输出验证码到控制台
		System.out.println("本次验证码："+word);


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Color getRandColor(int fc,int bc)
	{
		Random random = new Random();
		if(fc>255)
		{
			fc = 255;
		}
		if(bc>255)
		{
			bc = 255;
		}
		int r = fc+random.nextInt(bc-fc);
		int g = fc+random.nextInt(bc-fc);
		int b = fc+random.nextInt(bc-fc);
		
		
		return new Color(r,g,b);
	}
}
