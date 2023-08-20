import java.util.Scanner;

public class Main{
public static void main(String[] args){
int a, b;
double c;
boolean d;
String t;
t = "teste" ;
a = (2*(1+3))/2 ;
b = 2 ;
Scanner sc = new Scanner(System.in);
a = sc.nextInt();
b = sc.nextInt();
d = (a>b)&&((1<3)||(2<4)) ;
if ((a<b)&&((1<3)||(2<4))) {
 System.out.println(a);

}
else {
System.out.println(b);

}
while (a<b) {
 a = a+1 ;
System.out.println(t);

}
do {
 a = a+1 ;
System.out.println("teste 2");

} while(a<b); 
sc.close();
}
}

