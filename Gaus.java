public class Gaus
{
    public static void main (String args [])
    {
               
        System.out.println("Projeto Gays");
        try {
        
            Equacao eq = new Equacao(3);   
       
            // System.out.print(valores[0]);

            eq.addIncog(0.0);
            eq.addIncog(3.0);
            eq.addIncog(2.0);
            eq.addIncog(28.0);

            System.out.println(eq.toString());
            System.out.println(eq.getResultado());

        } catch (Exception e) {
            System.out.print(e);
        }



        }

}