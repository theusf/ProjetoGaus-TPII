import java.util.StringTokenizer;
import java.io.*;

public class Aula
{
    public static void main (String[] args)
    {
        //double dividendo = -22;
        //double divisor   = 0;
        //double resultado = dividendo / divisor;
        //System.out.println (resultado);

        try
        {
            BufferedReader arquivo =
                           new BufferedReader (
                           new FileReader (
                           "gauss.txt"));

            int qtdEquacoes = Integer.parseInt (arquivo.readLine());

            for (int i=0; i<qtdEquacoes; i++)
            {
                System.out.println("Equacao: " + i);

                StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
     
                Equacao eq = new Equacao(qtdEquacoes);
        
                while (quebrador.hasMoreTokens())
                {
     
                    eq.addIncog(Double.valueOf(quebrador.nextToken()));
                }


                System.out.println (eq.toString());
            }

        }
        catch (Exception erro)
        {
			System.out.println("Erro a tratar:" + erro);
	    }
    }
}