import java.util.Scanner;
import java.math.BigInteger;
public class rsa {
public static BigInteger gcd_calculator(BigInteger phi,int j)
{
 BigInteger i=BigInteger.valueOf(j);
 return(phi.gcd(i));
}
public static void main(String[] args)
{
 int i;
 BigInteger cipher,recv_plain,p,q,n,phi,temp,plain,e,d;
 Scanner scanner=new Scanner(System.in);
 System.out.println("enter the prime value for p: ");
 p=scanner.nextBigInteger();
 while(!(p.isProbablePrime(1)))
 {
 System.out.println("non primes are not accepted!!.enter
only prime values");
 p=scanner.nextBigInteger();
 }
 System.out.println("\nenter the prime value for q: ");
 q=scanner.nextBigInteger();
 while(!(q.isProbablePrime(1)))
 {
 System.out.println("non primes are not accepted!!.enter
only prime values");
 q=scanner.nextBigInteger();
 }
 System.out.print("\nenter the plain text to be sent");
 plain=scanner.nextBigInteger();
 n=p.multiply(q);

phi=(p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
 System.out.println("\n\n n= "+n);
 System.out.println(" phi(n)= "+phi);
 i=2;
 while (true)
 {
 temp=gcd_calculator(phi,i);
 if(temp.compareTo(BigInteger.ONE)==0)
 {
 e=BigInteger.valueOf(i);
break;
 }
 i=i+1;
 }
 System.out.println(" public key (e) = "+e);
 i=1;
 d=e.modInverse(phi);
 System.out.println(" private key (d) = "+d);
 cipher=plain.modPow(e,n);
 recv_plain=cipher.modPow(d,n);
 System.out.println(" cipher text sent : "+cipher);
 System.out.println(" recived plain text sent : "+recv_plain);
 scanner.close();
}
}
