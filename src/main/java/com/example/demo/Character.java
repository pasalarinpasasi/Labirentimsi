package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import static java.lang.Thread.sleep;

public class Character
{
    private int X, Y;

    private Image character;

    static final int INF = Integer.MAX_VALUE;

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public Character(int startX, int startY)
    {
        ImageIcon img = new ImageIcon("C://Test//karakter.png");
        character = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);

        X = startX;
        Y = startY;
    }

    public Image getCharacter()
    {
        return character;
    }

    public int getX()
    {
        return X;
    }
    public int getY()
    {
        return Y;
    }

    public void move(int dx, int dy)
    {
        X += dx;
        Y += dy;
    }

    static boolean isObstacle(String[][] Map, int x, int y)
    {
        return switch (Map[y][x]) {
            case "w" -> true;
            case "t" -> true;
            case "r" -> true;
            case "M" -> true;
            case "k" -> true;
            case "B" -> true;
            default -> false;
        };

        //return Map[x][y].equals("z");
    }

    public void shortestPath(String Map[][], int charX, int charY, int destX, int destY, Map m, Character c) {
        int V = Map.length * Map[0].length;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        int source = charY * Map.length + charX;
        int dest = destY * Map.length + destX;
        dist[source] = 0;

        int[] prev = new int[V];

        Set<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < V; i++)
        {
            unvisited.add(i);
        }

        while (!unvisited.isEmpty())
        {
            int u = -1;
            int minDist = INF;
            for (int v : unvisited) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }

            if (u == -1) break;

            unvisited.remove(u);

            int x = u % Map[0].length;
            int y = u / Map[0].length;

            int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] move : moves)
            {
                int nx = x + move[1];
                int ny = y + move[0];

                if (nx >= 0 && nx < Map[0].length && ny >= 0 && ny < Map.length && !isObstacle(Map, ny, nx))
                {
                    int v = nx + ny * Map[0].length;
                    int alt = dist[u] + 1;

                    if (alt < dist[v])
                    {
                        dist[v] = alt;
                        prev[v] = u;
                    }
                }
            }
        }

        if (dist[dest] == INF)
        {
            System.out.println("Hedefe ulaşılamadı!");
            return;
        }

        System.out.println("Başlangıç düğümünden varış düğümüne olan en kısa mesafe: " + dist[dest]);

        List<String> path = new ArrayList<>();
        while (dest != source)
        {
            int x = dest % Map[0].length;
            int y = dest / Map[0].length;
            int px = prev[dest] % Map[0].length;
            int py = prev[dest] / Map[0].length;

            if (x < px)
            {
                c.move(0, -1);
                path.add("Yukarı");
            }
            else if (x > px)
            {
                c.move(0, 1);
                path.add("Aşağı");
            }
            else if (y < py)
            {
                c.move(-1, 0);
                path.add("Sol");
            }
            else
            {
                c.move(1, 0);
                path.add("Sağ");
            }

            dest = prev[dest];
        }

        Collections.reverse(path);
        System.out.println("Karakterin hareket yönleri: " + path);
    }
}
