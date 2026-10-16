package smartlibrary;
import java.io.*;
public class DatasetLoader {
 public static Document[] load(String path){
  Document[] tmp=new Document[3000];int n=0;
  try(BufferedReader br=new BufferedReader(new FileReader(path))){
   br.readLine();String line;
   while((line=br.readLine())!=null&&n<tmp.length){String[] c=parse(line);if(c.length<7)continue;
    try{Document d=new Document(Integer.parseInt(c[0].trim()),c[1],c[2],Integer.parseInt(c[3].trim()),c[4],c[5],Integer.parseInt(c[6].trim()));tmp[n++]=d;}catch(Exception ex){System.out.println("Skipped row: "+line);}
   }
  }catch(IOException e){System.out.println("Dataset not found: "+path);}
  Document[] out=new Document[n];for(int i=0;i<n;i++)out[i]=tmp[i];return out;
 }
 private static String[] parse(String s){String[] a=new String[20];int n=0;StringBuilder b=new StringBuilder();boolean q=false;
  for(int i=0;i<s.length();i++){char c=s.charAt(i);if(c=='"'){if(q&&i+1<s.length()&&s.charAt(i+1)=='"'){b.append('"');i++;}else q=!q;}
  else if(c==','&&!q){a[n++]=b.toString();b.setLength(0);}else b.append(c);}a[n++]=b.toString();String[] r=new String[n];for(int i=0;i<n;i++)r[i]=a[i];return r;
 }
}