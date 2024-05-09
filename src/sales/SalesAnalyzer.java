
package sales;

public class SalesAnalyzer {
	
	private double []sale;
	private int noOfDays;
	
	public SalesAnalyzer(int noOfDays) // parameterized constructor
	{
		this.noOfDays = noOfDays;
		sale = new double[noOfDays];
	}
	
	// adds a daily sales to sale array
	public void addSales(double saleamount, int day)
	{
		
		if(day >= 0 && day < noOfDays)
		{
			sale[day] = saleamount;
		}
        
		else{
			System.out.println("Error : Invalid days");
		}	
	}
	
	// calculate total sales for the month
	public double calculateTotalSales()
	{
		double totalSales = 0;
		for(double sales : sale)  // use for each loop
		{
			totalSales = totalSales + sales;
		}
		return totalSales;
	}
	
	// calculate average of daily sales
	public double calculateAverageDailySales()
	{
		double totalSales = calculateTotalSales();
		return totalSales / noOfDays;
		
	}
	
	// find the highest sales day
	public int findBestSalesDay()
	{
		double maxSales = Double.MIN_VALUE;  // constant holding the smallest positive nonzero value of type double
		int bestDay = -1;
		for(int i=0; i < noOfDays; i++)
		{
			if(sale[i] > maxSales)
			{
				maxSales = sale[i];
				bestDay = i;
			}
		}
		return bestDay;
	}
      // find the lowest sales day
    public int findWorstSalesDay()
    {
    	double minSales = Double.MAX_VALUE;  // constant holding the largest positive finite value of type double
    	int worstDay = -1;
    	for(int i=0; i < noOfDays; i++)
    	{
    		if(sale[i] < minSales)
    		{
    			minSales = sale[i];
    			worstDay = i;
    		}
    	}
    	return worstDay;
    }
	
    // Create displaySalesReport method for dispaly all methods
    public void displaySalesReport()
    {
    	System.out.println("Calculate total sales for month : "+calculateTotalSales());  // call to calculateTotalSales() method
    	System.out.println("Average of daily sales : "+calculateAverageDailySales());  // call to calculateAverageDailySales() method
    	int bestDay = findBestSalesDay();
    	System.out.println("Highest sales day : " + " Day "+ bestDay + " with " + sale[bestDay]);
    	int worstDay = findWorstSalesDay();
    	System.out.println("Lowest sales day : " + " Day " + worstDay + " with " + sale[worstDay]);
    }
    
	public static void main(String[] args) {
		
		//create object of class 
		 SalesAnalyzer obj = new SalesAnalyzer(30);   // assuming month of days
		 obj.addSales(2000, 0);
		 obj.addSales(2500, 1);
		 obj.addSales(1450, 2);
		 obj.addSales(870, 3);
		 obj.addSales(0.0, 4);
		 obj.displaySalesReport();

	}

}