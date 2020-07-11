package com.java88.util;

import sun.awt.image.JPEGImageDecoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckCodeUtil {
    private static List<String> words = new ArrayList<String>();
    private static Random random = new Random();
    private static String getwords(HttpServletRequest request){
        String path = request.getServletContext().getRealPath("WEB-INF/words.txt");
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(path),"utf-8");
            BufferedReader bf = new BufferedReader(is);
            String line = "";
            while((line = bf.readLine()) != null)
            {
                words.add(line);
            }
            bf.close();
            return words.get(random.nextInt(words.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    private static Color getRandomColor()
    {
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    private static Color getReverseColor(Color c) {

        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String randomString = getwords(request);
        request.getSession(true).setAttribute("randomString", randomString);

        int width = 100;
        int height = 30;
        Color color =getRandomColor();
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        g.setColor(color);
        g.fillRect(0,0,width,height);
        g.setColor(reverse);
        g.drawString(randomString,18,20);
        for (int i = 0,n = random.nextInt(100); i <n ; i++)
        {
            g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
        }

//
        ImageIO.write(bi,"jpg",response.getOutputStream());

    }

}
