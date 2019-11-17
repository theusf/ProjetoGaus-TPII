import java.io.*;
public class SistemaEq //implements Comparable <SistemaEq>,Cloneable
{
	private Equacao vetEqs[];
	private int qtd = 0;
	
	public SistemaEq(int tam) throws Exception 
	{
		if(tam <= 0)
		throw new Exception("Tamanho inválido!");
		
		vetEqs = new Equacao[tam];
	}
	
	public void insereEqs (Equacao x) throws Exception
	{
		if(x == null)
		throw new Exception("Equação nula");
		
		if(this.qtd >= this.vetEqs.length)
		throw new Exception("Vetor Cheio!");
		
	/*	for(int i = 0; i < this.qtd; i++ )
		{
			for(int i2 = i + 1; i2 <= this.qtd; i2++ )
			{
				if(SistemaEq.EhaMesma(this.vetEqs[i], this.vetEqs[i2]))
					throw new Exception("Existem equações iguais no Sistema!")
			}
		}*/
		
		for(int i = 0; i < this.qtd; i++ )
		{	
				if(SistemaEq.EhaMesma(this.vetEqs[i], x))   //é statico e privado, por isso é <NOMEDACLASSE>.MÉTODO
					throw new Exception("Equação já existente!");
				
				if(this.vetEqs[i].equals(x))
					throw new Exception("Equação já existente!");
		}
		
		
		
		this.vetEqs[qtd] = x;
		this.qtd++;
	}
	
	public int kd(Equacao x) throws Exception
	{
		if(x == null)
		throw new Exception("Equação nula");
		
		for(int i = 0; i < qtd; i++)
		{
			if(vetEqs[i].equals(x)) 
			return i;
		}
			
		return -1;	//inexistente.
	}
	
	public String toString()
	{
		String ret = "";
		
		for(int i=0; i < qtd; i++)
		{
			ret += vetEqs[i] + "\n";	
		}
		return ret;
	}
	
	public Equacao getEquacao(int pos) throws Exception
	{
		if(pos > this.qtd+1)
		throw new Exception("Posição inválida!");
		
		if(this.qtd == 0)
		throw new Exception("Vetor de Equações nulo!");	
			
		return this.vetEqs[pos];
	}
	
	private static boolean EhaMesma(Equacao x1, Equacao x2) throws Exception
	{
		//System.out.println("Começando a validação");
		
		
		if(x1.getQtdEq() != x2.getQtdEq())
		throw new Exception("Equações com quantidade de INCOG diferentes!");
		//System.out.println("QTD DE INCOG: " + x1.getQtdEq());
		
		
		
		for(int i = 0; i < x1.getQtdEq()-2; i++)
		{
			//System.out.println((x1.getIncog(i) + "/" + x2.getIncog(i) + "=" + (x1.getIncog(i) / x2.getIncog(i))));
			
			if(!(x1.getIncog(i) == 0 || x2.getIncog(i) == 0))
			{
				//System.out.println("É ZERO!! pula");
				if((x1.getIncog(i) / x2.getIncog(i)) == (x1.getIncog(i + 1) / x2.getIncog(i + 1)))
				{
					//System.out.println((x1.getIncog(i) + "/" + x2.getIncog(i) + "=" + (x1.getIncog(i) / x2.getIncog(i))));
					return true;
				}
			}
		}
		
		return false; 
	}
	
	public String getDiagonal()
	{
		String total = "";
		for (int row = 0; row < this.vetEqs.length; row++)
		{
			total += row +":"+ vetEqs[row].getIncog(row) + ", " ;
		}


		return total;

	}


	public boolean temZeroNaDiagonal()
	{

		for (int row = 0; row < this.vetEqs.length; row++)
		{
			if  (vetEqs[row].getIncog(row) == 0)
				return true;
		}

		return false;

	}

	public void tiraZerosDiagonal()
	{

		if (this.temZeroNaDiagonal())
		{
			
			Equacao temp = this.vetEqs[0]; // variavel auxiliar 

			for(int i=0;i<vetEqs.length-1;i++){ // i = 0 , enquanto i < 2 i++
			
				vetEqs[i] = vetEqs[i+1]; // vetEqs[0] = vetEqs[1] ... vetEqs[1] = vetEqs[2] 
			}

			vetEqs[vetEqs.length-1] = temp;  //-1 porque o ultimo valor é sempre o resutlado da eq e eu não quero apagar meu resultado.........

		}

    } 
    
    public Equacao getEqua(int pos) throws Exception
    {
		if (pos <= this.vetEqs.length && pos>=0)
		return this.vetEqs[pos];
		else
		throw new Exception("getEqua: Posição fornecida invalida");
	}
	
	public void setEquacao(Equacao x, int pos) throws Exception
	{
		if (pos <= this.vetEqs.length && pos>=0)
		this.vetEqs[pos] = x;
		else
		throw new Exception("setEqua: Posição fornecida invalida");
	}

	public String mostraResultados()
	{

		String ret = "Resultados: S={";

		for (int i = 0; i< this.vetEqs.length - 1; i++)
		{
			ret += vetEqs[i].getResultado() + ", ";
		}
			ret += vetEqs[this.vetEqs.length - 1].getResultado() + "} \n";
		

		return ret;

	}
	
	public int hashCode()
	{
		int ret = 6;
		
		ret+= 13* + new Integer(this.qtd).hashCode();
		
		for(int i = 0; i < this.qtd; i++)
		ret+= 13* + this.vetEqs[i].hashCode();

		if(ret<0)
		ret= -ret;
		
		return ret;
		
	}
	
	public SistemaEq (SistemaEq x) throws Exception 
	{
		if(x == null)
		throw new Exception("Modelo nulo");
		
		this.qtd = x.qtd;
		
		this.vetEqs = new Object[x.vetEqs[i].length];
		
		for(int i = 0; i < this.qtd; i++)
		this.vetEqs[i] = x.vetEqs[i];  //criando objeto this armazenando os valores do outro objeto passado no param 
		
	}
	
	public Object clone()
	{
		SistemaEq ret = null;
		
		try
		{
			ret = new SistemaEq(this);
			
		}
		catch(Exception erro)
		{
			System.err.println(erro);
		}
		return ret;
	}

	
}
