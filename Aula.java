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
            SistemaEq Sistema = new SistemaEq(qtdEquacoes);

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
                System.out.println ("Resultado = " + eq.getResultado());

                Sistema.insereEqs(eq);
            }
            System.out.println("Sistema:");

            //System.out.println(Sistema.toString());

            
            while(Sistema.temZeroNaDiagonal())
            {
				
				//System.out.println("Valores da diagonal:" + Sistema.getDiagonal());
				System.out.println("Tem zero na diagonal? :" + Sistema.temZeroNaDiagonal());
				System.out.println(Sistema.toString());
				Sistema.tiraZerosDiagonal();
			}
            System.out.println("Sistema sem zero na diagonal:");

            System.out.println(Sistema.toString());
            System.out.println("Tem zero na diagonal? :" + Sistema.temZeroNaDiagonal());
			
			MetodoGaus testeFODASE = new MetodoGaus(Sistema);
			testeFODASE.tornaPrimeiroElemUm();
			System.out.println(Sistema.toString());

			testeFODASE.tornaDemaisElemZero();
			System.out.println(Sistema);



        }
        catch (Exception erro)
        {
			System.out.println("Erro a tratar:" + erro);
	    }
    }
}
