package smartlibrary;
public class Document {
 public int id,year,citations; public String title,author,abstractText,keywords;
 public Document(int i,String t,String a,int y,String x,String k,int c){id=i;title=t;author=a;year=y;abstractText=x;keywords=k;citations=c;}
 public String searchableText(){return title+" "+abstractText+" "+keywords;}
 public void print(){System.out.println(id+" | "+title+" | "+author+" | "+year+" | citations="+citations);System.out.println(abstractText+" ["+keywords+"]");}
}