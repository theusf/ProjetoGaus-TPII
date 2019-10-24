public class Equacao {

    public Double valores[];
    public int qtd = 0;

public Equacao(int tamanho) throws Exception{

    if (tamanho < 3)
    throw new Exception("Tamanho invalido");

    this.valores = new Double[tamanho+1];

}

public void addIncog(Double x) throws Exception {
    
    this.valores[qtd] = x;  // se qtd == 0, é o primeiro valor do vetor 
    qtd++;     
}

public Double getResultado (){

    return new Double(this.valores[qtd-1]);    //qtd-1 pois qtd começa com 0(vetor)

}

public String toString(){

    String ret = "";

    for (int i =0; i<qtd; i++)
    {
        ret += this.valores[i] + " ";      
    }

    return ret;

}

public Double getIncog (double pos){
    
    return new Double(this.valores[pos]);
    
}

public int getQtdEq ()
{
	return this.qtd;
}

public boolean equals(Object obj)
{
	if(this == obj)
	return true;
	
	if(obj == null)
	return false;
	
	if(obj.getClass() != this.getClass())
	return false;
	
	Equacao eqObj = (Equacao) obj;
	
	if(this.qtd != eqObj)
	return false; 

	for(int i = 0; i < this.qtd; i++)			//qtd retorna a quantidade valores q equacao tem;     0 3 1 = 28 tem 4 valores
	{
		if(this.valores[i] != eqObj.valores[i])
		return false;
	}
	
	return true;
	
}

  


}
