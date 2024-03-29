package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Proje extends JFrame implements ActionListener
{
    JTextField size;
    JButton button;
    JFrame menu;

    public static void main(String[] args)
    {
        new Proje();
    }

    public Proje()
    {
        size = new JTextField();
        size.setBounds(148, 182, 190, 38);

        button = new JButton(new ImageIcon("C://Test//Buton.jpg"));
        button.setBounds(180, 300, 120, 60);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(this);

        menu = new JFrame("Menü")
        {
            @Override
            public void paint(Graphics g)
            {
                super.paint(g);

                ImageIcon menuIcon = new ImageIcon("C://Test//Menu.jpg");
                Image menuImage = menuIcon.getImage();

                if(menuImage != null)
                {
                    int x = (getWidth() - menuImage.getWidth(null)) / 2;
                    int y = (getHeight() - menuImage.getHeight(null)) / 2;
                    g.drawImage(menuImage, x, y, menu);
                }
            }
        };

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLayout(null);
        menu.setSize(500, 500);
        menu.add(button);
        menu.add(size);
        menu.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            menu.dispose();
            Map.size = Integer.parseInt(size.getText());
            Board b = new Board();
            JFrame frame = new JFrame();
            frame.setTitle("Proje");
            frame.add(b);
            frame.setSize(Map.size * Board.pixel + 16,Map.size * Board.pixel + 39);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}

/**/