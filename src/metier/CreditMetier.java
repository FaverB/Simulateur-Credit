package metier;

public class CreditMetier {
	public double calculMensualite(double c, int duree, double taux) {
		
		double t = taux/100;
		double t1 = c*t/12;
		double t2 = 1-Math.pow((1+t/12), -1*duree);
		double res = t1/t2;
		
		return res;
	}    
}
