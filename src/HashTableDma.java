/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author Brian Martinez
 */
public class HashTableDma {
    private static class DMA
    {
        int AreaCode;
        String Region;
        String State;
    }
    
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        String filename = "dma.txt", str = "";
        
        try
        {
            Scanner inFile = new Scanner(new FileReader(filename));
            
            // using area code as key
            long start = System.currentTimeMillis();
            
            while (inFile.hasNext())
            {
                str = inFile.nextLine();
                StringTokenizer st = new StringTokenizer(str, ",");
        
                DMA dma = new DMA();
                while (st.hasMoreTokens())
                {
                    dma.AreaCode = Integer.parseInt(st.nextToken());
                    dma.Region = st.nextToken();
                    dma.State = st.nextToken();
                    ht.Insert(dma.AreaCode, dma);
                }
            }
            long time = System.currentTimeMillis()- start;
            
            System.out.println("Using area code as key...");
            System.out.println("Load complete, execution time: " + time + " ms");
            System.out.println("Total keys inserted:  " + ht.KeyCount());
            System.out.println("Number of collisions: " + ht.CollisionCount());
            
            Enumeration keys = ht.GetKeys();
            
            while (keys.hasMoreElements()) {
                Object d = keys.nextElement();
                DMA foo = (DMA)ht.Search(d);
                System.out.println(foo.AreaCode + " " + foo.Region + " " + foo.State);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
