//import sun.nio.cs.ext.EUC_CN;

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
		
		vetEqs[qtd] = x;
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
			
			Equacao temp = this.vetEqs[0]; // 0

			for(int i=0;i<vetEqs.length-1;i++){ // i = 0 , enquanto i < 2 i++
			
				vetEqs[i] = vetEqs[i+1]; // vetEqs[0] = vetEqs[1] ... vetEqs[1] = vetEqs[2] 
			}

			vetEqs[vetEqs.length-1] = temp;  //-1 porque o ultimo valor é sempre o resutlado da eq e eu não quero apagar meu resultado.........

		}

    } 
    
    public Equacao getEqua(int pos)
    {
		
		return this.vetEqs[pos];
	}
	
	public void setEquacao(Equacao x, int pos)
	{
		this.vetEqs[pos] = x;
	}
}
