class Methods {
    public static int parseNum(String s)
	{
		int num = 0;
		try
		{
			num = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid input.");
		}
		return num;
	}
}