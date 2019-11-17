import java.util.StringTokenizer;
import java.io.*;
import java.io.*;
public class Program
{
	public static void main (String[] args)
	{
	
        try
        {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Escreva o nome do arquivo a ser lido: ");
			String arq = in.readLine();
			
            BufferedReader arquivo =
                           new BufferedReader (
                           new FileReader (
                           arq));

            boolean continua = true;
            
            while (continua)  // verificar se tem + de um sistema
            {
				int qtdEquacoes = 0;
				Object linhaLida = arquivo.readLine();
                if (linhaLida == null)
                {
                    System.out.println("FIM DOS SISTEMAS!");
                    arquivo.close();
                    break;
				}
				else
                qtdEquacoes = Integer.parseInt((String) linhaLida);

                SistemaEq Sistema = new SistemaEq(qtdEquacoes);

                for (int i=0; i<qtdEquacoes; i++)
                {
                   // System.out.println("Equacao: " + i);

                    StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
        
                    Equacao eq = new Equacao(qtdEquacoes);

                    while (quebrador.hasMoreTokens())
                    {
        
                        eq.addIncog(Double.valueOf(quebrador.nextToken()));
                    }


                   // System.out.println (eq.toString());
                   // System.out.println ("Resultado = " + eq.getResultado());

                    Sistema.insereEqs(eq);
                }
                
                System.out.println("Sistema antes do metodo de Eliminação de Gauss:");
                System.out.println(Sistema);

                int contador = 0;
                while(Sistema.temZeroNaDiagonal())
                {
                    contador++;
                   // System.out.println("Tem zero na diagonal? :" + Sistema.temZeroNaDiagonal());
                  //  System.out.println(Sistema.toString());			//printar sistema 
                    if (contador<= Sistema.getQtd()*2)
                    Sistema.tiraZerosDiagonal();	
                    else
                    throw new Exception("Impossivel retirar os zeros da diagonal ");
                }

                
                MetodoGaus gauss = new MetodoGaus(Sistema);
                    
                for (int i = 0; i < qtdEquacoes; i++  )
                {
                    
                gauss.tornaPrimeiroElemUm(i);
                //System.out.println(Sistema.toString());

               // System.out.println("Posicao da Equacao do Valor diferente de zero na coluna:");
               // System.out.println(gauss.temValorDiferenteDeZeroNaColuna(0));

               // System.out.println(Sistema.toString());

                    while(gauss.temValorDiferenteDeZeroNaColuna(i) != -1 ) //Enquanto eu tiver valor pra zerar na coluna eu vou ficar zerando
                    {
                    int PosicaoDoEquacaoDoValorQuePrecisaSerZerado = gauss.temValorDiferenteDeZeroNaColuna(i);  //param = coluna, para retornar a linha (equacao)
                    
                    Sistema.getEqua(PosicaoDoEquacaoDoValorQuePrecisaSerZerado).getIncog(i);
                    
                    gauss.tornaDemaisElemZero( PosicaoDoEquacaoDoValorQuePrecisaSerZerado, i );
                    
                    //System.out.println(Sistema);
                    }
                    
                }
                    
                System.out.println("Metodo de gauss aplicado: ");
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
