package smartlibrary;
import java.util.Scanner;
public class SmartLibrary {
 static Document[] docs;
 public static void main(String[]args){Scanner in=new Scanner(System.in);docs=DatasetLoader.load("dataset/SmartLibrary_Dataset.csv");System.out.println("SmartLibrary Advanced Text Analytics Engine");System.out.println("Dataset loaded: "+docs.length+" documents");int ch;
 do{System.out.println("\n1 View documents  2 Pattern search  3 Fuzzy matching  4 Suffix array/LCP  5 Sequence alignment  6 DP demos  7 Max flow  8 Vertex-cover approximation  9 Miller-Rabin  10 Reservoir sampling  0 Exit");System.out.print("Choice: ");ch=integer(in);
 switch(ch){
 case 1:for(int i=0;i<docs.length;i++)docs[i].print();break;
 case 2:System.out.print("Pattern: ");String p=in.nextLine().toLowerCase();if(docs.length==0){System.out.println("Dataset empty");break;}String t=docs[0].searchableText().toLowerCase();System.out.println("Naive="+StringAlgorithms.naive(t,p)+" KMP="+StringAlgorithms.kmp(t,p)+" Z="+StringAlgorithms.zSearch(t,p)+" Rabin-Karp="+StringAlgorithms.rabinKarp(t,p));break;
 case 3:System.out.print("Text 1: ");String a=in.nextLine();System.out.print("Text 2: ");String b=in.nextLine();System.out.println("Levenshtein="+StringAlgorithms.edit(a,b)+" Damerau-Levenshtein="+StringAlgorithms.damerau(a,b));break;
 case 4:System.out.print("Text: ");SuffixStructures.show(in.nextLine());break;
 case 5:System.out.print("Sequence A: ");a=in.nextLine();System.out.print("Sequence B: ");b=in.nextLine();System.out.println("Needleman-Wunsch score="+DPAlgorithms.align(a,b,false));System.out.println("Smith-Waterman score="+DPAlgorithms.align(a,b,true));break;
 case 6:System.out.println("Matrix-chain [10,20,30,40]="+DPAlgorithms.matrixChain(new int[]{10,20,30,40}));System.out.println("Optimal BST frequencies [34,8,50]="+DPAlgorithms.optimalBST(new int[]{34,8,50}));System.out.println("TSP demo="+DPAlgorithms.tsp(new int[][]{{0,10,15,20},{10,0,35,25},{15,35,0,30},{20,25,30,0}}));break;
 case 7:int[][]cap={{0,3,2,0,0,0},{0,0,0,3,2,0},{0,0,0,0,0,2},{0,0,0,0,0,2},{0,0,0,0,0,3},{0,0,0,0,0,0}};System.out.println("Edmonds-Karp max flow="+NetworkFlow.maxFlow(cap,0,5));break;
 case 8:boolean[][]e=new boolean[4][4];e[0][1]=e[1][0]=true;e[1][2]=e[2][1]=true;e[2][3]=e[3][2]=true;e[0][3]=e[3][0]=true;boolean[]c=Approximation.vertexCover2Approx(e);System.out.print("Selected vertices: ");for(int i=0;i<c.length;i++)if(c[i])System.out.print(i+" ");System.out.println();break;
 case 9:System.out.print("Positive integer (prefer < 3 billion): ");long num=longNum(in);System.out.println(RandomizedAlgorithms.millerRabin(num,8)?"Probably prime":"Composite");break;
 case 10:System.out.print("Population n: ");int n=integer(in);System.out.print("Sample k: ");int k=integer(in);int[]s=RandomizedAlgorithms.reservoir(n,k);for(int x:s)System.out.print(x+" ");System.out.println();break;
 case 0:System.out.println("Bye");break;default:System.out.println("Invalid choice");
 }}while(ch!=0);in.close();}
 static int integer(Scanner s){try{return Integer.parseInt(s.nextLine().trim());}catch(Exception e){return -1;}}static long longNum(Scanner s){try{return Long.parseLong(s.nextLine().trim());}catch(Exception e){return 0;}}
}