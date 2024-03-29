package com.example.demo;

abstract class Obstacle
{
    public String[][] size;
    public String[][] getSize()
    {
        return size;
    }

    public abstract String[][] getSize(int size);
}
