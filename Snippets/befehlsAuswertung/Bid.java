package befehlsAuswertung;


public class Bid implements Command {

	@Override
	public void execute(String[] args) {
		if(args.length != 3){
			System.out.println("Wrong number of arguments.");
			System.exit(-2);
		}
		System.out.println("Bid command:");
		for(int i = 1; i < args.length; i++)
			System.out.print(args[i] + " ");
	}
}
