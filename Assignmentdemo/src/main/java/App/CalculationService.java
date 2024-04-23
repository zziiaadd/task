package App;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Calculation;

@Stateless
@Path("/calc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationService {
	
	public List<Calculation> calculations = new ArrayList<>();
	
    @POST
    public String  calculations(Calculation cu) {
            int number1 = cu.getNumber1();
            int number2 = cu.getNumber2();
            String operation = cu.getOperation();
            calculations.add(cu);
            
            int result;
            if ("+".equals(operation)) {
                result = number1 + number2;
            } else if ("-".equals(operation)) {
                result = number1 - number2;
            } else if ("*".equals(operation)) {
                result = number1 * number2;
            } else if ("/".equals(operation)) {
                result = number1 / number2;
            } else {
                throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            return "result :" + result;
    	}
    @GET
    @Path("/calculations")
    public List<Calculation> getAllCalculations() {
        return calculations;
    }
    }

