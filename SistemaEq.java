public class SistemaEq
{
	Equacao vetEqs[];
	int qtd = 0;
	
	public SistemaEq(int tam) throws Exception 
	{
		if(tam <= 0)
		throw new Exception("Tamanho inválido!");
		
		vetEqs = new Equacao[tam];
	}
	
	public void insereEqs (Equacao x)
	{
		if(x == null)
		throw new Exception("Equação nula");
		
		if(qtd >= tam)
		throw new Exception("Vetor Cheio!");
		
		verEqs[qtd] = x.;
		qtd++;
	}
	
	public int kd(Equacao x)
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
	}
	
	public Ob
	
	
}
