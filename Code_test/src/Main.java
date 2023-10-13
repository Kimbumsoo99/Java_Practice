import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.set(0, 3);
        System.out.println(list.get(0) + " " + list.get(2));
    }
}