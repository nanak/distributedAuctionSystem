package befehlsAuswertung;


public class Login implements Command {

	@Override
	public void execute(String[] args) {
		if(args.length != 2){
			System.out.println("Wrong number of arguments.");
			System.exit(-2);
		}
		System.out.println("Login command:");
		for(int i = 1; i < args.length; i++)
			System.out.print(args[i] + " ");
	}
}

