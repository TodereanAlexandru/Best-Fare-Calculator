public class TransitCalculator{
	
  private double transitDays;
  private double rideNumber;
  private String[] rideType = {"Pay-per-ride","7-day Unlimited Rides","30-day Unlimited Rides"};
  private double[] pricesType = {2.75,33,127};

  public double getTransitDays(){
    return this.transitDays;
  }
  public  void setTransitDays(int transitDays){
    this.transitDays = transitDays;
  }

  
  public double getRideNumber(){
    return this.rideNumber;
  }
  public void setRideNumber(int rideNumber){
    this.rideNumber = rideNumber;
  }

  public TransitCalculator(double transitDays,double rideNumber){
    this.transitDays = transitDays;
    this.rideNumber = rideNumber;
  }

  public double unlimited7Price(){
    int nrWeeks = (int) Math.ceil((transitDays/7));
    double totalCost =33* nrWeeks;
    return (double)totalCost/rideNumber;
  }

  public double[] getRidePrices(){
    double[] prices = {0,0,0};
    double peyPerRide = pricesType[0];
    prices[0] = peyPerRide;

    double dayRides = unlimited7Price();
    prices[1] = dayRides;

    int nrMonths= (int) Math.ceil(transitDays/30);
    int totalCost= 127 * nrMonths;
    double dayRidesT = totalCost/rideNumber;
    prices[2] = dayRidesT;
    return prices;
    
  }

  public String getBestFare(){
	  double[] getPrices = {0,0,0};
	  getPrices = getRidePrices();
	  double min = 1000;
	  for(int i=0;i<3;i++) {
		  if(getPrices[i] < min){
		         min = getPrices[i];
		       }  
	  }
	  
	  if(min == getPrices[0]){
	      return "You should get the Pay-per-ride option at "+getPrices[0]+" per ride.";
	    }
	    else if(min == getPrices[1]){
	        return "You should get the 7-day Unlimited  option at "+getPrices[1]+" per ride.";
	    }
	    else{
	       return "You should get the 30-day Unlimited  option at "+getPrices[2]+" per ride.";

	    }
	  
  }
  
  public static void main(String[] args) {
	  final double transitDays = 5;
	  final double rideNumber = 12;
	  
	  TransitCalculator t1 = new TransitCalculator(transitDays,rideNumber);
	 
	  System.out.println(t1.getBestFare());
	 
	 
	  
	  
  }

}