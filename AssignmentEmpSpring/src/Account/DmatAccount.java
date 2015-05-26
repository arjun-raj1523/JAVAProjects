package Account;

public class DmatAccount implements Account{
	int amt;
	public DmatAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Override
	public String withDraw() {
		// TODO Auto-generated method stub
		return "From Dmat Account";
	}

	public String toString(){
		return "Dmat Account "+amt;
	}
	
}
