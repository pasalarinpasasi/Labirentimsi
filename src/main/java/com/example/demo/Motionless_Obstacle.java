package com.example.demo;

import javax.swing.*;
import java.awt.*;

public abstract class Motionless_Obstacle extends Obstacle
{
    public class Tree extends Obstacle
    {
        private String size1[][] = {
                {"t","t"},
                {"t","t"}
        };

        private String size2[][] = {
                {"t","t","t"},
                {"t","t","t"},
                {"t","t","t"}
        };

        private String size3[][] = {
                {"t","t","t","t"},
                {"t","t","t","t"},
                {"t","t","t","t"},
                {"t","t","t","t"}
        };

        private String size4[][] = {
                {"t","t","t","t","t"},
                {"t","t","t","t","t"},
                {"t","t","t","t","t"},
                {"t","t","t","t","t"},
                {"t","t","t","t","t"}
        };

        private Image tree;
        Tree()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//Tree.png");
            tree = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getTree()
        {
            return tree;
        }

        @Override
        public String[][] getSize(int size)
        {
            switch (size)
            {
                case 1:
                    return size1;

                case 2:
                    return size2;

                case 3:
                    return size3;

                case 4:
                    return size4;
            }
            return null;
        }
    }

    public class Rock extends Obstacle
    {
        private String size1[][] = {
                {"r","r"},
                {"r","r"}
        };

        private String size2[][] = {
                {"r","r","r"},
                {"r","r","r"},
                {"r","r","r"}
        };

        private Image rock;
        Rock()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//The_Rock_2.png");
            rock = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getRock()
        {
            return rock;
        }

        @Override
        public String[][] getSize(int size)
        {
            switch (size)
            {
                case 1:
                    return size1;

                case 2:
                    return size2;
            }

            return null;
        }
    }

    public class Wall extends Obstacle
    {
        private String size1[][] = {
                {"w","w","w","w","w","w","w","w","w","w"}
        };

        private Image wall;
        Wall()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//Wall.png");
            wall = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getWall()
        {
            return wall;
        }

        @Override
        public String[][] getSize(int size)
        {
            return size1;
        }
    }

    public class Mountain extends Obstacle
    {
        private String size1[][] = {
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
                {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M"},
        };

        private Image mountain;
        Mountain()
        {
            ImageIcon img = new ImageIcon("C://Test//Obstacles//Mountain.png");
            mountain = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        }

        public Image getMountain()
        {
            return mountain;
        }

        @Override
        public String[][] getSize(int size)
        {
            return size1;
        }
    }
}
