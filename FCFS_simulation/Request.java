package aa;

public class Request {

	//id
	//the disk number to be accessed
	//is this request accessed or not
	private int id;
	private int number;
	private boolean flag;

	public Request(int id, int number) {
		this.id = id;
		this.number = number;
		this.flag = false;
		System.out.println(this + " is generated");
	}

	public void setId(int id) {
		this.id = id;
	}

	// 以下是一系列set和get方法
	public int getId() {
		return this.id;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean getFlag() {
		return this.flag;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "request " + id + ", accessed disk number " + number + "";
	}
}
