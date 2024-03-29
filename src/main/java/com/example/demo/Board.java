package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Board extends JPanel implements ActionListener
{
    public static int pixel = 16; //Piksel boyutu
    private Timer timer;
    private Map m;
    private Character c;
    private String Message = "";

    public Board()
    {
        Random rastgele = new Random();
        m = new Map();
        while(true)
        {
            int a = rastgele.nextInt(Map.size);
            int b = rastgele.nextInt(Map.size);
            if(m.Grid[a][b].equals("z"))
            {
                c = new Character(b, a);
                break;
            }
        }

        addKeyListener(new AL());
        setFocusable(true);

        timer = new Timer(25, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        m.rewriteFile(c.getY(), c.getX(), 2);

        for(int y = 0; y < Map.size; y++)
        {
            for(int x = 0; x < Map.size; x++)
            {
                if(m.getMap(x, y).equals("a"))
                {
                    if(x < Map.size / 2)
                        g.drawImage(m.getAltinSandik(1), x * pixel, y * pixel, null);
                    else
                        g.drawImage(m.getAltinSandik(2), x * pixel, y * pixel, null);
                }
                if(m.getMap(x, y).equals("g"))
                {
                    if(x < Map.size / 2)
                        g.drawImage(m.getGumusSandik(1), x * pixel, y * pixel, null);
                    else
                        g.drawImage(m.getGumusSandik(2), x * pixel, y * pixel, null);
                }
                if(m.getMap(x, y).equals("e"))
                {
                    if(x < Map.size / 2)
                        g.drawImage(m.getZumrutSandik(1), x * pixel, y * pixel, null);
                    else
                        g.drawImage(m.getZumrutSandik(2), x * pixel, y * pixel, null);
                }
                if(m.getMap(x, y).equals("b"))
                {
                    if(x < Map.size / 2)
                        g.drawImage(m.getBakirSandik(1), x * pixel, y * pixel, null);
                    else
                        g.drawImage(m.getBakirSandik(2), x * pixel, y * pixel, null);
                }
                if(m.getMap(x, y).equals("w"))
                {
                    g.drawImage(m.getEngel(), x * pixel, y * pixel, null);
                }
                if(m.getMap(x, y).equals("z"))
                {
                    if(x < Map.size / 2)
                        g.drawImage(m.getZemin(1), x * pixel, y * pixel, null);
                    else
                        g.drawImage(m.getZemin(2), x * pixel, y * pixel, null);
                }
                if(m.getFogmap(x, y).equals("f"))
                {
                    g.drawImage(m.getFog(), x * pixel, y * pixel, null);
                }
                if(m.getFogmap(x, y).equals("0"))
                {
                    g.drawImage(m.getNull(), x * pixel, y * pixel, null);
                }
            }
        }
        Font font = new Font("Verdana", Font.PLAIN, 10);
        FontMetrics metrics = new FontMetrics(font) {};
        Rectangle2D bounds = metrics.getStringBounds(Message, null);
        int widthInPixels = (int) bounds.getWidth();

        g.drawString(Message, Map.size * pixel - widthInPixels, 20);

        g.drawImage(c.getCharacter(), c.getX() * pixel, c.getY() * pixel, null);
    }

    public class AL extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_ENTER)
            {
                Start();
            }

            if(keycode == KeyEvent.VK_W)
            {
                if(c.getY() > 0)
                    if(!m.getMap(c.getX(), c.getY() - 1).equals("w"))
                    {
                        c.move(0, -1);

                        if(m.getMap(c.getX(), c.getY()).equals("a"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Altın sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("g"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Gümüş sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("e"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Zümrüt sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("b"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Bakır sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }
                    }
            }

            if(keycode == KeyEvent.VK_S)
            {
                if(c.getY() + 1 < Map.size)
                    if(!m.getMap(c.getX(), c.getY() + 1).equals("w"))
                    {
                        c.move(0, 1);

                        if(m.getMap(c.getX(), c.getY()).equals("a"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Altın sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("g"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Gümüş sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("e"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Zümrüt sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("b"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Bakır sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }
                    }
            }

            if(keycode == KeyEvent.VK_A)
            {
                if(c.getX() > 0)
                    if(!m.getMap(c.getX() - 1, c.getY()).equals("w"))
                    {
                        c.move(-1, 0);

                        if(m.getMap(c.getX(), c.getY()).equals("a"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Altın sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("g"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Gümüş sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("e"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Zümrüt sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("b"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Bakır sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }
                    }
            }

            if(keycode == KeyEvent.VK_D)
            {
                if(c.getX() + 1 < Map.size)
                    if(!m.getMap(c.getX() + 1, c.getY()).equals("w"))
                    {
                        c.move(1, 0);

                        if(m.getMap(c.getX(), c.getY()).equals("a"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Altın sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("g"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Gümüş sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("e"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Zümrüt sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }

                        if(m.getMap(c.getX(), c.getY()).equals("b"))
                        {
                            m.Grid[c.getY()][c.getX()] = "z";
                            m.openFile();
                            m.rewriteFile(c.getY(), c.getX(), 1);
                            Message = "Bakır sandık toplandı! " + "(" + c.getX() + "," + c.getY() + ")" + " konumunda bulundu.";
                        }
                    }

                if(keycode == KeyEvent.VK_ENTER)
                {
                    Start();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }
    }

    public void Start()
    {
        Random rastgele = new Random();

        while(true)
        {
            int startX = rastgele.nextInt(Map.size);
            int startY = rastgele.nextInt(Map.size);

            if(m.Fog[startY][startX].equals("f") && m.Grid[startY][startX].equals("z"))
            {
                c.shortestPath(m.Grid, c.getX(), c.getY(), startX, startY, m, c);
                break;
            }
        }
    }
}
