
public class T2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}


class testA {
	
	public void methodA() throws RuntimeException {
    // do some number crunching
	}
}
class testB1 extends testA {
	  public void methodA() throws ArithmeticException {
	    // do some number crunching
	  }
	}
/*
class testB2 extends testA {
	  public void methodA() throws Exception {
	    int x = 0 / 0;
	  }
	}
9*/