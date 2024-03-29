package com.example.demo;

import javax.swing.*;
import java.awt.*;

public abstract class Moving_Obstacle extends Obstacle
{
    public class Bird extends Obstacle
    {
        private String size1[][] = {
                {"k","k"},
                {"k","k"}
        };

        private Image bird;
        Bird()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//Bird.png");
            bird = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getBird()
        {
            return bird;
        }

        @Override
        public String[][] getSize(int size) {
            return new String[0][];
        }
    }

    public class Bee extends Obstacle
    {
        private String size1[][] = {
                {"B","B"},
                {"B","B"}
        };

        private Image bee;
        Bee()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//Bee.png");
            bee = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getBee()
        {
            return bee;
        }

        @Override
        public String[][] getSize(int size) {
            return new String[0][];
        }
    }
}
