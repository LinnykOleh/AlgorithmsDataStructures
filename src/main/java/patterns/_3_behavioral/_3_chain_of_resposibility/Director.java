package patterns._3_behavioral._3_chain_of_resposibility;

/**
 * @author LinnykOleh
 */
public class Director extends Handler{

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE){
			System.out.println("Directors can approve conferences");
		}else {
			successor.handleRequest(request);
		}
	}
}
