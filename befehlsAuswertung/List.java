package befehlsAuswertung;


public class List implements Command {

	@Override
	public void execute(String[] args) {
		if(args.length != 1){
			System.out.println("Wrong number of arguments.");
			System.exit(-2);
		}
		System.out.println("List command:");
		for(int i = 1; i < args.length; i++)
			System.out.print(args[i] + " ");
	}
}

