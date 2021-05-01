package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsExceptionTest 
{

	
}

class SuperClass
{
	public void method() throws IOException
	{
		
	}
}

class SubClass extends SuperClass
{
	public void method() throws FileNotFoundException
	{
		
	}
}