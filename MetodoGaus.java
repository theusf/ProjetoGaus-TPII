public class MetodoGaus {		//aplica o método de Gauss no sistema

    private SistemaEq Sistema;

 public MetodoGaus(SistemaEq x)
 {
    this.Sistema = x;
    Sistema.tiraZerosDiagonal();

 }


 public void tornaPrimeiroElemUm()
 {	
	try
	{
	Equacao equa = 	Sistema.getEqua(0);
	Equacao ret = new Equacao(equa.getQtdEq());
	double divisor = equa.getIncog(0);
		
	for(int i = 0; i < equa.getQtdEq(); i++)
	{
		double valSet = 0;
		ret.addIncog((equa.getIncog(i) / divisor));
		
	}
	equa = ret;
	Sistema.setEquacao(ret, 0);  //estamos fazendo so com o primeiro para testa, apenas.
	
	}
	catch(Exception erro)
	{
		System.err.println(erro);
	}	

 }

}

