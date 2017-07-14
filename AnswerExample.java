package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liya_john on 13/7/17.
 */
public class AnswerExample {

    static final String CORRECTANS_FILE = "/home/liya_john/Documents/java files//Correct ans.txt";
    static final String STUDENTANS_FILE = "/home/liya_john/Documents/java files//Student ans.txt";

    public static void main(String args[]) throws Exception{
        Map<Integer,Correctans> correctansMap = readFromCorrectansFile(CORRECTANS_FILE);
        Map<Integer,Studentans> studentansMap = readFromStudentansFile(STUDENTANS_FILE);
        Map<Integer,Correctans> correctansMap1 = createCorrectansMap(correctansMap);
        Map<Integer,Studentans> studentansMap1 = createStudentansMap(studentansMap);

        int mark = 0;
        for (Map.Entry<Integer,Correctans> entry1 : correctansMap1.entrySet()){
            for (Map.Entry<Integer,Studentans> entry2 : studentansMap1.entrySet()){
                if ((entry1.getValue().ans == entry2.getValue().ans) && (entry1.getValue().qno == entry2.getValue().qno))
                    mark = mark+entry1.getValue().mark;
            }
        }
        System.out.println(mark);

    }

    public static Map<Integer, Correctans> readFromCorrectansFile(String filename) throws Exception{
        Map<Integer,Correctans> correctansMap =new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            int k = 1;
            while ((line = br.readLine())!= null){
                k = k+1;
                String tokens[] = line.split(" ");
                correctansMap.put(k,);
            }
        }
        return correctansMap;
    }

    static Map<Integer,Correctans> createCorrectansMap(Map<Integer,Correctans> correctansMap){
        Map<Integer,Correctans> correctansMap1 = new TreeMap<>();
        for (String str : correctansMap){
            String[] tokens = str.split(" ");
            correctansMap1.put(new Correctans(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2])));
        }
        return correctansMap1;
    }

    public static Map<Integer,Studentans> readFromStudentansFile(String filename) throws Exception{
        Map<Integer,Studentans> studentansMap = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine())!= null){
                studentansMap.put(line);
            }
        }
        return studentansMap;
    }

    static Map<Integer,Studentans> createStudentansMap(Map<Integer,Studentans> studentansMap){
        Map<Integer,Studentans> studentansMap1 = new TreeMap<>();
        for (String str : studentansMap){
            String[] tokens = str.split(" ");
            studentansMap1.put(new Studentans(Integer.parseInt(tokens[0]),tokens[1]));
        }
        return studentansMap1;
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
                ", Mark=" +
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