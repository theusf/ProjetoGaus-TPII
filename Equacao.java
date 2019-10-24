public class Equacao {

    public Double valores[];
    public int qtd = 0;

public Equacao(int tamanho) throws Exception{

    if (tamanho < 3)
    throw new Exception("Tamanho invalido");

    this.valores = new Double[tamanho+1];

}

public void addIncog(Double x) throws Exception {
    
    this.valores[qtd] = x;
    qtd++;
}

public Double getResultado (){

    return this.valores[qtd-1];

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

  


}
