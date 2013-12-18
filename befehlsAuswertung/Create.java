package befehlsAuswertung;


public class Create implements Command {

	@Override
	public void execute(String[] args) {
		if(args.length != 3){
			System.out.println("Wrong number of arguments.");
			System.exit(-2);
		}
		System.out.println("Create command:");
		for(int i = 1; i < args.length; i++)
			System.out.print(args[i] + " ");
	}
}

