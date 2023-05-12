package main;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logmachine {

    PrintWriter rfile = new PrintWriter("log.js");

    List<String> templog = new ArrayList<>();

    List<String> backlog = new ArrayList<>();

    public Logmachine() throws FileNotFoundException {
    }

    public void addjson(String s) {
       templog.add(s);
    }

    public void wcycle(){
        backlog.add(templog.toString());
        System.out.println(backlog.toString());
        templog.clear();
    }

    public void printlog(){
        rfile.print("const logs ="+backlog.toString());
        rfile.close();
    }


}
