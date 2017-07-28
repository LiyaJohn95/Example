package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liya_john on 13/7/17.
 */
public class AnswerExample {


    static final String CORRECTANS_FILE = "/home/liya_john/Documents/java files/Correctans.txt";
    static final String STUDENTANS_FILE = "/home/liya_john/Documents/java files/Studentans.txt";

    public static void main(String args[]) throws Exception{
        Map<Integer,Correctans> correctansMap = readFromCorrectansFile(CORRECTANS_FILE);
        Map<Integer,Studentans> studentansMap = readFromStudentansFile(STUDENTANS_FILE);
        System.out.println(correctansMap);
        System.out.println(studentansMap);

        int mark = 0;
        for (Map.Entry<Integer,Correctans> entry1 : correctansMap.entrySet()){
            for (Map.Entry<Integer,Studentans> entry2 : studentansMap.entrySet()) {
                if ((entry1.getValue().qno == entry2.getValue().qno) && (entry1.getValue().ans.equals(entry2.getValue().ans)))

                        mark = mark + entry1.getValue().mark;
                      //System.out.println(mark);
                    }
                }
        System.out.println("Total Mark :-");
                System.out.println(mark);
    }

    public static Map<Integer, Correctans> readFromCorrectansFile(String filename) throws Exception{
        Map<Integer,Correctans> correctansMap =new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            System.out.println("Correct Ans Sheet :-");
            String line;
            int k = 1;
            while ((line = br.readLine())!= null){
                k = k+1;
                System.out.println(line);
                String tokens[] = line.split(" ");
                //System.out.println(tokens);
                correctansMap.put(k,new Correctans(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2])));
            }
        }
        return correctansMap;
    }


    public static Map<Integer,Studentans> readFromStudentansFile(String filename) throws Exception{
        Map<Integer,Studentans> studentansMap = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            System.out.println("Student Ans Sheet :-");
            String line;
            int k = 1;
            while ((line = br.readLine())!= null){
                k = k+1;
                System.out.println(line);
                String tokens[] = line.split(" ");
                studentansMap.put(k,new Studentans(Integer.parseInt(tokens[0]),tokens[1]));
            }
        }
        return studentansMap;
    }

}

class Correctans{
    int qno;
    String ans;
    int mark;

    public Correctans(int qno,String ans,int mark){
        this.qno = qno;
        this.ans = ans;
        this.mark = mark;
    }

   @Override
    public String toString(){
        return "Correctans{" +
                "Qno=" + qno+'\''+
                ", Ans=" + ans+'\''+
                ", Mark=" + mark +
                '}';
   }
}

class Studentans{
    int qno;
    String ans;

    public Studentans(int qno,String ans){
        this.qno = qno;
        this.ans = ans;
    }

    @Override
    public  String toString(){
        return "Studentans{" +
                "Qno=" + qno +'\'' +
                "Ans=" +ans +'\''+
                '}';
    }
}