public class SistemaEq //implements Comparable <SistemaEq>,Cloneable
{
	Equacao vetEqs[];
	int qtd = 0;
	
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
		
		for(int i = 0; i < this.qtd; i++ )
		{
			if(this.get)
		}
		
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
	
	public String ToString()
	{
		String ret = "";
		
		for(int i=0; i < qtd; i++)
		{
			ret += vetEqs[i] + "\n";	
		}
		return ret;
	}
	
	public getEquacao()
	{
		for(int i = 0; i < this.vetEqs.lenght; i++)
		{
			
		}
	}
	
	private static boolean EhaMesma(Equacao x1, Equacao x2) throws Exception
	{
		if(x1.getQtdEq() != x2.getQtdEq())
		throw new Exception("Equações com quantidade de INCOG diferentes!");
		
		for(int i = 0; i < x1.getQtdEq(); i++)
		{
			if((x1.getIncog(i) / x2.getIncog(i)) == (x1.getIncog(i + 1) / x2.getIncog(i + 1)))
			return true; 
		}
		
		return false; 
	}
	
}
