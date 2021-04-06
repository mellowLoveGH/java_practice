package aa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Magnetic {
	
	//the range of disk track
	//where t start and where to end
	//how many requests
	private int start;
	private int end;	
	private int number;
	
	//
	private List<Request> list;
	
	public Magnetic(int start, int end, int number) {
		this.start = start;
		this.end = end;
		this.number = number;
		this.list = new LinkedList<>();
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public List<Request> getRequests(){
		return list;
	}
	
	public void addRequest(Request req) {
		list.add(req);
	}
	
	public void generateRequests() {
		generateRequests(this.number);
	}
	
	public void generateRequests(int reqNumber) {
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		
		//generate different disk track numbers
		while (set.size() != reqNumber) {
			set.add((int) (random.nextInt(end - start) + start));
		}
		
		//
		int i = 0;
		for (int item : set) {
			int id = i + 1;
			int number = item;
			Request req = new Request(id, number);
			addRequest(req);
			i++;
		}
		
	}
}
