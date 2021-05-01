package exception;

public class EcmDef {
	
	public static void main(String[] args) {
		EcmDef ecmDef = new EcmDef();
		try {
			ecmDef.ecm(-1,2);
		}catch(EcDef e) {
			e.printStackTrace();
		}
	}
	
	public int ecm(int i,int j) throws EcDef {
		if(i < 0 || j < 0) {
			throw new EcDef("分子或分母为负数了！");
		}
		return i/j;
	}

}
