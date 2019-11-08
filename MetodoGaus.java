public class MetodoGaus {		//aplica o método de Gauss no sistema

    private SistemaEq Sistema;

 public MetodoGaus(SistemaEq x)
 {
    this.Sistema = x;
    Sistema.tiraZerosDiagonal();

 }


 public void tornaPrimeiroElemUm(int passo)
 {	
	try
	{
	Equacao equa = 	Sistema.getEqua(passo);
	Equacao ret = new Equacao(equa.getQtdEq());
	double divisor = equa.getIncog(passo);
		
	for(int i = 0; i < equa.getQtdEq(); i++)
	{
		double valSet = 0;
		ret.addIncog((equa.getIncog(i) / divisor));
		
	}
	equa = ret;
	Sistema.setEquacao(ret, passo);  //estamos fazendo so com o primeiro para testa, apenas.
	
	}
	catch(Exception erro)
	{
		System.err.println(erro);
	}	

 }
 
 public void tornaDemaisElemZero(int posicaoDaEquacao /* 1 */, int posicaoDoValorAZerar  /* coluna */)	
 {
	 
	 /*
		1	0	1/2	  6
		2	3	0	  16
		0	3	2	  28

	 */
	try
	{
		Equacao eq1 = Sistema.getEquacao(posicaoDoValorAZerar); 				// 1	0	1/2	  6				
		Equacao eq2 = Sistema.getEquacao(posicaoDaEquacao);					// 2   3   0    16
		//Equacao aux = new Equacao(eq1.getQtdEq());
		double aux = 0;
		double valNumeroAmulti = eq2.getIncog(posicaoDoValorAZerar);// 2
		
		for(int i = 0; i < eq1.getQtdEq(); i++)
		{
		     //aux.addIncog();
		     System.out.println(eq2.getIncog(i) + "+ (" + (eq1.getIncog(i) + "*" + (valNumeroAmulti * -1) + ")"));
		     aux = eq2.getIncog(i) + (eq1.getIncog(i) * (valNumeroAmulti * -1) );  // aux = 2 + ( 1 * -2 ))
		     System.out.println("AUX PORRA: "+ aux);
		     
		     eq2.setIncog(aux,i);			// 0, 0  ==  0   3  -1     
		}
		
		
		
		
	}
	catch(Exception erro)
	{
		System.err.println(erro);
	}
 }
 
 
	public int temValorDiferenteDeZeroNaColuna(int coluna)  //pos equacao  
	{
			int ret = -1;

		try{
		
		for (int i = 0; i<Sistema.qtd; i++)
			if ( ((Sistema.getEquacao(i).getIncog(coluna)) != 0 ) && i != coluna)
				ret = i; //Me retorna a posicao da Equacao que tem valor a ser zerado no vetor de Sistema ;
	

		}
		catch (Exception erro)
		{
		}
		return ret;
	}

	

 /* 
 
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
 
 public void tornaDemaisElemZero()	
 {
	try
	{
		Equacao eq1 = Sistema.getEquacao(0);
		Equacao eq2 = Sistema.getEquacao(1);
		//Equacao aux = new Equacao(eq1.getQtdEq());
		double aux = 0;
		double valNumeroAmulti = eq2.getIncog(0);
		
		for(int i = 0; i < eq1.getQtdEq(); i++)
		{
		     //aux.addIncog();
		     System.out.println(eq2.getIncog(i) + "+ (" + (eq1.getIncog(i) + "*" + (valNumeroAmulti * -1) + ")"));
		     aux = eq2.getIncog(i) + (eq1.getIncog(i) * (valNumeroAmulti * -1) );
		     System.out.println("AUX PORRA: "+ aux);
		     
		     eq2.setIncog(aux,i);
		}
		
		
		
		
	}
	catch(Exception erro)
	{
		System.err.println(erro);
	}
 } */









}

