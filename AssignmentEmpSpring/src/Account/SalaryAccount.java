package Account;

public class SalaryAccount implements Account{
	int amt;
	public int getAmt() {
		return amt;
	}
	public SalaryAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Override
	public String withDraw() {
		// TODO Auto-generated method stub
		return "from salary Account";
	}

	public String toString(){
		return "Salary Account";
	}
	
}
