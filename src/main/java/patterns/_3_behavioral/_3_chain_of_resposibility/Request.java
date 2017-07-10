package patterns._3_behavioral._3_chain_of_resposibility;

/**
 * @author LinnykOleh
 */
public class Request {

	private RequestType requestType;
	private double amount;

	public Request(RequestType requestType, double amount) {
		this.requestType = requestType;
		this.amount = amount;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public double getAmount() {
		return amount;
	}
}
