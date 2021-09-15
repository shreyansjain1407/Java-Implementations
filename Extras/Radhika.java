class Solution{
	public int getListSize(){
		List<Integer> inputs = new ArrayList<>();
		int number = 0;
		int count = 0; //Counter to keep track of the total number of elements that exist in the list
		Scanner sc = new Scanner(System.in); // Scanner object to get input from the user
		boolean quit = false, check;
		while(!quit){
			System.out.println("Please enter a number: ");
			number = sc.nextInt();
			boolean check = getInp(number, inputs);

			if(check){//If the current number is greater than the previous number
				inputs.set(inputs.size()-1, inputs.get(inputs.size()-1)+number);
			} else {//If the current number is smaller than the previous number
				inputs.add(number);
				count++;
			}

			//Code just for the sake of exiting the while loop of user inputs
			System.out.println("Do you want to exist? 1:0"); 
			if (sc.nextInt() == 1) quit = true;
		}

		return inputs.size();//Returning the size of the arraylist
	}

	//Function to check if the previous number is larger than the current or not
	boolean getInp(int number, List inputs){
		if(inputs.size() == 0) return false;
		if (number > inputs.get(inputs.size()-1)) {
			return true;
		}
		return false;
	}
}