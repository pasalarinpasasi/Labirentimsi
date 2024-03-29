package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Map
{
    public static int size; //Harita boyutu

    private Scanner m;
    private Scanner fm;
    private File file = new File("C://Test//Map.txt");
    private File fogFile = new File("C://Test//Fog.txt");
    private FileWriter fWriter;
    private FileWriter fogFWriter;

    {
        try {
            fWriter = new FileWriter(file, true);
            fogFWriter = new FileWriter(fogFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedWriter bWriter;
    BufferedWriter fogWriter;

    public String Grid[][] = new String[size][size];
    public String Fog[][] = new String[size][size];
    private String FogMap[] = new String[size];
    private String Map[] = new String[size];

    private Image engel, zemin_yaz, zemin_kis, altinYaz, altinKis, gumusYaz, gumusKis, zumrutYaz, zumrutKis, bakirYaz, bakirKis, fog, nul;

    public Map()
    {
        ImageIcon img = new ImageIcon("C://Test//Obstacles//Wall.png");
        engel = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Zemin_Kis.png");
        zemin_kis = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Zemin_Yaz.png");
        zemin_yaz = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Altin_Kis.png");
        altinKis = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Altin_Yaz.png");
        altinYaz = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Gumus_Kis.png");
        gumusKis = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Gumus_Yaz.png");
        gumusYaz = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Zumrut_Kis.png");
        zumrutKis = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Zumrut_Yaz.png");
        zumrutYaz = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Bakir_Kis.png");
        bakirKis = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Bakir_Yaz.png");
        bakirYaz = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//Fog2.png");
        fog = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);
        img = new ImageIcon("C://Test//null.png");
        nul = img.getImage().getScaledInstance(Board.pixel, Board.pixel, Image.SCALE_DEFAULT);


        openFile();
        writeFile();
        readFile(1);
        readFile(2);
        closeFile();
    }

    public Image getEngel()
    {
        return engel;
    }

    public Image getZemin(int mod)
    {
        if(mod == 1)
            return zemin_kis;
        else
            return zemin_yaz;
    }

    public Image getAltinSandik(int mod)
    {
        if(mod == 1)
            return altinKis;
        else
            return altinYaz;
    }

    public Image getGumusSandik(int mod)
    {
        if(mod == 1)
            return gumusKis;
        else
            return gumusYaz;
    }

    public Image getZumrutSandik(int mod)
    {
        if(mod == 1)
            return zumrutKis;
        else
            return zumrutYaz;
    }

    public Image getBakirSandik(int mod)
    {
        if(mod == 1)
            return bakirKis;
        else
            return bakirYaz;
    }

    public Image getFog() {
        return fog;
    }

    public Image getNull() {
        return nul;
    }

    public String getMap(int x, int y)
    {
        return Map[y].substring(x, x + 1);
    }

    public String getFogmap(int x, int y) {
        return FogMap[y].substring(x, x + 1);
    }

    public void openFile()
    {
        try
        {
            m = new Scanner(file);
            fm = new Scanner(fogFile);

        }
        catch (Exception e)
        {
            System.out.println("Haritayı yüklerken hata oluştu.");
        }

    }

    public void readFile(int mod)
    {
        switch (mod)
        {
            case 1:
                while (m.hasNext())
                {
                    for (int i = 0; i < size; i++)
                    {
                        Map[i] = m.next();
                    }
                }

            case 2:
                while (fm.hasNext())
                {
                    for (int i = 0; i < size; i++)
                    {
                        FogMap[i] = fm.next();
                    }
                }
        }
    }

    public void writeFile()
    {
        deleteContent(1);
        deleteContent(2);

        bWriter = new BufferedWriter(fWriter);
        fogWriter = new BufferedWriter(fogFWriter);
        Random rastgele = new Random();

        //DİZİYİ RASTGELE DOLDUR
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {

                if (rastgele.nextInt(5) == 0)
                {
                    Grid[i][j] = "w";
                }
                else if (rastgele.nextInt(150) == 1)
                {
                    Grid[i][j] = "a";
                }
                else if (rastgele.nextInt(150) == 2)
                {
                    Grid[i][j] = "g";
                }
                else if (rastgele.nextInt(150) == 3)
                {
                    Grid[i][j] = "e";
                }
                else if (rastgele.nextInt(150) == 4)
                {
                    Grid[i][j] = "b";
                }
                else
                {
                    Grid[i][j] = "z";
                }
            }
        }

        //DOSYAYA YAZ
        try
        {
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    bWriter.write(Grid[i][j]);
                }

                bWriter.newLine();
            }
            System.out.println("Dosyaya yazıldı.");
            bWriter.flush();
            bWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Dosya yazılırken bir hata oluştu: " + e.getMessage());
        }

        //SİS OLUŞTUR
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Fog[i][j] = "f";
            }
        }

        try
        {
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    fogWriter.write(Fog[i][j]);
                }

                fogWriter.newLine();
            }

            fogWriter.flush();
        }

        catch (IOException e)
        {
            System.out.println("Sis oluşturulurken bir hata oluştur: " + e.getMessage());
        }
    }

    public void rewriteFile(int y, int x, int mod) //DOSYAYI GÜNCELLE
    {
        FileWriter zfWriter;
        FileWriter zfogWriter;

        try {
            zfWriter = new FileWriter(file, true);
            zfogWriter = new FileWriter(fogFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter bWriter = new BufferedWriter(zfWriter);
        BufferedWriter fogWriter = new BufferedWriter(zfogWriter);

        switch (mod)
        {
            case 1:
                deleteContent(1);

                try
                {
                    for (int i = 0; i < size; i++)
                    {
                        for (int j = 0; j < size; j++)
                        {
                            bWriter.write(Grid[i][j]);
                        }

                        bWriter.newLine();
                    }

                    bWriter.flush();
                    readFile(1);
                }
                catch (IOException e)
                {
                    System.out.println("Dosya yazılırken bir hata oluştu: " + e.getMessage());
                }

            case 2:
                deleteContent(2);
                openFile();

                try
                {
                    for (int i = 0; i < size; i++)
                    {
                        for (int j = 0; j < size; j++)
                        {
                            if (i == y && j == x)
                            {
                                for (int k = - 3; k < 4; k++)
                                {
                                    for (int t = -3; t < 4; t++)
                                    {
                                        if(i + k > -1 && i + k < size && j + t > -1 && j + t < size)
                                        {
                                            Fog[i + k][j + t] = "0";
                                        }
                                    }
                                }
                            }

                            fogWriter.write(Fog[i][j]);
                        }

                        fogWriter.newLine();
                    }

                    fogWriter.flush();
                    readFile(2);
                }
                catch (IOException e)
                {
                    System.out.println("Sis dosyası düzenlenirken bir hata oluştu: " + e.getMessage());
                }
        }

        closeFile();
    }

    public void deleteContent(int mod) //DOSYA İÇERİKLERİNİ SİL
    {
        switch (mod)
        {
            case 1:
                try(BufferedWriter writer = Files.newBufferedWriter(file.toPath())){
                    writer.write("");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            case 2:
                try(BufferedWriter writer = Files.newBufferedWriter(fogFile.toPath())){
                    writer.write("");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public void closeFile()
    {
        m.close();
    }
}
