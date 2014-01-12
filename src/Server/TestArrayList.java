package Server;

public class TestArrayList {
	public static void main(String[]args){
		User logout = null;
		if(!userlist.isEmpty()){
			for(int i=0; i<userlist.size(); i++){
				if(userlist.get(i).getName().equals(name)){
					logout=userlist.get(i);
					break;
				}
			}
		}
	}
	
}
