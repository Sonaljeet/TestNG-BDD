package commonFunctions;

public class RandomNumber {

	/**
	 *this method generates the random alphabets of any given length
	 * @param length
	 * @return
	 * @throws Exception
	 */
	public static String generateRandomalphabets(int length) throws Exception
	{
	    String aplhabets = "";
	    for (int i = 1 ; i <= length ; i++)
	    {
	       aplhabets += (char)(Math.random() * ('Z' - 'A' + 1) + 'A');
	    }
	    //System.out.println("Random Alpbahbets is "+aplhabets);
	    return aplhabets;
	}
		
}
