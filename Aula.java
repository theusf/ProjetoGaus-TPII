import java.util.StringTokenizer;
import java.io.*;

public class Aula
{
    public static void main (String[] args)
    {


        try
        {
            BufferedReader arquivo =
                           new BufferedReader (
                           new FileReader (
                           "gauss.txt"));

            boolean continua = true;
            
            while (continua)  // verificar se tem + de um sistema
            {
				int qtdEquacoes = 0;
				Object linhaLida = arquivo.readLine();
                if (linhaLida == null)
                {
					System.out.println("FIM DOS SISTEMAS!");
                    break;
				}
				else
                qtdEquacoes = Integer.parseInt((String) linhaLida);

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

                int contador = 0;
                while(Sistema.temZeroNaDiagonal() && (contador< Sistema.qtd*2))
                {
                    contador++;
        
                    System.out.println("Tem zero na diagonal? :" + Sistema.temZeroNaDiagonal());
                    System.out.println(Sistema.toString());			//printar sistema 
                    Sistema.tiraZerosDiagonal();					
                }
                System.out.println("Sistema sem zero na diagonal:");

                System.out.println(Sistema.toString());
                System.out.println("Tem zero na diagonal? :" + Sistema.temZeroNaDiagonal());
                
                MetodoGaus testeFODASE = new MetodoGaus(Sistema);
                
        
                    
                for (int i = 0; i < qtdEquacoes; i++  )
                {
                    
                testeFODASE.tornaPrimeiroElemUm(i);
                System.out.println(Sistema.toString());

                System.out.println("Posicao da Equacao do Valor diferente de zero na coluna:");
                System.out.println(testeFODASE.temValorDiferenteDeZeroNaColuna(0));

                System.out.println(Sistema.toString());
                

                
                    while(testeFODASE.temValorDiferenteDeZeroNaColuna(i) != -1 ) //Enquanto eu tiver valor pra zerar na coluna eu vou ficar zerando
                    {
                    int PosicaoDoEquacaoDoValorQuePrecisaSerZerado = testeFODASE.temValorDiferenteDeZeroNaColuna(i);  //param = coluna, para retornar a linha (equacao)
                    
                    Sistema.getEqua(PosicaoDoEquacaoDoValorQuePrecisaSerZerado).getIncog(i);
                    
                    testeFODASE.tornaDemaisElemZero( PosicaoDoEquacaoDoValorQuePrecisaSerZerado, i );
                    
                    System.out.println(Sistema);
                    }
                    
                }
                    
                System.out.println(Sistema);
                System.out.println(Sistema.mostraResultados());


            }

        }
        catch (Exception erro)
        {
			System.out.println("Erro a tratar:" + erro);
	    }
    }
}
