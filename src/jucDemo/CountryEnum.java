package jucDemo;

/**
 * ö����
 * @author lws
 *
 */
public enum CountryEnum {
	ONE(1, "���"), TWO(2, "����"), THREE(3, "���"),
    FOUR(4, "�Թ�"), FIVE(5, "κ��"), SIX(6, "����");

    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (index == countryEnum.retCode) {
                return countryEnum;
            }
        }
        return null;
    }

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
    
    
}
